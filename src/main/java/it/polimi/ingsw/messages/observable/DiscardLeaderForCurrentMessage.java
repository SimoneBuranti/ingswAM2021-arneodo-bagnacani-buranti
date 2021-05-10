package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

public class DiscardLeaderForCurrentMessage extends Message {
    private final MessageType messageType = MessageType.DISCARDLEADERCARDRESPONSE;

    private LeaderCard leaderCard;

    public DiscardLeaderForCurrentMessage(LeaderCard leaderCard){
        this.leaderCard=leaderCard;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

    public LeaderCard getLeaderCard() {
        return leaderCard;
    }
}
