package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.BuyProductionCardMessage;
import it.polimi.ingsw.messages.Message;

public class BuyActionCommand extends Command {

    /**
     * Attribute for the chosen deck number
     */
    private int deckNumber;

    /**
     * Attribute for the chosen column number
     */
    private int columnNumber;

    /**
     * Attribute for the viewController reference.
     */
    private ViewController viewController;

    public BuyActionCommand(int deckNumber, int column, ViewController viewController) {
        this.deckNumber = deckNumber;
        this.columnNumber = column;
        this.viewController = viewController;
    }


    /**
     * The commandOn() method returns a BuyProductionCardMessage instance if the action token is available. Otherwise it
     * throws a SpentTokenException
     * @return BuyProductionCardMessage
     * @throws SpentTokenException
     */
    public Message commandOn() throws SpentTokenException {
        if(viewController.isActionToken() && !viewController.isProductionMode()){
            viewController.setActionToken(false);
            return new BuyProductionCardMessage(this.deckNumber,this.columnNumber);
        }
        throw new SpentTokenException();
    }

    /**
     * Deck number getter
     * @return
     */
    public int getDeckNumber() {
        return deckNumber;
    }

    /**
     * ColumnNumber getter
     * @return
     */
    public int getColumnNumber() {
        return columnNumber;
    }

    public String toString(){
        return "buy "+deckNumber+" "+columnNumber;
    }

    public static String defToString(){
        return "buy [1..12] [1..3]";
    }
}
