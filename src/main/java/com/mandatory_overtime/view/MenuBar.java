package com.mandatory_overtime.view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public final class MenuBar extends JMenuBar {

    public static JMenuBar MENU_BAR;

    private final SettingsMenu settingsDialog = new SettingsMenu();
    private final GameInfo gameInfoDialog = new GameInfo();
    private final HelpMenu helpDialog = new HelpMenu();
    private final JButton settings = new JButton("Settings");
    private final JButton help = new JButton("   Help   ");
    private final JButton quit = new JButton("Quit To Main    ");

    private final JButton save = new JButton("Save");
    private final JButton gameInfo = new JButton("Game Info");

    private Runnable saveAction;

    public MenuBar() {
        settings.setBorderPainted(false);
        settings.setContentAreaFilled(false);
        settings.setFocusPainted(false);
        settings.setOpaque(false);
        settings.addActionListener(e -> settingsDialog.openMenu());

        help.setBorderPainted(false);
        help.setContentAreaFilled(false);
        help.setFocusPainted(false);
        help.setOpaque(false);
        help.addActionListener(e -> helpDialog.openHelpMenu());

        gameInfo.setBorderPainted(false);
        gameInfo.setContentAreaFilled(false);
        gameInfo.setFocusPainted(false);
        gameInfo.setOpaque(false);
        gameInfo.addActionListener(e -> gameInfoDialog.openGameInfoMenu());

        save.setBorderPainted(false);
        save.setContentAreaFilled(false);
        save.setFocusPainted(false);
        save.setOpaque(false);
        save.addActionListener(e -> {
            saveAction.run();
        });

        quit.setBorderPainted(false);
        quit.setContentAreaFilled(false);
        quit.setFocusPainted(false);
        quit.setOpaque(false);

        quit.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        MENU_BAR = new JMenuBar();
        MENU_BAR.setBounds(0, 0, 1490, 40);
        MENU_BAR.setBackground(Color.LIGHT_GRAY);
        MENU_BAR.add(settings);
        MENU_BAR.add(new JMenu("|")).setEnabled(false);
        MENU_BAR.add(help);
        MENU_BAR.add(new JMenu("|")).setEnabled(false);
        MENU_BAR.add(save);
        MENU_BAR.add(Box.createHorizontalGlue());
        MENU_BAR.add(quit);

    }


    public static JMenuBar getMenuBar() {
        return MENU_BAR;
    }

    public void setSaveAction(Runnable runnable){
        saveAction = runnable;
    }

}
