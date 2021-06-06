package it.polimi.ingsw.messages;

import it.polimi.ingsw.server.model.Resource;

import java.io.IOException;
import java.util.ArrayList;

public class InitialResourcesMessage extends Message {

    /**
     * message  of chosen resource choose from client to server
     * after the initial resource choice
     */
    private final MessageType messageType=MessageType.INITIALRESOURCES;

    private ArrayList<Resource> resources;

    public InitialResourcesMessage(ArrayList<Resource> resources) {
        this.resources=resources;
    }

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
