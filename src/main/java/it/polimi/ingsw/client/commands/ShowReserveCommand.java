package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.Message;

public class ShowReserveCommand extends Command {


    private Cli cli;

    public ShowReserveCommand(Cli cli) {
        this.cli = cli;
    }

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
