package it.polimi.ingsw.Client.View.LigtModelNotification;

import it.polimi.ingsw.server.model.marbles.Marble;

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
