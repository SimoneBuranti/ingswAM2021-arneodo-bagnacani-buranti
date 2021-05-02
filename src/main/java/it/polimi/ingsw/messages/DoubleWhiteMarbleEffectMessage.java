package it.polimi.ingsw.messages;

public class DoubleWhiteMarbleEffectMessage extends Message {
    private final MessageType messageType = MessageType.DOUBLEWHITEMARBLEEFFECT;

    private int whiteMarbleNumber;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    public int getWhiteMarbleNumber() {
        return whiteMarbleNumber;
    }

    public void setWhiteMarbleNumber(int whiteMarbleNumber) {
        this.whiteMarbleNumber = whiteMarbleNumber;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
