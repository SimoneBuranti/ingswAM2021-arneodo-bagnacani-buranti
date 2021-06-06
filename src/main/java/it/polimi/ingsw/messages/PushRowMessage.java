package it.polimi.ingsw.messages;

import java.io.IOException;

public class PushRowMessage extends Message{

    /**
     * message which contain the information of row pushed in market
     * cause market action
     */
    private final MessageType messageType = MessageType.PUSHROW;

    private int rowNumber;

    public PushRowMessage(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }
}
