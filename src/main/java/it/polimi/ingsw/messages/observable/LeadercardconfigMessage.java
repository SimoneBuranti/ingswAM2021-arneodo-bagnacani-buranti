package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.util.ArrayList;

public class LeadercardconfigMessage extends Message {
    private final MessageType messageType = MessageType.LEADERCONFIGMESSAGE;
    private ArrayList<LeaderCard> notActivated;
    private ArrayList<LeaderCard> activated;

    public LeadercardconfigMessage(ArrayList<LeaderCard> NotActivated,ArrayList<LeaderCard> Activated){
        notActivated=new ArrayList<>();
        activated=new ArrayList<>();
        this.notActivated =NotActivated;
        this.activated=Activated;
    }




    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

    public ArrayList<LeaderCard> getNotActivated() {
        return notActivated;
    }

    public ArrayList<LeaderCard> getActivated() {
        return activated;
    }
}
