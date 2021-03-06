package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class NoPlayersErrorMessage extends Message {

    /**
     * message which contain the error
     * for notify error of player
     * due asking to show oppopnent player?s information
     * from server to client
     */
    private final MessageType messageType = MessageType.NOTPLAYERSERROR;


    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    @Override
    public String toString(){
        return "sorry but no player at that position";
    }
}
