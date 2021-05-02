package it.polimi.ingsw.messages;

public class ProductionOnMessage extends Message {

    private int productionCardNumber;


    /**
     * type of message
     */
    private final MessageType messageType=MessageType.PRODUCTIONON;

    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }

    public int getProductionCardNumber() {
        return productionCardNumber;
    }

    public void setProductionCardNumber(int productionCardNumber) {
        this.productionCardNumber = productionCardNumber;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
