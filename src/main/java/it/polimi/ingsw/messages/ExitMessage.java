package it.polimi.ingsw.messages;

import java.io.IOException;

public class ExitMessage extends Message{

    /**
     * type of message
     */
    private final MessageType messageType=MessageType.EXIT;


    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

}
