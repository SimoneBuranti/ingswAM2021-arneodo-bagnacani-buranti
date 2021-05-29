package it.polimi.ingsw.client.ligtModelNotification;

import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.io.IOException;
import java.util.ArrayList;

public class ActivateLeaderNotification extends Notification{
    private final NotificationType notificationType = NotificationType.ACTIVATELEADER;

    private int index;
    private int key;

    public ActivateLeaderNotification(int index, int key){
        this.index = index;
        this.key = key;
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

    public int getKey() {
        return key;
    }
}
