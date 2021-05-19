package it.polimi.ingsw.client.ligtModelNotification;

import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.io.IOException;
import java.util.ArrayList;

public class LeaderListCardNotification extends Notification{

    private final NotificationType notificationType = NotificationType.LEADERLISTNOTIFY;
    private ArrayList<LeaderCard> listOfFirstCard;
    public LeaderListCardNotification(ArrayList<LeaderCard> listOfFirstCard){
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

    public ArrayList<LeaderCard> getListOfFirstCard() {
        return listOfFirstCard;
    }
}
