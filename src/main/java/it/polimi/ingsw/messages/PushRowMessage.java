package it.polimi.ingsw.messages;

import java.io.IOException;

public class PushRowMessage extends Message{
    private final MessageType messageType = MessageType.PUSHROW;

    private int rowNumber;
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
