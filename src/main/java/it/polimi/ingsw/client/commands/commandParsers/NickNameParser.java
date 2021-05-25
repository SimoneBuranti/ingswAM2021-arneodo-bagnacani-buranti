package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.commands.ExitCommand;
import it.polimi.ingsw.client.commands.InvalidCommandException;
import it.polimi.ingsw.client.commands.UsernameCommand;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;

public class NickNameParser implements CommandParser{

    @Override
    public Command parseCommand(String commandText, ViewController viewController, Cli cli) throws InvalidCommandException {

        commandText = Command.deleteInitSpaces(commandText);
        if (commandText.length() == 0)
            throw new InvalidCommandException();

        if (commandText.equals("exit"))
            return new ExitCommand();

        return new UsernameCommand(Command.deleteInitSpaces(commandText));
    }

}
