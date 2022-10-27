package com.mandatory_overtime.view;

import com.mandatory_overtime.model.Room;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class LocationGUIPanel {

    private Map<String, JLayeredPane> locationsGuiPanels;

    private String[] elevatorButtonNames = new String[]{"1","2","3", "4","5"};
    private String[] elevator_1_ButtonNames = new String[]{"2","3", "4","5"};
    private String[] elevator_2_ButtonNames = new String[]{"1","3", "4","5"};
    private String[] elevator_3_ButtonNames = new String[]{"1","2", "4","5"};
    private String[] elevator_4_ButtonNames = new String[]{"1","2","3","5"};
    private String[] elevator_5_ButtonNames = new String[]{"1","2","3", "4"};


    public LocationGUIPanel(Map<String, Room> map) {
        locationsGuiPanels = generateLocationPanels(map);

    }

    public Map<String, JLayeredPane> getLocationsGuiPanels(){
        return locationsGuiPanels;
    }

    private Map<String, JLayeredPane> generateLocationPanels(Map<String, Room> map) {
        locationsGuiPanels = new HashMap<>();
        for (Entry<String, Room> entry : map.entrySet()) {
            JLayeredPane pane = createPane(entry.getValue().getImage(), entry.getKey());
            locationsGuiPanels.put(entry.getKey(), pane);
        }
        return locationsGuiPanels;
    }

    private JLayeredPane createPane(String imageUrl, String locationName){
        JLayeredPane pane = new JLayeredPane();

        // LOCATION SECTION
        try {
            InputStream stream = getClass().getResourceAsStream("/images/"+imageUrl);
            ImageIcon img = new ImageIcon(ImageIO.read(stream));
            // CREATES LOCATION IMAGE
            JLabel locationImage= new JLabel(img);
            locationImage.setSize(1100, 700);

            // ADDS LOCATION ITEM BUTTON
            //TODO get the item for the location and add image as a button
            // set coords for the item on the image
            // save into JSON as x, y coords

            // IF THE LOCATION IS Elevator add the elevator buttons
            switch (locationName){
                case "elevator":
                    for(int i =0; i < elevatorButtonNames.length; i++){
                        pane.add(createButton(elevatorButtonNames[i]));
                    }
                    break;
                case "1":
                    for(int i =0; i < elevator_1_ButtonNames.length; i++){
                        pane.add(createButton(elevator_1_ButtonNames[i]));
                    }
                    break;
                case "2":
                    for(int i =0; i < elevator_2_ButtonNames.length; i++){
                        pane.add(createButton(elevator_2_ButtonNames[i]));
                    }
                    break;
                case "3":
                    for(int i =0; i < elevator_3_ButtonNames.length; i++){
                        pane.add(createButton(elevator_3_ButtonNames[i]));
                    }
                    break;
                case "4":
                    for(int i =0; i < elevator_4_ButtonNames.length; i++){
                        pane.add(createButton(elevator_4_ButtonNames[i]));
                    }
                    break;
                case "5":
                    for(int i =0; i < elevator_5_ButtonNames.length; i++){
                        pane.add(createButton(elevator_5_ButtonNames[i]));
                    }
                    break;
                default:
                    break;
            }


            pane.add(locationImage);
           // pane.add(inventoryItem);

        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pane;
    }

    private JButton createButton(String buttonSelection){
         JButton elevatorBtn_1;
         JButton elevatorBtn_2;
         JButton elevatorBtn_3;
         JButton elevatorBtn_4;
         JButton elevatorBtn_5;

        try {
            InputStream img1 = getClass().getResourceAsStream("/images/elevatorBtn1.png");
            ImageIcon elevatorBtn1Image = new ImageIcon(ImageIO.read(img1));
            elevatorBtn_1 = new JButton(elevatorBtn1Image);
            elevatorBtn_1.setBounds(663,130,80, 80);
            elevatorBtn_1.setFocusPainted(false);
            elevatorBtn_1.setContentAreaFilled(false);
            elevatorBtn_1.setBorder(null);
            elevatorBtn_1.setToolTipText("Click to go To level 1");

            InputStream img2 = getClass().getResourceAsStream("/images/elevatorBtn2.png");
            ImageIcon elevatorBtn2Image = new ImageIcon(ImageIO.read(img2));
            elevatorBtn_2 = new JButton(elevatorBtn2Image);
            elevatorBtn_2.setBounds(663,215,80, 80);
            elevatorBtn_2.setFocusPainted(false);
            elevatorBtn_2.setContentAreaFilled(false);
            elevatorBtn_2.setBorder(null);
            elevatorBtn_2.setToolTipText("Click to go To level 2");

            InputStream img3 = getClass().getResourceAsStream("/images/elevatorBtn3.png");
            ImageIcon elevatorBtn3Image = new ImageIcon(ImageIO.read(img3));
            elevatorBtn_3 = new JButton(elevatorBtn3Image);
            elevatorBtn_3.setBounds(663,300,80, 80);
            elevatorBtn_3.setFocusPainted(false);
            elevatorBtn_3.setContentAreaFilled(false);
            elevatorBtn_3.setBorder(null);
            elevatorBtn_3.setToolTipText("Click to go To level 3");

            InputStream img4 = getClass().getResourceAsStream("/images/elevatorBtn4.png");
            ImageIcon elevatorBtn4Image = new ImageIcon(ImageIO.read(img4));
            elevatorBtn_4 = new JButton(elevatorBtn4Image);
            elevatorBtn_4.setBounds(663,385,80, 80);
            elevatorBtn_4.setFocusPainted(false);
            elevatorBtn_4.setContentAreaFilled(false);
            elevatorBtn_4.setBorder(null);
            elevatorBtn_4.setToolTipText("Click to go To level 4");

            InputStream img5 = getClass().getResourceAsStream("/images/elevatorBtn5.png");
            ImageIcon elevatorBtn5Image = new ImageIcon(ImageIO.read(img5));
            elevatorBtn_5 = new JButton(elevatorBtn5Image);
            elevatorBtn_5.setBounds(663,480,80, 80);
            elevatorBtn_5.setFocusPainted(false);
            elevatorBtn_5.setContentAreaFilled(false);
            elevatorBtn_5.setBorder(null);
            elevatorBtn_5.setToolTipText("Click to go To level 5");

            switch(buttonSelection){
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


}
