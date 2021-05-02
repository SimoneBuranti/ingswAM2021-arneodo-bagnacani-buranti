package it.polimi.ingsw.messages;

public class PingMessage extends Message{
    private final MessageType messageType = MessageType.PING;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
