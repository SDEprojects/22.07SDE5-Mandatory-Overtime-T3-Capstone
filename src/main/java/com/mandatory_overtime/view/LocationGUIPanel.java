package com.mandatory_overtime.view;

import com.mandatory_overtime.model.Room;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class LocationGUIPanel {

    private Map<String, JLayeredPane> locationsGuiPanels;

    private JButton elevatorBtn_1;
    private JButton elevatorBtn_2;
    private JButton elevatorBtn_3;
    private JButton elevatorBtn_4;
    private JButton elevatorBtn_5;


    public LocationGUIPanel(Map<String, Room> map) {
        locationsGuiPanels = generateLocationPanels(map);
        createElevatorButtons();
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
            pane.add(locationImage);
           // pane.add(inventoryItem);

        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pane;
    }

    private void createElevatorButtons(){


        try {
            InputStream img1 = getClass().getResourceAsStream("/images/elevatorBtn1.png");
            ImageIcon elevatorBtn1Image = new ImageIcon(ImageIO.read(img1));
            elevatorBtn_1 = new JButton(elevatorBtn1Image);

            InputStream img2 = getClass().getResourceAsStream("/images/elevatorBtn2.png");
            ImageIcon elevatorBtn2Image = new ImageIcon(ImageIO.read(img2));
            elevatorBtn_1 = new JButton(elevatorBtn1Image);

            InputStream img3 = getClass().getResourceAsStream("/images/elevatorBtn3.png");
            ImageIcon elevatorBtn3Image = new ImageIcon(ImageIO.read(img3));
            elevatorBtn_1 = new JButton(elevatorBtn1Image);

            InputStream img4 = getClass().getResourceAsStream("/images/elevatorBtn4.png");
            ImageIcon elevatorBtn4Image = new ImageIcon(ImageIO.read(img4));
            elevatorBtn_1 = new JButton(elevatorBtn1Image);

            InputStream img5 = getClass().getResourceAsStream("/images/elevatorBtn5.png");
            ImageIcon elevatorBtn5Image = new ImageIcon(ImageIO.read(img5));
            elevatorBtn_1 = new JButton(elevatorBtn1Image);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
