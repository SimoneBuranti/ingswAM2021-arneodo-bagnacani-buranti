package it.polimi.ingsw.server.network.messages;

public class CompleteRunningMatchErrorMessage extends Message{
    /**
     * type of message
     */
    private final MessageType messageType=MessageType.COMPLETERUNNINGMATCHERROR;


    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }
}
