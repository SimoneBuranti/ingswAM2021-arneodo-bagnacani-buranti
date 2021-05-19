package it.polimi.ingsw.messages;

import java.io.IOException;

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

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }


    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

}
