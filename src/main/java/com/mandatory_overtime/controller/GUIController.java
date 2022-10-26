package com.mandatory_overtime.controller;


import java.awt.Dimension;
import java.io.IOException;
import javax.swing.*;



public class GUIController {

    private final JFrame frame;
    private final MainMenu mainMenu = new MainMenu();

    private final JButton startBtn = MainMenu.getStartBtn();
    private final JButton loadBtn = MainMenu.getLoadBtn();



    private GamePlayScreen gamePlayScreen = new GamePlayScreen();



    public GUIController() {
        frame = new JFrame("Mandatory Overtime");
        frame.setPreferredSize(new Dimension(1500, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadMainMenu();
    }

    public void loadMainMenu(){
        displayLoadingScreen();
        frame.getContentPane().removeAll();
        JLayeredPane menu = MainMenu.getHomeScreen();
        startBtn.addActionListener(e -> loadGamePlayScreen());
        loadBtn.addActionListener(e -> loadGamePlayScreen());
        frame.add(menu);
        frame.pack();
        frame.setVisible(true);

    }


    public void loadGamePlayScreen() {
        displayLoadingScreen();
        frame.getContentPane().removeAll();
        JLayeredPane screen = gamePlayScreen.getGameScreen();
        frame.add(screen);
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

    public void openInstructionsMenu(){

    }

    public void displayLoadingScreen(){
        JLayeredPane menu = MainMenu.getLoadingScreen();
        startBtn.addActionListener(e -> loadGamePlayScreen());
        loadBtn.addActionListener(e -> loadGamePlayScreen());
        frame.add(menu);
        frame.pack();
        frame.setVisible(true);
        MainMenu.loadProgressBar();
    }

}
