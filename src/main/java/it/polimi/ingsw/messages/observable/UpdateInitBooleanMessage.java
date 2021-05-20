package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class UpdateInitBooleanMessage extends Message {
    private boolean init;
    private final MessageType messageType = MessageType.INIT;
    public UpdateInitBooleanMessage(boolean init) {
        this.init=init;
    }

    public boolean isInit() {
        return init;
    }


    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }
}
