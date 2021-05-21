package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class UpdateInitBooleanMessage extends Message {
    private boolean initResource;
    private final MessageType messageType = MessageType.INIT;
    private boolean initLeader;

    public UpdateInitBooleanMessage(boolean initResource,boolean initLeader) {
        this.initResource = initResource;
        this.initLeader = initLeader;
    }

    public boolean isInitResource() {
        return initResource;
    }


    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    public boolean isInitLeader() {
        return initLeader;
    }
}
