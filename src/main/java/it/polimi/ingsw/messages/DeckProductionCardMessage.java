package it.polimi.ingsw.messages;

import java.util.ArrayList;

public class DeckProductionCardMessage extends Message {
    private final MessageType messageType = MessageType.DECKPRODUCTIONCARD;

    private int NumberDeck;

    public DeckProductionCardMessage(int numberDeck){
        this.NumberDeck=numberDeck;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }




}
