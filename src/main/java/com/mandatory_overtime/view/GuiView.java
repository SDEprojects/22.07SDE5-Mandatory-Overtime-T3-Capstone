package com.mandatory_overtime.view;

import com.mandatory_overtime.model.Item;
import com.mandatory_overtime.model.Room;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class GuiView {

    private final MenuBar menuBar = new MenuBar();
    private final Container container;

    private final MainMenu mainMenu = new MainMenu();
    private GamePlayScreen gamePlayScreen;

    private final LevelSelectionPanel gameStartPanel = new LevelSelectionPanel();


    public GuiView(){
        JFrame frame = new JFrame("Mandatory Overtime");
        frame.setPreferredSize(new Dimension(1500, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLACK);
        frame.setVisible(true);
        frame.pack();
        container = frame.getContentPane();
    }

    public void presentGameScreen(){
     //   presentLoadingScreen();

        JLayeredPane screen = gamePlayScreen.getGameScreen();
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
        container.removeAll();
        container.add(loadingScreen);
        container.repaint();
        container.revalidate();
        MainMenu.loadProgressBar();

    }

    public void setUpGamePlay(HashMap locations, HashMap items) throws IOException {
        gamePlayScreen =new GamePlayScreen(locations, items);

    }

    public JButton getNewGameButton(){
        return MainMenu.getStartBtn();
    }

    public JButton getLoadGameButton(){
        return MainMenu.getLoadBtn();
    }


    public void updateGameScreen(String location, List<String> inventory,String message, String[] directions,
         String removedItem){
        gamePlayScreen.updateGamePlayScreen(location, inventory,message,directions, removedItem);
    }

    public void setMoveConsumer(Consumer<String> listener) {
        gamePlayScreen.setMoveListener(roomName -> listener.accept(roomName));
    }

    public GamePlayScreen getGamePlayScreen() {
        return gamePlayScreen;
    }

    public void setSaveListener(Runnable runnable){
      menuBar.setSaveAction(runnable);
    }

    public void setQuitListener(Runnable runnable){
        menuBar.setQuitListener(runnable);
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public JPanel getGameStartPanel(){
        return gameStartPanel.getLevelSelection();
    }
}
