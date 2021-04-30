package it.polimi.ingsw.server.network.messages;

import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.util.ArrayList;

public class PickedLeaderCardsMessage extends Message{


    private ArrayList<LeaderCard> initLeaderCards;

    /**
     * type of message
     */
    private final MessageType messageType=MessageType.PICKEDLEADERCARDS;

    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }


    public ArrayList<LeaderCard> getInitLeaderCards() {
        return initLeaderCards;
    }

    public void setInitLeaderCards(ArrayList<LeaderCard> initLeaderCards) {
        this.initLeaderCards = initLeaderCards;
    }
}
