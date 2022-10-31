package com.mandatory_overtime.view;

import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class MapDialog extends JDialog {
    private static ImageIcon office;
    private static ImageIcon desk;
    private static ImageIcon conference;
    private static ImageIcon devfloor;
    private static ImageIcon itcloset;
    private static ImageIcon breakroom;
    private static ImageIcon kitchen;
    private static ImageIcon partyfloor;
    private static ImageIcon elevator;
    private static ImageIcon table;
    private static ImageIcon lobby;
    private static ImageIcon vending;
    private static JDialog map;
    private static JLabel imageContainer = new JLabel();

    public MapDialog(String currentLocation){
        loadImages();
        map = new JDialog();
        map.setTitle("MAP");
        map.setBounds(200, 50, 1000,700);
        updateMap(currentLocation);
        map.add(imageContainer);

    }

    public void loadImages(){
        try {
            InputStream stream = getClass().getResourceAsStream("/images/map/office.png");
            office = new ImageIcon(ImageIO.read(stream));

            InputStream stream2 = getClass().getResourceAsStream("/images/map/desk.png");
            desk = new ImageIcon(ImageIO.read(stream2));

            InputStream stream3 = getClass().getResourceAsStream("/images/map/conference.png");
            conference = new ImageIcon(ImageIO.read(stream3));

            InputStream stream4 = getClass().getResourceAsStream("/images/map/devfloor.png");
            devfloor = new ImageIcon(ImageIO.read(stream4));

            InputStream stream5 = getClass().getResourceAsStream("/images/map/itcloset.png");
            itcloset = new ImageIcon(ImageIO.read(stream5));

            InputStream stream6 = getClass().getResourceAsStream("/images/map/breakroom.png");
            breakroom = new ImageIcon(ImageIO.read(stream6));

            InputStream stream7 = getClass().getResourceAsStream("/images/map/kitchen.png");
            kitchen = new ImageIcon(ImageIO.read(stream7));

            InputStream stream8 = getClass().getResourceAsStream("/images/map/partyfloor.png");
            partyfloor = new ImageIcon(ImageIO.read(stream8));

            InputStream stream9 = getClass().getResourceAsStream("/images/map/table.png");
            table = new ImageIcon(ImageIO.read(stream9));

            InputStream stream10 = getClass().getResourceAsStream("/images/map/lobby.png");
            lobby = new ImageIcon(ImageIO.read(stream10));

            InputStream stream11 = getClass().getResourceAsStream("/images/map/vending.png");
            vending = new ImageIcon(ImageIO.read(stream11));

            InputStream stream12 = getClass().getResourceAsStream("/images/map/elevator.png");
            elevator = new ImageIcon(ImageIO.read(stream12));
        }catch(IOException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void updateMap(String currentLocation){
        imageContainer.removeAll();
        switch(currentLocation){
            case "office":{
                imageContainer.setIcon(office);
                break;
            }
            case "desk":{
                imageContainer.setIcon(desk);
                break;
            }
            case "conference room":{
                imageContainer.setIcon(conference);
                break;
            }
            case "dev floor":{
                imageContainer.setIcon(devfloor);
                break;
            }
            case "it closet":{
                imageContainer.setIcon(itcloset);
                break;
            }
            case "break room":{
                imageContainer.setIcon(breakroom);
                break;
            }
            case "kitchen":{
                imageContainer.setIcon(kitchen);
                break;
            }
            case "party floor":{
                imageContainer.setIcon(partyfloor);
                break;
            }
            case "table":{
                imageContainer.setIcon(table);
                break;
            }
            case "lobby":{
                imageContainer.setIcon(lobby);
                break;
            }
            case "vending machine":{
                imageContainer.setIcon(vending);
                break;
            }

            default:
                imageContainer.setIcon(elevator);
                break;

        }
        imageContainer.repaint();
        imageContainer.revalidate();
    }

    public static void displayMap(){
        map.setVisible(true);
    }
    public static JDialog getMapDialog(){
        return map;
    }
}
