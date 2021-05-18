package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.Resource;

import java.io.IOException;

public class StorageExtraDoubleConfig extends Message {
    private final MessageType messageType = MessageType.CONFIGURATIONSTORAGEEXTRADOUBLE;
    private int quantityIn;

    private Resource resourceProduction;
    public StorageExtraDoubleConfig(int numExtraFirstAvailable, Resource resourceProduction) {
        this.quantityIn=numExtraFirstAvailable;

        this.resourceProduction=resourceProduction;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }


    public int getQuantityIn() {
        return quantityIn;
    }

    public Resource getResourceProduction() {
        return resourceProduction;
    }
}
