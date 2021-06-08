package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.io.IOException;
import java.util.ArrayList;

public class LeadercardconfigMessage extends Message {
    /**
     * message which contain the information
     * for notify your light gameboard about personal leader card after game restart
     * it includes the list of card activate and te list of disactivate
     * from server to client
     */
    private final MessageType messageType = MessageType.LEADERCONFIGMESSAGE;
    private ArrayList<Integer> notActivated;
    private ArrayList<Integer> activated;

    public LeadercardconfigMessage(ArrayList<Integer> NotActivated,ArrayList<Integer> Activated){
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
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    public ArrayList<Integer> getNotActivated() {
        return notActivated;
    }

    public ArrayList<Integer> getActivated() {
        return activated;
    }
}
