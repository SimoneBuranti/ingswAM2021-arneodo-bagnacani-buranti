package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.marbles.Marble;

import java.util.ArrayList;

public class ChangeMarketMessage extends Message {
    private final MessageType messageType = MessageType.CHANGEMARKETMESSAGE;

    public ChangeMarketMessage(){}

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }



}
