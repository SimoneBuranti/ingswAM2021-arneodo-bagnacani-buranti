package it.polimi.ingsw.client.ligtModelNotification;


import java.io.IOException;

/**
 * Notification of activation of a leader card
 */
public class ActivateLeaderNotification extends Notification{
    /**
     * The type of notification
     */
    private final NotificationType notificationType = NotificationType.ACTIVATELEADER;

    /**
     * The key of the activated leader card
     */
    private int key;
    /**
     * The index of the card in the activated leader card list
     */
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
