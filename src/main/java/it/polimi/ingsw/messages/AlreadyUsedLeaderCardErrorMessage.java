package it.polimi.ingsw.messages;

import java.io.IOException;

public class AlreadyUsedLeaderCardErrorMessage extends Message {

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
