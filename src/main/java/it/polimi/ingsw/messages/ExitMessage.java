package it.polimi.ingsw.messages;

public class ExitMessage extends Message{

    /**
     * type of message
     */
    private final MessageType messageType=MessageType.EXIT;


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
