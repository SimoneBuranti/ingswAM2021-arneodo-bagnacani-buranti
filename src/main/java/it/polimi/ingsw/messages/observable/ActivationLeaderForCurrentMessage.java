package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

public class ActivationLeaderForCurrentMessage extends Message {
    private final MessageType messageType = MessageType.ACTIVATIONLEADERCARDRESPONSE;

    private int index;

    public ActivationLeaderForCurrentMessage(int index){
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
