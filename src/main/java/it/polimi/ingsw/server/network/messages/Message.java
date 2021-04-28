package it.polimi.ingsw.server.network.messages;
import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.leaderCards.*;

import java.util.ArrayList;
import java.util.Map;

public class Message {

    private MessageType messageType;

    private String nickname;

    private int nOfPlayers;

    private int missPlayer;

    private ArrayList<Resource> resources;

    private ArrayList<LeaderCard> initLeaderCards;

    private int[] chosenLeaderCards;

    private int productionCardNumber;

    private int chosenRow;

    private int chosenColumn;

    private Resource firstInputResource;

    private Resource secondInputResource;

    private Resource outputResource;

    private int howManyWhite;

    private int leaderCardAction;

    private int deckNumber;

    private Map playerScores;


    public Message(MessageType messageType, String nickname){
        this.messageType = messageType;
        this.nickname = nickname;
    }

    public Message(MessageType messageType){
        this.messageType = messageType;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getNickname() {
        return nickname;
    }

    public int getNOfPlayers() {
        return nOfPlayers;
    }

    public int getMissPlayer() {
        return missPlayer;
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public ArrayList<LeaderCard> getInitLeaderCards() {
        return initLeaderCards;
    }

    public int[] getChosenLeaderCards() {
        return chosenLeaderCards;
    }

    public int getProductionCardNumber() {
        return productionCardNumber;
    }

    public int getChosenRow() {
        return chosenRow;
    }

    public int getChosenColumn() {
        return chosenColumn;
    }

    public Resource getFirstInputResource() {
        return firstInputResource;
    }

    public Resource getSecondInputResource() {
        return secondInputResource;
    }

    public Resource getOutputResource() {
        return outputResource;
    }

    public int getHowManyWhite() {
        return howManyWhite;
    }

    public int getLeaderCardAction() {
        return leaderCardAction;
    }

    public int getDeckNumber() {
        return deckNumber;
    }

    public Map getPlayerScores() {
        return playerScores;
    }

    /*
    public abstract class Message implements Serializable {
        private static final long serialVersionUID = 6589184250663958343L;

        private final String nickname;
        private final MessageType messageType;

        Message(String nickname, MessageType messageType) {
            this.nickname = nickname;
            this.messageType = messageType;
        }

        public String getNickname() {
            return nickname;
        }

        public MessageType getMessageType() {
            return messageType;
        }

        @Override
        public String toString() {
            return "Message{" +
                    "nickname=" + nickname +
                    ", messageType=" + messageType +
                    '}';
        }
    }*/
}
