package it.polimi.ingsw.client.ligtModelNotification;

import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.io.IOException;
/**
 * Notification of the player's production cards
 */
public class GameboardListNotification extends Notification{
    /**
     * The type of notification
     */
    private final NotificationType notificationType = NotificationType.GAMEBOARDDECKLISTNOTIFY;
    /**
     * The actual player's production cards
     */
    private ProductionCard[][] listOfFirstCard;

    public GameboardListNotification(ProductionCard[][] listOfFirstCard){
        this.listOfFirstCard=listOfFirstCard;
    }

    @Override
    public void accept(NotificatorVisitor v) throws IOException, InterruptedException {
        v.visit(this);}

    @Override
    public NotificationType getNotificationType() {
        return notificationType;
    }


    public ProductionCard[][] getListOfFirstCard() {
        return listOfFirstCard;
    }
}
