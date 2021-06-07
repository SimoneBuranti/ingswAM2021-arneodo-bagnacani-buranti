package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;

public class ResumeGameParser implements CommandParser{


    /**
     *This parser recognise only the "resume game" answer and returns a ResumeAnswerCommand.
     * @param commandText
     * @param viewController
     * @param cli
     * @return ResumeAnswerCommand
     * @throws InvalidCommandException
     */
    @Override
    public Command parseCommand(String commandText, ViewController viewController, Cli cli) throws InvalidCommandException {


        commandText = Command.deleteInitSpaces(commandText);
        if (commandText.length() == 0)
            throw new InvalidCommandException();

        if (commandText.equals("exit"))
            return new ExitCommand();


        if (commandText.equals("yes"))
            return new ResumeAnswerCommand(true);

        if (commandText.equals("no"))
            return new ResumeAnswerCommand(false);

        throw new InvalidCommandException();
    }

}
