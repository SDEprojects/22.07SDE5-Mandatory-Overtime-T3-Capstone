package com.mandatory_overtime.view;

public class UserView {

  public String startUpInfo(String name) {

    String gameInfo =

        "Hello " + name + ", \n"
            + "You are a developer for Amazon and it's Halloween night\n"
            + "You have had a long week at the office, but you are diving head first into the weekend\n"
            + "because there's a rooftop Halloween Party tonight!\n\n"
            + "You wake up from slobbering on your desk. You wipe off the cheetos dust from your cheek.\n"
            + "While you're looking at the same error in your code from the last 2 weeks,\n"
            + "your coworker Pete tells you that he has been hearing rumors of Mandatory Overtime.\n\n"
            + "You know that it's your turn to be On-Call this weekend.\n"
            + "Finish your work and escape the building with your things\n"
            + "before your manager, Scott, finds you and you miss the party tonight.";

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
            + "\tTurn music off/on in the settings menu\n"
            + "\tUse the slider in the settings menu to settings\n"
                  + "\t  to adjust background music volume\n"
            + "\tBe on the lookout for items in locations\n"
            + "\tTo add an item to your inventory, click on it's image\n"
            + "\tGame play dialogue will appear on the black screen\n"

            + "\tHover over an item to see a description of the item\n"

            + "\tUse the save button to save the game at any time";
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

