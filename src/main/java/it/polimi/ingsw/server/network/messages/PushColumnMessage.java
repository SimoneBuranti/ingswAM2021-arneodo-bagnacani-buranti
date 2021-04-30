package it.polimi.ingsw.server.network.messages;

public class PushColumnMessage extends Message{
    private final MessageType messageType = MessageType.PUSHCOLUMN;

    private int columnNumber;

    public MessageType getMessageType() {
        return messageType;
    }

    public int getColumnNumber() {
        return columnNumber;
    }
}
