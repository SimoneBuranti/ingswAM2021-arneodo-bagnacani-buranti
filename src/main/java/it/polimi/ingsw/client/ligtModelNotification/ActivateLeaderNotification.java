package it.polimi.ingsw.client.ligtModelNotification;

import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.io.IOException;
import java.util.ArrayList;

public class ActivateLeaderNotification extends Notification{
    private final NotificationType notificationType = NotificationType.ACTIVATELEADER;

    private int key;
    private int newIndex;

    public ActivateLeaderNotification(int key, int newIndex){
        this.key = key;
        this.newIndex = newIndex;
    }
    @Override
    public void accept(NotificatorVisitor v) throws IOException, InterruptedException {
        v.visit(this);}

    @Override
    public NotificationType getNotificationType() {
        return notificationType;
    }

    public int getKey() {
        return key;
    }

    public int getNewIndex() {
        return newIndex;
    }
}
