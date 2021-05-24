package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.KeepLeaderCardsMessage;

public class InitLeaderCardParser implements CommandParser{

    private int[] chosenLeaderCards = {0,0};

    @Override
    public Command parseCommand(String commandText, ViewController viewController, Cli cli) throws InvalidCommandException, NoMessageReturnException {
        String w = " ";
        int c;


        commandText = Command.deleteInitSpaces(commandText);
        if (commandText.length() == 0)
            throw new InvalidCommandException();

        for(int i = 0;i<commandText.length();i++){
            if (commandText.charAt(i)!=' ' || i != commandText.length()-1){
                w = w + commandText.charAt(i);
            } else {
                c = Command.fromStringToInt(w);
                if (c<1 || c>4)
                    throw new InvalidCommandException();
                if (chosenLeaderCards[0] == 0){
                    chosenLeaderCards[0] = c;
                } else {
                    chosenLeaderCards[1] = c;
                    return new KeepLeaderCardsCommand(chosenLeaderCards);
                }

            }
        }
        throw new NoMessageReturnException();
    }
}
