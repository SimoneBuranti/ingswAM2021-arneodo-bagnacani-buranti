package it.polimi.ingsw.messages;

import java.util.ArrayList;

public class DeckProductionCardMessage extends Message {
    private final MessageType messageType = MessageType.DECKPRODUCTIONCARD;

    private int NumberDeck;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

    public int getNumberDeck() {
        return NumberDeck;
    }

    public void setNumberDeck(int numberDeck) {
        NumberDeck = numberDeck;
    }



}
