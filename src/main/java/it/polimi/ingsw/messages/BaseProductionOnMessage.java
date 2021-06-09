package it.polimi.ingsw.messages;

import it.polimi.ingsw.server.model.Resource;

import java.io.IOException;

public class BaseProductionOnMessage extends Message{
    /**
     * message which contain the information of base production activate
     * cause production leader action
     */
    private final MessageType messageType=MessageType.BASEPRODUCTIONON;

    private Resource firstInputResource;

    private Resource secondInputResource;

    private Resource outputResource;

    public BaseProductionOnMessage(Resource i1, Resource i2, Resource o) {
        this.firstInputResource = i1;
        this.secondInputResource = i2;
        this.outputResource = o;
    }

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
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }
}
