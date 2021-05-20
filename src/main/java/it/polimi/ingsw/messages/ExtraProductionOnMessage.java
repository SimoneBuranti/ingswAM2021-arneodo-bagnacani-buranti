package it.polimi.ingsw.messages;

import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.io.IOException;

public class ExtraProductionOnMessage extends Message {
    /**
     * type of message
     */
    private final MessageType messageType=MessageType.EXTRAPRODUCTIONON;

    private Resource resourceLeader;

    private Resource outputResource;

    public ExtraProductionOnMessage(Resource o) {
        this.outputResource = o;
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
