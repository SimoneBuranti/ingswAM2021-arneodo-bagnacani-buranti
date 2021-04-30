package it.polimi.ingsw.server.network.messages;

public class LastTurnMessage extends Message{

    private final MessageType messageType = MessageType.LASTTURN;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }
}
