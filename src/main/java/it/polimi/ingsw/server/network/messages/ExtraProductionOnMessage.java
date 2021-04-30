package it.polimi.ingsw.server.network.messages;

import it.polimi.ingsw.server.model.Resource;

public class ExtraProductionOnMessage extends Message {
    /**
     * type of message
     */
    private final MessageType messageType=MessageType.EXTRAPRODUCTIONON;

    private Resource outputResource;

    public Resource getOutputResource() {
        return outputResource;
    }

    public void setOutputResource(Resource outputResource) {
        this.outputResource = outputResource;
    }

    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }
}
