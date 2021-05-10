package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.util.ArrayList;

public class TakeCardMessage extends Message {
    private final MessageType messageType = MessageType.TAKECARD;

    private int NumberDeck;

    private int column;


    public TakeCardMessage(int numberDeck, int column ){
        this.NumberDeck=numberDeck;
        this.column=column;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

    public int getColumn() {
        return column;
    }


    public int getNumberDeck() {
        return NumberDeck;
    }
}
