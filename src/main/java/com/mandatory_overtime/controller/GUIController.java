package com.mandatory_overtime.controller;


import com.mandatory_overtime.view.GuiView;
import javax.swing.JButton;


public class GUIController {
    private GuiView view;

//    private final JButton startBtn;
//
//    private final JButton loadBtn;


    public GUIController() {
        view = new GuiView();
        view.presentMainMenu();

        loadActionEvents();
    }

    public void startGame(){
        view.presentGameScreen();
    }

    public void loadActionEvents(){
//        startBtn.addActionListener( e -> startGame());
//        loadBtn.addActionListener( e -> {loadGame()});

    }

}
