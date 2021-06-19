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

    /**
     * View controller reference
     */
    private ViewController viewController;

    public ExtraProductionCommand(ViewController viewController) {
        this.viewController = viewController;
    }

    /**
     * This commandOn method returns an ExtraProductionOnMessage if one only production leader card is activated. Otherwise
     * it asks for which one to activate and then returns the corresponding messaeg.
     * @return
     * @throws InvalidCommandException
     * @throws AlreadyActivatedProductionException
     * @throws SpentTokenException
     */
    public Message commandOn() throws InvalidCommandException, AlreadyActivatedProductionException, SpentTokenException {
        if(viewController.isActionToken()) {
            Scanner in = new Scanner(System.in);
            String input = "nothing";
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
                if (!getExtraProductionToken(1))
                    throw new AlreadyActivatedProductionException();
                setFalseProductionBools(1);
                return new ExtraProductionOnMessage(askForOutputResource(),viewController.getGame().getLeaderCardActivated().get(0).getResourceEffect());

            } else {

                while (!input.equals("1") && !input.equals("2")) {
                    System.out.println("Insert the number of the activated production card you want to use (1/2): ");
                    input = in.nextLine();
                }

                if (!getExtraProductionToken((input.charAt(0) - '0')))
                    throw new AlreadyActivatedProductionException();

                setFalseProductionBools((input.charAt(0) - '0'));


                if ((input.charAt(0) - '0') == 1) {
                    return new ExtraProductionOnMessage(askForOutputResource(),viewController.getGame().getLeaderCardActivated().get(0).getResourceEffect());
                }
                return new DoubleProductionOnMessage(askForOutputResource(),viewController.getGame().getLeaderCardActivated().get(1).getResourceEffect());
            }
        }else
            throw new SpentTokenException();
    }

    /**
     * This method sets the right boolean token to a false value.
     * @param choosenLeaderCard
     */
    public void setFalseProductionBools(int choosenLeaderCard){
        if (choosenLeaderCard == 1){
            viewController.getGame().setProductionToken(4,false);
        } else {
            viewController.getGame().setProductionToken(5,false);
        }
    }

    /**
     * ExtraProductionToke getter, this method distinguish which method to call.
     * @param choosenLeaderCard
     * @return
     */
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