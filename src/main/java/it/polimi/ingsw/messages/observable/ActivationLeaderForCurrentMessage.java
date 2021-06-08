package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.io.IOException;

public class ActivationLeaderForCurrentMessage extends Message {
    /**
     * message which contain the information
     * for notify your light model about activation of a leader card
     * after leader activation action
     * from server to client
     */
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
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    public int getIndex() {
        return index;
    }
}
