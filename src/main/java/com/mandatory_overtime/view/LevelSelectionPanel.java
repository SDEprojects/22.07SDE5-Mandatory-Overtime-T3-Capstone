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

    private JTextField nameTextField;


    private String selectedButton = "easy";

    public LevelSelectionPanel() {
        buildMenu();
    }

    public void buildMenu() {
        nameTextField = new JTextField();
        ButtonGroup group = new ButtonGroup();

        levelSelection.setLayout(null);
        levelSelection.setBounds(0,0,800, 700);


        nameLabel.setBounds(0,25, 100, 50);
        nameTextField.setBounds(0, 65, 300,25);

        difficultyLabel.setBounds(0,100, 300, 50);

        JRadioButton easyBtn = new JRadioButton("Easy");
        easyBtn.setBounds(10 ,140,200, 25 );
        easyBtn.setActionCommand("easy");
        easyBtn.setSelected(true);
        easyBtn.addActionListener(e ->{
            selectedButton = e.getActionCommand();
        });

        JRadioButton hardBtn = new JRadioButton("Hard");
        hardBtn.setBounds(10 ,170,200, 25 );
        hardBtn.setActionCommand("hard");
        hardBtn.addActionListener(e ->{
            selectedButton = e.getActionCommand();
        });

        group.add(easyBtn);
        group.add(hardBtn);

        levelSelection.add(nameLabel);
        levelSelection.add(nameTextField);
        levelSelection.add(difficultyLabel);
        levelSelection.add(easyBtn);
        levelSelection.add(hardBtn);

    }

    public JPanel getLevelSelection() {
        return levelSelection;
    }

    public JTextField getNameInput(){
        return nameTextField;
    }

    public String getSelectedButton() {
        return selectedButton;
    }




}
