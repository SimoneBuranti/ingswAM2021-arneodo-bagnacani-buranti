package it.polimi.ingsw.server.network.messages;

public class PongMessage extends Message{
    private final MessageType messageType = MessageType.PONG;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }
}
