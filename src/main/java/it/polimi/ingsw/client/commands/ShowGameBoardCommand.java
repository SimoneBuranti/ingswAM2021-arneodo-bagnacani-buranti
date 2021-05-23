package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.Message;

public class ShowGameBoardCommand extends Command {

    private Cli cli;

    public ShowGameBoardCommand(Cli cli) {
        this.cli = cli;
    }

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
