package it.polimi.ingsw.client.view.ligtModelNotification;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReserveNotification extends Notification{
    private final NotificationType notificationType = NotificationType.RESERVENOTIFY;
    private Map map;
    public ReserveNotification(Map map){
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
