package it.polimi.ingsw.messages;

import java.io.IOException;

public class DiscardLeaderCardMessage extends Message {
    /**
     * message which contain the information of the possibility
     * to discard a card from client to server
     * cause discard leader action
     */
    private final MessageType messageType = MessageType.DISCARDLEADERCARD;

    private int cardNumber;

    public DiscardLeaderCardMessage(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }
}
