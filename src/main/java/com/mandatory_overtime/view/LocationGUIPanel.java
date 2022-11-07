package com.mandatory_overtime.view;

import com.mandatory_overtime.model.Item;
import com.mandatory_overtime.model.Room;
import java.awt.Cursor;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class LocationGUIPanel {

    private Map<String, JLayeredPane> locationsGuiPanels;
    private final Map<String, Item> gameItems;


    private Consumer<String> itemPickupListener;

    private Consumer<String> moveLocationListener;

    private Consumer<String> npcListener;

    private final String[] elevatorButtonNames = new String[]{"1", "2", "3", "4", "5"};
    private final String[] elevator_1_ButtonNames = new String[]{"2", "3", "4", "5"};
    private final String[] elevator_2_ButtonNames = new String[]{"1", "3", "4", "5"};
    private final String[] elevator_3_ButtonNames = new String[]{"1", "2", "4", "5"};
    private final String[] elevator_4_ButtonNames = new String[]{"1", "2", "3", "5"};
    private final String[] elevator_5_ButtonNames = new String[]{"1", "2", "3", "4"};


    public LocationGUIPanel(Map<String, Room> map, Map<String, Item> items) {
        gameItems = items;
        locationsGuiPanels = generateLocationPanels(map);
    }

    public Map<String, JLayeredPane> getLocationsGuiPanels() {
        return locationsGuiPanels;
    }

    private Map<String, JLayeredPane> generateLocationPanels(Map<String, Room> map) {
        locationsGuiPanels = new HashMap<>();
        for (Entry<String, Room> entry : map.entrySet()) {
            JLayeredPane pane = createPane(entry.getValue().getImage(), entry.getKey(),
                entry.getValue().getItem(), entry.getValue());
            locationsGuiPanels.put(entry.getKey(), pane);
        }
        return locationsGuiPanels;
    }

    private JLayeredPane createPane(String imageUrl, String locationName, String itemName, Room room) {
        JLayeredPane pane = new JLayeredPane();

        // GET IMAGE FOR LOCATION
        try {
            InputStream stream = getClass().getResourceAsStream("/images/" + imageUrl);
            ImageIcon img = new ImageIcon(ImageIO.read(stream));

            // CREATES LOCATION IMAGE
            JLabel locationImage = new JLabel(img);
            locationImage.setSize(1100, 700);

            // ADDS LOCATION ITEM BUTTON
            if (gameItems.get(itemName) != null) {
                JButton itemButton = createItemButton(gameItems.get(itemName));
                pane.add(itemButton);
            }

            // ADDS NPC BUTTON
            if(room.getNPC() != null){
                JButton npcButton = createNPCButton(room);
                pane.add(npcButton);
            }


            // IF THE LOCATION IS Elevator add the elevator buttons
            switch (locationName) {
                case "elevator":
                    for (int i = 0; i < elevatorButtonNames.length; i++) {
                        pane.add(createElevatorButton(elevatorButtonNames[i]));
                    }
                    break;
                case "1":
                    for (int i = 0; i < elevator_1_ButtonNames.length; i++) {
                        pane.add(createElevatorButton(elevator_1_ButtonNames[i]));
                    }
                    break;
                case "2":
                    for (int i = 0; i < elevator_2_ButtonNames.length; i++) {
                        pane.add(createElevatorButton(elevator_2_ButtonNames[i]));
                    }
                    break;
                case "3":
                    for (int i = 0; i < elevator_3_ButtonNames.length; i++) {
                        pane.add(createElevatorButton(elevator_3_ButtonNames[i]));
                    }
                    break;
                case "4":
                    for (int i = 0; i < elevator_4_ButtonNames.length; i++) {
                        pane.add(createElevatorButton(elevator_4_ButtonNames[i]));
                    }
                    break;
                case "5":
                    for (int i = 0; i < elevator_5_ButtonNames.length; i++) {
                        pane.add(createElevatorButton(elevator_5_ButtonNames[i]));
                    }
                    break;
                default:
                    break;
            }

            pane.add(locationImage);
            pane.setBounds(10, 10, 1080, 640);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pane;
    }

    private JButton createElevatorButton(String buttonSelection) {
        JButton elevatorBtn_1;
        JButton elevatorBtn_2;
        JButton elevatorBtn_3;
        JButton elevatorBtn_4;
        JButton elevatorBtn_5;

        try {
            InputStream img1 = getClass().getResourceAsStream("/images/elevatorBtn1.png");
            ImageIcon elevatorBtn1Image = new ImageIcon(ImageIO.read(img1));
            elevatorBtn_1 = new JButton(elevatorBtn1Image);
            elevatorBtn_1.setBounds(665, 120, 80, 80);
            elevatorBtn_1.setFocusPainted(false);
            elevatorBtn_1.setContentAreaFilled(false);
            elevatorBtn_1.setBorder(null);
            elevatorBtn_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            elevatorBtn_1.setToolTipText("Click to go To level 1");
            elevatorBtn_1.addActionListener(e -> {
                moveLocationListener.accept(buttonSelection);
            });

            InputStream img2 = getClass().getResourceAsStream("/images/elevatorBtn2.png");
            ImageIcon elevatorBtn2Image = new ImageIcon(ImageIO.read(img2));
            elevatorBtn_2 = new JButton(elevatorBtn2Image);
            elevatorBtn_2.setBounds(665, 215, 80, 80);
            elevatorBtn_2.setFocusPainted(false);
            elevatorBtn_2.setContentAreaFilled(false);
            elevatorBtn_2.setBorder(null);
            elevatorBtn_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            elevatorBtn_2.setToolTipText("Click to go To level 2");
            elevatorBtn_2.addActionListener(e -> {
                moveLocationListener.accept(buttonSelection);
            });

            InputStream img3 = getClass().getResourceAsStream("/images/elevatorBtn3.png");
            ImageIcon elevatorBtn3Image = new ImageIcon(ImageIO.read(img3));
            elevatorBtn_3 = new JButton(elevatorBtn3Image);
            elevatorBtn_3.setBounds(665, 320, 80, 80);
            elevatorBtn_3.setFocusPainted(false);
            elevatorBtn_3.setContentAreaFilled(false);
            elevatorBtn_3.setBorder(null);
            elevatorBtn_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            elevatorBtn_3.setToolTipText("Click to go To level 3");
            elevatorBtn_3.addActionListener(e -> {
                moveLocationListener.accept(buttonSelection);
            });

            InputStream img4 = getClass().getResourceAsStream("/images/elevatorBtn4.png");
            ImageIcon elevatorBtn4Image = new ImageIcon(ImageIO.read(img4));
            elevatorBtn_4 = new JButton(elevatorBtn4Image);
            elevatorBtn_4.setBounds(665, 415, 80, 80);
            elevatorBtn_4.setFocusPainted(false);
            elevatorBtn_4.setContentAreaFilled(false);
            elevatorBtn_4.setBorder(null);
            elevatorBtn_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            elevatorBtn_4.setToolTipText("Click to go To level 4");
            elevatorBtn_4.addActionListener(e -> {
                moveLocationListener.accept(buttonSelection);
            });

            InputStream img5 = getClass().getResourceAsStream("/images/elevatorBtn5.png");
            ImageIcon elevatorBtn5Image = new ImageIcon(ImageIO.read(img5));
            elevatorBtn_5 = new JButton(elevatorBtn5Image);
            elevatorBtn_5.setBounds(665, 515, 80, 80);
            elevatorBtn_5.setFocusPainted(false);
            elevatorBtn_5.setContentAreaFilled(false);
            elevatorBtn_5.setBorder(null);
            elevatorBtn_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            elevatorBtn_5.setToolTipText("Click to go To level 5");
            elevatorBtn_5.addActionListener(e -> {
                moveLocationListener.accept(buttonSelection);
            });

            switch (buttonSelection) {
                case "1":
                    return elevatorBtn_1;
                case "2":
                    return elevatorBtn_2;
                case "3":
                    return elevatorBtn_3;
                case "4":
                    return elevatorBtn_4;
                case "5":
                    return elevatorBtn_5;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new JButton();
    }

    private JButton createItemButton(Item item) {
        JButton itemButton;
        int[] cords = item.getImgCord();
        try {
            InputStream img1 = getClass().getResourceAsStream("/images/" + item.getImage());
            ImageIcon itemImage = new ImageIcon(ImageIO.read(img1));
            // ITEM BUTTON CREATED
            itemButton = new JButton(itemImage);
            itemButton.setActionCommand(item.getName());
            itemButton.setFocusPainted(false);
            itemButton.setContentAreaFilled(false);
            itemButton.setBorderPainted(false);
            itemButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            itemButton.setBounds(cords[0], cords[1], cords[2], cords[3]);
            itemButton.setToolTipText(item.getPurpose());
            itemButton.addActionListener(e -> {
                String itemName = e.getActionCommand();
                itemPickupListener.accept(itemName);
            });
            return itemButton;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private JButton createNPCButton(Room room){
        JButton btn;
        int[] coords = room.getNpcCoord();
        InputStream img = getClass().getResourceAsStream("/images/" + room.getNpcImage());
        try {
            ImageIcon npcImg = new ImageIcon(ImageIO.read(img));
            // ITEM BUTTON CREATED
            btn = new JButton(npcImg);
            btn.setActionCommand(room.getNPC());
            btn.setFocusPainted(false);
            btn.setContentAreaFilled(false);
            btn.setBounds(coords[0], coords[1], coords[2], coords[3]);
            btn.setToolTipText(room.getNPC());
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btn.addActionListener(e -> {
                npcListener.accept(room.getNPC());

           });


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        btn.setBorderPainted(false);
        return btn;
    }

    public void setItemPickupListener(Consumer<String> itemPickupListener) {
        this.itemPickupListener = itemPickupListener;
    }

    public void setMoveLocationListener(Consumer<String> moveLocationListener){
        this.moveLocationListener = moveLocationListener;
    }

    public void setNpcListener(Consumer<String> npcListener) {
        this.npcListener = npcListener;
    }
}
