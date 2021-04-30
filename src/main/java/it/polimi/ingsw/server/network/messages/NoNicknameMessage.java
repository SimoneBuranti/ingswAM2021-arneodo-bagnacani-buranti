package it.polimi.ingsw.server.network.messages;

public class NoNicknameMessage extends Message{
    /**
     * type of message
     */
    private final MessageType messageType=MessageType.NICKNAMENOTFOUNDERROR;




    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }

}
