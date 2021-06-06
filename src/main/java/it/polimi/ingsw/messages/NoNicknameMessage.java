package it.polimi.ingsw.messages;

import java.io.IOException;

public class NoNicknameMessage extends Message{
    /**
     * message error of no nickname  from server to client
     * due to request of show all of a player
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
