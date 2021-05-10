package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

public class StorageExtraConfig extends Message {
    private final MessageType messageType = MessageType.CONFIGURATIONSTORAGEEXTRA;
    private int quantityIn;

    public StorageExtraConfig(int quantityIn){

        this.quantityIn=quantityIn;
    }
    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }


    public int getQuantityIn() {
        return quantityIn;
    }
}
