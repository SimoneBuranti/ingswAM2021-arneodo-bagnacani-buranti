package it.polimi.ingsw.messages;

public class LastTurnMessage extends Message{

    private final MessageType messageType = MessageType.LASTTURN;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
