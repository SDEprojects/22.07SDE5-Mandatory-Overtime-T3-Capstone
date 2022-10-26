package com.mandatory_overtime.controller;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MainMenu {
    private final SettingsMenu settingsMenu = new SettingsMenu();
    private JLayeredPane homeScreen;

    private JButton startBtn;
    private JButton loadBtn;

    public MainMenu(){
        buildMainMenu();
    }

    public void buildMainMenu(){
        homeScreen = new JLayeredPane();

        // Settings BUTTON
        JButton settingsBtn = new JButton("Settings");
        settingsBtn.addActionListener(e -> settingsMenu.openMenu());

        // Help BUTTON
        JButton helpBtn = new JButton("Help");

        // Settings Bar
        JPanel settingsBar = new JPanel();
        settingsBar.setBackground(Color.DARK_GRAY);
        settingsBar.setBounds(0, 0, 1500, 40);
        settingsBar.add(settingsBtn);
        settingsBar.add(helpBtn);

        // BackGroundImage
        ImageIcon mainMenuImage = new ImageIcon("mainMenu.png");
        JLabel imageSection = new JLabel(mainMenuImage);
        imageSection.setSize(1500, 800);

        // Start Button
        Icon icon = new ImageIcon("newgame.png");
        startBtn = new JButton(icon);
        startBtn.setBounds(500, 575, 225, 75);
        startBtn.setFocusPainted(false);
        startBtn.setContentAreaFilled(false);


        // Load Game Button
        Icon loadBtnIcon = new ImageIcon("loadgameBtn.png");
        loadBtn = new JButton(loadBtnIcon);
        loadBtn.setBounds(825, 575, 225, 75);
        loadBtn.setFocusPainted(false);
        loadBtn.setContentAreaFilled(false);

        homeScreen.add(settingsBar, Integer.valueOf(1));
        homeScreen.add(imageSection, Integer.valueOf(0));
        homeScreen.add(startBtn, Integer.valueOf(2));
        homeScreen.add(loadBtn, Integer.valueOf(2));

    }


    public JLayeredPane getHomeScreen(){
        return homeScreen;
    }

    public JButton getStartBtn(){
        return startBtn;
    }

    public JButton getLoadBtn(){
        return loadBtn;
    }

}
