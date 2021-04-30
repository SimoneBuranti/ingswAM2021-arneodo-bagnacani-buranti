package it.polimi.ingsw.server.network.messages;

public class DiscardLeaderCardMessage extends Message {
    private final MessageType messageType = MessageType.DISCARDLEADERCARD;

    private int cardNumber;

    public MessageType getMessageType() {
        return messageType;
    }

    public int getCardNumber() {
        return cardNumber;
    }
}
