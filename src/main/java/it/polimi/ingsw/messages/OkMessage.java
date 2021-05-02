package it.polimi.ingsw.messages;

public class OkMessage extends Message {

    /**
     * type of message
     */
    private final MessageType messageType=MessageType.OK;

    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
