package it.polimi.ingsw.server.network.messages;

import it.polimi.ingsw.server.model.Resource;

import java.util.List;

public class WhiteMarbleChoosenResources extends Message {
    private final MessageType messageType = MessageType.WHITEMARBLECHOOSENRESOURCES;

    private List<Resource> choosenResources;

    public MessageType getMessageType() {
        return messageType;
    }

    public List<Resource> getChoosenResources() {
        return choosenResources;
    }
}
