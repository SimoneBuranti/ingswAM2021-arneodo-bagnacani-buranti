package it.polimi.ingsw.server.network.messages;

public class ChangeCurrentPlayerMessage extends Message{
    private final MessageType messageType = MessageType.CHANGECURRENTPLAYER;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }
}