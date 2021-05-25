package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.KeepLeaderCardsMessage;

import java.util.Scanner;

public class InitLeaderCardParser implements CommandParser{

    private int[] chosenLeaderCards = {0,0};

    @Override
    public Command parseCommand(String commandText, ViewController viewController, Cli cli){
        String w = "";
        int c;

        Scanner in = new Scanner(System.in);


        commandText = Command.deleteInitSpaces(commandText);
        while (commandText.length() == 0){
            System.out.println("Please insert two leader card numbers");
            commandText = in.nextLine();
            commandText = Command.deleteInitSpaces(commandText);
        }
        commandText = Command.deleteInitSpaces(commandText);

        if (commandText.equals("exit"))
            return new ExitCommand();


        for(int i = 0;i<commandText.length();i++){
            if (commandText.charAt(i)!=' '){
                w = w + commandText.charAt(i);
                c = Command.fromStringToInt(w);
                if ( c>0 && c<5) {
                    if (chosenLeaderCards[0] == 0){
                        chosenLeaderCards[0] = c;
                    } else {
                        if (c != chosenLeaderCards[0])
                            chosenLeaderCards[1] = c;
                        /*else {
                            System.out.println("You have chosen the same card twice, please type another number");
                        }*/
                    }
                }
                w = "";
            }
        }
        System.out.println("Chosen dopo il for: "+chosenLeaderCards[0]+chosenLeaderCards[1]);

        if (chosenLeaderCards[1] == 0){
            System.out.println("You have to insert another leader card number to continue:");
            w = "";
            c = 0 ;
            while(c<1 || c>4){

                w = in.nextLine();
                if (w.equals("exit"))
                    return new ExitCommand();
                c = Command.fromStringToInt(w);
                if (c<1 || c>4)
                    System.out.println("Please type a number between 1 and 4...");
                if (c == chosenLeaderCards[0])
                    System.out.println("You have already chosen this card, please type another number");

            }
            chosenLeaderCards[1] = c;
        }

        System.out.println("mo ritorno il command");
        return new KeepLeaderCardsCommand(chosenLeaderCards,viewController);
    }
}
