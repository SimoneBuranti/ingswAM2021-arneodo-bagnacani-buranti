package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.commands.InvalidCommandException;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;

public interface CommandParser {
    Command parseCommand(String commandText, ViewController viewController, View view) throws InvalidCommandException;
}
