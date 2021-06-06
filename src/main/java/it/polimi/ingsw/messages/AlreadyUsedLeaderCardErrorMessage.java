package it.polimi.ingsw.messages;

import java.io.IOException;

public class AlreadyUsedLeaderCardErrorMessage extends Message {
    /**
     * message which contain the information
     * error cause activation of leader card
     * from server to client
     */
    private final MessageType messageType = MessageType.ALREADYUSEDLEADERCARDERROR;

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
        return "The chosen leader card was already used, please choose another card or another action.";
    }
}
