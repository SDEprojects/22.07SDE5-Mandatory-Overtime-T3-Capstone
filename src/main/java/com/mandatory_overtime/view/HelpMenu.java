package com.mandatory_overtime.view;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

  private JTextArea gameCommandLabel;
  // private JTextArea gameInstructionsLabel;

  private void buidlHelpmenu() {

    helpDialog = new JDialog(new JFrame(), true);
    helpDialog.setTitle("Help");
    helpDialog.setBounds(500, 100, 600, 500);

    JPanel helpMenu= new JPanel(new GridLayout(1, 0));


//    JButton gameCommandsBtn = new JButton("Game Commands");
//    JButton gameInstructionsBtn = new JButton("Instructions");



    gameCommandLabel = new JTextArea();
    //grabs text from UserView class and sets it to a TextArea
    gameCommandLabel.setText(helpView.showHelp());
    //prevents the TextArea from being editable
    gameCommandLabel.setEditable(false);

    gameCommandLabel.setFont(new Font("Serif", Font.ITALIC, 18));
    gameCommandLabel.setLineWrap(true);
    gameCommandLabel.setWrapStyleWord(true);




//    gameInstructionsLabel = new JTextArea();
//    gameInstructionsLabel.setText(helpView.startUpInfo("olu"));;
//    gameInstructionsLabel.setEditable(false);
//    gameInstructionsLabel.setFont(new Font("Serif", Font.ITALIC, 18));
//    gameInstructionsLabel.setLineWrap(true);
//    gameInstructionsLabel.setWrapStyleWord(true);



    // helpMenu.add(gameCommandsBtn);
    //helpMenu.add(gameInstructionsBtn);

    helpMenu.add(gameCommandLabel);
    // helpMenu.add(gameInstructionsLabel);

    helpDialog.add(helpMenu);
    //helpDialog.add(gameInstructionsLabel);

  }



}