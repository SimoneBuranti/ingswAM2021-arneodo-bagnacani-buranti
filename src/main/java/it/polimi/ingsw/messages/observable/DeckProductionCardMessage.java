package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;
import java.util.ArrayList;

public class DeckProductionCardMessage extends Message {
    private final MessageType messageType = MessageType.REMOVECARD;

    private int NumberDeck;

    public DeckProductionCardMessage(int numberDeck){
        this.NumberDeck=numberDeck;
    }

    public int getNumberDeck() {
        return NumberDeck;
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
