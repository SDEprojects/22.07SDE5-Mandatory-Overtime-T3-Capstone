package com.mandatory_overtime.view;

import java.awt.Container;
import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;


public class GuiView {

    private final Container container;
    private MainMenu mainMenu = new MainMenu();
    private final GamePlayScreen gamePlayScreen = new GamePlayScreen();

    private final LocationGUIPanel locationGUIPanel = new LocationGUIPanel();
    public GuiView() {
        JFrame frame = new JFrame("Mandatory Overtime");
        frame.setPreferredSize(new Dimension(1500, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    public void buildLocationGUI(HashMap locations){
        locationGUIPanel.generateLocationPanels(locations);
    }

}
