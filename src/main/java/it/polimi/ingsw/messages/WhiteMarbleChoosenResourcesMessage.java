package it.polimi.ingsw.messages;

import it.polimi.ingsw.server.model.Resource;

import java.util.ArrayList;
import java.util.List;

public class WhiteMarbleChoosenResourcesMessage extends Message {
    private final MessageType messageType = MessageType.WHITEMARBLECHOOSENRESOURCES;

    private ArrayList<Resource> choosenResources;


    public WhiteMarbleChoosenResourcesMessage(ArrayList<Resource> choosenResources) {
        this.choosenResources = choosenResources;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    public ArrayList<Resource> getChoosenResources() {
        return choosenResources;
    }

    public void setChoosenResources(ArrayList<Resource> choosenResources) {
        this.choosenResources = choosenResources;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
