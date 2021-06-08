package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class LorenzoMoveMessage extends Message {
    /**
     * message which contain the information
     * for notify you about lorenzo moving update
     * from server to client
     */
    private final MessageType messageType = MessageType.LORENZOMAGNIFICFAITHMOVE;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }
}
