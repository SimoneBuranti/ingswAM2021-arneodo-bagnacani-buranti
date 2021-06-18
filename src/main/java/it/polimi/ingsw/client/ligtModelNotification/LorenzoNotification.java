package it.polimi.ingsw.client.ligtModelNotification;

import java.io.IOException;

/**
 * Notification of the change of position of the black cross
 */
public class LorenzoNotification extends Notification{

    /**
     * The type of notification
     */
    private final NotificationType notificationType = NotificationType.LORENZOMOVE;
    /**
     * The new position of the black cross
     */
    private int pos;

    public LorenzoNotification(int faithIndicator) {
        this.pos = faithIndicator;
    }


    @Override
    public void accept(NotificatorVisitor v) throws IOException, InterruptedException {
        v.visit(this);}

    @Override
    public NotificationType getNotificationType() {
        return notificationType;
    }


    public int getI() {
        return pos;
    }

}
