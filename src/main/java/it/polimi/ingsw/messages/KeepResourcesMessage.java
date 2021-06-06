package it.polimi.ingsw.messages;

import it.polimi.ingsw.server.model.Resource;

import java.io.IOException;
import java.util.ArrayList;

public class KeepResourcesMessage extends Message{
    /**
     * message  of chosen resource choose from client to server
     * after an error in model
     */
    private final MessageType messageType = MessageType.KEEPRESOURCES;

    private ArrayList<Resource> choosenResources;

    public KeepResourcesMessage(ArrayList<Resource> choosenResources) {
        this.choosenResources = choosenResources;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    public ArrayList<Resource> getChoosenResources() {
        return choosenResources;
    }


    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }
}
