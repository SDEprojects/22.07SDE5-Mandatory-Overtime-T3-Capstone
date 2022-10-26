package com.mandatory_overtime.view;

import com.mandatory_overtime.model.Room;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class LocationGUIPanel {

    private Map<String, JLayeredPane> locationsGuiPanels;

    public LocationGUIPanel(Map<String, Room> map) {
        locationsGuiPanels = generateLocationPanels(map);
    }

    public Map<String, JLayeredPane> getLocationsGuiPanels(){
        return locationsGuiPanels;
    }

    private Map<String, JLayeredPane> generateLocationPanels(Map<String, Room> map) {
        locationsGuiPanels = new HashMap<>();
        for (Entry<String, Room> entry : map.entrySet()) {
            System.out.println(entry);
            JLayeredPane pane = createPane(entry.getValue().getImage());
            locationsGuiPanels.put(entry.getKey(), pane);
        }
        System.out.println(locationsGuiPanels);
        return locationsGuiPanels;
    }

    private JLayeredPane createPane(String imageUrl){
        JLayeredPane pane = new JLayeredPane();

        // LOCATION SECTION
        ImageIcon img = new ImageIcon(
            String.valueOf(getClass().getClassLoader().getResourceAsStream(imageUrl)));
        JLabel locationImage= new JLabel(img);
        pane.add(locationImage);

        return pane;
    }


}
