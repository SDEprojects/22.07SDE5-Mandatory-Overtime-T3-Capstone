package com.mandatory_overtime.controller;


import com.mandatory_overtime.model.Building;
import com.mandatory_overtime.view.GuiView;
import java.io.IOException;
import javax.swing.JButton;


public class GUIController {
    private GuiView view;
    private final JButton startBtn;
    private final JButton loadBtn;
    Building building = new Building();
    public GUIController() throws IOException {
        building.createGameStructureFromNew();
        view = new GuiView();
        view.presentMainMenu();
        loadBtn = view.getLoadGameButton();
        startBtn = view.getNewGameButton();

        view.buildLocationGUI(building.getBuilding());

        loadActionEvents();
    }

    public void startGame(){
        view.presentGameScreen();
    }



    public void loadActionEvents(){
        startBtn.addActionListener( e -> startGame());
        loadBtn.addActionListener( e -> startGame());

    }



}
