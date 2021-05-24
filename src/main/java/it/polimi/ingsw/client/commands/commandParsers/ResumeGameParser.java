package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.commands.HowManyPlayersCommand;
import it.polimi.ingsw.client.commands.InvalidCommandException;
import it.polimi.ingsw.client.commands.ResumeAnswerCommand;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;

public class ResumeGameParser implements CommandParser{

    @Override
    public Command parseCommand(String commandText, ViewController viewController, Cli cli) throws InvalidCommandException {

        if (commandText.length() == 0)
            throw new InvalidCommandException();

        commandText = Command.deleteInitSpaces(commandText);

        if (commandText == "yes")
            return new ResumeAnswerCommand(true);

        if (commandText == "no")
            return new ResumeAnswerCommand(false);

        throw new InvalidCommandException();
    }

}
