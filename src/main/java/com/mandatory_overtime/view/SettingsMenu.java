package com.mandatory_overtime.view;

import com.mandatory_overtime.model.GameMusic;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SettingsMenu {

    private static JDialog settingsDialog;
    private JCheckBox toggleCheatCheckbox;
    private final JLayeredPane settingsMenu = new JLayeredPane();
    private final JLabel musicControlLabel = new JLabel("  Music Control");
    private final JLabel musicVolLabel = new JLabel("  Music Volume");
    private final JLabel toggleCheatLabel = new JLabel("  Enable Cheats");
    private final JButton musicOffBtn = new JButton("off");
    private final JButton musicOnBtn = new JButton("on");

    private final JSlider volumeSlider = new JSlider();
    private JLabel settingsBackground;

    public SettingsMenu() {
        buildSettingsMenu();
    }

    public void openMenu() {
        settingsDialog.setVisible(true);
    }

    public void buildSettingsMenu() {
        settingsDialog = new JDialog(new javax.swing.JFrame(), true);
        settingsDialog.setTitle("Settings");
        settingsDialog.setBounds(500, 100, 600, 500);

        try {
            InputStream stream = getClass().getResourceAsStream("/images/settingsMenu.png");
            ImageIcon img = new ImageIcon(ImageIO.read(stream));
            settingsBackground = new JLabel(img);
            settingsBackground.setSize(600, 500);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            musicControlLabel.setBounds(50, 100, 200, 100);
            musicControlLabel.setForeground(Color.WHITE);
            musicControlLabel.setFont(new Font("Serif", Font.BOLD, 22));

            musicVolLabel.setBounds(50, 200, 200, 100);
            musicVolLabel.setForeground(Color.WHITE);
            musicVolLabel.setFont(new Font("Serif", Font.BOLD, 22));

            musicOnBtn.setBounds(300, 135, 100, 40);
            musicOnBtn.addActionListener(e -> GameMusic.musicOnOff("on"));

            musicOffBtn.setBounds(425, 135, 100, 40);
            musicOffBtn.addActionListener(e -> GameMusic.musicOnOff("off"));

            volumeSlider.setMinorTickSpacing(1);
            volumeSlider.setMajorTickSpacing(5);
            volumeSlider.setPaintTicks(true);
            volumeSlider.setSnapToTicks(true);
            volumeSlider.setPaintLabels(true);
            volumeSlider.setMinimum(0);
            volumeSlider.setMaximum(10);
            volumeSlider.setValue(4);
            volumeSlider.setBounds(300, 225, 230, 60);
            volumeSlider.addChangeListener(e -> {
                int vol = ((JSlider) e.getSource()).getValue();
                GameMusic.volumeUpDown(String.valueOf(vol));
            });

            toggleCheatLabel.setBounds(50, 300, 200, 100);
            toggleCheatLabel.setForeground(Color.WHITE);
            toggleCheatLabel.setFont(new Font("Serif", Font.BOLD, 22));

            toggleCheatCheckbox = new JCheckBox();
            toggleCheatCheckbox.setBounds(300, 340, 20, 20);
            toggleCheatCheckbox.setEnabled(false);
            toggleCheatCheckbox.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
                    MenuBar.showGodeModeBtn();
                } else {//checkbox has been deselected
                    MenuBar.hideGodeModeBtn();
                }
            });

            settingsMenu.add(settingsBackground);
            settingsMenu.add(musicControlLabel);
            settingsMenu.add(musicOnBtn);
            settingsMenu.add(musicOffBtn);
            settingsMenu.add(musicVolLabel);
            settingsMenu.add(volumeSlider);
            settingsMenu.add(toggleCheatLabel);
            settingsMenu.add(toggleCheatCheckbox);

            settingsMenu.setLayer(settingsBackground, 0);

            settingsDialog.add(settingsMenu);
        }


    }


    public JCheckBox getToggleCheatCheckbox() {
        return toggleCheatCheckbox;
    }
}
