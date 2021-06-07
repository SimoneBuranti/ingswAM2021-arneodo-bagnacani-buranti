package it.polimi.ingsw.client.ligtModelNotification;

import java.io.IOException;

/**
 * Notification of initial values of the papal cards
 */
public class PapalCardsConfigNotification extends Notification{
    /**
     * The type of notification
     */
    private final NotificationType notificationType = NotificationType.PAPALCARDSCONFIG;
    /**
     * The array containing the initial values of the papal cards
     */
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
