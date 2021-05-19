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

public abstract class Notification {
    static Gson gson = new Gson();
    private static JsonParser jsonParser = new JsonParser();


    public abstract void accept( NotificatorVisitor v) throws IOException, InterruptedException;
    /**
     * Contains the method to deserialize messages from Json and to serialize
     * object in Json messages.
     *
     *
     * @param jsonMsg the json msg
     * @return the abstract message
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

            case ACTIVATELEADERLISTNOTIFY:
                return gson.fromJson(jsonObj, ActivateNotification.class);

            case FAITHNOTIFY:
                return gson.fromJson(jsonObj, FaithPathNotification.class);

                default:
                throw new IllegalArgumentException("Invalid topic " + notificationType);
        }
    }

    /**
     * Serialize string.
     *
     * @return the string
     */
    public String serialize () {
        Gson gson = gsonAdapter();
        return gson.toJson(this);
    }

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
     */
    public abstract NotificationType getNotificationType();
}
