package it.polimi.ingsw.messages;

import it.polimi.ingsw.server.model.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KeepResourcesMessage extends Message{
    private final MessageType messageType = MessageType.KEEPRESOURCES;

    private ArrayList<Resource> choosenResources;

    public KeepResourcesMessage(ArrayList<Resource> choosenResources) {
        System.out.println("Sono dentro al messaggio : "+ choosenResources);
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
