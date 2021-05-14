package it.polimi.ingsw.messages;

import java.io.IOException;

public class EndOfTurnMessage extends Message{
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
