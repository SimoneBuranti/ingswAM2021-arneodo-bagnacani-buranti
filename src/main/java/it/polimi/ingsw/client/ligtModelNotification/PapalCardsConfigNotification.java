package it.polimi.ingsw.client.ligtModelNotification;

import java.io.IOException;

public class PapalCardsConfigNotification extends Notification{
    private final NotificationType notificationType = NotificationType.PAPALCARDSCONFIG;
    private int[] papalCards;

    public PapalCardsConfigNotification(int[] papalCards){
        this.papalCards = papalCards;
    }
    @Override
    public void accept(NotificatorVisitor v) throws IOException, InterruptedException {
        v.visit(this);}

    @Override
    public NotificationType getNotificationType() {
        return notificationType;
    }

    public int[] getPapalCards() {
        return papalCards;
    }
}
