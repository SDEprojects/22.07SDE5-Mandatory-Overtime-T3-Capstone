package com.mandatory_overtime.view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public final class MenuBar extends JMenuBar {

    public static JMenuBar MENU_BAR;


    private final SettingsMenu settingsDialog = new SettingsMenu();
    private final GameInfo gameInfoDialog = new GameInfo();
    private final HelpMenu helpDialog = new HelpMenu();
    private static final JButton settings = new JButton("Settings");
    private static final JButton quit = new JButton("Quit To Main  ");
    private static final JMenu spacer = new JMenu("|");
    private static final JMenu spacer2 = new JMenu("|");
    private static final JButton save = new JButton("Save");

    private static final JButton map = new JButton("Map");

    private static final JButton godMode = new JButton("God Mode");

    private static final JLabel timerLabel = new JLabel();
    private Runnable saveAction;

    private Runnable quitAction;

    private Runnable godModeAction;

    public MenuBar() {

        settings.setBorderPainted(false);
        settings.setContentAreaFilled(false);
        settings.setFocusPainted(false);
        settings.setOpaque(false);
        settings.setFont(new Font("arial narrow", Font.BOLD, 17));
        //sets font color
        settings.setForeground(Color.white);
        settings.addActionListener(e -> settingsDialog.openMenu());

        timerLabel.setForeground(Color.ORANGE);
        timerLabel.setFont(new Font("arial narrow", Font.BOLD, 15));
        timerLabel.setBounds(60, 0, 100, 100);


        JButton help = new JButton("   Help   ");
        help.setBorderPainted(false);
        help.setContentAreaFilled(false);
        help.setFocusPainted(false);
        help.setOpaque(false);
        help.setFont(new Font("arial narrow", Font.BOLD, 17));
        //sets font color
        help.setForeground(Color.white);

        help.addActionListener(e -> helpDialog.openHelpMenu());

        JButton gameInfo = new JButton("Game Info");
        gameInfo.setBorderPainted(false);
        gameInfo.setContentAreaFilled(false);
        gameInfo.setFocusPainted(false);
        gameInfo.setOpaque(false);
        gameInfo.setFont(new Font("arial narrow", Font.BOLD, 17));
        //sets font color
        gameInfo.setForeground(Color.white);
        gameInfo.addActionListener(e -> gameInfoDialog.openGameInfoMenu());

        map.setBorderPainted(false);
        map.setContentAreaFilled(false);
        map.setFocusPainted(false);
        map.setOpaque(false);
        map.setFont(new Font("arial narrow", Font.BOLD, 17));
        //sets font color
        map.setForeground(Color.white);
        map.addActionListener(e -> {MapDialog.displayMap();});

        save.setBorderPainted(false);
        save.setContentAreaFilled(false);
        save.setFocusPainted(false);
        save.setOpaque(false);
        save.setFont(new Font("arial narrow", Font.BOLD, 17));
        //sets font color
        save.setForeground(Color.white);
        save.addActionListener(e -> {
            saveAction.run();
        });

        godMode.setBorderPainted(false);
        godMode.setContentAreaFilled(false);
        godMode.setFocusPainted(false);
        godMode.setOpaque(false);
        godMode.setFont(new Font("arial narrow", Font.BOLD, 17));
        //sets font color
        godMode.setForeground(Color.white);
        godMode.addActionListener(e -> {
            godModeAction.run();
            godMode.setEnabled(false);
            godMode.setBackground(Color.cyan);
        });

        quit.setBorderPainted(false);
        quit.setContentAreaFilled(false);
        quit.setFocusPainted(false);
        quit.setOpaque(false);
        quit.setFont(new Font("arial narrow", Font.BOLD, 17));
        //sets font color
        quit.setForeground(Color.white);
        quit.addActionListener(e ->{
            quitAction.run();
        });

        quit.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        MENU_BAR = new JMenuBar();
        MENU_BAR.setBounds(0, 0, 1490, 40);
        MENU_BAR.setBackground(Color.DARK_GRAY);
        MENU_BAR.add(settings);
        MENU_BAR.add(new JMenu("|")).setEnabled(false);
        MENU_BAR.add(help);
        MENU_BAR.add(new JMenu("|")).setEnabled(false);
        MENU_BAR.add(gameInfo);
        MENU_BAR.add(new JMenu("|")).setEnabled(false);
        MENU_BAR.add(map);
        MENU_BAR.add(spacer).setEnabled(false);
        MENU_BAR.add(save);
        MENU_BAR.add(spacer2).setEnabled(false);
        MENU_BAR.add(godMode);
        MENU_BAR.add(Box.createHorizontalGlue());
        MENU_BAR.add(timerLabel);
        MENU_BAR.add(Box.createHorizontalGlue());
        MENU_BAR.add(quit);

    }


    public static JMenuBar getMenuBar() {
        return MENU_BAR;
    }

    public void setSaveAction(Runnable runnable){
        saveAction = runnable;
    }

    public void setQuitListener(Runnable runnable) {
        quitAction = runnable;
    }

    public void setGodModeAction(Runnable godModeAction) {
        this.godModeAction = godModeAction;
    }

    public static void hideGameBtns(){
        save.setVisible(false);
        quit.setVisible(false);
        map.setVisible(false);
        spacer.setVisible(false);
        godMode.setVisible(false);
        spacer2.setVisible(false);
    }
    public static void showGameBtn(){
        save.setVisible(true);
        quit.setVisible(true);
        map.setVisible(true);
        spacer.setVisible(true);
    }

    public static void showGodeModeBtn(){
        godMode.setVisible(true);
        spacer2.setVisible(true);
    }

    public static void hideGodeModeBtn(){
        godMode.setVisible(false);
        spacer2.setVisible(false);
    }

    public SettingsMenu getSettingsDialog() {
        return settingsDialog;
    }

    public void presentGameInfo(){
        gameInfoDialog.openGameInfoMenu();
    }

    public static JLabel getTimerLabel(){
        return timerLabel;
    }

}
