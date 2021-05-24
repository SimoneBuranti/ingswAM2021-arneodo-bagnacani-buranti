package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.server.model.Resource;

import java.util.ArrayList;

public class InitResourceParser implements CommandParser{

    private int nOfResources;

    public InitResourceParser(int nOfResources) {
        this.nOfResources = nOfResources;
    }

    @Override
    public Command parseCommand(String commandText, ViewController viewController, Cli cli) throws InvalidCommandException, NoMessageReturnException {

        String w = " ";
        int c;
        ArrayList<Resource> chosenResources = new ArrayList<>();

        commandText = Command.deleteInitSpaces(commandText);
        if (commandText.length() == 0)
            throw new InvalidCommandException();

        Resource r;
        for (int i = 0;i<commandText.length();i++){
            if (commandText.charAt(i) != ' '){
                w = w + commandText.charAt(i);
            } else {
                r = Command.fromStringToResource(w);
                if(r != null)
                    chosenResources.add(r);
                w = "";
            }
        }
        r = Command.fromStringToResource(w);
        if(r != null)
            chosenResources.add(r);

        if (chosenResources.size() != nOfResources)
            throw new InvalidCommandException();

        return new InitResourceCommand(chosenResources,cli);
    }


}
