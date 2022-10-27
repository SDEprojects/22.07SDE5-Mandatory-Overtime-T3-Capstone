package com.mandatory_overtime.controller;


import com.mandatory_overtime.model.Building;
import com.mandatory_overtime.model.Player;
import com.mandatory_overtime.view.GuiView;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;


public class GUIController {
    private GuiView view;
    private final JButton startBtn;
    private final JButton loadBtn;
    Building building = new Building();



    Player player = new Player();

    public GUIController() throws IOException {
        building.createGameStructureFromNew();
        view = new GuiView(building.getBuilding());
        view.presentMainMenu();
        loadBtn = view.getLoadGameButton();
        startBtn = view.getNewGameButton();

        loadActionEvents();
    }

    public void startGame(){
        //String currentLocation = player.getCurrentLocation();
        String currentLocation = "lobby";
        String[] directions = building.getBuilding().get(currentLocation).getDirections();
        System.out.println(Arrays.toString(directions));
        String message = "Whatever feedback we get from building methods";
        List<String> inventory = player.getInventory();
        player.setName("PLAYER 1");
        view.updateGameScreen(currentLocation,inventory, message, directions );
        view.presentGameScreen();
    }



    public void loadActionEvents(){
        startBtn.addActionListener( e -> startGame());
        loadBtn.addActionListener( e -> startGame());

    }



}
