package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

public class UpdateInitLeaderMessage extends Message {
    private final MessageType messageType = MessageType.UPDATEINITLEADERCARD;


    private LeaderCard c1;

    private LeaderCard c2;


    public UpdateInitLeaderMessage(LeaderCard c1, LeaderCard c2){

        this.c1=c1;
        this.c2 =c2;


    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }


    public LeaderCard getC1() {
        return c1;
    }

    public LeaderCard getC2() {
        return c2;
    }
}
