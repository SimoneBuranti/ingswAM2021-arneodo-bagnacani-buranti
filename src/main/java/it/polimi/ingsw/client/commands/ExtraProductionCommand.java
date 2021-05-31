package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.DoubleProductionOnMessage;
import it.polimi.ingsw.messages.ExtraProductionOnMessage;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.leaderCards.LeaderCardProduction;

import java.util.ArrayList;
import java.util.Scanner;


public class ExtraProductionCommand extends Command {

    private ViewController viewController;

    public ExtraProductionCommand(ViewController viewController) {
        this.viewController = viewController;
    }

    public Message commandOn() throws InvalidCommandException, AlreadyActivatedProductionException, SpentTokenException {
        if(viewController.isActionToken()) {
            Scanner in = new Scanner(System.in);
            String input = null;
            int cont = 0;
            Resource o;

            ArrayList<LeaderCard> activated = viewController.getGame().getLeaderCardActivated();

            for (LeaderCard card : activated) {
                if (card instanceof LeaderCardProduction)
                    cont++;
            }

            if (cont == 0)
                throw new InvalidCommandException();
            if (cont == 1) {
                if (getExtraProductionToken(1))
                    throw new AlreadyActivatedProductionException();
                o = askForOutputResource();
                setFalseProductionBools(1);
                return new ExtraProductionOnMessage(o);

            } else {

                while (!input.equals("1") && !input.equals("2")) {
                    System.out.println("Insert the number of the activated production card you want to use (1/2): ");
                    input = in.nextLine();
                }
                setFalseProductionBools((input.charAt(0) - '0'));

                if (getExtraProductionToken((input.charAt(0) - '0')))
                    throw new AlreadyActivatedProductionException();

                if ((input.charAt(0) - '0') == 1) {
                    return new ExtraProductionOnMessage(askForOutputResource(),viewController.getGame().getLeaderCardActivated().get(0).getResourceEffect());
                }
                return new DoubleProductionOnMessage(askForOutputResource(),viewController.getGame().getLeaderCardActivated().get(1).getResourceEffect());
            }
        }else
            throw new SpentTokenException();
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
        return "extraProductionOn";
    }

    public String toString(){
        return defToString();
    }

}