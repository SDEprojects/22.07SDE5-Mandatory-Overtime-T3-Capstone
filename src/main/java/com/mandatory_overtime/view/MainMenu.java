package com.mandatory_overtime.view;

import com.mandatory_overtime.model.Building;
import com.mandatory_overtime.view.SettingsMenu;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Supplier;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class MainMenu {
    private static final JMenuBar menuBar = MenuBar.getMenuBar();
    private static JLayeredPane homeScreen;
    private static JLayeredPane loadingScreen;

    private static JButton startBtn;
    private static JButton loadBtn;
    private static JProgressBar progressBar;
    private ImageIcon mainMenu;
    private ImageIcon startButtonImage;
    private ImageIcon loadButtonImage;

    //----------CONSTRUCTOR ----------------------//
    public MainMenu(){
        loadImages();
        buildMainMenu();
        buildLoadingScreen();
    }

    private void loadImages(){
        try {
            InputStream stream = getClass().getResourceAsStream("/images/mainMenu.png");
            mainMenu = new ImageIcon(ImageIO.read(stream));

            InputStream stream2 = getClass().getResourceAsStream("/images/newgame.png");
            startButtonImage = new ImageIcon(ImageIO.read(stream2));

            InputStream stream3 = getClass().getResourceAsStream("/images/loadgameBtn.png");
            loadButtonImage = new ImageIcon(ImageIO.read(stream3));
        }catch(IOException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
    private void buildMainMenu(){
        homeScreen = new JLayeredPane();
        MenuBar.hideGameBtns();

        // BackGroundImage
        JLabel imageSection = new JLabel(mainMenu);
        imageSection.setSize(1500, 800);

        // Start Button
        startBtn = new JButton(startButtonImage);
        startBtn.setBounds(500, 575, 225, 75);
        startBtn.setFocusPainted(false);
        startBtn.setContentAreaFilled(false);
        startBtn.setBorderPainted(false);

        // Load Game Button
        loadBtn = new JButton(loadButtonImage);
        loadBtn.setBounds(825, 575, 225, 75);
        loadBtn.setFocusPainted(false);
        loadBtn.setContentAreaFilled(false);
        loadBtn.setBorderPainted(false);

        homeScreen.add(MenuBar.getMenuBar(), Integer.valueOf(1));
        homeScreen.add(imageSection, Integer.valueOf(0));
        homeScreen.add(startBtn, Integer.valueOf(2));
        homeScreen.add(loadBtn, Integer.valueOf(2));

    }

    private void buildLoadingScreen() {
        loadingScreen = new JLayeredPane();

        // BackGroundImage
        JLabel imageSection = new JLabel(mainMenu);
        imageSection.setSize(1500, 800);

        // Progress Bar
        progressBar = new JProgressBar();
        progressBar.setValue(0);
        progressBar.setBounds(300, 575, 900, 50);
        progressBar.setStringPainted(true);

        loadingScreen.add(progressBar, Integer.valueOf(1));
        loadingScreen.add(imageSection, Integer.valueOf(0));

    }

    public static JLayeredPane getHomeScreen() {
        homeScreen.add(menuBar);
        homeScreen.setLayer(menuBar, 2);
        MenuBar.hideGameBtns();
        return homeScreen;
    }

    public static JLayeredPane getLoadingScreen() {
        return loadingScreen;
    }

    public static JButton getStartBtn() {
        return startBtn;
    }

    public static JButton getLoadBtn() {
        return loadBtn;
    }

    public static void loadProgressBar() {
        int counter = 0;

        while (counter <= 100) {
            progressBar.setValue(counter);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                //Ignore
            }
            counter += 1;
        }
    }
}
