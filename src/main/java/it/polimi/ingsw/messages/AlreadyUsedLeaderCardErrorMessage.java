package it.polimi.ingsw.messages;

public class AlreadyUsedLeaderCardErrorMessage extends Message {

    private final MessageType messageType = MessageType.ALREADYUSEDLEADERCARDERROR;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
