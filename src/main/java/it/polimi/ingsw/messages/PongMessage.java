package it.polimi.ingsw.messages;

public class PongMessage extends Message{
    /**
     * message utils for pong message from client to server
     */
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
