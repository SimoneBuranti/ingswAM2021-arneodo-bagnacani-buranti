package it.polimi.ingsw.server.network.messages;

public class AlreadyUsedLeaderCardErrorMessage extends Message {

    private final MessageType messageType = MessageType.ALREADYUSEDLEADERCARDERROR;

    public MessageType getMessageType() {
        return messageType;
    }
}
