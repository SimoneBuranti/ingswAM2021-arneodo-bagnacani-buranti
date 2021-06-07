package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.Message;

public class ShowGameBoardCommand extends Command {

    /**
     * Cli reference.
     */
    private Cli cli;

    public ShowGameBoardCommand(Cli cli) {
        this.cli = cli;
    }
    /**
     * This commandOn method call the corresponding view show method. It returns a NoMessageReturnException as
     * no return message is required.
     * @return
     * @throws NoMessageReturnException
     */
    public Message commandOn() throws NoMessageReturnException {

        cli.showGameBoardOfPlayer();

        throw new NoMessageReturnException();
    }

    public static String defToString(){
        return "showGameboard";
    }

    public String toString(){
        return defToString();
    }
}
