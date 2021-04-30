package it.polimi.ingsw.server.network.messages;

public class AlreadyActivatedErrorMessage extends Message {

    private final MessageType messageType = MessageType.ALREADYACTIVATEDERROR;

    private int cardNumber;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

}
