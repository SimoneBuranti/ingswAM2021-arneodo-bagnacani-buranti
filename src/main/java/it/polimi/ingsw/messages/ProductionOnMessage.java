package it.polimi.ingsw.messages;

public class ProductionOnMessage extends Message {

    private int columnNumber;


    /**
     * type of message
     */
    private final MessageType messageType=MessageType.PRODUCTIONON;

    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
