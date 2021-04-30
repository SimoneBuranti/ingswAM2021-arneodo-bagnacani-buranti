package it.polimi.ingsw.server.network.messages;

public class EndOfTurnMessage extends Message{
    private final MessageType messageType = MessageType.ENDOFTURN;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }
}
