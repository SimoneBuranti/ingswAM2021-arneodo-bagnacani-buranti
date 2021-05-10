package it.polimi.ingsw.messages;


import it.polimi.ingsw.server.model.players.Player;

public class OpponentFaithMoveMessage extends Message{
    private final MessageType messageType = MessageType.OPPONENTFAITHMOVE;


    private Player player;
    public OpponentFaithMoveMessage(Player player){
        this.player=player;
    }


    public Player getPlayer() {
        return player;
    }


    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
