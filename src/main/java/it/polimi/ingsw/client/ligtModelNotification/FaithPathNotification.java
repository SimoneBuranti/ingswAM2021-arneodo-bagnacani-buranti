package it.polimi.ingsw.client.ligtModelNotification;

import java.io.IOException;

public class FaithPathNotification extends Notification{
    private final NotificationType notificationType = NotificationType.FAITHNOTIFY;

    private int i;
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
