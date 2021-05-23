package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.messages.Message;

public class ShowReserveCommand extends Command {


    private View view;

    public ShowReserveCommand(View view) {
        this.view = view;
    }

    public Message commandOn() throws NoMessageReturnException {

        view.showReserve();

        throw new NoMessageReturnException();
    }

    public static String defToString(){
        return "showReserve";
    }

    public String toString() {
        return defToString();
    }

}
