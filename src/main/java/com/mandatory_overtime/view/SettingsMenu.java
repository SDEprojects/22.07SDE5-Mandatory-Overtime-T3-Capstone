package com.mandatory_overtime.view;

import com.mandatory_overtime.model.GameMusic;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class SettingsMenu {

    private static JDialog settingsDialog;
    private JCheckBox toggleCheatCheckbox;

    public SettingsMenu() {
        buildSettingsMenu();
    }

    public void openMenu() {
        settingsDialog.setVisible(true);
    }

    public static JDialog getMenu() {
        return settingsDialog;
    }

    public void buildSettingsMenu() {
        settingsDialog = new JDialog(new javax.swing.JFrame(), true);
        settingsDialog.setTitle("Settings");
        settingsDialog.setBounds(500, 100, 400, 300);

        // MUSIC CONTROL BUTTONS
        JPanel settingsMenu = new JPanel(new GridLayout(3, 3));

        JLabel musicControlLabel = new JLabel("  Music Control");
        JLabel soundControlLabel = new JLabel("  FX Control");
        JLabel musicVolLabel = new JLabel("  Music Volume");
        JLabel soundVolLabel = new JLabel("  FX Volume");
        JLabel toggleCheatLabel = new JLabel("  Cheats");

        JButton musicOffBtn = new JButton("off");
        JButton musicOnBtn = new JButton("on");
        JButton soundOnBtn = new JButton("on");
        JButton soundOffBtn = new JButton("off");

        JButton increaseMusicBtn = new JButton("+");
        JButton decreaseMusicBtn = new JButton("-");
        JButton increaseSoundBtn = new JButton("+");
        JButton decreaseSoundBtn = new JButton("-");

        toggleCheatCheckbox = new JCheckBox();
        toggleCheatCheckbox.setEnabled(false);

        // SET BUTTON FONT SIZE
        decreaseMusicBtn.setFont(new Font("Arial", Font.BOLD, 25));
        increaseMusicBtn.setFont(new Font("Arial", Font.BOLD, 25));
        decreaseSoundBtn.setFont(new Font("Arial", Font.BOLD, 25));
        increaseSoundBtn.setFont(new Font("Arial", Font.BOLD, 25));

        // EVENT LISTENERS ON BUTTONS
        increaseMusicBtn.addActionListener(e -> {
            increaseMusic();
        });

        decreaseMusicBtn.addActionListener(e -> {
            lowerMusic();
        });

        increaseSoundBtn.addActionListener(e -> {
            increaseSoundEffects();
        });

        decreaseSoundBtn.addActionListener(e -> {
            lowerSoundEffects();
        });

        musicOnBtn.addActionListener(e -> {
            turnOnMusic();
        });

        musicOffBtn.addActionListener(e -> {
            turnOffMusic();
        });

        soundOnBtn.addActionListener(e -> {
            turnOnSound();
        });

        soundOffBtn.addActionListener(e -> {
            turnOffSound();
        });

        toggleCheatCheckbox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
                MenuBar.showGodeModeBtn();
            } else {//checkbox has been deselected
                MenuBar.hideGodeModeBtn();
            }
        });

        settingsMenu.add(musicControlLabel);
        settingsMenu.add(musicOnBtn);
        settingsMenu.add(musicOffBtn);

        settingsMenu.add(musicVolLabel);
        settingsMenu.add(decreaseMusicBtn);
        settingsMenu.add(increaseMusicBtn);

        settingsMenu.add(toggleCheatLabel);
        settingsMenu.add(toggleCheatCheckbox);

        // SOUND EFFECTS BUTTONS
//        settingsMenu.add(soundControlLabel);
//        settingsMenu.add(soundOnBtn);
//        settingsMenu.add(soundOffBtn);
//
//        settingsMenu.add(soundVolLabel);
//        settingsMenu.add(decreaseSoundBtn);
//        settingsMenu.add(increaseSoundBtn);

        settingsDialog.add(settingsMenu);
    }

    public void lowerMusic() {
        int vol = Integer.parseInt(GameMusic.getVolume());
        if (vol >= 0) {
            vol -= 1;
            GameMusic.setVolume(String.valueOf(vol));
        }
        GameMusic.volumeUpDown(String.valueOf(vol));
    }

    public void increaseMusic() {
        int vol = Integer.parseInt(GameMusic.getVolume());
        if (vol <= 10) {
            vol += 1;
            GameMusic.setVolume(String.valueOf(vol));
        }
        GameMusic.volumeUpDown(String.valueOf(vol));
    }

    public void lowerSoundEffects() {

    }

    public void increaseSoundEffects() {

    }

    public void turnOffMusic() {
        GameMusic.musicOnOff("off");
    }

    public void turnOnMusic() {
        GameMusic.musicOnOff("on");
    }

    public void turnOffSound() {

    }

    public void turnOnSound() {

    }

    public static JDialog getSettingsDialog() {
        return settingsDialog;
    }

    public JCheckBox getToggleCheatCheckbox() {
        return toggleCheatCheckbox;
    }
}
