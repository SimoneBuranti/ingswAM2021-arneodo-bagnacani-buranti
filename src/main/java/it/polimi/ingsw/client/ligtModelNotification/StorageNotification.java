package it.polimi.ingsw.client.ligtModelNotification;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StorageNotification extends Notification{
    private final NotificationType notificationType = NotificationType.STORAGENOTIFY;
    private Map map;
    public StorageNotification(Map map){
        this.map =new HashMap();
        this.map =map;
    }
    @Override
    public void accept(NotificatorVisitor v) throws IOException, InterruptedException {
        v.visit(this);}

    @Override
    public NotificationType getNotificationType() {
        return notificationType;
    }


    public Map getMap() {
        return map;
    }
}
