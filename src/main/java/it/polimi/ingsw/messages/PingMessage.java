package it.polimi.ingsw.messages;

public class PingMessage extends Message{
    /**
     * message utils for ping message from server to client
     */
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
