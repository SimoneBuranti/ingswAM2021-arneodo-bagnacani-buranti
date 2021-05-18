package it.polimi.ingsw.client.view.ligtModelNotification;

import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.io.IOException;
import java.util.ArrayList;

public class DeckListNotification extends Notification{

    private final NotificationType notificationType = NotificationType.DECKLISTNOTIFY;
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
