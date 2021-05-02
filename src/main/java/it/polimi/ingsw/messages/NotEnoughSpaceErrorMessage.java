package it.polimi.ingsw.messages;

public class NotEnoughSpaceErrorMessage extends Message {
    private final MessageType messageType = MessageType.NOTENOUGHSPACEERROR;
@Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
