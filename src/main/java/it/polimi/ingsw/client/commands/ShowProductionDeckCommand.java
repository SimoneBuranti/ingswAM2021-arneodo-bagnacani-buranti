package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.messages.Message;

public class ShowProductionDeckCommand extends Command{

    private View view;

    public ShowProductionDeckCommand(View view) {
        this.view = view;
    }

    public Message commandOn() throws NoMessageReturnException {

        view.showProductionDecks();

        throw new NoMessageReturnException();
    }

    public static String defToString(){
        return "showProductionDecks";
    }

    public String toString(){
        return defToString();
    }

}
