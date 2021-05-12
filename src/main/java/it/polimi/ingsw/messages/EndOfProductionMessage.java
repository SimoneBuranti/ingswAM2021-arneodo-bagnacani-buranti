package it.polimi.ingsw.messages;

import java.io.IOException;

public class EndOfProductionMessage extends Message{
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
