package it.polimi.ingsw.client.ligtModelNotification;

import it.polimi.ingsw.server.model.marbles.Marble;

import java.io.IOException;
/**
 * Notification of the new grid of the market
 */
public class MarketNotification extends Notification{
    /**
     * The type of notification
     */
    private final NotificationType notificationType = NotificationType.MARKETNOTIFY;
    /**
     * The grid of the market
     */
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
