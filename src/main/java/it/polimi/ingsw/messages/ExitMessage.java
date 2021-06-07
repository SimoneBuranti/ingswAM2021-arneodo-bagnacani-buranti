package it.polimi.ingsw.messages;

import java.io.IOException;

public class ExitMessage extends Message{

    /**
     * message which contains the information of exit from client to server
     * the consequence is the disconnection
     */
    private final MessageType messageType=MessageType.EXIT;


    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

}
