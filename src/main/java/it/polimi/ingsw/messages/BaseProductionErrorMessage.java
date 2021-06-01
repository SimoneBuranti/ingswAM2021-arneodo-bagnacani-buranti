package it.polimi.ingsw.messages;

import java.io.IOException;

public class BaseProductionErrorMessage extends Message {

    private final MessageType messageType = MessageType.BASEPRODUCTIONERROR;

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public String toString(){
        return "Sorry mate, you don't have those input resources";
    }
}
