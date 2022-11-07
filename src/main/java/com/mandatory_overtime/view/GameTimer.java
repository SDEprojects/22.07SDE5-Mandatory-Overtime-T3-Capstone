package com.mandatory_overtime.view;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.function.Consumer;
import javax.swing.Timer;

public class GameTimer {

    Timer timer;
    DecimalFormat format = new DecimalFormat("00");
    private String doubleDigitSeconds;
    private String doubleDigitMinutes;
    private int minutes;
    private int seconds = 0;
    private boolean timeUp;

    private Runnable loseAction;

    private final static String TIMER_STATUS= "Timer -  %s : %s";

    public GameTimer(){
        MenuBar.getTimerLabel().setText("");
        timer = new Timer(1000, e -> {
            timeUp = false;
            seconds--;
            if (seconds == -1){
                minutes--;
                seconds = 59;
                MenuBar.getTimerLabel().setText(String.format(TIMER_STATUS, doubleDigitMinutes,doubleDigitSeconds));
            }
            doubleDigitSeconds = format.format(seconds);
            doubleDigitMinutes = format.format(minutes);
            MenuBar.getTimerLabel().setText(String.format(TIMER_STATUS, doubleDigitMinutes,doubleDigitSeconds));

            MenuBar.getTimerLabel().setText(String.format(TIMER_STATUS, doubleDigitMinutes,doubleDigitSeconds));
            if(minutes ==0 && seconds == 0){
                timeUp = true;
                MenuBar.getTimerLabel().setForeground(Color.RED);
                timer.stop();
                MenuBar.getTimerLabel().setText(String.format(TIMER_STATUS, doubleDigitMinutes,doubleDigitSeconds));
                loseAction.run();
            }
        });
    }


    public void setSeconds(int seconds){
        this.seconds = seconds;
    }

    public int getSeconds() {
        return seconds;
    }
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    public int getMinutes() {
        return minutes;
    }
    public boolean getTimeUp(){
        return timeUp;
    }
    public void start(){
        timer.start();
    }
    public void stop(){
        timer.stop();
    }

    public void setLoseAction(Runnable loseAction) {
        this.loseAction = loseAction;
    }
}
