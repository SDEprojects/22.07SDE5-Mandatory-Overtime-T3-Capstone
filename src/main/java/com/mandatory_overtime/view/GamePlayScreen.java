package com.mandatory_overtime.view;


import com.mandatory_overtime.controller.GamePlay;
import com.mandatory_overtime.model.Building;
import com.mandatory_overtime.model.Item;
import com.mandatory_overtime.model.Room;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
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
    private LocationGUIPanel locationGUIPanel;


    private final SettingsMenu settingsMenu = new SettingsMenu();
    private final HelpMenu helpMenu = new HelpMenu();
    private final Building building = new Building();




    private Consumer<String> moveListener;
    private final JLayeredPane gameScreen = new JLayeredPane();
    private final JPanel settingsBar = new JPanel();
    private final JPanel gameTextContainer = new JPanel();


    private final JPanel locationContainer = new JPanel();
    private final JPanel gameInfoContainer = new JPanel();
    private final JPanel inventoryContainer = new JPanel();

    JLabel gameMessage = new JLabel();
    JLabel gameInfoText = new JLabel();

    public GamePlayScreen(HashMap locations, HashMap items) throws IOException {
        buildLocationGUI(locations, items);
        buildGamePLayScreen();
    }

    private void buildGamePLayScreen() throws IOException {
        // Settings BUTTON
        JButton settingsBtn = new JButton("Settings");
        settingsBtn.addActionListener(e -> settingsMenu.openMenu());

        // Help BUTTON
        JButton helpBtn = new JButton("Help");
        helpBtn.setToolTipText("Enter Prompt");
        helpBtn.addActionListener(e -> helpMenu.openHelpMenu());

        // Save BUTTON

        //TODO: Fix error( throws an exception in line 112 (Building.java))
        JButton saveBtn = new JButton("Save Game");
        saveBtn.setToolTipText("Click to save game");
//        saveBtn.addActionListener(e -> {
//            try {
//                building.gameSave();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });

        //Quit BUTTON

        JButton quitBtn = new JButton("Quit Game");
        quitBtn.setToolTipText("Click to quit game");
        quitBtn.addActionListener(e ->building.quit() );


        // SETTINGS BAR
        settingsBar.setBackground(Color.DARK_GRAY);
        settingsBar.setBounds(0, 0, 1500, 40);
        settingsBar.add(settingsBtn);
        settingsBar.add(helpBtn);
        settingsBar.add(saveBtn);
        settingsBar.add(quitBtn);

        // GAME MESSAGE
        gameMessage.setFont(new Font("Arial", Font.ITALIC, 25));
        gameMessage.setBounds(10, 25, 1500, 125);

        // GAME TEXT SECTION
        gameTextContainer.setLayout(null);
        gameTextContainer.setBounds(0, 25, 1500, 120);
        gameTextContainer.setBackground(Color.GRAY);
        gameTextContainer.add(gameMessage);

        // LOCATION SECTION
        locationContainer.setBounds(0, 100, 1100, 700);
        locationContainer.setLayout(null);

        // GAME INFO SECTION
        gameInfoText.setBounds(10, 20, 400, 20);
        JPanel buttonPanel = new JPanel();
        gameInfoContainer.setLayout(null);
        // gameInfo.setBackground(Color.GRAY);

        gameInfoContainer.setBounds(1100, 150, 375, 145);

        gameInfoContainer.add(gameInfoText);


        // GAME INFO BORDER
        // TitledBorder gameInfoBorder = BorderFactory.createTitledBorder("GAME INFORMATION");
        // gameInfoBorder.setTitleJustification(TitledBorder.CENTER);
        Border gameInfoBorder = BorderFactory.createStrokeBorder(new BasicStroke(5.0f));
        gameInfoContainer.setBorder(gameInfoBorder);


        // Border
        TitledBorder inventoryBorder = BorderFactory.createTitledBorder("INVENTORY");
        inventoryBorder.setTitleJustification(TitledBorder.CENTER);
        inventoryContainer.setBorder(inventoryBorder);
        inventoryContainer.setBackground(Color.LIGHT_GRAY);
        inventoryContainer.setBounds(1100, 300, 375, 450);

        // ADD ALL TO GAMESCREEN
        gameScreen.add(locationContainer);
        gameScreen.add(inventoryContainer);
        gameScreen.add(gameInfoContainer);
        gameScreen.add(gameTextContainer);
        gameScreen.add(settingsBar);

        gameScreen.setLayer(gameTextContainer, 2);
        gameScreen.setLayer(inventoryContainer, 0);
        gameScreen.setLayer(locationContainer, 1);
        gameScreen.setLayer(settingsBar, 3);

    }

    public JLayeredPane getGameScreen() {
        return gameScreen;
    }

    public void updateGamePlayScreen(String location, List<String> inventory, String message,
        String[] directions,String removedItem) {


        Component[] comp = LOCATION_GUI_PANELS.get(location).getComponents();

        for(int i = 0; i < comp.length; i++){
            if(comp[i] instanceof JButton && ((JButton) comp[i]).getActionCommand().equals(removedItem)){
                LOCATION_GUI_PANELS.get(location).remove(i);
                break;
            }
        }


        gameTextContainer.removeAll();
        gameInfoContainer.removeAll();
        inventoryContainer.removeAll();
        locationContainer.removeAll();

        // UPDATE GAME TEXT
        gameMessage.setText("<html>" + message + "</html>");
        gameTextContainer.add(gameMessage);
        gameTextContainer.revalidate();
        gameTextContainer.repaint();

        // UPDATE LOCATION
        locationContainer.add(LOCATION_GUI_PANELS.get(location));
        locationContainer.revalidate();
        locationContainer.repaint();

        // UPDATE GAME INFO SECTION
        gameInfoText.setText("Current Location:\t    " + location.toUpperCase());
        gameInfoContainer.add(gameInfoText);
        gameInfoContainer.revalidate();
        gameInfoContainer.repaint();

        // DIRECTIONAL BUTTONS
        for (int i = 0; i < directions.length; i++) {
            int x = i == 0 ? 10 : i * 125;
            if( !directions[i].equals("1") &&
                !directions[i].equals("2")&&
                !directions[i].equals("3") &&
                !directions[i].equals("4")&&
                !directions[i].equals("5")){

                JButton btn = new JButton(directions[i]);
                btn.addActionListener(e -> {
                    String roomName = e.getActionCommand();
                    moveListener.accept(roomName);
                });
                btn.setBounds(x, 50, 100, 30);
                gameInfoContainer.add(btn);
            }

        }
        gameInfoContainer.revalidate();
        gameInfoContainer.repaint();

        // INVENTORY SECTION
        // UPDATE INVENTORY VIEW
        for (String item : inventory) {
            ImageIcon itemImageIcon;
            try (InputStream imgStream = getClass().getResourceAsStream(
                "/images/thumbnails/" + item + ".png")) {
                if (imgStream != null) {
                    itemImageIcon = new ImageIcon(ImageIO.read(imgStream));
                    JLabel itemImageLabel = new JLabel(itemImageIcon);
                    inventoryContainer.add(itemImageLabel);
                } else {
                    JLabel inventoryText = new JLabel(item);
                    inventoryContainer.add(inventoryText);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        inventoryContainer.revalidate();
        inventoryContainer.repaint();

        gameScreen.setLayer(gameTextContainer, 2);
        gameScreen.setLayer(inventoryContainer, 0);
        gameScreen.setLayer(locationContainer, 1);
        gameScreen.setLayer(settingsBar, 3);


    }


    public void buildLocationGUI(HashMap locations, HashMap items) {
        locationGUIPanel = new LocationGUIPanel(locations, items);
        LOCATION_GUI_PANELS = locationGUIPanel.getLocationsGuiPanels();
    }


    public LocationGUIPanel getLocationGUIPanel() {
        return locationGUIPanel;
    }

    public void setMoveListener(Consumer<String> listener) {
        moveListener = listener;
        locationGUIPanel.setMoveLocationListener(listener);
    }
}
