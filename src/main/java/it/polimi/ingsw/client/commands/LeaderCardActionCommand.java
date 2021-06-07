package it.polimi.ingsw.client.commands;


import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.ActivateLeaderCardMessage;
import it.polimi.ingsw.messages.DiscardLeaderCardMessage;
import it.polimi.ingsw.messages.Message;

public class LeaderCardActionCommand extends Command{

    /**
     * Activate / discard attribute.
     */
    private char ad;

    /**
     * Leader card number.
     */
    private int n;

    /**
     * View controller reference.
     */
    private ViewController viewController;

    /**
     * Class constructor.
     * @param ad
     * @param n
     * @param viewController
     */
    public LeaderCardActionCommand(char ad, int n,ViewController viewController) {
        this.ad = ad;
        this.n = n;
        this.viewController = viewController;
    }

    /**
     * Activate discard char getter.
     * @return
     */
    public char getAd() {
        return ad;
    }

    /**
     * N getter.
     * @return
     */
    public int getN() {
        return n;
    }

    /**
     * This commandOn method returns the correct ActivateLeaderCardMessage instance.
     * @return
     * @throws SpentTokenException
     */
    public Message commandOn() throws SpentTokenException {

        if (ad == 'a')
            return new ActivateLeaderCardMessage(n);

        return new DiscardLeaderCardMessage(n);
    }



    public static String defToString(){
        return "leader a/x n";
    }

    public String toString(){
        return "leader "+ad+" "+n;
    }
}