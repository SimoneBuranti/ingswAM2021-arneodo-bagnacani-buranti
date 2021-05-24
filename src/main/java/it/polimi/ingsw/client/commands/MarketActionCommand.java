package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.*;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.*;

public class MarketActionCommand extends Command {

    private final char rc;
    private final int n;
    private final ViewController viewController;

    public MarketActionCommand(char rc, int i, ViewController viewController) {
        this.rc = rc;
        this.n = i;
        this.viewController = viewController;
    }

    public char getRc() {
        return rc;
    }

    public int getN() {
        return n;
    }

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
