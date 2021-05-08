package it.polimi.ingsw.messages;

public class BootingLobbyErrorMessage extends Message{
    private final MessageType messageType = MessageType.BOOTINGLOBBYERROR;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
