package it.polimi.ingsw.client.ligtModelNotification;

import it.polimi.ingsw.server.model.Resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Notification of the reserve values
 */
public class ReserveNotification extends Notification{
    /**
     * The type of notification
     */
    private final NotificationType notificationType = NotificationType.RESERVENOTIFY;
    /**
     * This attributes represents the reserve
     */
    private Map<Resource,Integer> map;

    public ReserveNotification(Map<Resource,Integer> map){
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
