package com.mandatory_overtime;


import com.mandatory_overtime.controller.GUIController;
import com.mandatory_overtime.model.GameMusic;
import java.io.IOException;


public class Main {

    public static void main(String[] args)
        throws IOException{
        GameMusic.startBackgroundMusic();
        GUIController gui = new GUIController();
    }
}
