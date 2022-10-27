package com.mandatory_overtime.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;


public class GuiView {

    private final Container container;

    private final MainMenu mainMenu = new MainMenu();
    private final GamePlayScreen gamePlayScreen;

    public static Map<String, JLayeredPane> LOCATION_GUI_PANELS;

    public GuiView(HashMap locations, HashMap items) throws IOException {

        gamePlayScreen =new GamePlayScreen(locations, items);
        JFrame frame = new JFrame("Mandatory Overtime");
        frame.setPreferredSize(new Dimension(1500, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLACK);
        frame.setVisible(true);
        frame.pack();
        container = frame.getContentPane();
    }

    public void presentGameScreen(){
        JLayeredPane screen = gamePlayScreen.getGameScreen();
        presentLoadingScreen();
        container.removeAll();
        container.add(screen);
        container.repaint();
        container.revalidate();

    }

    public void presentMainMenu(){
        JLayeredPane menu = MainMenu.getHomeScreen();
        presentLoadingScreen();
        container.removeAll();
        container.add(menu);
        container.repaint();
        container.revalidate();
    }
    public void presentLoadingScreen(){
        JLayeredPane loadingScreen = MainMenu.getLoadingScreen();
        container.add(loadingScreen);
        container.repaint();
        container.revalidate();
        MainMenu.loadProgressBar();

        container.removeAll();
        container.repaint();
        container.revalidate();
    }

    public JButton getNewGameButton(){
        return MainMenu.getStartBtn();
    }

    public JButton getLoadGameButton(){
        return MainMenu.getLoadBtn();
    }


    public void updateGameScreen(String location, List<String> inventory,String message, String[] directions ){
        gamePlayScreen.updateGamePlayScreen(location, inventory,message,directions);
    }

    public void setMoveConsumer(Consumer<String> listener) {
        gamePlayScreen.setMoveListener(roomName -> listener.accept(roomName));
    }
}
