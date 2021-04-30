package it.polimi.ingsw.server.network.messages;

public class EndOfProductionMessage extends Message{
    private final MessageType messageType = MessageType.ENDOFPRODUCTION;



    @Override
    public MessageType getMessageType() {
        return messageType;
    }
}
