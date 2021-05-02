package it.polimi.ingsw.messages;

import it.polimi.ingsw.server.model.Resource;

public class DoubleProductionOnMessage extends Message {
    /**
     * type of message
     */
    private final MessageType messageType=MessageType.DOUBLEEXTRAPRODUCTIONON;

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

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
