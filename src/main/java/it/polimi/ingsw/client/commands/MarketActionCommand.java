package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.*;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.*;

public class MarketActionCommand extends Command {

    /**
     * Row / column attribute.
     */
    private final char rc;

    /**
     * Number of row/column attribute.
     */
    private final int n;
    private final ViewController viewController;


    /**
     * Class constructor.
     * @param rc
     * @param i
     * @param viewController
     */
    public MarketActionCommand(char rc, int i, ViewController viewController) {
        this.rc = rc;
        this.n = i;
        this.viewController = viewController;
    }

    /**
     * Row / column getter.
     * @return
     */
    public char getRc() {
        return rc;
    }

    /**
     * Number of row or column getter.
     * @return
     */
    public int getN() {
        return n;
    }

    /**
     * This commandOn method checks if an action is possible. If it is it sets the new false value of the corresponding
     * token and returns the push message. Otherwise it throws a SpentTokenException.
     * @return
     * @throws SpentTokenException
     */
    public Message commandOn() throws SpentTokenException {

        if(viewController.isActionToken()){
            viewController.setActionToken(false);

            if (rc=='c'){
                System.out.println("push column");
                return new PushColumnMessage(n);
            }
            if (rc=='r'){
                System.out.println("push row");
                return new PushRowMessage(n);
            }

        }
        throw new SpentTokenException();
    }

    public static String defToString(){
        return "market r/c n";
    }

    public String toString(){
        return "market "+rc+" "+n;
    }

}
