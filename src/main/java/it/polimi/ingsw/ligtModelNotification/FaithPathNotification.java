package it.polimi.ingsw.ligtModelNotification;

import java.io.IOException;

public class FaithPathNotification extends Notification{
    private final NotificationType notificationType = NotificationType.FAITHNOTIFY;
    private int i;

    public FaithPathNotification(int i){
        this.i = i;
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
}
