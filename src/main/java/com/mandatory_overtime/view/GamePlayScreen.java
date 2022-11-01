package com.mandatory_overtime.view;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class GamePlayScreen {

    private static Map<String, JLayeredPane> LOCATION_GUI_PANELS;
    private LocationGUIPanel locationGUIPanel;

    private Consumer<String> moveListener;
    private final JLayeredPane gameScreen = new JLayeredPane();
    private final JPanel gameTextContainer = new JPanel();

    private final JPanel locationContainer = new JPanel();
    private final JPanel gameInfoContainer = new JPanel();
    private final JPanel inventoryContainer = new JPanel();

    private final JMenuBar menu = MenuBar.getMenuBar();

    JLabel gameMessage = new JLabel();
    JLabel gameInfoText = new JLabel();


    public GamePlayScreen(HashMap locations, HashMap items) throws IOException {
        buildLocationGUI(locations, items);
        buildGamePLayScreen();
    }

    private void buildGamePLayScreen() throws IOException {
        MenuBar.showGameBtn();
        // GAME MESSAGE
        gameMessage.setFont(new Font("Arial", Font.ITALIC, 25));
        gameMessage.setBounds(10, 15, 1450, 125);

        // GAME TEXT SECTION
        gameTextContainer.setLayout(null);
        gameTextContainer.setBounds(0, 25, 1500, 120);
        gameTextContainer.setBackground(Color.BLACK);
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
        gameScreen.add(menu);

        gameScreen.setLayer(gameTextContainer, 2);
        gameScreen.setLayer(inventoryContainer, 0);
        gameScreen.setLayer(locationContainer, 1);
        gameScreen.setLayer(menu, 3);

    }

    public JLayeredPane getGameScreen() {
        return gameScreen;
    }

    public void updateGamePlayScreen(String location, List<String> inventory, String message,
        String[] directions, String removedItem) {

        Component[] comp = LOCATION_GUI_PANELS.get(location).getComponents();

        for (int i = 0; i < comp.length; i++) {
            if (comp[i] instanceof JButton && ((JButton) comp[i]).getActionCommand()
                .equals(removedItem)) {
                LOCATION_GUI_PANELS.get(location).remove(i);
                break;
            }
        }

        gameTextContainer.removeAll();
        gameInfoContainer.removeAll();
        inventoryContainer.removeAll();
        locationContainer.removeAll();

        // UPDATE MAP
        MapDialog.updateMap(location);

        // UPDATE GAME TEXT
        gameMessage.setText("<html>" + message + "</html>");
        gameMessage.setFont(new Font("Serif", Font.ITALIC, 22));
        gameMessage.setForeground(Color.white);

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
        if(directions != null){

            for (int i = 0; i < directions.length; i++) {
                int x = i == 0 ? 10 : i * 125;
                if (!directions[i].equals("1") &&
                    !directions[i].equals("2") &&
                    !directions[i].equals("3") &&
                    !directions[i].equals("4") &&
                    !directions[i].equals("5")) {

                    JButton btn = new JButton(directions[i]);
                    btn.addActionListener(e -> {
                    String roomName = e.getActionCommand();
                        moveListener.accept(roomName);
                });
                    btn.setBounds(x, 50, 100, 30);
                    gameInfoContainer.add(btn);
                }

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
        // gameScreen.setLayer(settingsBar, 3);

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
