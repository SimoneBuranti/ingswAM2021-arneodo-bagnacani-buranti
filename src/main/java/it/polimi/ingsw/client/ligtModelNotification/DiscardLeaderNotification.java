package it.polimi.ingsw.client.ligtModelNotification;

import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.io.IOException;
import java.util.ArrayList;

public class DiscardLeaderNotification extends Notification{
    private final NotificationType notificationType = NotificationType.DISCARDLEADER;

    private int index;

    public DiscardLeaderNotification(int index){
        this.index = index;
    }
    @Override
    public void accept(NotificatorVisitor v) throws IOException, InterruptedException {
        v.visit(this);}

    @Override
    public NotificationType getNotificationType() {
        return notificationType;
    }

    public int getIndex() {
        return index;
    }

}
