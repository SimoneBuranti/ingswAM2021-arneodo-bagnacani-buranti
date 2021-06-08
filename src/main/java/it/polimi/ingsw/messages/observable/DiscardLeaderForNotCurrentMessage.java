package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.players.Player;

import java.io.IOException;

public class DiscardLeaderForNotCurrentMessage extends Message {
    /**
     * message which contain the information
     * for notify opponent view about discard of a leader card
     * after leader discard action
     * from server to client
     */
    private final MessageType messageType = MessageType.DISCARDLEADERCARDNOTIFICATION;

    private String player;

    public DiscardLeaderForNotCurrentMessage(String player){
        this.player=player;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    public String getPlayer() {
        return player;
    }

    @Override
    public String toString(){
        return player +" has discarded a leader card";
    }
}
