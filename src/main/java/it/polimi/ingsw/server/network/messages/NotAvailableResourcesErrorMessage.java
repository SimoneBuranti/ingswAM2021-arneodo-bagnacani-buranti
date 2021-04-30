package it.polimi.ingsw.server.network.messages;

public class NotAvailableResourcesErrorMessage extends Message {
    private final MessageType messageType = MessageType.NOTAVAILABLERESOURCESERROR;


    @Override
    public MessageType getMessageType() {
        return messageType;
    }

}
