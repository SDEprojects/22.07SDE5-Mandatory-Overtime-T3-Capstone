package com.mandatory_overtime.view;

import com.mandatory_overtime.view.SettingsMenu;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class MainMenu {

    private final SettingsMenu settingsMenu = new SettingsMenu();
    private static JLayeredPane homeScreen;

    private static JLayeredPane loadingScreen;

    private static JButton startBtn;
    private static JButton loadBtn;

    private static JProgressBar progressBar;

    public MainMenu() {
        buildMainMenu();
        buildLoadingScreen();
    }

    private void buildMainMenu() {
        homeScreen = new JLayeredPane();

        // Settings BUTTON
        JButton settingsBtn = new JButton("Settings");
        settingsBtn.addActionListener(e -> settingsMenu.openMenu());

        // Help BUTTON
        JButton helpBtn = new JButton("Help");

        // Settings Bar
        JPanel settingsBar = new JPanel();
        settingsBar.setBackground(Color.DARK_GRAY);
        settingsBar.setBounds(0, 0, 1500, 40);
        settingsBar.add(settingsBtn);
        settingsBar.add(helpBtn);

        // BackGroundImage
        ImageIcon mainMenuImage = new ImageIcon("mainMenu.png");
        JLabel imageSection = new JLabel(mainMenuImage);
        imageSection.setSize(1500, 800);

        // Start Button
        Icon icon = new ImageIcon("newgame.png");
        startBtn = new JButton(icon);
        startBtn.setBounds(500, 575, 225, 75);
        startBtn.setFocusPainted(false);
        startBtn.setContentAreaFilled(false);

        // Load Game Button
        Icon loadBtnIcon = new ImageIcon("loadgameBtn.png");
        loadBtn = new JButton(loadBtnIcon);
        loadBtn.setBounds(825, 575, 225, 75);
        loadBtn.setFocusPainted(false);
        loadBtn.setContentAreaFilled(false);

        homeScreen.add(settingsBar, Integer.valueOf(1));
        homeScreen.add(imageSection, Integer.valueOf(0));
        homeScreen.add(startBtn, Integer.valueOf(2));
        homeScreen.add(loadBtn, Integer.valueOf(2));

    }

    private void buildLoadingScreen() {
        loadingScreen = new JLayeredPane();

        // BackGroundImage
        ImageIcon mainMenuImage = new ImageIcon("mainMenu.png");
        JLabel imageSection = new JLabel(mainMenuImage);
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

    public static JProgressBar getProgressBar(){
        return progressBar;
    }

}
