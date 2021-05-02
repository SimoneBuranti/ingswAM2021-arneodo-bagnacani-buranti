package it.polimi.ingsw.messages;

public class NotAvailableResourcesErrorMessage extends Message {
    private final MessageType messageType = MessageType.NOTAVAILABLERESOURCESERROR;


    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

}
