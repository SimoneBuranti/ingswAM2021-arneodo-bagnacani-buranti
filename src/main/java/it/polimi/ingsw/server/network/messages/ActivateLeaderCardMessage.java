package it.polimi.ingsw.server.network.messages;

public class ActivateLeaderCardMessage extends Message {

    private final MessageType messageType = MessageType.ACTIVATELEADERCARD;

    private int cardNumber;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    public int getCardNumber() {
        return cardNumber;
    }
}
