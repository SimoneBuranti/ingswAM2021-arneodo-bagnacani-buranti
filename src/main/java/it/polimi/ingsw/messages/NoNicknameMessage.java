package it.polimi.ingsw.messages;

import java.io.IOException;

public class NoNicknameMessage extends Message{
    /**
     * type of message
     */
    private final MessageType messageType=MessageType.NICKNAMENOTFOUNDERROR;

    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    @Override
    public String toString(){
        return "username not found, try again to reconnect to the game.";
    }

}
