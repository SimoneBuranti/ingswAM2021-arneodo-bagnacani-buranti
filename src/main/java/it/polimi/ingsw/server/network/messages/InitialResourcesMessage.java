package it.polimi.ingsw.server.network.messages;

import it.polimi.ingsw.server.model.Resource;

import java.util.ArrayList;

public class InitialResourcesMessage extends Message {

    /**
     * type of message
     */
    private final MessageType messageType=MessageType.INITIALRESOURCES;


    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }

    private ArrayList<Resource> resources;

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }
}
