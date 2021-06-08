package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.io.IOException;
import java.util.ArrayList;

public class UpdateInitLeaderMessage extends Message {
    /**
     * message which contain the information
     * for notify your if you choose leader cards or not in your old game
     * from server to client
     */
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
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }


    public ArrayList<Integer> getLeaderCards(){
        return leaderCards;
    }
}
