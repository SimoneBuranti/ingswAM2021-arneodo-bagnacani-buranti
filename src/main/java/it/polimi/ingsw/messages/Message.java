package it.polimi.ingsw.messages;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public abstract class Message{
    static Gson gson = new Gson();
    private static JsonParser jsonParser = new JsonParser();


    public abstract void accept(MessageVisitor v);
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

        String msgTopicString = jsonObj.get("messageType").getAsString();
        if (msgTopicString == null) throw new IllegalArgumentException("Missing message topic");

        MessageType messageType = MessageType.valueOf(msgTopicString);

        switch (messageType) {

            /*case OK:
                return gson.fromJson(jsonObj, OkMessage.class);*/

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
                return gson.fromJson(jsonObj, BaseProductionOnMessage.class);

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
                return gson.fromJson(jsonObj, WhiteMarbleChoosenResourcesMessage.class);

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

            case BUYPRODUCTIONCARD:
                return gson.fromJson(jsonObj, BuyProductionCardMessage.class);

            case ENDOFTURN:
                return gson.fromJson(jsonObj, EndOfTurnMessage.class);

            case CHANGECURRENTPLAYER:
                return gson.fromJson(jsonObj, ChangeCurrentPlayerMessage.class);

            case LASTTURN:
                return gson.fromJson(jsonObj, LastTurnMessage.class);

            case ENDGAME:
                return gson.fromJson(jsonObj, EndGameMessage.class);

            case OPPONENTFAITHMOVE:
                return gson.fromJson(jsonObj, OpponentFaithMoveMessage.class);

            case OPPONENTBUYPRODCARD:
                return gson.fromJson(jsonObj, OpponentBuyProductionCardMessage.class);

            case OPPONENTDISCARDLC:
                return gson.fromJson(jsonObj, OpponentDiscardLeaderCardMessage.class);

            case OPPONENTACTIVATELC:
                return gson.fromJson(jsonObj, OpponentActivateLeaderCardMessage.class);

            case SETPAPALS:
                return gson.fromJson(jsonObj, SetPapalsMessage.class);

            case LORENZOSACTION:
                return gson.fromJson(jsonObj, LorenzoActionMessage.class);

            case RESERVEVALUE:
                return gson.fromJson(jsonObj, ReserveValueMessage.class);

            case PING:
                return gson.fromJson(jsonObj, PingMessage.class);

            case PONG:
                return gson.fromJson(jsonObj, PongMessage.class);

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


    /**
     */
    public abstract MessageType getMessageType();
}