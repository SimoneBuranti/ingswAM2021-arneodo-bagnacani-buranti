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

    @Override
    public String toString(){
        return "the chosen column does not fit, try with another column or another action";
    }
}
