package it.polimi.ingsw.messages;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import it.polimi.ingsw.messages.observable.*;

import java.io.IOException;

public abstract class Message{
    static Gson gson = new Gson();
    private static JsonParser jsonParser = new JsonParser();


    public abstract void accept(MessageVisitor v) throws IOException, InterruptedException;
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


            case SETPAPALS:
                return gson.fromJson(jsonObj, SetPapalsMessage.class);



            case RESERVEVALUE:
                return gson.fromJson(jsonObj, ReserveValueMessage.class);

            case PING:
                return gson.fromJson(jsonObj, PingMessage.class);

            case PONG:
                return gson.fromJson(jsonObj, PongMessage.class);


            case MYVICTORY:
                return gson.fromJson(jsonObj, MyVictoryMessage.class);





            case ACTIVATIONLEADERCARDNOTIFICATION:
                return gson.fromJson(jsonObj, ActivationLeaderForNotCurrentMessage.class);

            case ACTIVATIONLEADERCARDRESPONSE:
                return gson.fromJson(jsonObj, ActivationLeaderForCurrentMessage.class);

            case CHANGEMARKETMESSAGECOLUMN:
                return gson.fromJson(jsonObj, ChangeMarketMessageColumn.class);

            case CHANGEMARKETMESSAGEROW:
                return gson.fromJson(jsonObj, ChangeMarketMessageRow.class);

            case CONFIGURATIONMARKET:
                return gson.fromJson(jsonObj, ConfigurationMarketMessage.class);

            case DECKPRODUCTIONCARDCONFIG:
                return gson.fromJson(jsonObj, DeckProductionCardConfigMessage.class);

            case DECKPRODUCTIONCARD:
                return gson.fromJson(jsonObj, DeckProductionCardMessage.class);

            case DISCARDLEADERCARDRESPONSE:
                return gson.fromJson(jsonObj, DiscardLeaderForCurrentMessage.class);

            case DISCARDLEADERCARDNOTIFICATION:
                return gson.fromJson(jsonObj, DiscardLeaderForNotCurrentMessage.class);

            case ENDGAMEWINNER:
                return gson.fromJson(jsonObj, EndGamePlayerWinnerMessage.class);

            case MYFAITHMOVECONFIG:
                return gson.fromJson(jsonObj, FaithConfigMessage.class);

            case MYFAITHMOVE:
                return gson.fromJson(jsonObj, FaithPathMessage.class);

            case OPPONENTFAITHPATHMOVE:
                return gson.fromJson(jsonObj, FaithPathOpponentMessage.class);

            case LEADERCONFIGMESSAGE:
                return gson.fromJson(jsonObj, LeadercardconfigMessage.class);

            case LORENZOCONFIG:
                return gson.fromJson(jsonObj, LorenzoTheMagnificentConfigMessage.class);



            case MAGNIFICENTWIN:
                return gson.fromJson(jsonObj, MagnificentWinMessage.class);

            case NICKNAME:
                return gson.fromJson(jsonObj, NicknameStartedMessage.class);

            case TABLEPRODUCTIONCARDCONFIG:
                return gson.fromJson(jsonObj, ProductionCardConfigMessage.class);

            case PRODUCTIONUPDATEFORCURRENT:
                return gson.fromJson(jsonObj, ProductionMessageForCurrentMessage.class);

            case PRODUCTIONUPDATE:
                return gson.fromJson(jsonObj, ProductionMessageForNotCurrentMessage.class);

            case PRODUCTIONUPDATEFORNOTCURRENT:
                return gson.fromJson(jsonObj, ResultOfProductionForNotCurrentMessage.class);

            case RESULTFROMARKET:
                return gson.fromJson(jsonObj, ResultFromMarketMessage.class);

            case RESULTFROMARKETNOTCURRENT:
                return gson.fromJson(jsonObj, ResultFromMarketNotCurrentMessage.class);

            case PRODUCTIONRESULT:
                return gson.fromJson(jsonObj, ResultOfProductionMessage.class);

            case CONFIGURATIONSTORAGE:
                return gson.fromJson(jsonObj, StorageConfigMessage.class);

            case CONFIGURATIONSTORAGEEXTRA:
                return gson.fromJson(jsonObj, StorageExtraConfig.class);

            case CONFIGURATIONSTORAGEEXTRADOUBLE:
                return gson.fromJson(jsonObj, StorageExtraDoubleConfig.class);

            case CONFIGURATIONSTRONGBOX:
                return gson.fromJson(jsonObj, StrongboxConfigMessage.class);


            case TAKECARDFORNOTCURRENT:
                return gson.fromJson(jsonObj, TakeCardForNotCurrentMessage.class);

            case TAKECARD:
                return gson.fromJson(jsonObj, TakeCardMessage.class);

            case OPPONENTUPDATEINITRESOURCE:
                return gson.fromJson(jsonObj, UpdateForNotCurrentResourceMessage.class);


            case UPDATEINITLEADERCARD:
                return gson.fromJson(jsonObj, UpdateInitLeaderMessage.class);

            case UPDATECHOSENLEADERCARD:
                return gson.fromJson(jsonObj, UpdateChosenLeaderMessage.class);

                case UPDATEINITRESOURCE:
                return gson.fromJson(jsonObj, UpdateInitResourceMessage.class);

            case USEACTIONMARKER:
                return gson.fromJson(jsonObj, UseActionMarkerMessage.class);

            case BOOTINGLOBBYERROR:
                return gson.fromJson(jsonObj, BootingLobbyErrorMessage.class);

            case LORENZOMAGNIFICFAITHMOVE:
                return gson.fromJson(jsonObj, LorenzoMoveMessage.class);

            case GAMETYPE:
                return gson.fromJson(jsonObj, GameTypeMessage.class);

            case RESTARTQUESTIONMESSAGE:
                return gson.fromJson(jsonObj, RestartQuestionMessage.class);

            case RESTARTANSWERMESSAGE:
                return gson.fromJson(jsonObj, RestartAnswerMessage.class);

            case NOTYOURTURNERROR:
                return gson.fromJson(jsonObj, NotYourTurnErrorMessage.class);

            case YOURTURN:
                return gson.fromJson(jsonObj, YourTurnMessage.class);

            case ASKINFO:
                return gson.fromJson(jsonObj, AskInformationMessage.class);

            case ALLOFPLAYER:
                return gson.fromJson(jsonObj, ShowAllOfPlayerMessage.class);

            case NOTPLAYERSERROR:
                return gson.fromJson(jsonObj, NoPlayersErrorMessage.class);

            case POSITION:
                return gson.fromJson(jsonObj, PositionMessage.class);

            case INIT:
                return gson.fromJson(jsonObj, UpdateInitBooleanMessage.class);

            case CHANGETURN:
                return gson.fromJson(jsonObj, ChangeTurnMessage.class);

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