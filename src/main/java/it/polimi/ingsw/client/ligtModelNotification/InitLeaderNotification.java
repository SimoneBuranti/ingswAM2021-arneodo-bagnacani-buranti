package it.polimi.ingsw.client.ligtModelNotification;

import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Notification of the initial player's leader cards
 */
public class InitLeaderNotification extends Notification{
    /**
     * The type of notification
     */
    private final NotificationType notificationType = NotificationType.INITLEADER;
    /**
     * The list containing the initial player's leader cards
     */
    private ArrayList<LeaderCard> listOfFirstCard;
    /**
     * This attribute indicates whether the list contains cards already activated
     */
    private boolean activated;


    public InitLeaderNotification(ArrayList<LeaderCard> listOfFirstCard, boolean activated){
        this.listOfFirstCard=new ArrayList<>();
        this.listOfFirstCard=listOfFirstCard;
        this.activated = activated;
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

    public boolean isActivated() {
        return activated;
    }
}
