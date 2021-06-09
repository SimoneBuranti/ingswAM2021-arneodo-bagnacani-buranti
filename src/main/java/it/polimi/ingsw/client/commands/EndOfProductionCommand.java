package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.lightModel.LightGame;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.EndOfProductionMessage;
import it.polimi.ingsw.messages.Message;



public class EndOfProductionCommand extends Command {

    /**
     * Attribute for the viewController reference.
     */
    private ViewController viewController;

    /**
     * Constructor.
     * @param viewController
     */
    public EndOfProductionCommand(ViewController viewController) {
        this.viewController = viewController;
    }

    /**
     * This method checks whether the palyer has done a production action or not. If they have it returns an EndOfProductionMessage().
     * Otherwise an InvalidCommandException is thrown.
     * @return
     * @throws SpentTokenException
     * @throws InvalidCommandException
     */
    public Message commandOn() throws SpentTokenException, InvalidCommandException {

        LightGame game = viewController.getGame();

        for (int i = 0; i<6;i++){
            if(!game.isProductionToken(i)) {
                viewController.setActionToken(false);
                viewController.resetProductionTokens();
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
