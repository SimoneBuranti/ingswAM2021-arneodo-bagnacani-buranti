package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.players.Player;

import java.io.IOException;

public class TakeCardForNotCurrentMessage extends Message {
    private final MessageType messageType = MessageType.TAKECARDFORNOTCURRENT;

    private int NumberDeck;


    private Player player;


    public TakeCardForNotCurrentMessage(Player player,int numberDeck){
        this.player=player;
        this.NumberDeck=numberDeck;

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

    public int getNumberDeck() {
        return NumberDeck;
    }
}
