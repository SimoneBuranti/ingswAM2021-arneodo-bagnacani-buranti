package it.polimi.ingsw.messages;

public class NotYourTurnErrorMessage extends Message{
    private final MessageType messageType = MessageType.NOTENOUGHSPACEERROR;


    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }
}
