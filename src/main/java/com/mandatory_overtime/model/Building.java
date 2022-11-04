package com.mandatory_overtime.model;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import com.mandatory_overtime.model.exception.IllegalMoveException;
import com.mandatory_overtime.model.exception.MissingRequirementException;
import com.mandatory_overtime.model.exception.NoSavedGame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 * Building class that creates gameboard to track and update state
 */
public class Building {

    // FIELDS
    Player player = new Player();
    public GameState gameState;

    public static HashMap<String, Room> building;
    private HashMap<String, Item> items;
    private HashMap<String, Npc> npcs;
    private int npcCount = 0;

    // CONSTRUCTOR
    public Building() throws IOException {

    }

    public void createGameStructureFromNew(String difficulty) throws IOException {
        Gson gson = new Gson();
        List<Room> rooms;
        setGameState(GameState.IN_PROGRESS);
        if(difficulty.equals("hard")){
            rooms = load("RoomStructure_Hard.json", gson, new TypeToken<ArrayList<Room>>() {
            }.getType());

//            System.out.println("loading hard game....");
        }else{
            rooms = load("RoomStructure.json", gson, new TypeToken<ArrayList<Room>>() {
            }.getType());
        }


        List<Item> itemArray = load("ItemStructure.json", gson, new TypeToken<ArrayList<Item>>() {
        }.getType());

        List<Npc> npcsArray = load("NPCStructure.json", gson, new TypeToken<ArrayList<Npc>>() {
        }.getType());

        building = (HashMap<String, Room>) rooms.stream().collect(
            Collectors.toMap(Room::getDisplayName, room -> room));

        items = (HashMap<String, Item>) itemArray.stream()
            .collect(Collectors.toMap(Item::getName, item -> item));

        npcs = (HashMap<String, Npc>) npcsArray.stream()
            .collect(Collectors.toMap(Npc::getName, npc -> npc));
    }

    public void createGameStructureFromSave()
        throws IOException, URISyntaxException {
        Gson gson = new Gson();
        setGameState(GameState.IN_PROGRESS);
        List<Room> rooms = loadSave("RoomStructureSave.json", gson,
            new TypeToken<ArrayList<Room>>() {
            }.getType());

        List<Item> itemArray = loadSave("ItemStructureSave.json", gson,
            new TypeToken<ArrayList<Item>>() {
            }.getType());

        List<Npc> npcsArray = loadSave("NPCStructureSave.json", gson,
            new TypeToken<ArrayList<Npc>>() {
            }.getType());

        //load hashmaps
        building = (HashMap<String, Room>) rooms.stream().collect(
            Collectors.toMap(Room::getDisplayName, room -> room));

        items = (HashMap<String, Item>) itemArray.stream()
            .collect(Collectors.toMap(Item::getName, item -> item));

        npcs = (HashMap<String, Npc>) npcsArray.stream()
            .collect(Collectors.toMap(Npc::getName, npc -> npc));

        //load player
        File f = new File("PlayerSave.json");
        try (Reader reader = new InputStreamReader(new FileInputStream(f))) {
            player = gson.fromJson(reader, Player.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void gameSave() throws IOException {
        //save game

        //get hashmaps of structures//convert back to Lists<>
        List<Room> roomsSvArr = new ArrayList<Room>(building.values());
        List<Item> itemsSvArr = new ArrayList<>(items.values());
        List<Npc> npcsSvArr = new ArrayList<>(npcs.values());

        //convert structures to saved json files
        convertSaveDataToJson(roomsSvArr, "RoomStructureSave.json");
        convertSaveDataToJson(itemsSvArr, "ItemStructureSave.json");
        convertSaveDataToJson(npcsSvArr, "NPCStructureSave.json");

        //Write Player obj to Json file
        convertSavedPlayerToJson(player, "PlayerSave.json");

    }

    public void convertSavedPlayerToJson(Player currentPlayer, String filename) throws IOException {
        try {
            File filePath = new File(filename);

            Gson gson = new Gson();

            Writer writer = new FileWriter(filePath, false);

            gson.toJson(currentPlayer, writer);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JsonIOException e) {
            throw new RuntimeException(e);
        }
    }

    public void convertSaveDataToJson(List<?> structureArr, String filename) {
        try {

            Gson gson = new Gson();

            String filePath = new File(filename).getAbsolutePath();
            Writer writer = new FileWriter(filePath, false);

            // convert list to JSON File
            gson.toJson(structureArr, writer);

            // close the writer
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
//      throw new RuntimeException(e);
        }
    }

//  GETTERS/SETTERS

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    //  HELPER METHODS
    private <T> T load(String resourceFile, Gson gson, Type type) throws IOException {

        try (Reader reader = new InputStreamReader(
            getClass().getClassLoader().getResourceAsStream(resourceFile))) {
            return gson.fromJson(reader, type);
        }
    }

    /**
     * Loads JSON classes from saved data to create Java structures
     *
     * @param resourceFile
     * @param gson
     * @param type
     * @param <T>
     * @return
     * @throws IOException
     */
    private <T> T loadSave(String resourceFile, Gson gson, Type type)
        throws IOException, URISyntaxException {

        File f = new File(resourceFile);

        if (f.exists()) {
            try {
                Reader reader = new InputStreamReader(new FileInputStream(f));
                return gson.fromJson(reader, type);
            } catch (Exception e) {
                throw new NoSavedGame();
            }
        } else {

            throw new FileNotFoundException();
        }

    }

//  BUSINESS METHODS

    /**
     * Ends the game completely
     */
    public void quit() {
        System.exit(0); //Update to utilize state.
    }


    public void moveRooms2(String newLocation)
        throws InterruptedException, MissingRequirementException, IllegalMoveException {
        String currentLoc = player.getCurrentLocation();

        String[] directions = building.get(currentLoc).getDirections();

        List<String> directionsList = new ArrayList<>(Arrays.asList(directions));

        List<String> inventory = player.getInventory();

        String nextRoomPreReq = "";

        boolean validLocation = false;

        if(GameMusic.getNpcAudioClip() != null){
            GameMusic.getNpcAudioClip().stop();
        }
        if (newLocation == "lose") {
            player.setCurrentLocation(newLocation);
        } else if (!directionsList.contains(newLocation)) {
            throw new IllegalMoveException(newLocation);

        } else {
            // updates current location
            nextRoomPreReq = building.get(newLocation).getPreReq();

            if (nextRoomPreReq == null || inventory.contains(nextRoomPreReq)) {
                for (String direction : directions) {
                    if (newLocation.equals(direction)) {
                        validLocation = true;
                        player.setCurrentLocation(newLocation);
                        winGameCheck(newLocation);
                        GameMusic.playMoveSound(newLocation);
                        GameMusic.playRoomSound(newLocation);
                        // TODO: DELETE THIS METHOD
                        //getRoomDescriptionInfo();
                        break;
                    }
                }
            } else {
                winGameCheck(newLocation);
                if (!this.getGameState().equals(GameState.LOSS)) {
                    GameMusic.playAccessDeniedSound(newLocation);
                    throw new MissingRequirementException(newLocation, nextRoomPreReq);
                }
            }
        }


    }


    private void winGameCheck(String noun) throws InterruptedException {
        boolean wonGame = false;
        String preReqCondition = building.get(noun).getPreReq();
        ArrayList<String> currentItems = (ArrayList<String>) player.getInventory();
        Boolean roomFail = building.get(noun).getFailCondition();
        if (roomFail) {
            if (noun.equals("home") && currentItems.contains(preReqCondition)) {
                setGameState(GameState.WIN);
            } else if (currentItems.contains(preReqCondition)) {
                building.get(noun).setFailCondition(false);
                building.get(noun).setPreReq(null);
            } else {
                setGameState(GameState.LOSS);
                moveRooms2("lose");
//                System.out.println("you lose");
            }
        }
    }


    public boolean getItem(String item)
        throws IOException, InterruptedException, CantGetItemException {
//        getRoomDescriptionInfo();
        String playerCurrentLocation = player.getCurrentLocation();
        boolean startChallenge = false;

        boolean isValidItem = items.containsKey(item);

        //conditional to check if item is in array //check if location correct // check if npc doesn't have it
//        items.containsKey(item) && !items.get(item).getAcquired() && items.get(item)
//            .getLocation().equals(playerCurrentLocation)
//            && !items.get(item).isNpc()
        if (isValidItem) {
            boolean itemAlreadyAcquired = items.get(item).getAcquired();
            boolean itemIsAtTheLocation = items.get(item).getLocation()
                .equals(playerCurrentLocation);
            boolean npcHasItem = items.get(item).isNpc();
            if (!itemAlreadyAcquired && itemIsAtTheLocation && !npcHasItem) {
                //conditionals to check it item has prerequisite
                if (items.get(item).getPreReq() == null) {

                    //conditional to check for challenge
                    if (items.get(item).getChallenge()) {
                        startChallenge = true;
                        runItemChallenge(item);
                        if(items.get(item).getAcquired()){
                            building.get(playerCurrentLocation).setItem(null);
                        }

                    } else {
                        player.addToInventory(item);
                        GameMusic.playItemSound();
                        items.get(item).setAcquired(true);
                        building.get(playerCurrentLocation).setItem(null);
                    }
                } else {
                    checkItemPreReqIsFulfilled(item);
                }
            } else {
                throw new CantGetItemException();
            }
        } else {
            throw new CantGetItemException();
        }

        return player.getInventory().contains(item);
    }

    /**
     * Cheat mode method that allows user to move through game without blocks.
     *
     * @param noun
     */
    public void getAllItems(String noun) {
        if (noun.equals("mode")) {
            for (String itemN : items.keySet()) {
                player.addToInventory(itemN);
                items.get(itemN).setAcquired(true);
                items.get(itemN).setChallenge(false);
                items.get(itemN).setNpc(false);
                items.get(itemN).setPreReq(null);

            }
        }
        if (noun.contains("move")) {
            String[] newNoun = noun.split(" ", 2);
            String loc = newNoun[newNoun.length - 1];
            player.setCurrentLocation(loc);
            //getRoomDescriptionInfo();
        }

    }

    private void checkItemPreReqIsFulfilled(String item) throws InterruptedException {
        //If prereq in player inventory, add to inventory, remove prereq from inventory, set acquired to true.
        if (player.getInventory().contains(items.get(item).getPreReq())) {
            player.addToInventory(item);
            GameMusic.playDrawerSound();
            GameMusic.playVendingMachineSound();
            GameMusic.playItemSound();
            items.get(item).setAcquired(true);
            player.removeFromInventory(
                items.get(item).getPreReq()); //removes prereq from player inventory

        }
    }

    private void runItemChallenge(String item) throws IOException, InterruptedException {
        while (!player.getInventory().contains(item)) {
            String userAnswer = JOptionPane.showInputDialog(items.get(item).getChallengePrompt());
            if(userAnswer == null){
                return;
            }
            if (items.get(item).getChallengeAnswer().equalsIgnoreCase(userAnswer.trim())) {
                player.addToInventory(item);
                items.get(item).setAcquired(true);
                items.get(item).setChallenge(false);
                GameMusic.playPhoneUnlockingSound();
                GameMusic.playItemSound();
            }
            else {
                int response = JOptionPane.showConfirmDialog(null,"Would you like to try again?","Confrim",JOptionPane.YES_NO_OPTION);

                if (response == JOptionPane.YES_OPTION){
                    runItemChallenge(item);

                }else return;

            }
        }
    }


    public String inspectItem(String item) throws CantGetItemException {
        //checks if item exists, if location is correct, if item is held by NPC

        if (items.containsKey(item) && items.get(item).getLocation()
            .equals(player.getCurrentLocation())
            && !items.get(item).isNpc()) {

            return items.get(item).getPurpose();
        } else {
            throw new CantGetItemException();
        }
    }


    public void getRoomDescriptionInfo() {

        String inventory = player.getInventory().toString();
        String currentLocation = player.getCurrentLocation();
        String npc = building.get(currentLocation).getNPC() == null ? "No one is around"
            : building.get(currentLocation).getNPC();
        String item = building.get(currentLocation).getItem() == null ? "There are no items"
            : building.get(currentLocation).getItem();
        String directions = Arrays.toString(building.get(currentLocation).getDirections());
        String description = building.get(currentLocation).getDescription() == null ? ""
            : building.get(currentLocation).getDescription();

        System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "========================================================================================================\n"
                + "Inventory: %1$s \t\t\t\t\t\t\tCurrent Room: %2$S\n"
                + "Items in Room: %3$s\n"
                + "========================================================================================================\n"
                + "%4$s\n"
                + "Coworkers in the room: %5$s\n"
                + "You can go the directions %6$s\n"
                + "You see the item: %3$s\n"
                + "========================================================================================================\n",
            inventory, currentLocation, item, description, npc, directions);

    }


    public void startingRoomDescription() {
        String currentLocation = player.getCurrentLocation();
        String directions = Arrays.toString(building.get(currentLocation).getDirections());
        String item = building.get(currentLocation).getItem();
        System.out.printf(
            "========================================================================================================\n"
                + "You are currently at the %1$S\n"
                + "You see the item, %3$s\n"
                + "You can go the to %2$s\n"
                + "========================================================================================================\n",
            currentLocation, directions, item);
        System.out.print(">");
    }

    public String interactWithNpc(String npcName) {
        if(GameMusic.getNpcAudioClip() != null){
            GameMusic.getNpcAudioClip().stop();
        }
        String response = null;
        for (String npc : npcs.keySet()) {
            if (npc.equals(npcName) && player.getCurrentLocation()
                .equals(npcs.get(npc).getLocation())) {
                if (!player.getInventory().contains(npcs.get(npc).getPrereq())
                    && npcs.get(npc).getNpcCount() == 0) {
                    response = String.format(npcs.get(npc).getInitialDialogue(), player.getName());
                    // Play initial sound
                    GameMusic.playNPCSound(npcs.get(npc).getInitialAudio());
                    npcs.get(npc).getNpcCount();
                    break;
                } else if (player.getInventory().contains((npcs.get(npc).getPrereq()))) {

                    response = String.format((npcs.get(npc).getDialogueWithItem()),
                        player.getName());
                    player.removeFromInventory((npcs.get(npc).getPrereq()));
                    player.addToInventory((npcs.get(npc).getItems()));
                    // Play audio with item
                    GameMusic.playNPCSound(npcs.get(npc).getAudioWithItem());
                    npcs.get(npc).setItems(null);
                    break;
                } else if ((npcs.get(npc).getItems()) == null) {
                    response = String.format((npcs.get(npc).getDialogueQuestDone()),
                        player.getName());
                    // Play audio with quest completed
                    GameMusic.playNPCSound(npcs.get(npc).getAudioQuestDone());
                    break;
                } else if (!player.getInventory().contains((npcs.get(npc).getPrereq()))
                    && npcs.get(npc).getNpcCount() >= 1) {
                    // Play audio no item
                    response = String.format(npcs.get(npc).getDialogueNoItem(), player.getName());
                    GameMusic.playNPCSound(npcs.get(npc).getAudioNoItem());
                    break;
                }
            }
        }
        return response;
    }

    public void setName(String name) {
        player.setName(name);

    }

    public String getName() {
        return player.getName();
    }

    public Player getPlayer() {
        return player;
    }

    public HashMap<String, Room> getBuilding() {
        return building;
    }

    public HashMap<String, Item> getGameItems() {
        return items;
    }

    public class CantGetItemException extends Throwable {

    }

}











