package com.mandatory_overtime.controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GamePlayScreen {

    private final SettingsMenu settingsMenu = new SettingsMenu();
    private JLayeredPane gameScreen;

    public GamePlayScreen(){
        buildGamePlayScreen();
    }

    private void buildGamePlayScreen(){
        gameScreen = new JLayeredPane();

        // Settings BUTTON
        JButton settingsBtn = new JButton("Settings");
        settingsBtn.addActionListener(e -> settingsMenu.openMenu());

        // Help BUTTON
        JButton helpBtn = new JButton("Help");

        // Save BUTTON
        JButton saveBtn = new JButton("Save Game");

        // SETTINGS BAR
        JPanel settingsBar = new JPanel();
        settingsBar.setBackground(Color.DARK_GRAY);
        settingsBar.setBounds(0, 0, 1500, 40);
        settingsBar.add(settingsBtn);
        settingsBar.add(helpBtn);
        settingsBar.add(saveBtn);

        // GAME TEXT SECTION
        JPanel gameTextSection = new JPanel();
        gameTextSection.setBounds(0,25,1500, 125);
        gameTextSection.setBackground(Color.BLACK);

        // LOCATION SECTION
        ImageIcon img = new ImageIcon("location_office.png");
        JLabel locationImage= new JLabel(img);
        JPanel locationPanel = new JPanel();
        locationPanel.add(locationImage);
        locationPanel.setBounds(0, 150, 1100, 700);


        // GAME INFO SECTION
        JPanel gameInfo = new JPanel();
        gameInfo.setBackground(Color.YELLOW);
        gameInfo.setBounds(1100, 150,400,150 );

        // INVENTORY SECTION
        JLabel inventoryLabel = new JLabel("INVENTORY");
        JPanel inventoryHeader = new JPanel();

        inventoryHeader.setBounds(0,0,400, 10);
        inventoryHeader.add(inventoryLabel);
        inventoryHeader.setBackground(Color.GRAY);

        JLabel raisinets = new JLabel(new ImageIcon("raisinets.png"));
        JLabel mask = new JLabel(new ImageIcon("mask.png"));
        JPanel inventoryView = new JPanel(new FlowLayout());
        inventoryView.add(inventoryHeader);
        inventoryView.add(raisinets);
        inventoryView.add(mask);
        inventoryView.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        inventoryView.setBounds(1100, 300,400,475 );



        gameScreen.add(settingsBar);
        gameScreen.add(gameTextSection);
        gameScreen.add(locationPanel);
        gameScreen.add(inventoryView);
        gameScreen.add(gameInfo);

    }

    public JLayeredPane getGameScreen(){
        return gameScreen;
    }

}
