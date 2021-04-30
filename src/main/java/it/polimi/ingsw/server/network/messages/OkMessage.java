package it.polimi.ingsw.server.network.messages;

public class OkMessage extends Message {

    /**
     * type of message
     */
    private final MessageType messageType=MessageType.OK;

    /**
     * @return type of message
     */
    public MessageType getMessageType() {
        return messageType;
    }
}
