package it.polimi.ingsw.server.network.messages;

public class PingMessage extends Message{
    private final MessageType messageType = MessageType.PING;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }
}
