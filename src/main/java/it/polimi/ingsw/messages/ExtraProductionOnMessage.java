package it.polimi.ingsw.messages;

import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.io.IOException;

public class ExtraProductionOnMessage extends Message {
    /**
     * message which contain the information of extra produciton activate
     * cause production leader action
     */
    private final MessageType messageType=MessageType.EXTRAPRODUCTIONON;

    private Resource resourceLeader;

    private Resource outputResource;

    public ExtraProductionOnMessage(Resource o) {
        this.outputResource = o;
    }

    public ExtraProductionOnMessage(Resource o, Resource leader) {
        this.outputResource = o;
        this.resourceLeader = leader;
    }

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
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }


    public Resource getResourceLeader() {
        return resourceLeader;
    }

    public void setResourceLeader(Resource resourceLeader) {
        this.resourceLeader = resourceLeader;
    }
}
