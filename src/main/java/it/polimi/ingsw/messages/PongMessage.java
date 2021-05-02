package it.polimi.ingsw.messages;

public class PongMessage extends Message{
    private final MessageType messageType = MessageType.PONG;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
