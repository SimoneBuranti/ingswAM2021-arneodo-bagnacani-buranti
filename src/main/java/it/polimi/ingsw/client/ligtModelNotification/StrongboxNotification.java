package it.polimi.ingsw.client.ligtModelNotification;

import it.polimi.ingsw.server.model.Resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * Notification of the player's strongbox values
 */
public class StrongboxNotification extends Notification{
    /**
     * The type of notification
     */
    private final NotificationType notificationType = NotificationType.STRONGBOXNOTIFY;
    /**
     * This attributes represents the player's strongbox
     */
    private Map<Resource,Integer> map;

    public StrongboxNotification(Map<Resource,Integer> map){
        this.map =new HashMap<>();
        this.map =map;
    }

    @Override
    public void accept(NotificatorVisitor v) throws IOException, InterruptedException {
        v.visit(this);}

    @Override
    public NotificationType getNotificationType() {
        return notificationType;
    }


    public Map<Resource,Integer> getMap() {
        return map;
    }
}
