package com.mandatory_overtime.controller;


import java.awt.Dimension;
import java.io.IOException;
import javax.swing.*;



public class GUIController {

    private JFrame frame;
    private final MainMenu mainMenu = new MainMenu();
    private GamePlayScreen gamePlayScreen = new GamePlayScreen();


    public GUIController() {
        frame = new JFrame("Mandatory Overtime");
        frame.setPreferredSize(new Dimension(1500, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadMainMenu();
    }

    public void loadMainMenu(){
        JLayeredPane menu = mainMenu.getHomeScreen();
        JButton startButton = mainMenu.getStartBtn();
        JButton loadButton = mainMenu.getLoadBtn();
        startButton.addActionListener(e -> loadGamePlayScreen());
        loadButton.addActionListener(e -> loadGamePlayScreen());
        frame.add(menu);
        frame.pack();
        frame.setVisible(true);
    }


    public void loadGamePlayScreen() {
        System.out.println("Loading");
        frame.getContentPane().removeAll();
        JLayeredPane gameScreen = gamePlayScreen.getGameScreen();
        frame.add(gameScreen);
        frame.pack();
        frame.setVisible(true);
    }

    //this will update view
    public void updateView() {

    }

    public void openHelpMenu(){
        JDialog helpDialog = new JDialog(new JFrame(), true);
        helpDialog.setTitle("Help");
        helpDialog.setBounds(500, 100, 400, 300);
        helpDialog.setVisible(true);
    }
}
