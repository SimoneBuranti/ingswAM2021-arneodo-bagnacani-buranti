package it.polimi.ingsw.server.network.messages;

public class OkMessage extends Message {

    /**
     * type of message
     */
    private final MessageType messageType=MessageType.OK;

    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }


}
