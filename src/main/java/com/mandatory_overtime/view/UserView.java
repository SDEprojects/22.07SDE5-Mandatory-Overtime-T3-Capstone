package com.mandatory_overtime.view;

public class UserView {

  public String startUpInfo(String name) {

    String gameInfo =

        "Hello " + name + ", \n"
            + "You are a developer for Amazon and it's Halloween night"
            + "You have had a long week at the office, but you are diving head first into the weekend"
            + "because there's a rooftop Halloween Party tonight!\n\n"
            + "You wake up from slobbering on your desk. You wipe off the cheetos dust from your cheek."
            + "While you're looking at the same error in your code from the last 2 weeks,"
            + "your coworker Pete tells you that he has been hearing rumors of Mandatory Overtime.\n\n"
            + "You know that it's your turn to be On-Call this weekend."
            + "Finish your work and escape the building with your things"
            + "before your manager, Scott, finds you and you miss the party tonight.";

    return gameInfo;
  }
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


  public String startUpTitle() {
    String pumpkin = "\t\t\t\t\t\t\t\t\t\t\t────────────────████\n\t\t\t\t\t\t\t\t\t\t\t───────────────█░░███\n\t\t\t\t\t\t\t\t\t\t\t───────────────█░░████\n\t\t\t\t\t\t\t\t\t\t\t────────────────███▒██─────████████\n\t\t\t\t\t\t\t\t\t\t\t──────████████─────█▒█──████▒▒▒▒▒▒████\n\t\t\t\t\t\t\t\t\t\t\t────███▒▒▒▒▒▒████████████░░████▒▒▒▒▒███\n\t\t\t\t\t\t\t\t\t\t\t──██▒▒▒▒░▒▒████░░██░░░░██░░░░░█▒▒▒▒▒▒▒███\n\t\t\t\t\t\t\t\t\t\t\t─██▒▒░░░░▒██░░░░░█▒░░░░░██▒░░░░░░░▒▒▒▒▒▒█\n\t\t\t\t\t\t\t\t\t\t\t██▒░░░░░▒░░░░░░░░░▒░░░░░░░▒▒░░░░░░░▒▒▒▒▒██\n\t\t\t\t\t\t\t\t\t\t\t█░░░░░░▒░░░██░░░░░░░░░░░░░██░░░░░░░░▒▒▒▒▒█\n\t\t\t\t\t\t\t\t\t\t\t█░░░░░░░░█▒▒███░░░░░░░░░█▒▒███░░░░░░░▒▒▒▒█\n\t\t\t\t\t\t\t\t\t\t\t█░░░░░░░████████░░░░░░░████████░░░░░░▒▒▒▒█\n\t\t\t\t\t\t\t\t\t\t\t█░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒█\n\t\t\t\t\t\t\t\t\t\t\t─█░░░░██░█░░░░░░░░░░░░░░░░░░░░░░░███▒▒▒▒▒█\n\t\t\t\t\t\t\t\t\t\t\t─█▒▒░░░░█████░░░█░░░░██░░░██░░████░▒▒▒▒▒▒█\n\t\t\t\t\t\t\t\t\t\t\t─██▒▒░░░░░█████████████████████░░░▒▒▒▒▒▒██\n\t\t\t\t\t\t\t\t\t\t\t──██▒▒▒▒░░░░░██░░░███░░░██░░░█░░░▒▒▒▒▒▒██\n\t\t\t\t\t\t\t\t\t\t\t───███▒▒▒░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒█████\n\t\t\t\t\t\t\t\t\t\t\t─────███▒▒▒▒▒▒░░░░░░░░░░░░░▒▒▒▒▒▒████\n\t\t\t\t\t\t\t\t\t\t\t────────██████████████████████████\n";
    String title = "\n▒█▀▄▀█ █▀▀█ █▀▀▄ █▀▀▄ █▀▀█ ▀▀█▀▀ █▀▀█ █▀▀█ █░░█ 　 ▒█▀▀▀█ ▀█░█▀ █▀▀ █▀▀█ ▀▀█▀▀ ░▀░ █▀▄▀█ █▀▀\n▒█▒█▒█ █▄▄█ █░░█ █░░█ █▄▄█ ░░█░░ █░░█ █▄▄▀ █▄▄█ 　 ▒█░░▒█ ░█▄█░ █▀▀ █▄▄▀ ░░█░░ ▀█▀ █░▀░█ █▀▀\n▒█░░▒█ ▀░░▀ ▀░░▀ ▀▀▀░ ▀░░▀ ░░▀░░ ▀▀▀▀ ▀░▀▀ ▄▄▄█ 　 ▒█▄▄▄█ ░░▀░░ ▀▀▀ ▀░▀▀ ░░▀░░ ▀▀▀ ▀░░░▀ ▀▀▀\n========================================================================================================";
    String summary = "\n\nIt's Halloween night in the office and the halls echo with rumours of mandatory overtime.\nEscape before your manager finds you to make it to your Halloween Party!";
    return pumpkin + title + summary;
  }

  public String showHelp() {
    String help =

          "\t\n\n"
        + " Turn music off/on in the settings menu\n"
        + " Use the slider in the settings menu to settings to adjust background music volume\n"
        + " Be on the lookout for items in locations\n"
        + " To add an item to your inventory, click on it's image\n"
        + " Game play dialogue will appear on the black screen\n"
        + " Hover over an item to see a description of the item\n"
        + " Use the SAVE button to save the game at any time";
    return help;
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
  public String incorrectInput() {
    return "\nWe don't recognize this command. Please review the game commands for valid inputs. (type 'help')\n";
  }

  public String showWin(){

    String art ="\n\n\n\n\n\n\n.===================================================================.\n"
        + "||                                                                 ||\n"
        + "||                                                                 ||\n"
        + "||                            ___                                  ||\n"
        + "||                          .'   '.                                ||\n"
        + "||                         /       \\           oOoOo               ||\n"
        + "||                        |         |       ,==|||||               ||\n"
        + "||                         \\       /       _|| |||||               ||\n"
        + "||                          '.___.'    _.-'^|| |||||               ||\n"
        + "||                        __/_______.-'     '==HHHHH               ||\n"
        + "||                   _.-'` /                   \"\"\"\"\"               ||\n"
        + "||                .-'     /   oOoOo                                ||\n"
        + "||                `-._   / ,==|||||                                ||\n"
        + "||                    '-/._|| |||||                                ||\n"
        + "||                     /  ^|| |||||                                ||\n"
        + "||                    /    '==HHHHH                                ||\n"
        + "||                   /________\"\"\"\"\"                                ||\n"
        + "||                   `\\       `\\                                   ||\n"
        + "||                     \\        `\\   /                             ||\n"
        + "||                      \\         `\\/                              ||\n"
        + "||                      /                                          ||\n"
        + "||                     /                                           ||\n"
        + "||                    /_____                                       ||\n"
        + "||                                                                 ||\n"
        + "'==================================================================='\n"
        + "\n"
        + "---------------------------------------------------------------------\n\n";
    String message = "\n"
        + "██╗░░░██╗░█████╗░██╗░░░██╗  ░██╗░░░░░░░██╗██╗███╗░░██╗  ██╗██╗██╗\n"
        + "╚██╗░██╔╝██╔══██╗██║░░░██║  ░██║░░██╗░░██║██║████╗░██║  ██║██║██║\n"
        + "░╚████╔╝░██║░░██║██║░░░██║  ░╚██╗████╗██╔╝██║██╔██╗██║  ██║██║██║\n"
        + "░░╚██╔╝░░██║░░██║██║░░░██║  ░░████╔═████║░██║██║╚████║  ╚═╝╚═╝╚═╝\n"
        + "░░░██║░░░╚█████╔╝╚██████╔╝  ░░╚██╔╝░╚██╔╝░██║██║░╚███║  ██╗██╗██╗\n"
        + "░░░╚═╝░░░░╚════╝░░╚═════╝░  ░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚══╝  ╚═╝╚═╝╚═╝";

    return art + message;
  }
  public String showLoss(){
    String skull= "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t███████████████████████████"
        + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t███████▀▀▀░░░░░░░▀▀▀███████"
        + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t████▀░░░░░░░░░░░░░░░░░▀████"
        + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t███│░░░░░░░░░░░░░░░░░░░│███"
        + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t██▌│░░░░░░░░░░░░░░░░░░░│▐██"
        + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t██░└┐░░░░░░░░░░░░░░░░░┌┘░██"
        + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t██░░└┐░░░░░░░░░░░░░░░┌┘░░██"
        + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t██░░┌┘▄▄▄▄▄░░░░░▄▄▄▄▄└┐░░██"
        + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t██▌░│██████▌░░░▐██████│░▐██"
        + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t███░│▐███▀▀░░▄░░▀▀███▌│░███"
        + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t██▀─┘░░░░░░░▐█▌░░░░░░░└─▀██"
        + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t██▄░░░▄▄▄▓░░▀█▀░░▓▄▄▄░░░▄██"
        + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t████▄─┘██▌░░░░░░░▐██└─▄████"
        + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t█████░░▐█─┬┬┬┬┬┬┬─█▌░░█████"
        + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t████▌░░░▀┬┼┼┼┼┼┼┼┬▀░░░▐████"
        + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t█████▄░░░└┴┴┴┴┴┴┴┘░░░▄█████"
        + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t███████▄░░░░░░░░░░░▄███████"
        + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t██████████▄▄▄▄▄▄▄██████████"
        + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t███████████████████████████";

    String message = "\n██╗░░░██╗░█████╗░██╗░░░██╗  ░██████╗██╗░░░██╗░█████╗░██╗░░██╗  ██╗░░░░░░█████╗░░██████╗███████╗██████╗░" +
    "\n╚██╗░██╔╝██╔══██╗██║░░░██║  ██╔════╝██║░░░██║██╔══██╗██║░██╔╝  ██║░░░░░██╔══██╗██╔════╝██╔════╝██╔══██╗" +
    "\n░╚████╔╝░██║░░██║██║░░░██║  ╚█████╗░██║░░░██║██║░░╚═╝█████═╝░  ██║░░░░░██║░░██║╚█████╗░█████╗░░██████╔╝" +
    "\n░░╚██╔╝░░██║░░██║██║░░░██║  ░╚═══██╗██║░░░██║██║░░██╗██╔═██╗░  ██║░░░░░██║░░██║░╚═══██╗██╔══╝░░██╔══██╗" +
    "\n░░░██║░░░╚█████╔╝╚██████╔╝  ██████╔╝╚██████╔╝╚█████╔╝██║░╚██╗  ███████╗╚█████╔╝██████╔╝███████╗██║░░██║" +
    "\n░░░╚═╝░░░░╚════╝░░╚═════╝░  ╚═════╝░░╚═════╝░░╚════╝░╚═╝░░╚═╝  ╚══════╝░╚════╝░╚═════╝░╚══════╝╚═╝░░╚═╝";
    String message2 = "\n"
        + "███████╗███╗░░██╗░░░░░██╗░█████╗░██╗░░░██╗  ░█████╗░██╗░░░██╗███████╗██████╗░████████╗██╗███╗░░░███╗███████╗\n"
        + "██╔════╝████╗░██║░░░░░██║██╔══██╗╚██╗░██╔╝  ██╔══██╗██║░░░██║██╔════╝██╔══██╗╚══██╔══╝██║████╗░████║██╔════╝\n"
        + "█████╗░░██╔██╗██║░░░░░██║██║░░██║░╚████╔╝░  ██║░░██║╚██╗░██╔╝█████╗░░██████╔╝░░░██║░░░██║██╔████╔██║█████╗░░\n"
        + "██╔══╝░░██║╚████║██╗░░██║██║░░██║░░╚██╔╝░░  ██║░░██║░╚████╔╝░██╔══╝░░██╔══██╗░░░██║░░░██║██║╚██╔╝██║██╔══╝░░\n"
        + "███████╗██║░╚███║╚█████╔╝╚█████╔╝░░░██║░░░  ╚█████╔╝░░╚██╔╝░░███████╗██║░░██║░░░██║░░░██║██║░╚═╝░██║███████╗\n"
        + "╚══════╝╚═╝░░╚══╝░╚════╝░░╚════╝░░░░╚═╝░░░  ░╚════╝░░░░╚═╝░░░╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚═╝╚═╝░░░░░╚═╝╚══════╝";

    return skull + message + message2;
  }

//  public String missingSomethingFromInventory(String location){
//    return String.format("Looks like you're missing something in inventory. You won't be able to proceed to %s until you do", location);
//  }

  public String gameStatus(String locationDescription, String roomDescription, String item){
    return roomDescription;
  }

}

