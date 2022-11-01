package com.mandatory_overtime.view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class JTextAreaPlus extends JTextArea {

  Image image;

  public JTextAreaPlus(){
    super();

  }

  public JTextAreaPlus(String text){
    super((text));
  }

  public void setImage(ImageIcon icon){
    this.image = icon.getImage();
    setOpaque(false);
  }
  public void paint(Graphics g){

    g.drawImage(image,0,0,null);
    super.paint(g);
  }

}
