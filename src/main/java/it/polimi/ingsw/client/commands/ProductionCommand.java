package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.DoubleProductionOnMessage;
import it.polimi.ingsw.messages.ExtraProductionOnMessage;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.ProductionOnMessage;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.leaderCards.LeaderCardProduction;

import java.util.ArrayList;
import java.util.Scanner;


public class ProductionCommand extends Command {

    private ViewController viewController;

    public ProductionCommand(ViewController viewController) {
        this.viewController = viewController;
    }

    public Message commandOn() throws InvalidCommandException, AlreadyActivatedProductionException {
        Scanner in = new Scanner(System.in);
        String input = null;
        int choosenColumn = 0;
        boolean exitFlag = false;
        ArrayList<Integer> available = viewController.getGame().getAvailableProductionCards();

        if (available.size() == 0)
            throw new InvalidCommandException();

        while(!exitFlag){
            System.out.println("Insert column between"+available);
            System.out.println(available);
            input = in.nextLine();
            choosenColumn = input.charAt(0) - '0';
            for (Integer i : available)
                if (choosenColumn == i.intValue())
                    exitFlag = true;
        }

        if (!viewController.getGame().isProductionToken(choosenColumn))
            throw new AlreadyActivatedProductionException();

        setFalseProductionBools(choosenColumn);

        return new ProductionOnMessage(choosenColumn);
    }

    public void setFalseProductionBools(int choosenLeaderCard){
        if (choosenLeaderCard == 1){
            viewController.getGame().setProductionToken(4,false);
        } else {
            viewController.getGame().setProductionToken(5,false);
        }
    }

    public boolean getExtraProductionToken(int choosenLeaderCard){
        if (choosenLeaderCard == 1){
            return viewController.getGame().isProductionToken(4);
        } else {
            return viewController.getGame().isProductionToken(5);
        }
    }

    public static String defToString(){
        return "productionOn";
    }

    public String toString(){
        return defToString();
    }

}