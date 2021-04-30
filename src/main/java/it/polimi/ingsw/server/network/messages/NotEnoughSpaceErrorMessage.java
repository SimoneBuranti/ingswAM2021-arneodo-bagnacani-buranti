package it.polimi.ingsw.server.network.messages;

public class NotEnoughSpaceErrorMessage extends Message {
    private final MessageType messageType = MessageType.NOTENOUGHSPACEERROR;
@Override
    public MessageType getMessageType() {
        return messageType;
    }
}
