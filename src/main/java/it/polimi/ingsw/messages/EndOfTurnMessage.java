package it.polimi.ingsw.messages;

public class EndOfTurnMessage extends Message{
    private final MessageType messageType = MessageType.ENDOFTURN;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
