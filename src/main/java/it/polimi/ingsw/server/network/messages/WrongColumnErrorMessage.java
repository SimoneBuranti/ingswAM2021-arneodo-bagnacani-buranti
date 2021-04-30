package it.polimi.ingsw.server.network.messages;

public class WrongColumnErrorMessage extends Message {

    private final MessageType messageType = MessageType.WRONGCOLUMNERROR;


    @Override
    public MessageType getMessageType() {
        return messageType;
    }
}
