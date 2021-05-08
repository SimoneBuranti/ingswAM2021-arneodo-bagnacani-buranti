package it.polimi.ingsw.messages;

public class BuyProductionCardMessage extends Message{
    private final MessageType messageType = MessageType.BUYPRODUCTIONCARD;
    private int deckNumber;
    private int columnNumber;

    public BuyProductionCardMessage(int deckNumber, int columnNumber) {
        this.deckNumber = deckNumber;
        this.columnNumber = columnNumber;
    }

    public int getDeckNumber() {
        return deckNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
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
