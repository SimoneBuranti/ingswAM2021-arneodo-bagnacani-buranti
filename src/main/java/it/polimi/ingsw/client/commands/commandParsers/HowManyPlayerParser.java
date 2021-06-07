package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.NumberPlayerMessage;

public class HowManyPlayerParser implements CommandParser{


    /**
     * State for the initial number of player choice. This parser accepts only the exit command besides the number of players.
     * @param commandText
     * @param viewController
     * @param cli
     * @return HowManyPlayersCommand
     * @throws InvalidCommandException
     */

    @Override
    public Command parseCommand(String commandText, ViewController viewController, Cli cli) throws InvalidCommandException {

        int nOfplayers;

        commandText = Command.deleteInitSpaces(commandText);
        if (commandText.length() == 0)
            throw new InvalidCommandException();

        if (commandText.equals("exit"))
            return new ExitCommand();

        nOfplayers = Command.fromStringToInt(commandText);
        if (nOfplayers<1 || nOfplayers > 4)
            throw new InvalidCommandException();

        return new HowManyPlayersCommand(nOfplayers);
    }
}


