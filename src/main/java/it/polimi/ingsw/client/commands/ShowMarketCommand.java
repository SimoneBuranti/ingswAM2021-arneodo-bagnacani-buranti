package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.Message;

public class ShowMarketCommand extends Command {

    private Cli cli;

    public ShowMarketCommand(Cli cli) {
        this.cli = cli;
    }

    public Message commandOn() throws NoMessageReturnException {

        cli.showMarket();

        throw new NoMessageReturnException();
    }

    public static String defToString(){
        return "showMarket";
    }

    public String toString() {
        return defToString();
    }
}
