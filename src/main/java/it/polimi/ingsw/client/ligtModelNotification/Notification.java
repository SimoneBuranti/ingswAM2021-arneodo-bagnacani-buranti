package it.polimi.ingsw.client.ligtModelNotification;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import it.polimi.ingsw.server.model.RuntimeTypeAdapterFactory;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.gameBoard.*;
import it.polimi.ingsw.server.model.leaderCards.*;
import it.polimi.ingsw.server.model.requirements.*;

import java.io.IOException;

/**
 * This class contains methods common to all notifications
 */
public abstract class Notification {
    /**
     * This attribute is used to parse notifications
     */
    private static JsonParser jsonParser = new JsonParser();

    /**
     * Pattern visitor method
     */
    public abstract void accept( NotificatorVisitor v) throws IOException, InterruptedException;

    /**
     * This method deserializes notification from Json
     * @param jsonMsg the json notification
     * @return the abstract notification
     */
    public static Notification deserialize (String jsonMsg) {

        JsonObject jsonObj = jsonParser.parse(jsonMsg).getAsJsonObject();

        String notificationTopicString = jsonObj.get("notificationType").getAsString();
        if (notificationTopicString == null) throw new IllegalArgumentException("Missing message topic");

        NotificationType notificationType = NotificationType.valueOf(notificationTopicString);

        Gson gson = gsonAdapter();

        switch (notificationType) {

            case DECKLISTNOTIFY:
                return gson.fromJson(jsonObj, DeckListNotification.class);

            case EXTRAMARKETNOTIFY:
                return gson.fromJson(jsonObj, ExtraMarketNotification.class);

            case GAMEBOARDDECKLISTNOTIFY:
                return gson.fromJson(jsonObj, GameboardListNotification.class);

            case LEADERLISTNOTIFY:
                return gson.fromJson(jsonObj, LeaderListCardNotification.class);

            case MARKETNOTIFY:
                return gson.fromJson(jsonObj, MarketNotification.class);

            case RESERVENOTIFY:
                return gson.fromJson(jsonObj, ReserveNotification.class);

                case STORAGENOTIFY:
                return gson.fromJson(jsonObj, StorageNotification.class);

            case STRONGBOXNOTIFY:
                return gson.fromJson(jsonObj, StrongboxNotification.class);

            case FAITHNOTIFY:
                return gson.fromJson(jsonObj, FaithPathNotification.class);

            case INITLEADER:
                return gson.fromJson(jsonObj, InitLeaderNotification.class);

            case ACTIVATELEADER:
                return gson.fromJson(jsonObj, ActivateLeaderNotification.class);

            case DISCARDLEADER:
                return gson.fromJson(jsonObj, DiscardLeaderNotification.class);

            case PAPALCARDSCONFIG:
                return gson.fromJson(jsonObj, PapalCardsConfigNotification.class);

            case LORENZOMOVE:
                return gson.fromJson(jsonObj, LorenzoNotification.class);


                default:
                throw new IllegalArgumentException("Invalid topic " + notificationType);
        }
    }


    /**
     * This method serializes notification to json
     * @return the json notification
     */
    public String serialize () {
        Gson gson = gsonAdapter();
        return gson.toJson(this);
    }

    /**
     * This method returns a Gson object build with the adapters
     */
    public static Gson gsonAdapter(){
        RuntimeTypeAdapterFactory<Colour> adapterColour =
                RuntimeTypeAdapterFactory
                        .of(Colour.class)
                        .registerSubtype(Green.class)
                        .registerSubtype(Yellow.class)
                        .registerSubtype(Blue.class)
                        .registerSubtype(Violet.class);


        RuntimeTypeAdapterFactory<Requirements> adapterRequirements =
                RuntimeTypeAdapterFactory
                        .of(Requirements.class)
                        .registerSubtype(ResourceRequirement.class)
                        .registerSubtype(SecondLevelRequirement.class)
                        .registerSubtype(ThreeFlagsTwoColourRequirement.class)
                        .registerSubtype(TwoFlagsTwoColourRequirement.class);

        RuntimeTypeAdapterFactory<LeaderCard> adapterLeader =
                RuntimeTypeAdapterFactory
                        .of(LeaderCard.class)
                        .registerSubtype(LeaderCardMarble.class)
                        .registerSubtype(LeaderCardProduction.class)
                        .registerSubtype(LeaderCardReduction.class)
                        .registerSubtype(LeaderCardStorage.class);


        Gson gson=new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapterFactory(adapterColour)
                .registerTypeAdapterFactory(adapterRequirements)
                .registerTypeAdapterFactory(adapterLeader)
                .create();

        return gson;
    }


    /**
     * This method returns the notification type
     */
    public abstract NotificationType getNotificationType();
}
