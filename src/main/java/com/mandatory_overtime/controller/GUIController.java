package com.mandatory_overtime.controller;


import com.mandatory_overtime.model.Building;
import com.mandatory_overtime.model.Player;
import com.mandatory_overtime.model.exception.MissingRequirementException;
import com.mandatory_overtime.view.GuiView;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JButton;


public class GUIController {

    private GuiView view;

    private final JButton startBtn;

    private final JButton loadBtn;
    Building building = new Building();

    private String message = "";

    Player player = new Player();

    public GUIController() throws IOException {
        building.createGameStructureFromNew();
        view = new GuiView(building.getBuilding(), building.getGameItems());
        view.presentMainMenu();
        view.setMoveConsumer(roomName -> {
            try {
                System.out.println("Moving to: " + roomName);
                building.moveRooms2(roomName);
                message = "room updated";
                building.getPlayer().addToInventory("phone");
                building.getPlayer().addToInventory("wallet");
                building.getPlayer().addToInventory("sweater");
                updateGameView();
            } catch (MissingRequirementException | InterruptedException e) {
                message = "Couldn't move to that location";
            }
        });
        loadBtn = view.getLoadGameButton();
        startBtn = view.getNewGameButton();

        loadActionEvents();
    }

    public void startGame(){
        building.setName("Player 1");
        building.getPlayer().addToInventory("laptop");
        message = "Starting in the Office";
        updateGameView();
        view.presentGameScreen();
    }

    public void updateGameView() {
        String currentLocation = building.getPlayer().getCurrentLocation();
        String[] directions = building.getBuilding().get(currentLocation).getDirections();
        List<String> inventory = building.getPlayer().getInventory();
        view.updateGameScreen(currentLocation, inventory, message, directions);

    }

    public void loadActionEvents() {
        startBtn.addActionListener(e -> startGame());

    }


}
