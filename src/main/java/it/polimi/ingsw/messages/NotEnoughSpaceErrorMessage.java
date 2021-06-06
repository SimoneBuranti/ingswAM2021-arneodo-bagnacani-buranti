package it.polimi.ingsw.messages;

import it.polimi.ingsw.server.model.Resource;

import java.util.ArrayList;

public class NotEnoughSpaceErrorMessage extends Message {
    /**
     * message error of not enough space from server to client
     * due to market action
     */
    private final MessageType messageType = MessageType.NOTENOUGHSPACEERROR;

    private ArrayList<Resource> resources;

    public NotEnoughSpaceErrorMessage(ArrayList<Resource> choosenResources) {
        this.resources = choosenResources;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    public ArrayList<Resource> getReources() {
        return resources;
    }


    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

    @Override
    public String toString(){
        return "you don't have enough storage space, choose which resources \n" +
                "to keep from the following ([none] for no resources) : \n" +
                "" + resources;
    }
}
