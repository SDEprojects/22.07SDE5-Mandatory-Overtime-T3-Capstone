package com.mandatory_overtime.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HelpMenu {


  //Creates and instance of the UserView class.
  UserView helpView = new UserView();


  private JDialog helpDialog;

  public HelpMenu() {
    buidlHelpmenu();
  }

  public void openHelpMenu() {
    helpDialog.setVisible(true);

  }

  private JTextAreaPlus gameCommandLabel;
  // private JTextArea gameInstructionsLabel;

  private void buidlHelpmenu() {

    helpDialog = new JDialog(new JFrame(), true);
    helpDialog.setTitle("Help");
    helpDialog.setBounds(500, 100, 580, 500);

    JPanel helpMenu= new JPanel(new GridLayout(1, 0));


    gameCommandLabel = new JTextAreaPlus();

    //grabs text from UserView class and sets it to a TextArea
    //gameCommandLabel.setBackground(Color.cyan);
    ImageIcon icon;
    try (InputStream helpMenuImage = getClass().getResourceAsStream("/images/help3.png")) {
      icon = new ImageIcon(ImageIO.read(helpMenuImage));

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    gameCommandLabel.setImage(icon);
    gameCommandLabel.setText(helpView.showHelp());

    //prevents the TextArea from being editable
    gameCommandLabel.setEditable(false);

    gameCommandLabel.setFont(new Font("Serif", Font.PLAIN, 20));

    gameCommandLabel.setForeground(Color.white);
    gameCommandLabel.setLineWrap(true);
    gameCommandLabel.setWrapStyleWord(true);

    helpMenu.add(gameCommandLabel);

    helpDialog.add(helpMenu);



  }



}