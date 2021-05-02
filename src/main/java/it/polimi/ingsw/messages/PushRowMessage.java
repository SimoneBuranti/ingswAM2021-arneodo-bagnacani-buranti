package it.polimi.ingsw.messages;

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
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
