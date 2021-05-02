package it.polimi.ingsw.messages;

public class WrongColumnErrorMessage extends Message {

    private final MessageType messageType = MessageType.WRONGCOLUMNERROR;


    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}