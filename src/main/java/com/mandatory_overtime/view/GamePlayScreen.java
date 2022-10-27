package com.mandatory_overtime.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class GamePlayScreen {

    private static Map<String, JLayeredPane> LOCATION_GUI_PANELS;
    private final SettingsMenu settingsMenu = new SettingsMenu();
    private JLayeredPane gameScreen;

    public GamePlayScreen(HashMap locations, HashMap items){
        buildLocationGUI(locations, items);

    }
    public JLayeredPane getGameScreen(){
        return gameScreen;
    }

    public void buildGamePlayScreen(String location, List<String> inventory,String message,
        String[] directions){
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

        // GAME MESSAGE
        JLabel gameMessage = new JLabel(message);
        gameMessage.setFont(new Font("Arial", Font.BOLD, 25));
        gameMessage.setBounds(10, 25, 1500, 125);

        // GAME TEXT SECTION
        JPanel gameTextSection = new JPanel();
        gameTextSection.setLayout(null);
        gameTextSection.setBounds(0,25,1500, 120);
        gameTextSection.setBackground(Color.GRAY);
        gameTextSection.add(gameMessage);





        // LOCATION SECTION
        JLayeredPane locationPanel = LOCATION_GUI_PANELS.get(location);
        locationPanel.setBounds(0, 100, 1100, 700);



        // GAME INFO SECTION
        JLabel gameInfoText = new JLabel("Current Location:\t    " +location.toUpperCase());
        gameInfoText.setBounds(10, 20, 400, 20);
        JPanel gameInfo = new JPanel();
        JPanel buttonPanel = new JPanel();
        gameInfo.setLayout(null);
       // gameInfo.setBackground(Color.GRAY);
        gameInfo.setBounds(1100, 150,375,145 );
        gameInfo.add(gameInfoText);
        // DIRECTIONAL BUTTONS
        for (int i = 0; i < directions.length; i++){
            int x = i == 0? 10 : i*125;
            JButton btn = new JButton(directions[i]);
            btn.setBounds(x, 50, 100, 30);
            gameInfo.add(btn);
        }

        // GAME INFO BORDER
        // TitledBorder gameInfoBorder = BorderFactory.createTitledBorder("GAME INFORMATION");
        // gameInfoBorder.setTitleJustification(TitledBorder.CENTER);
        Border gameInfoBorder = BorderFactory.createStrokeBorder(new BasicStroke(5.0f));

        gameInfo.setBorder(gameInfoBorder);


        // INVENTORY SECTION
        // ITEMS
        JLabel inventoryText = new JLabel(inventory.toString());
        JLabel raisinets = new JLabel(new ImageIcon("raisinets.png"));
        JLabel mask = new JLabel(new ImageIcon("mask.png"));

        JPanel inventoryView = new JPanel();

        inventoryView.add(inventoryText);
        inventoryView.add(raisinets);
        inventoryView.add(mask);
        // Border
        TitledBorder inventoryBorder = BorderFactory.createTitledBorder("INVENTORY");
        inventoryBorder.setTitleJustification(TitledBorder.CENTER);
        inventoryView.setBorder(inventoryBorder);
        inventoryView.setBackground(Color.LIGHT_GRAY);

        inventoryView.setBounds(1100, 300,375,450 );

        // Button Controls

        gameScreen.add(settingsBar);
        gameScreen.add(gameTextSection);
        gameScreen.add(locationPanel);
        gameScreen.add(inventoryView);
        gameScreen.add(gameInfo);

    }




    public void buildLocationGUI(HashMap locations, HashMap items){
        LocationGUIPanel locationGUIPanel = new LocationGUIPanel(locations, items);
        LOCATION_GUI_PANELS = locationGUIPanel.getLocationsGuiPanels();
    }


}
