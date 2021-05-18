package it.polimi.ingsw.ligtModelNotification;

import it.polimi.ingsw.server.model.marbles.Marble;

import java.io.IOException;

public class ExtraMarketNotification extends Notification{
    private final NotificationType notificationType = NotificationType.EXTRAMARKETNOTIFY;
    private Marble marble;

    public ExtraMarketNotification( Marble marble){
        this.marble = marble;
    }
    @Override
    public void accept(NotificatorVisitor v) throws IOException, InterruptedException {
        v.visit(this);}

    @Override
    public NotificationType getNotificationType() {
        return notificationType;
    }


    public Marble getMarble() {
        return marble;
    }
}
