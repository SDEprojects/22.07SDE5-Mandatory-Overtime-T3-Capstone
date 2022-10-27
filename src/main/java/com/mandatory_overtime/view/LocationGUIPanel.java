package com.mandatory_overtime.view;

import com.mandatory_overtime.model.Room;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.imageio.ImageIO;
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
            JLayeredPane pane = createPane(entry.getValue().getImage());
            locationsGuiPanels.put(entry.getKey(), pane);
        }
        return locationsGuiPanels;
    }

    private JLayeredPane createPane(String imageUrl){
        JLayeredPane pane = new JLayeredPane();

        // LOCATION SECTION
        try {
            InputStream stream = getClass().getResourceAsStream("/images/"+imageUrl);
            ImageIcon img = new ImageIcon(ImageIO.read(stream));
            JLabel locationImage= new JLabel(img);
            locationImage.setSize(1100, 700);
            pane.add(locationImage);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }



        return pane;
    }


}
