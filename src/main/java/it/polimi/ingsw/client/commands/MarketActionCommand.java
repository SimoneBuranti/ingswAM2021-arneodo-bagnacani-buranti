package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.*;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.PushColumnMessage;
import it.polimi.ingsw.messages.PushRowMessage;

public class MarketActionCommand extends Command {

    private char rc;
    private int n;
    private ViewController viewController;

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

    public Message commandOn(){
        /*if (rc=='c'){
            //viewController.sendMessage(new PushColumnMessage(n));
        } else{}
            //viewController.sendMessage(new PushRowMessage(n));
        */
        return null;
    }

    public static String defToString(){
        return "market r/c n";
    }

    public String toString(){
        return "market "+rc+" "+n;
    }

}
