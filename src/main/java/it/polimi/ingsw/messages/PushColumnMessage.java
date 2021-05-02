package it.polimi.ingsw.messages;

public class PushColumnMessage extends Message{
    private final MessageType messageType = MessageType.PUSHCOLUMN;

    private int columnNumber;
@Override
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