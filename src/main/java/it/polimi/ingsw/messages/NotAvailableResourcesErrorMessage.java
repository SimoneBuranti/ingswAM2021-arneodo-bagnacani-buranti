package it.polimi.ingsw.messages;

import java.io.IOException;

public class NotAvailableResourcesErrorMessage extends Message {
    private final MessageType messageType = MessageType.NOTAVAILABLERESOURCESERROR;


    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    @Override
    public String toString(){
        return "you don't have enough resources to activate the production, try with another one or end the action";
    }
}
