package it.polimi.ingsw.messages;

import java.io.IOException;

public class BaseProductionErrorMessage extends Message {
    /**
     * message which contain the information of extra produciton activate
     * error cause production  action
     * when user doesn't have input resources
     * from server to client
     */
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
