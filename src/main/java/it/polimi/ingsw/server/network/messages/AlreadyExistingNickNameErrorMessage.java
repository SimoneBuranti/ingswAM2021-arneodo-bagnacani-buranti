package it.polimi.ingsw.server.network.messages;

public class AlreadyExistingNickNameErrorMessage extends Message{
    /**
     * type of message
     */
    private final MessageType messageType=MessageType.ALREADYEXISTINGNICKNAMEERROR;

    /**
     */
    public MessageType getMessageType() {
        return messageType;
    }
}
