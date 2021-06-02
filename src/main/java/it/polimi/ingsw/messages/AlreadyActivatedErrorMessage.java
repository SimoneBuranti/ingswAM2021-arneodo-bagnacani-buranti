package it.polimi.ingsw.messages;

import java.io.IOException;

public class AlreadyActivatedErrorMessage extends Message {

    private final MessageType messageType = MessageType.ALREADYACTIVATEDERROR;

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

    @Override
    public String toString(){
        return "The chosen leader card was already used, please choose another card or another action.";
    }
}
