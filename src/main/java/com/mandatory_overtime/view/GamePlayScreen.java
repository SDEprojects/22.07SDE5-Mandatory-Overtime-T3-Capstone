package com.mandatory_overtime.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class GamePlayScreen {

    private static Map<String, JLayeredPane> LOCATION_GUI_PANELS;
    private final SettingsMenu settingsMenu = new SettingsMenu();
    private final HelpMenu helpMenu = new HelpMenu();
    private Consumer<String> moveListener;
    private JLayeredPane gameScreen = new JLayeredPane();
    private JPanel settingsBar = new JPanel();
    private JPanel gameTextSection = new JPanel();
    private JLayeredPane locationPanel;
    private JPanel gameInfo = new JPanel();
    private JPanel inventoryView = new JPanel();

    JLabel gameMessage = new JLabel();
    JLabel gameInfoText = new JLabel();

    public GamePlayScreen(HashMap locations) {
        buildLocationGUI(locations);
        buildGamePLayScreen();
    }

    private void buildGamePLayScreen() {
        // Settings BUTTON
        JButton settingsBtn = new JButton("Settings");
        settingsBtn.addActionListener(e -> settingsMenu.openMenu());

        // Help BUTTON
        JButton helpBtn = new JButton("Help");
        helpBtn.setToolTipText("Enter Prompt");
//        helpBtn.addActionListener(e->helpMenu.openHelpMenu());

        // Save BUTTON
        JButton saveBtn = new JButton("Save Game");

        // SETTINGS BAR
        settingsBar.setBackground(Color.DARK_GRAY);
        settingsBar.setBounds(0, 0, 1500, 40);
        settingsBar.add(settingsBtn);
        settingsBar.add(helpBtn);
        settingsBar.add(saveBtn);

        // GAME MESSAGE
        gameMessage.setFont(new Font("Arial", Font.BOLD, 25));
        gameMessage.setBounds(10, 25, 1500, 125);

        // GAME TEXT SECTION
        gameTextSection.setLayout(null);
        gameTextSection.setBounds(0, 25, 1500, 120);
        gameTextSection.setBackground(Color.GRAY);
        gameTextSection.add(gameMessage);

        // LOCATION SETTING
        locationPanel = LOCATION_GUI_PANELS.get("office");
        locationPanel.setBounds(0, 100, 1100, 700);

        // GAME INFO SECTION
        gameInfoText.setBounds(10, 20, 400, 20);
        JPanel buttonPanel = new JPanel();
        gameInfo.setLayout(null);
        // gameInfo.setBackground(Color.GRAY);
        gameInfo.setBounds(1100, 150, 375, 145);
        gameInfo.add(gameInfoText);

        // GAME INFO BORDER
        // TitledBorder gameInfoBorder = BorderFactory.createTitledBorder("GAME INFORMATION");
        // gameInfoBorder.setTitleJustification(TitledBorder.CENTER);
        Border gameInfoBorder = BorderFactory.createStrokeBorder(new BasicStroke(5.0f));
        gameInfo.setBorder(gameInfoBorder);

        // Border
        TitledBorder inventoryBorder = BorderFactory.createTitledBorder("INVENTORY");
        inventoryBorder.setTitleJustification(TitledBorder.CENTER);
        inventoryView.setBorder(inventoryBorder);
        inventoryView.setBackground(Color.LIGHT_GRAY);
        inventoryView.setBounds(1100, 300, 375, 450);

        // ADD ALL TO GAMESCREEN
        gameScreen.add(settingsBar);
        gameScreen.add(gameTextSection);
        gameScreen.add(locationPanel);
        gameScreen.add(inventoryView);
        gameScreen.add(gameInfo);
    }

    public JLayeredPane getGameScreen() {
        return gameScreen;
    }

    public void updateGamePlayScreen(String location, List<String> inventory, String message,
        String[] directions) {

        // UPDATE GAME TEXT
        gameMessage.setText(message);

        // UPDATE LOCATION
        locationPanel = LOCATION_GUI_PANELS.get(location);

        // UPDATE GAME INFO SECTION
        gameInfoText.setText("Current Location:\t    " + location.toUpperCase());

        // DIRECTIONAL BUTTONS
        for (int i = 0; i < directions.length; i++) {
            int x = i == 0 ? 10 : i * 125;
            JButton btn = new JButton(directions[i]);
            btn.addActionListener(e -> {
                String roomName = e.getActionCommand();
                moveListener.accept(roomName);
            });
            btn.setBounds(x, 50, 100, 30);
            gameInfo.add(btn);
        }

        // INVENTORY SECTION
        // ITEMS
        JLabel inventoryText = new JLabel(inventory.toString());
        ImageIcon itemImage;
        try (InputStream img1 = getClass().getResourceAsStream("/images/raisinets.png");){
            itemImage = new ImageIcon(ImageIO.read(img1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel raisinets = new JLabel(itemImage);
        inventoryView.add(inventoryText);
        inventoryView.add(raisinets);
    }


    public void buildLocationGUI(HashMap locations) {
        LocationGUIPanel locationGUIPanel = new LocationGUIPanel(locations);
        LOCATION_GUI_PANELS = locationGUIPanel.getLocationsGuiPanels();
    }

    public void setMoveListener(Consumer<String> listener) {
        moveListener = listener;
    }
}
