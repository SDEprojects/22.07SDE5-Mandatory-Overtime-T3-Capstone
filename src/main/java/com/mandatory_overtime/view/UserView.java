package com.mandatory_overtime.view;

import java.io.PrintStream;

public class UserView {

  public String startUpInfo(String name){

    return "Hello " + name + ", \n"
        + "You are a developer for Amazon and it's Halloween night\n"
        + "You have had a long week at the office, but you are diving head first into the weekend\n"
        + "because there's a rooftop Halloween Party tonight!\n\n"
        + "You wake up from slobbering on your desk. You wipe off the cheetos dust from your cheek.\n"
        + "While you're looking at the same error in your code from the last 2 weeks,\n"
        + "your coworker Pete tells you that he has been hearing rumors of Mandatory Overtime.\n\n"
        + "You know that it's your turn to be On-Call this weekend.\n"
        + "Finish your work and escape the building with your things\n"
        + "before your manager, Scott, finds you and you miss the party tonight.\n";


  }

  public String startUpTitle(){
    return null;
  }

  public String showHelp(){
    return null;
  }

}
