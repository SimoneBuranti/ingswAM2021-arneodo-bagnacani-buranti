package it.polimi.ingsw.server.network.messages;

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
}
