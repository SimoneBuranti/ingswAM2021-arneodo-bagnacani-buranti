package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.Message;

public class ShowProductionDeckCommand extends Command{

    /**
     * Cli reference.
     */
    private Cli cli;

    public ShowProductionDeckCommand(Cli cli) {
        this.cli = cli;
    }

    /**
     * This commandOn method call the corresponding view show method. It returns a NoMessageReturnException as
     * no return message is required.
     * @throws NoMessageReturnException
     */
    public Message commandOn() throws NoMessageReturnException {

        cli.showProductionDecks();

        throw new NoMessageReturnException();
    }

    public static String defToString(){
        return "showProductionDecks";
    }

    public String toString(){
        return defToString();
    }

}
