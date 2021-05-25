package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.commands.ExitCommand;
import it.polimi.ingsw.client.commands.InvalidCommandException;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;

public class ExitOnlyParser implements CommandParser{
    @Override
    public Command parseCommand(String commandText, ViewController viewController, Cli cli) throws InvalidCommandException {

        commandText = Command.deleteInitSpaces(commandText);

        if (commandText.equals("exit"))
            return new ExitCommand();

        throw new InvalidCommandException();
    }
}
