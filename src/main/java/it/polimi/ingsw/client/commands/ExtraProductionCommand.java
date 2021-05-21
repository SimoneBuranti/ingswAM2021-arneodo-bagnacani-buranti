package it.polimi.ingsw.client.commands;


import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.ExtraProductionOnMessage;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.util.ArrayList;
import java.util.Scanner;

public class ExtraProductionCommand extends Command {

    private ViewController viewController;

    public ExtraProductionCommand(ViewController viewController) {
        this.viewController = viewController;
    }

    public Message commandOn() throws InvalidCommandException {

        int cardNumber;
        Resource o;
        Scanner in = new Scanner(System.in);

        ArrayList<LeaderCard> activated = viewController.getGame().getLeaderCardActivated();

        if (activated.size() == 0)
            throw new InvalidCommandException();
        if (activated.size() == 1) {
            System.out.println("COIN: 'coin'        ROCK: 'rock'        SHIELD: 'shield'        SERVANT: 'servant'");
            System.out.println("Output resource type: ");
            while ((o = fromStringToResource(in.nextLine())) == null){
                System.out.println("Invalid resource type");
            }

            viewController.getGame().setProductionToken(4,false);

            return new ExtraProductionOnMessage(o);
        }

        System.out.println("COIN: 'coin'        ROCK: 'rock'        SHIELD: 'shield'        SERVANT: 'servant'");
        System.out.println("Output resource type: ");
        while ((o = fromStringToResource(in.nextLine())) == null){
            System.out.println("Invalid resource type");
        }

        viewController.getGame().setProductionToken(4,false);

        return new ExtraProductionOnMessage(o);





    }

    public static String defToString(){
        return "extraProductionOn";
    }

    public String toString(){
        return "extraProductionOn";
    }

}