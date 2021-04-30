package it.polimi.ingsw.server.network.messages;
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

            case OK:
                return gson.fromJson(jsonObj, OkMessage.class);

            case EXIT:
                return gson.fromJson(jsonObj, ExitMessage.class);

            case  COMPLETERUNNINGMATCHERROR:
                return gson.fromJson(jsonObj, CompleteRunningMatchErrorMessage.class);

            case MESSAGEFORNPLAYERS:
                return gson.fromJson(jsonObj, NPlayersMessage.class);

            case PLAYERNUMBER:
                return gson.fromJson(jsonObj, NumberPlayerMessage.class);

            case USERNAME:
                return gson.fromJson(jsonObj, UsernameMessage.class);

            case NICKNAMENOTFOUNDERROR:
                return gson.fromJson(jsonObj, NoNicknameMessage.class);

            case INITIALRESOURCES:
                return gson.fromJson(jsonObj, InitialResourcesMessage.class);

            case PICKEDLEADERCARDS:
                return gson.fromJson(jsonObj, PickedLeaderCardsMessage.class);

            case BASEPRODUCTIONON:
                return gson.fromJson(jsonObj, BaseProdcutionOnMessage.class);

            case EXTRAPRODUCTIONON:
                return gson.fromJson(jsonObj, ExtraProductionOnMessage.class);

            case KEEPLEADERCARDS:
                return gson.fromJson(jsonObj, KeepLeaderCardsMessage.class);

            case PRODUCTIONON:
                return gson.fromJson(jsonObj, ProductionOnMessage.class);

            case ALREADYEXISTINGNICKNAMEERROR:
                return gson.fromJson(jsonObj, AlreadyExistingNickNameErrorMessage.class);

            case DOUBLEEXTRAPRODUCTIONON:
                return gson.fromJson(jsonObj, DoubleProductionOnMessage.class);

            case ALREADYACTIVATEDERROR:
                return gson.fromJson(jsonObj, AlreadyActivatedErrorMessage.class);

            case WRONGCOLUMNERROR:
                return gson.fromJson(jsonObj, WrongColumnErrorMessage.class);

            case  NOTAVAILABLERESOURCESERROR:
                return gson.fromJson(jsonObj, NotAvailableResourcesErrorMessage.class);

            case ENDOFPRODUCTION:
                return gson.fromJson(jsonObj, EndOfProductionMessage.class);

            case PUSHROW:
                return gson.fromJson(jsonObj, PushRowMessage.class);

            case PUSHCOLUMN:
                return gson.fromJson(jsonObj, PushColumnMessage.class);

            case DOUBLEWHITEMARBLEEFFECT:
                return gson.fromJson(jsonObj, DoubleWhiteMarbleEffectMessage.class);

            case WHITEMARBLECHOOSENRESOURCES:
                return gson.fromJson(jsonObj, WhiteMarbleChoosenResources.class);

            case NOTENOUGHSPACEERROR:
                return gson.fromJson(jsonObj, NotEnoughSpaceErrorMessage.class);

            case KEEPRESOURCES:
                return gson.fromJson(jsonObj, KeepResourcesMessage.class);

            case DISCARDLEADERCARD:
                return gson.fromJson(jsonObj, DiscardLeaderCardMessage.class);

            case ACTIVATELEADERCARD:
                return gson.fromJson(jsonObj, ActivateLeaderCardMessage.class);

            case ALREADYUSEDLEADERCARDERROR:
                return gson.fromJson(jsonObj, AlreadyUsedLeaderCardErrorMessage.class);

            case REQUIREMENTSERROR:
                return gson.fromJson(jsonObj, RequirementsErrorMessage.class);































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
