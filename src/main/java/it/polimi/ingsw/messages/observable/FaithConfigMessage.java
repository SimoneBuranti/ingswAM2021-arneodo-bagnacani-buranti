package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

public class FaithConfigMessage extends Message {
    private final MessageType messageType = MessageType.MYFAITHMOVECONFIG;
    private int faithConfig;
    public FaithConfigMessage(int faithConfig){
        this.faithConfig=faithConfig;
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
