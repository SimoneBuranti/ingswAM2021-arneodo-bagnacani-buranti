package it.polimi.ingsw.messages;

public class AlreadyExistingNickNameErrorMessage extends Message{
    /**
     * type of message
     */
    private final MessageType messageType=MessageType.ALREADYEXISTINGNICKNAMEERROR;

    /**
     */
    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
