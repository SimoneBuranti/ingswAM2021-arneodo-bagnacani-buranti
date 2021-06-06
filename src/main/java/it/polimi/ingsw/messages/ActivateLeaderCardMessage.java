package it.polimi.ingsw.messages;

import java.io.IOException;

public class ActivateLeaderCardMessage extends Message {
    /**
     * message which contain the information
     * for activate leader card
     * from client to server
     */
    private final MessageType messageType = MessageType.ACTIVATELEADERCARD;

    private int cardNumber;

    public ActivateLeaderCardMessage(int cardNumber) {
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
