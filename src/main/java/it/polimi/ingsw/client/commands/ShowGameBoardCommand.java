package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.messages.Message;

public class ShowGameBoardCommand extends Command {

    private View view;

    public ShowGameBoardCommand(View view) {
        this.view = view;
    }

    public Message commandOn() throws NoMessageReturnException {

        view.showGameBoardOfPlayer();

        throw new NoMessageReturnException();
    }

    public static String defToString(){
        return "showGameboard";
    }

    public String toString(){
        return defToString();
    }
}
