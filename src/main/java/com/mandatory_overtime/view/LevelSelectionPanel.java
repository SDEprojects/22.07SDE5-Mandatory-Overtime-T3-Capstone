package com.mandatory_overtime.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LevelSelectionPanel {


    private final JPanel levelSelection = new JPanel();

    private final JLabel nameLabel = new JLabel("Enter Your Name");
    private final JLabel difficultyLabel = new JLabel("Select Your Difficulty");

    public LevelSelectionPanel() {
        buildMenu();
    }

    public void buildMenu() {

        levelSelection.setLayout(null);
        levelSelection.setBounds(0,0,300, 500);

        nameLabel.setBounds(0,0 , 200, 100);
        ButtonGroup group = new ButtonGroup();

        JRadioButton easyBtn = new JRadioButton("Easy");
        JRadioButton hardBtn = new JRadioButton("hard");
        easyBtn.setSelected(true);
        group.add(easyBtn);
        group.add(hardBtn);

        levelSelection.add(nameLabel);
        levelSelection.add(new JTextField(10));
        levelSelection.add(new JLabel());

        levelSelection.add(difficultyLabel);
        levelSelection.add(easyBtn);
        levelSelection.add(hardBtn);

    }

    public JPanel getLevelSelection() {
        return levelSelection;
    }

}
