package com.mandatory_overtime.view;

public class UserView {

  public String startUpInfo2(String name) {

    String gameInfo =

        "Hello " + name + ", <br>"
            + "You are a developer for Amazon and it's Halloween night. "
            + "You have had a long week at the office, but you are diving head first into the weekend "
            + "because there's a rooftop Halloween Party tonight! <br>"
            + "You wake up from slobbering on your desk. You wipe off the cheetos dust from your cheek.<br><br>"
            + "While you're looking at the same error in your code from the last 2 weeks, "
            + "your coworker Pete tells you that he has been hearing rumors of Mandatory Overtime. "
            + "You know that it's your turn to be On-Call this weekend.<br><br>"
            + "Finish your work and escape the building with your things "
            + "before your manager, Scott, finds you and you miss the party tonight.<br>";

    return gameInfo;
  }

  public String showHelp2() {
    String help =

        "\t\n\n"
            + "  <span style='color:#025fc2'>CONTROL MUSIC </span>         &emsp -  &emsp Open Settings and select music on/off.<br><br>"
            + "  <span style='color:#025fc2'>ADJUST VOLUME </span>        &emsp -  &emsp Open Settings and adjust slider.<br><br>"
            + "  <span style='color:#025fc2'>GRAB ITEM </span>          &emsp -  &emsp During gameplay click the item on screen.<br><br>"
            + "  <span style='color:#025fc2'>INSPECT ITEM </span>       &emsp -  &emsp During gameplay hover over the item.<br><br>"
            + "  <span style='color:#025fc2'>SAVE  </span>          &emsp -  &emsp Select Save game on the menu at any time.<br><br>"
            + "  <span style='color:#025fc2'>QUIT </span>          &emsp -  &emsp Select Quit To Main to return to the main menu.<br><br>"
            + "  <span style='color:#025fc2'>NPCs </span>          &emsp -  &emsp During gameplay click on NPC to interact.<br><br>"
            + "  <span style='color:#025fc2'>CHEAT </span>        &emsp -  &emsp During gameplay, open Settings, then God Mode on the top navbar.<br><br>";
    return help;
  }

  public String gameStatus(String locationDescription, String roomDescription, String item){
    return roomDescription;
  }
}

