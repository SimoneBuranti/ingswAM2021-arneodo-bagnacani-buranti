package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.NumberPlayerMessage;

public class HowManyPlayerParser implements CommandParser{


    @Override
    public Command parseCommand(String commandText, ViewController viewController, Cli cli) throws InvalidCommandException {

        int nOfplayers;

        if (commandText.length() == 0)
            throw new InvalidCommandException();

        nOfplayers = Command.fromStringToInt(commandText);

        if (nOfplayers<1 || nOfplayers > 4)
            throw new InvalidCommandException();

        return new HowManyPlayersCommand(nOfplayers);
    }
}


