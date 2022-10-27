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

        "\t\tGame Commands\n\n"
            + "                                    Go [location]\texample: 'Go Elevator' \n\n"
            + "                                    Get [item]\texample: 'Get Phone'   \n\n"
            + "                                    Interact [NPC]\texample: 'Interact Roy'\n\n"
            + "                                    Inspect [item]\texample:'Inspect Sweater'\n\n"
            + "                                    Volume [0-10]\texample:'Volume 3'\n\n"
            + "                                   'Music On'\t[turns music on] \n\n"
            + "                                   'Music Off'\t[turns music off]\n\n"
            + "                                   'Look Around'\t[display room description]\n\n"
            + "                                   'Quit'\t[to quit the game at any time]";
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

}

