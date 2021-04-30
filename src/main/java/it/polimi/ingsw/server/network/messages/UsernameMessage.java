package it.polimi.ingsw.server.network.messages;

public class UsernameMessage extends Message{

    /**
 * type of message
 */
private final MessageType messageType=MessageType.USERNAME;

    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }
}
