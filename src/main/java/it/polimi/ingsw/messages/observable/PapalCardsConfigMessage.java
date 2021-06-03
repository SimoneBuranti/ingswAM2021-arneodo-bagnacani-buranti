package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class PapalCardsConfigMessage extends Message {
    private final MessageType messageType = MessageType.PAPALCARDSCONFIG;

    private int[] papalCards;

    public PapalCardsConfigMessage(int[] papalCards){
        this.papalCards = papalCards;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    public int[] getPapalCards() {
        return papalCards;
    }
}
