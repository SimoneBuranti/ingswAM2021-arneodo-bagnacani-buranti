package it.polimi.ingsw.messages;

public class EndOfProductionMessage extends Message{
    private final MessageType messageType = MessageType.ENDOFPRODUCTION;



    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
