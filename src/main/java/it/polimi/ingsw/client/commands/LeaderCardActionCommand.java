package it.polimi.ingsw.client.commands;


import it.polimi.ingsw.client.view.ViewController;

public class LeaderCardActionCommand extends Command{

    private char ad;
    private int n;
    private ViewController viewController;

    public LeaderCardActionCommand(char ad, int n,ViewController viewController) {
        this.ad = ad;
        this.n = n;
        this.viewController = viewController;
    }

    public char getAd() {
        return ad;
    }

    public int getN() {
        return n;
    }

    public void commandOn(){

    }

    public static String defToString(){
        return "leader a/x n";
    }
    public String toString(){
        return "leader "+ad+" "+n;
    }
}