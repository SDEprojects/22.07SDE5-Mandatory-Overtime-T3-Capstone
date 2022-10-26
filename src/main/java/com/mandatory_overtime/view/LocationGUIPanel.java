package com.mandatory_overtime.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class LocationGUIPanel {

    Map<String, JPanel> locationsGUIPanels;

    public LocationGUIPanel(){

    }

    public void updateLocationView(String location){

    }

    public JLayeredPane generateLocationPanels(HashMap map){

        for( Object location : map.keySet()){
            System.out.println(location);
        }
        JLayeredPane location = new JLayeredPane();

        System.out.println(map.keySet());


        return location;
    }

}
