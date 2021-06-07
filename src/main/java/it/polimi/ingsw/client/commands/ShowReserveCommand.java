package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.Message;

public class ShowReserveCommand extends Command {

    /**
     * Cli reference.
     */
    private Cli cli;

    public ShowReserveCommand(Cli cli) {
        this.cli = cli;
    }

    /**
     * This method is called when a player wants to see the available resources in the reserve
     * @return
     * @throws NoMessageReturnException
     */
    public Message commandOn() throws NoMessageReturnException {

        cli.showReserve();

        throw new NoMessageReturnException();
    }

    public static String defToString(){
        return "showReserve";
    }

    public String toString() {
        return defToString();
    }

}
