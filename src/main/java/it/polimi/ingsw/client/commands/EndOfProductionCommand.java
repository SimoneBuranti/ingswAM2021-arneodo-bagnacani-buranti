package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.lightModel.LightGame;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.EndOfProductionMessage;
import it.polimi.ingsw.messages.Message;

public class EndOfProductionCommand extends Command {

    private ViewController viewController;

    public EndOfProductionCommand(ViewController viewController) {
        this.viewController = viewController;
    }

    public Message commandOn() throws SpentTokenException, InvalidCommandException {

        LightGame game = viewController.getGame();

        for (int i = 0; i<6;i++){
            if(!game.isProductionToken(i)) {
                viewController.setActionToken(false);
                return new EndOfProductionMessage();
            }
        }

        throw new InvalidCommandException();
    }



    public static String defToString(){
        return "endProduction";
    }

    public String toString(){
        return defToString();
    }
}
