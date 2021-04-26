package it.polimi.ingsw.server.network.messages;
import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.leaderCards.*;

import java.util.ArrayList;
import java.util.Map;

public class message {

    private MessageType messageType;

    private String nickname;

    private int nOfPlayers;

    private int missPlayer;

    private ArrayList<Resource> resources;

    private ArrayList<LeaderCard> initLeaderCards;

    private int[] choosenLeaderCards;

    private int productionCardNumber;

    private int choosenRow;

    private int choosenColumn;

    private Resource firstInputResource;

    private Resource secondInputResource;

    private Resource outputResource;

    private int howManyWhite;

    private int leaderCardAction;

    private int deckNumber;

    private Map playerScores;















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
