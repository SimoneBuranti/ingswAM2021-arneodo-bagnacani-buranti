package it.polimi.ingsw.client.ligtModelNotification;

import java.io.IOException;
/**
 * Notification of the discard of a leader card
 */
public class DiscardLeaderNotification extends Notification{
    /**
     * The type of notification
     */
    private final NotificationType notificationType = NotificationType.DISCARDLEADER;

    /**
     * The index of the discarded card in the leader card list
     */
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
