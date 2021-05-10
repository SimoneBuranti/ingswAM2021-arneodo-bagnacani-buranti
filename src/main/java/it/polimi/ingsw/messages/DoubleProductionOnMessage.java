package it.polimi.ingsw.messages;

import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

public class DoubleProductionOnMessage extends Message {
    /**
     * type of message
     */
    private final MessageType messageType=MessageType.DOUBLEEXTRAPRODUCTIONON;

    private Resource outputResource;

   private Resource resourceLeader;




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

    public Resource getResourceLeader() {
        return resourceLeader;
    }

    public void setResourceLeader(Resource resourceLeader) {
        this.resourceLeader = resourceLeader;
    }
}
