package it.polimi.ingsw.messages;

public class DoubleWhiteMarbleEffectMessage extends Message {
    private final MessageType messageType = MessageType.DOUBLEWHITEMARBLEEFFECT;

    private int whiteMarbleNumber;

    public DoubleWhiteMarbleEffectMessage(int whiteMarbleNumber) {
        this.whiteMarbleNumber = whiteMarbleNumber;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    public int getWhiteMarbleNumber() {
        return whiteMarbleNumber;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
