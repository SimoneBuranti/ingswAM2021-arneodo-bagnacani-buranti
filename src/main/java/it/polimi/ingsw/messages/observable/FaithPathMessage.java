package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.players.Player;

import java.io.IOException;

public class FaithPathMessage extends Message {
    private final MessageType messageType = MessageType.MYFAITHMOVE;
    private int faithmove;

    public FaithPathMessage(int faithMove) {
       this.faithmove=faithMove;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    public int getFaithmove() {
        return faithmove;
    }
}
