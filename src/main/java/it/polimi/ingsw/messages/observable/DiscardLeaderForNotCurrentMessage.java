package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.players.Player;

import java.io.IOException;

public class DiscardLeaderForNotCurrentMessage extends Message {
    private final MessageType messageType = MessageType.DISCARDLEADERCARDNOTIFICATION;

    private Player player;

    public DiscardLeaderForNotCurrentMessage(Player player){
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

    public Player getPlayer() {
        return player;
    }

    @Override
    public String toString(){
        return player.getNickName() +" has discarded a leader card";
    }
}
