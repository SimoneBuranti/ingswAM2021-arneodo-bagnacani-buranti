package it.polimi.ingsw.messages;

import java.io.IOException;

public class AlreadyExistingNickNameErrorMessage extends Message{
    /**
     * type of message
     */
    private final MessageType messageType=MessageType.ALREADYEXISTINGNICKNAMEERROR;

    /**
     */
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
        return "The chosen username has already been taken, please choose another username.";
    }
}
