package it.polimi.ingsw.client.ligtModelNotification;

import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Notification of the first production card of each deck
 */
public class DeckListNotification extends Notification{
    /**
     * The type of notification
     */
    private final NotificationType notificationType = NotificationType.DECKLISTNOTIFY;
    /**
     * The list containing the first production card of each deck
     */
    private ArrayList<ProductionCard> listOfFirstCard;

    public DeckListNotification(ArrayList<ProductionCard> listOfFirstCard){
        this.listOfFirstCard=new ArrayList<>();
        this.listOfFirstCard=listOfFirstCard;
    }
    @Override
    public void accept(NotificatorVisitor v) throws IOException, InterruptedException {
        v.visit(this);}

    @Override
    public NotificationType getNotificationType() {
       return notificationType;
    }

    public ArrayList<ProductionCard> getListOfFirstCard() {
        return listOfFirstCard;
    }
}
