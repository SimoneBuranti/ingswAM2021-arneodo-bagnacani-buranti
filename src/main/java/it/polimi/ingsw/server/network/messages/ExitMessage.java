package it.polimi.ingsw.server.network.messages;

public class ExitMessage extends Message{

    /**
     * type of message
     */
    private final MessageType messageType=MessageType.EXIT;


    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }

}
