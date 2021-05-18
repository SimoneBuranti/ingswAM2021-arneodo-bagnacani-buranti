package it.polimi.ingsw.Client.View.LigtModelNotification;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StrongboxNotification extends Notification{
    private final NotificationType notificationType = NotificationType.STRONGBOXNOTIFY;
    private Map map;
    public StrongboxNotification(Map map){
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
