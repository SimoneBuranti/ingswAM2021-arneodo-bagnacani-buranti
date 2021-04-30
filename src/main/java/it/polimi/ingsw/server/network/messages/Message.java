package it.polimi.ingsw.server.network.messages;
import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.leaderCards.*;

import java.util.ArrayList;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public abstract class Message{
    static Gson gson = new Gson();
    private static JsonParser jsonParser = new JsonParser();

    /**
     * Contains the method to deserialize messages from Json and to serialize
     * object in Json messages.
     *
     *
     * @param jsonMsg the json msg
     * @return the abstract message
     */
    public static Message deserialize (String jsonMsg) {
        JsonObject jsonObj = jsonParser.parse(jsonMsg).getAsJsonObject();

        String msgTopicString = jsonObj.get("topic").getAsString();
        if (msgTopicString == null) throw new IllegalArgumentException("Missing message topic");

        MessageType topic = MessageType.valueOf(msgTopicString);

        switch (topic) {
            case CHOOSE_NICKNAME:
                return gson.fromJson(jsonObj, ChooseNicknameMessage.class);
            case GAME_SETTINGS:
                return gson.fromJson(jsonObj, GameSettingsMessage.class);
            case ACTION_START:
                return gson.fromJson(jsonObj, ActionStartMessage.class);

            case ACTION:
                return gson.fromJson(jsonObj, ActionMessage.class);

            case ACTION_END:
                return gson.fromJson(jsonObj, ActionEndMessage.class);

            case END_TURN:
                return gson.fromJson(jsonObj, EndTurnMessage.class);

            case GAME_STATE:
                return gson.fromJson(jsonObj, GameStateMessage.class);
            case END_GAME:
                return gson.fromJson(jsonObj, EndGameMessage.class);

            case ERROR:
                return gson.fromJson(jsonObj, ErrorMessage.class);
            default:
                throw new IllegalArgumentException("Invalid topic " + msgTopicString);
        }
    }

    /**
     * Serialize string.
     *
     * @return the string
     */
    public String serialize () {
        return gson.toJson(this);
    }
}


















































   /* private MessageType messageType;

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


}*/
