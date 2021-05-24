package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.AskInformationMessage;
import it.polimi.ingsw.messages.Message;

public class ShowPlayerCommand extends Command {
    private ViewController viewController;

    private int numberPlayer;

    public ShowPlayerCommand(int n, ViewController viewController) {
        this.numberPlayer=n;
        this.viewController=viewController;
    }

    public int getNumberPlayer() {
        return numberPlayer;
    }

    public Message commandOn(){
      return new AskInformationMessage(numberPlayer);
    }

    public static String defToString(){
        return "showPlayer";
    }


}
