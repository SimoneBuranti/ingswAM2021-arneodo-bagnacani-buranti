package it.polimi.ingsw.messages;

public class NoNicknameMessage extends Message{
    /**
     * type of message
     */
    private final MessageType messageType=MessageType.NICKNAMENOTFOUNDERROR;




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
