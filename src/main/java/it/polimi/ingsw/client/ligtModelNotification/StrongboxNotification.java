package it.polimi.ingsw.client.ligtModelNotification;

import it.polimi.ingsw.server.model.Resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StrongboxNotification extends Notification{
    private final NotificationType notificationType = NotificationType.STRONGBOXNOTIFY;
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
