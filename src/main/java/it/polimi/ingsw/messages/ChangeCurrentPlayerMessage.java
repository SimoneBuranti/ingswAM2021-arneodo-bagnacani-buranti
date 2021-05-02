package it.polimi.ingsw.messages;

public class ChangeCurrentPlayerMessage extends Message{
    private final MessageType messageType = MessageType.CHANGECURRENTPLAYER;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
