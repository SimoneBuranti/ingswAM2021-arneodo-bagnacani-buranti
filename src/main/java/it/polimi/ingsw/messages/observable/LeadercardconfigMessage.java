package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.util.ArrayList;

public class LeadercardconfigMessage extends Message {
    private final MessageType messageType = MessageType.LEADERCONFIGMESSAGE;
    private ArrayList<LeaderCard> NotActivadet;
    private ArrayList<LeaderCard> Activadet;

    public LeadercardconfigMessage(ArrayList<LeaderCard> NotActivated,ArrayList<LeaderCard> Activated){
        this.NotActivadet=NotActivated;
        this.Activadet=Activated;
    }




    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

    public ArrayList<LeaderCard> getNotActivadet() {
        return NotActivadet;
    }

    public ArrayList<LeaderCard> getActivadet() {
        return Activadet;
    }
}
