package it.polimi.ingsw.client.ligtModelNotification;

import java.io.IOException;
/**
 * Notification of the change of position of the faith indicator
 */
public class FaithPathNotification extends Notification{
    /**
     * The type of notification
     */
    private final NotificationType notificationType = NotificationType.FAITHNOTIFY;
    /**
     * The new position of the faith indicator
     */
    private int i;
    /**
     * This attribute indicates if the indicator is the black cross
     */
    private boolean isLorenzo;

    public FaithPathNotification(int i){
        this.i = i;
        isLorenzo = false;
    }

    public FaithPathNotification(int i,boolean isLorenzo){
        this.i = i;
        this.isLorenzo = isLorenzo;
    }

    @Override
    public void accept(NotificatorVisitor v) throws IOException, InterruptedException {
        v.visit(this);}

    @Override
    public NotificationType getNotificationType() {
        return notificationType;
    }


    public int getI() {
        return i;
    }

    public boolean isLorenzo() {
        return isLorenzo;
    }
}
