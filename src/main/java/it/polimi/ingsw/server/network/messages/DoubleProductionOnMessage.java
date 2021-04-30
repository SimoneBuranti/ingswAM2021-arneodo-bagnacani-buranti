package it.polimi.ingsw.server.network.messages;

import it.polimi.ingsw.server.model.Resource;

public class DoubleProductionOnMessage extends Message {

    private Resource outputResource;

    public Resource getOutputResource() {
        return outputResource;
    }

    public void setOutputResource(Resource outputResource) {
        this.outputResource = outputResource;
    }

    /**
     * type of message
     */
    private final MessageType messageType=MessageType.DOUBLEEXTRAPRODUCTIONON;


    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }
}
