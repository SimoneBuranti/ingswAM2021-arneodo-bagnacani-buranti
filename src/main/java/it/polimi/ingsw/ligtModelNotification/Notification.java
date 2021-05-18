package it.polimi.ingsw.ligtModelNotification;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
        return gson.toJson(this);
    }


    /**
     */
    public abstract NotificationType getNotificationType();
}
