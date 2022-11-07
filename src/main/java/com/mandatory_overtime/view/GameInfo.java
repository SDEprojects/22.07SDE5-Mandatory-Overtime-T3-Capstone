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

public class GameInfo {

    final UserView gameInfoView = new UserView();
    private static JDialog gameInfoDialog = new JDialog();

    private final JLayeredPane gameInfoMenu = new JLayeredPane();

    private JLabel imgBackground;

    private final JLabel gameInfoText = new JLabel();

    public GameInfo() {
        buildMenu();
    }

    public void buildMenu() {
        gameInfoDialog = new JDialog(new javax.swing.JFrame(), true);
        gameInfoDialog.setTitle("Game Information");
        gameInfoDialog.setBounds(500, 100, 700, 525);

        try {
            InputStream stream = getClass().getResourceAsStream("/images/gameInfoMenu.png");
            ImageIcon img = new ImageIcon(ImageIO.read(stream));
            imgBackground = new JLabel(img);
            imgBackground.setSize(700, 500);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            gameInfoText.setText("<html>" + gameInfoView.startUpInfo2("") + "</html>");
            gameInfoText.setBounds(80, 0, 500, 525);
            gameInfoText.setFont(new Font("Serif", Font.PLAIN, 18));
            gameInfoText.setForeground(Color.WHITE);

            gameInfoMenu.add(imgBackground);
            gameInfoMenu.add(gameInfoText);

            gameInfoMenu.setLayer(imgBackground, 0);

            gameInfoDialog.add(gameInfoMenu);
        }
    }

    public void openGameInfoMenu() {
        gameInfoDialog.setVisible(true);
    }
}
