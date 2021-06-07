package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.AskInformationMessage;
import it.polimi.ingsw.messages.Message;

public class ShowPlayerCommand extends Command {

    /**
     * view controller reference.
     */
    private ViewController viewController;

    /**
     * Number of the player
     */
    private int numberPlayer;

    public ShowPlayerCommand(int n, ViewController viewController) {
        this.numberPlayer=n;
        this.viewController=viewController;
    }

    /**
     * Getter for the player number.
     * @return
     */
    public int getNumberPlayer() {
        return numberPlayer;
    }

    /**
     * This commandOn method returns a AskInformationMessage.
     * @return AskInformationMessage
     */
    public Message commandOn(){
      return new AskInformationMessage(numberPlayer);
    }

    public static String defToString(){
        return "showPlayer";
    }


}
