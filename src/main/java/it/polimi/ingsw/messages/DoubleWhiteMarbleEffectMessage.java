package it.polimi.ingsw.messages;

public class DoubleWhiteMarbleEffectMessage extends Message {
    /**
     * message error of DoubleWhiteMarble from server to client
     * due to market action
     */
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

    public String toString(){
        return "There are "+whiteMarbleNumber+" white marble, choose a resource type for each one";
    }
}
