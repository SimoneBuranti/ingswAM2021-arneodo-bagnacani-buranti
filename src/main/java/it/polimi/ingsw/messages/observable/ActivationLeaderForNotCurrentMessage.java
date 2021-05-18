package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.players.Player;

import java.io.IOException;

public class ActivationLeaderForNotCurrentMessage extends Message {
    private final MessageType messageType = MessageType.ACTIVATIONLEADERCARDNOTIFICATION;

    private Player player;

    public ActivationLeaderForNotCurrentMessage(Player player){
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
}
