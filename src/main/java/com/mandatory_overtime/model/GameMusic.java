package com.mandatory_overtime.model;


import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.UnsupportedAudioFileException;

public class GameMusic {

    private static Clip clip;

    private static Clip npcAudioClip;
    static Player player = new Player();

    private static String volume = "5";

    static Building building;
    private static Clip soundClip;
    private static FloatControl gainControlSoundFX;
    private static FloatControl gainControlNPC;

    private static float soundFxVolume = (-4.0f);
    private static float tempFxVolume = (-4.0f);

    static {
        try {
            building = new Building();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GameMusic() {

    }

    public static void playAudioFX(String soundFile) {

        try {
            URL audio = GameMusic.class.getResource("/" + soundFile);
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(audio);
            soundClip = AudioSystem.getClip();
            soundClip.open(audioInput);

            // Set default sound FX volume
            gainControlSoundFX = (FloatControl) soundClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControlSoundFX.setValue(soundFxVolume);
            soundClip.start();
        } catch (UnsupportedAudioFileException e) {
        } catch (Exception e) {
        }
    }

    public static void playAudioMusic(String soundFile) {

        try {
            URL audio = GameMusic.class.getResource("/" + soundFile);
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(audio);
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            startBackgroundAudio();
        } catch (UnsupportedAudioFileException e) {
        } catch (Exception e) {
        }
    }

    public static void musicOnOff(String noun) {
        if (noun.equals("off")) {
            clip.stop();
        }
        if (noun.equals("on")) {
            clip.start();
        }
    }

    public static void soundFXOnOff(String noun) {
        if (noun.equals("off")) {
            if(npcAudioClip != null){
                npcAudioClip.stop();
            }
            tempFxVolume = soundFxVolume;
            soundFxVolume = -80.0f;
        }
        if (noun.equals("on")) {
           soundFxVolume = tempFxVolume;
        }
    }

    public static void startBackgroundAudio() throws InterruptedException {
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.wait();
    }

    public static void startBackgroundMusic() {
        playAudioMusic("Spooky_Music.wav");
        FloatControl gainControl =
            (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-15.0f);
    }

    public static void volumeUpDown(String noun) {
        if (noun.equals("0")) {
            FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(gainControl.getMinimum());
            clip.start();
        } else if (noun.equals("1")) {
            FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-21.0f);
            clip.start();
        } else if (noun.equals("2")) {
            FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-18.0f);
            clip.start();
        } else if (noun.equals("3")) {
            FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-15.0f);
            clip.start();
        } else if (noun.equals("4")) {
            FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-12.0f);
            clip.start();
        } else if (noun.equals("5")) {
            FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-9.0f);
            clip.start();
        } else if (noun.equals("6")) {
            FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-6.0f);
            clip.start();
        } else if (noun.equals("7")) {
            FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-3.0f);
            clip.start();
        } else if (noun.equals("8")) {
            FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(0.0f);
            clip.start();
        } else if (noun.equals("9")) {
            FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(3.0f);
            clip.start();
        } else if (noun.equals("10")) {
            FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(gainControl.getMaximum());
            clip.start();
        }
    }

    public static void playRoomSound(String noun) throws InterruptedException {
        playAudioFX(building.getBuilding().get(noun).getAudio1());
        Thread.sleep(500);
        playAudioFX(building.getBuilding().get(noun).getAudio2());
        Thread.sleep(1000);
        playAudioFX(building.getBuilding().get(noun).getAudio3());
    }

    public static void playItemSound() throws InterruptedException {
        String currentLoc = player.getCurrentLocation();
        if (building.getBuilding().get(currentLoc).getInventoryAudio() != null) {
            playAudioFX(building.getBuilding().get(currentLoc).getInventoryAudio());
            Thread.sleep(1000);
        }
    }

    public static void playNPCSound(String npcSound) {

        try {
            URL audio = GameMusic.class.getResource("/" + npcSound);
            AudioInputStream audioInput = null;
            if (audio != null) {
                audioInput = AudioSystem.getAudioInputStream(audio);
            }
            //   npcAudioClip.stop();
            npcAudioClip = AudioSystem.getClip();
            npcAudioClip.open(audioInput);
            npcAudioClip.stop();

            // Set default sound FX volume
            gainControlNPC =
                (FloatControl) npcAudioClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControlNPC.setValue(soundFxVolume);
            npcAudioClip.start();
        } catch (Exception e) {
            //ignore
        }

    }


    public static void playMoveSound(String noun) throws InterruptedException {
        playAudioFX(building.getBuilding().get(noun).getFootstepAudio());
//    Thread.sleep(250);
    }

    public static void playDrawerSound() throws InterruptedException {
        String currentLoc = player.getCurrentLocation();
        playAudioFX(building.getBuilding().get(currentLoc).getDrawerOpenAudio());
        Thread.sleep(1000);
    }

    public static void playAccessDeniedSound(String noun) throws InterruptedException {
        playAudioFX(building.getBuilding().get(noun).getAccessDeniedAudio());
        Thread.sleep(1000);
    }

    public static void playAccessGrantedSound() throws InterruptedException {
        String currentLoc = player.getCurrentLocation();
        playAudioFX(building.getBuilding().get(currentLoc).getAccessGrantedAudio());
        Thread.sleep(1000);
    }

    public static void playDoorOpenSound() throws InterruptedException {
        String currentLoc = player.getCurrentLocation();
        playAudioFX(building.getBuilding().get(currentLoc).getDoorOpenAudio());
        Thread.sleep(1000);
    }

    public static void playVendingMachineSound() throws InterruptedException {
        String currentLoc = player.getCurrentLocation();
        playAudioFX(building.getBuilding().get(currentLoc).getVendingMachineAudio());
        Thread.sleep(1000);
    }

    public static void playTypingSound() throws InterruptedException {
        String currentLoc = player.getCurrentLocation();
        playAudioFX(building.getBuilding().get(currentLoc).getTypingAudio());
        Thread.sleep(1000);
    }

    public static void playPhoneTyping() throws InterruptedException {
        String currentLoc = player.getCurrentLocation();
        playAudioFX(building.getBuilding().get(currentLoc).getPhoneTypingAudio());
        Thread.sleep(1000);
    }

    public static void playPhoneUnlockingSound() throws InterruptedException {
        String currentLoc = player.getCurrentLocation();
        if (building.getBuilding().get(currentLoc).getPhoneUnlockingAudio() != null) {
            playAudioFX(building.getBuilding().get(currentLoc).getPhoneUnlockingAudio());
            Thread.sleep(1000);
        }
    }

    public static String getVolume() {
        return volume;
    }

    public static void setVolume(String vol) {
        volume = vol;
    }

    public static Clip getNpcAudioClip() {
        return npcAudioClip;
    }
}
