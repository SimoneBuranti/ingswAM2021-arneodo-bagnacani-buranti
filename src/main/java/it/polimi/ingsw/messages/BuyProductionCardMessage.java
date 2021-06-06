package it.polimi.ingsw.messages;

import java.io.IOException;

public class BuyProductionCardMessage extends Message{
    /**
     * message which contain the information of chosen first card deck
     * and the column where put the card on development personal board
     * cause production buy card action
     */
    private final MessageType messageType = MessageType.BUYPRODUCTIONCARD;
    private int deckNumber;
    private int columnNumber;

    public BuyProductionCardMessage(int deckNumber, int columnNumber) {
        this.deckNumber = deckNumber;
        this.columnNumber = columnNumber;
    }

    public int getDeckNumber() {
        return deckNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }
}
