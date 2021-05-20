package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.lightModel.LightGame;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.EndOfProductionMessage;
import it.polimi.ingsw.messages.EndOfTurnMessage;
import it.polimi.ingsw.messages.ExitMessage;
import it.polimi.ingsw.messages.Message;

public class EndOfTurnCommand {


    private ViewController viewController;

    public EndOfTurnCommand(ViewController viewController) {
        this.viewController = viewController;
    }

    public Message commandOn() throws SpentTokenException, InvalidCommandException {

        if(!viewController.isActionToken())
            return new EndOfProductionMessage();

        throw new InvalidCommandException();
    }



    public static String defToString(){
        return "endTurn";
    }

    public String toString(){
        return defToString();
    }
}
