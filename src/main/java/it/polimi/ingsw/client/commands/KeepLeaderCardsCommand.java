package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.KeepLeaderCardsMessage;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.NumberPlayerMessage;

public class KeepLeaderCardsCommand extends Command{


    /**
     * Chosen leader card array.
     */
    private int[] chosenLeaderCards;

    /**
     * View controller reference.
     */
    private ViewController viewController;


    /**
     * Class constructor.
     * @param chosenLeaderCards
     * @param viewController
     */
    public KeepLeaderCardsCommand(int[] chosenLeaderCards, ViewController viewController) {
        this.viewController = viewController;
        this.chosenLeaderCards = chosenLeaderCards;
    }

    /**
     * Chosen leader card indexes getter.
     * @return
     */
    public int[] getChosenLeaderCards() {
        return chosenLeaderCards;
    }

    /**
     * This commandOn method throws an InitLeaderCardsException.
     * @return
     * @throws InitLeaderCardsException
     */
    @Override
    public Message commandOn() throws InitLeaderCardsException {
        throw new InitLeaderCardsException(new KeepLeaderCardsMessage(chosenLeaderCards[0]-1,chosenLeaderCards[1]-1));
    }
}
