package it.polimi.ingsw.messages;

import java.io.IOException;

public class EndOfProductionMessage extends Message{
    /**
     * message which contain the information of end production action from client to server
     * the consequence is the result from reserve of all new resource
     */
    private final MessageType messageType = MessageType.ENDOFPRODUCTION;



    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }
}
