package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.commands.InvalidCommandException;
import it.polimi.ingsw.client.commands.NoMessageReturnException;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;

public interface CommandParser {

    /**
     * This is the parsing method overridden by each parser class as a state pattern has been implemented for this aim.
     * @param commandText
     * @param viewController
     * @param cli
     * @return
     * @throws InvalidCommandException
     */

    Command parseCommand(String commandText, ViewController viewController, Cli cli) throws InvalidCommandException;
}
