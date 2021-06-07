package it.polimi.ingsw.messages;

import java.io.IOException;

public class NotAvailableResourcesErrorMessage extends Message {
    /**
     * message error of not available resource  from server to client
     * due to buy production card error
     * due to production start error
     */
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
        return "you don't have enough resources for this action, try with another one";
    }
}
