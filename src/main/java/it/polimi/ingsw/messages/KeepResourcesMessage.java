package it.polimi.ingsw.messages;

import it.polimi.ingsw.server.model.Resource;

import java.util.List;

public class KeepResourcesMessage extends Message{
    private final MessageType messageType = MessageType.KEEPRESOURCES;

    private List<Resource> choosenResources;
@Override
    public MessageType getMessageType() {
        return messageType;
    }

    public List<Resource> getChoosenResources() {
        return choosenResources;
    }

    public void setChoosenResources(List<Resource> choosenResources) {
        this.choosenResources = choosenResources;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
