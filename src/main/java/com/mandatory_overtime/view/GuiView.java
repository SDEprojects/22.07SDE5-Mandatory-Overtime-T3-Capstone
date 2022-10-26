package com.mandatory_overtime.view;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;


public class GuiView {

    private final JFrame frame;
    private MainMenu mainMenu = new MainMenu();
    private final GamePlayScreen gamePlayScreen = new GamePlayScreen();


    public GuiView() {
        frame = new JFrame("Mandatory Overtime");
        frame.setPreferredSize(new Dimension(1500, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void presentGameScreen(){
        presentLoadingScreen();
        frame.getContentPane().removeAll();
        JLayeredPane screen = gamePlayScreen.getGameScreen();
        frame.add(screen);
        frame.pack();
        frame.setVisible(true);

    }

    public void presentMainMenu(){
        presentLoadingScreen();
        frame.getContentPane().removeAll();
        JLayeredPane menu = MainMenu.getHomeScreen();
        frame.add(menu);
        frame.pack();
        frame.setVisible(true);
    }
    public void presentLoadingScreen(){
        JLayeredPane loadingScreen = MainMenu.getLoadingScreen();
        frame.add(loadingScreen);
        frame.pack();
        frame.setVisible(true);
        MainMenu.loadProgressBar();
    }

    public JButton getNewGameButton(){
        return MainMenu.getStartBtn();
    }

    public JButton getLoadGameButton(){
        return MainMenu.getLoadBtn();
    }



}
