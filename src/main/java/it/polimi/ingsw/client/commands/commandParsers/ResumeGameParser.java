package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;

public class ResumeGameParser implements CommandParser{

    @Override
    public Command parseCommand(String commandText, ViewController viewController, Cli cli) throws InvalidCommandException {


        commandText = Command.deleteInitSpaces(commandText);
        if (commandText.length() == 0)
            throw new InvalidCommandException();

        if (commandText.equals("exit"))
            return new ExitCommand();


        if (commandText == "yes")
            return new ResumeAnswerCommand(true);

        if (commandText == "no")
            return new ResumeAnswerCommand(false);

        throw new InvalidCommandException();
    }

}
