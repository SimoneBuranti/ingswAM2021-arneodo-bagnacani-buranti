package it.polimi.ingsw.client.ligtModelNotification;

import it.polimi.ingsw.server.model.marbles.Marble;

import java.io.IOException;
/**
 * Notification of the new extra marble of the market
 */
public class ExtraMarketNotification extends Notification{
    /**
     * The type of notification
     */
    private final NotificationType notificationType = NotificationType.EXTRAMARKETNOTIFY;
    /**
     * The extra marble of the market
     */
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
