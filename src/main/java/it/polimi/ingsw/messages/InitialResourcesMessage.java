package it.polimi.ingsw.messages;

import it.polimi.ingsw.server.model.Resource;

import java.io.IOException;
import java.util.ArrayList;

public class InitialResourcesMessage extends Message {

    /**
     * type of message
     */
    private final MessageType messageType=MessageType.INITIALRESOURCES;

    private ArrayList<Resource> resources;

    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }


    public ArrayList<Resource> getResources() {
        return resources;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }
}
