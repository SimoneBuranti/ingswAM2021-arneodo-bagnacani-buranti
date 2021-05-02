package it.polimi.ingsw.messages;

import it.polimi.ingsw.server.model.Resource;

public class BaseProductionOnMessage extends Message{
    /**
     * type of message
     */
    private final MessageType messageType=MessageType.BASEPRODUCTIONON;

    private Resource firstInputResource;

    private Resource secondInputResource;

    private Resource outputResource;

    /**
     */
    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    public Resource getFirstInputResource() {
        return firstInputResource;
    }

    public void setFirstInputResource(Resource firstInputResource) {
        this.firstInputResource = firstInputResource;
    }

    public Resource getSecondInputResource() {
        return secondInputResource;
    }

    public void setSecondInputResource(Resource secondInputResource) {
        this.secondInputResource = secondInputResource;
    }

    public Resource getOutputResource() {
        return outputResource;
    }

    public void setOutputResource(Resource outputResource) {
        this.outputResource = outputResource;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
