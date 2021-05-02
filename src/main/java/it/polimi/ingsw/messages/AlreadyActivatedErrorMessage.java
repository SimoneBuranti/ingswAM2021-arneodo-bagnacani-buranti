package it.polimi.ingsw.messages;

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
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
