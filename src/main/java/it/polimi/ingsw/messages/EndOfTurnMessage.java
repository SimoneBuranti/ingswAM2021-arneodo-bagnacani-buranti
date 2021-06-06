package it.polimi.ingsw.messages;

import java.io.IOException;

public class EndOfTurnMessage extends Message{
    /**
     * message which contain the information end of turn from client to server
     * the consequence change of turn
     */
    private final MessageType messageType = MessageType.ENDOFTURN;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }
}
