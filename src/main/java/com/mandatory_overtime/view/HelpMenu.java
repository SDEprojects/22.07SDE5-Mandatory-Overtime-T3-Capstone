package com.mandatory_overtime.view;



import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;


public class HelpMenu {

    final UserView helpView = new UserView();
    private static JDialog helpDialog = new JDialog();

    private final JLayeredPane helpMenu = new JLayeredPane();

    private JLabel imgBackground;

    private final JLabel helpText = new JLabel();

    public HelpMenu() {
        buildHelpMenu();
    }

    public void buildHelpMenu() {
        helpDialog = new JDialog(new javax.swing.JFrame(), true);
        helpDialog.setTitle("Help");
        helpDialog.setBounds(500, 100, 700, 525);

        try {
            InputStream stream = getClass().getResourceAsStream("/images/helpMenu.png");
            ImageIcon img = new ImageIcon(ImageIO.read(stream));
            imgBackground = new JLabel(img);
            imgBackground.setSize(700, 500);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            helpText.setText("<html>"+helpView.showHelp2()+"</html>");
            helpText.setBounds(30, 30, 650,500);
            helpText.setFont(new Font("Serif", Font.PLAIN, 18));
            helpText.setForeground(Color.WHITE);

            helpMenu.add(imgBackground);
            helpMenu.add(helpText);

            helpMenu.setLayer(imgBackground,0);


            helpDialog.add(helpMenu);
        }

    }

    public void openHelpMenu() {
        helpDialog.setVisible(true);

    }


}
