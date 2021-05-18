package it.polimi.ingsw.Client.View.LigtModelNotification;

import it.polimi.ingsw.server.model.marbles.Marble;

import java.io.IOException;
import java.util.ArrayList;

public class MarketNotification extends Notification{
    private final NotificationType notificationType = NotificationType.MARKETNOTIFY;
    private Marble[][] list;

    public MarketNotification(Marble[][] list){
        this.list = list;
    }
    @Override
    public void accept(NotificatorVisitor v) throws IOException, InterruptedException {
        v.visit(this);}

    @Override
    public NotificationType getNotificationType() {
        return notificationType;
    }

    public  Marble[][] getList() {
        return list;
    }
}
