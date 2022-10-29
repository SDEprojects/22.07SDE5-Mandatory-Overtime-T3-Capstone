package com.mandatory_overtime.controller;


import com.mandatory_overtime.model.Building;
import com.mandatory_overtime.model.Building.CantGetItemException;
import com.mandatory_overtime.model.Player;
import com.mandatory_overtime.model.exception.MissingRequirementException;
import com.mandatory_overtime.view.GuiView;
import com.mandatory_overtime.view.UserView;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class GUIController {

    private GuiView view;

    private final JButton startBtn;

    private final JButton loadBtn;
    Building building = new Building();

    private String message = "";

    private String removedItem;

    private UserView stringMessages = new UserView();


    public GUIController() throws IOException {
        view = new GuiView();
        view.presentMainMenu();
        loadBtn = view.getLoadGameButton();
        startBtn = view.getNewGameButton();
        loadActionEvents();
    }

    public void startNewGame() throws IOException {
        // Create New Building
        building.createGameStructureFromNew();

        String playerName;
        playerName =  JOptionPane.showInputDialog("What is you name? ");
        building.setName(playerName);
        // Set up Game Screen
        view.setUpGamePlay(building.getBuilding(), building.getGameItems());

        // Set up Move Consumers for Game
        view.setMoveConsumer(roomName -> {
            try {
                building.moveRooms2(roomName);
                String currentLocation = building.getPlayer().getCurrentLocation();
                String description = building.getBuilding().get(currentLocation).getDescription();
                String item = building.getBuilding().get(currentLocation).getItem();
                message = stringMessages.gameStatus(currentLocation,description,item );
                updateGameView();
            } catch (MissingRequirementException | InterruptedException e) {
                message = "Couldn't move to that location";
            }
        });

        //Set up Item pickup consumer
        view.getGamePlayScreen().getLocationGUIPanel().setItemPickupListener(
            itemName -> {
                try {
                    building.getItem(itemName);
                    removedItem = itemName;
                    message = "You picked up " + itemName;
                    updateGameView();
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (MissingRequirementException | CantGetItemException e){
                    message = e.getMessage();
                }
            });

        view.getGamePlayScreen().getLocationGUIPanel().setNpcListener(npcName -> {
                message = building.interactWithNpc(npcName);
                updateGameView();
            }
        );


        // Set Message TO Intro Story
        message = "Starting in the Office";

        // Update View
        updateGameView();

        // Present View
        view.presentGameScreen();
    }

    public void updateGameView() {
        String currentLocation = building.getPlayer().getCurrentLocation();
        String[] directions = building.getBuilding().get(currentLocation).getDirections();
        List<String> inventory = building.getPlayer().getInventory();
        view.updateGameScreen(currentLocation, inventory, message, directions, removedItem);
    }

    public void loadActionEvents() {
        startBtn.addActionListener(e -> {
            try {
                startNewGame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

    }


}
