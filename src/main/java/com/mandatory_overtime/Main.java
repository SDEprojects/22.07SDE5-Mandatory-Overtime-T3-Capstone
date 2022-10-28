package com.mandatory_overtime;


import com.mandatory_overtime.controller.GUIController;
import com.mandatory_overtime.controller.GamePlay;
import com.mandatory_overtime.model.GameMusic;
import java.io.IOException;
import java.net.URISyntaxException;


public class Main {

    public static void main(String[] args)
        throws IOException, URISyntaxException {
       GameMusic.startBackgroundMusic();

        GUIController gui = new GUIController();
//        GamePlay gamePlay = new GamePlay();

    }
}
