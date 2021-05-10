package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

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
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

    public int getIndex() {
        return index;
    }
}