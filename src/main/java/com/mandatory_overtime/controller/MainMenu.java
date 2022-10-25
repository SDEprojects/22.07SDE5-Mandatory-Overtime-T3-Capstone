package com.mandatory_overtime.controller;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MainMenu {
    private final SettingsMenu settingsMenu = new SettingsMenu();
    private JLayeredPane homeScreen;

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
        ImageIcon mainMenuImage = new ImageIcon("mainscreen.png");
        JLabel imageSection = new JLabel(mainMenuImage);
        imageSection.setSize(1500, 800);

        // Start Button
        Icon icon = new ImageIcon("newgame.png");
        JButton startButton = new JButton(icon);
        startButton.setBounds(500, 575, 225, 75);
        startButton.setFocusPainted(false);
        startButton.setContentAreaFilled(false);

        // Load Game Button
        Icon loadBtnIcon = new ImageIcon("loadgameBtn.png");
        JButton loadBtn = new JButton(loadBtnIcon);
        loadBtn.setBounds(825, 575, 225, 75);
        loadBtn.setFocusPainted(false);
        loadBtn.setContentAreaFilled(false);

        homeScreen.add(settingsBar, Integer.valueOf(1));
        homeScreen.add(imageSection, Integer.valueOf(0));
        homeScreen.add(startButton, Integer.valueOf(2));
        homeScreen.add(loadBtn, Integer.valueOf(2));

    }

    public JLayeredPane getHomeScreen(){
        return homeScreen;
    }

}
