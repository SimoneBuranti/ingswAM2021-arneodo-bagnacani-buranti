package it.polimi.ingsw.server.network.messages;

public class RequirementsErrorMessage extends Message {

    private final MessageType messageType = MessageType.REQUIREMENTSERROR;
@Override
    public MessageType getMessageType() {
        return messageType;
    }
}
