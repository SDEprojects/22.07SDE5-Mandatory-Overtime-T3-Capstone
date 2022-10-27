package com.mandatory_overtime.view;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GameInfo {

  //Creates and instance of the UserView class.
  UserView gameInfoView = new UserView();
  private JDialog gameInfoDialog;


  public GameInfo() {
    buildGameInfomenu();
  }

  public void openGameInfoMenu() {
    gameInfoDialog.setVisible(true);

  }

  private JTextArea gameInfoLabel;


  private void buildGameInfomenu() {

    gameInfoDialog = new JDialog(new JFrame(), true);
    gameInfoDialog.setTitle("Game Information");
    gameInfoDialog.setBounds(500, 100, 600, 500);

    JPanel gameInfoMenu= new JPanel(new GridLayout(1, 0));


//    JButton gameCommandsBtn = new JButton("Game Commands");
//    JButton gameInstructionsBtn = new JButton("Instructions");



    gameInfoLabel = new JTextArea();
    //grabs text from UserView class and sets it to a TextArea
    gameInfoLabel.setText(gameInfoView.startUpInfo(""));
    //prevents the TextArea from being editable
    gameInfoLabel.setEditable(false);
    gameInfoLabel.setFont(new Font("Serif", Font.ITALIC, 18));
    gameInfoLabel.setLineWrap(true);
    gameInfoLabel.setWrapStyleWord(true);


    gameInfoMenu.add(gameInfoLabel);

    gameInfoDialog.add(gameInfoMenu);


  }

}
