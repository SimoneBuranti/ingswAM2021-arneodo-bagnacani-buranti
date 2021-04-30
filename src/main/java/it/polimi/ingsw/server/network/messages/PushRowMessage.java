package it.polimi.ingsw.server.network.messages;

public class PushRowMessage extends Message{
    private final MessageType messageType = MessageType.PUSHROW;

    private int rowNumber;
@Override
    public MessageType getMessageType() {
        return messageType;
    }

    public int getRowNumber() {
        return rowNumber;
    }
}
