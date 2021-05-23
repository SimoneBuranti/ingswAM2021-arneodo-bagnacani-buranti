package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.messages.Message;

public class ShowMarketCommand extends Command {

    private View view;

    public ShowMarketCommand(View view) {
        this.view = view;
    }

    public Message commandOn() throws NoMessageReturnException {

        view.showMarket();

        throw new NoMessageReturnException();
    }

    public static String defToString(){
        return "showMarket";
    }

    public String toString() {
        return defToString();
    }
}
