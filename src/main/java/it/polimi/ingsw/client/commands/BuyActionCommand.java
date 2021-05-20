package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.BuyProductionCardMessage;
import it.polimi.ingsw.messages.Message;

public class BuyActionCommand extends Command {

    private int deckNumber;
    private int columnNumber;
    private ViewController viewController;

    public BuyActionCommand(char colour, int level, ViewController viewController) {
        this.deckNumber = deckNumber;
        this.viewController = viewController;
    }



    public Message commandOn() throws SpentTokenException {
        if(viewController.isActionToken()){
            viewController.spendActionToken();
            return new BuyProductionCardMessage(this.deckNumber,this.columnNumber);
        }
        throw new SpentTokenException();

    }

    public String toString(){
        return "buy "+deckNumber+" "+columnNumber;
    }

    public static String defToString(){
        return "buy [1..12] [1..3]";
    }
}
