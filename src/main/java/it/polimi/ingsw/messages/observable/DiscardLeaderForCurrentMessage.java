package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.io.IOException;

public class DiscardLeaderForCurrentMessage extends Message {
    private final MessageType messageType = MessageType.DISCARDLEADERCARDRESPONSE;

    private int index;

    public DiscardLeaderForCurrentMessage(int index){
        this.index=index;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    public int getIndex() {
        return index;
    }
}
