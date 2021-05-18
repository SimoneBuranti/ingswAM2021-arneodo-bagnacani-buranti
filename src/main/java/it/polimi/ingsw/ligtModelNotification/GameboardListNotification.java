package it.polimi.ingsw.ligtModelNotification;

import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.io.IOException;

public class GameboardListNotification extends Notification{
    private final NotificationType notificationType = NotificationType.GAMEBOARDDECKLISTNOTIFY;
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
