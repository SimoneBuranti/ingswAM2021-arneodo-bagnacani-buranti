package it.polimi.ingsw.messages;

import java.io.IOException;

public class BaseProductionErrorMessage extends Message {
    

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    @Override
    public MessageType getMessageType() {
        return null;
    }
}
