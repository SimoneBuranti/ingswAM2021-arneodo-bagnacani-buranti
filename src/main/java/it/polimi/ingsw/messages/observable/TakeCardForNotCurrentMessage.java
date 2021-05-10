package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.players.Player;

public class TakeCardForNotCurrentMessage extends Message {
    private final MessageType messageType = MessageType.TAKECARDFORNOTCURRENT;

    private int NumberDeck;

    private int column;

    private Player player;


    public TakeCardForNotCurrentMessage(Player player,int numberDeck, int column ){
        this.player=player;
        this.NumberDeck=numberDeck;
        this.column=column;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

    public int getColumn() {
        return column;
    }

    public Player getPlayer() {
        return player;
    }

    public int getNumberDeck() {
        return NumberDeck;
    }
}
