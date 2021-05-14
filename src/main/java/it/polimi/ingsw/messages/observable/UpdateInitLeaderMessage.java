package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.util.ArrayList;

public class UpdateInitLeaderMessage extends Message {
    private final MessageType messageType = MessageType.UPDATEINITLEADERCARD;


    private ArrayList<Integer> leaderCards;



    public UpdateInitLeaderMessage(ArrayList<Integer> leaderCards){
        this.leaderCards=leaderCards;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }


    public ArrayList<Integer> getLeaderCards(){
        return leaderCards;
    }
}
