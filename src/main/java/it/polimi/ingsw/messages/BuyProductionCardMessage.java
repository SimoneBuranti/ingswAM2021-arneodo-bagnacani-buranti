package it.polimi.ingsw.messages;

public class BuyProductionCardMessage extends Message{
    private final MessageType messageType = MessageType.BUYPRODUCTIONCARD;
    private int deckNumber;

    public int getDeckNumber() {
        return deckNumber;
    }

    public void setDeckNumber(int deckNumber){
        this.deckNumber = deckNumber;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
