package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.util.ArrayList;

public class DeckProductionCardMessage extends Message {
    private final MessageType messageType = MessageType.REMOVECARD;

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
