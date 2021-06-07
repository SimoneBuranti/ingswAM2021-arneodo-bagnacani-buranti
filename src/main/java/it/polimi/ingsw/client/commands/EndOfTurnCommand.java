package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.commands.commandParsers.StandardParser;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.EndOfProductionMessage;
import it.polimi.ingsw.messages.EndOfTurnMessage;
import it.polimi.ingsw.messages.Message;

public class EndOfTurnCommand extends Command {
    /**
     * Attribute for the cli reference.
     */
    private Cli cli;

    /**
     * Attribute for the viewController reference.
     */
    private ViewController viewController;

    public EndOfTurnCommand(Cli cli, ViewController viewController) {
        this.cli = cli;
        this.viewController = viewController;
    }

    /**
     * This method checks whether the palyer has done a turn action or not. If they have it returns an EndOfTurnMessage().
     * Otherwise an InvalidCommandException is thrown.
     * @return
     * @throws SpentTokenException
     * @throws InvalidCommandException
     */
    public Message commandOn() throws SpentTokenException, InvalidCommandException {

        if(viewController.isActionToken())
            throw new InvalidCommandException();

        cli.changeCommandParser(new StandardParser());

        return new EndOfTurnMessage();
    }



    public static String defToString(){
        return "endTurn";
    }

    public String toString(){
        return defToString();
    }
}
