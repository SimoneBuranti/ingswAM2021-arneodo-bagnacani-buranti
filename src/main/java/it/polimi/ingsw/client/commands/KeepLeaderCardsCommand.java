package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.KeepLeaderCardsMessage;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.NumberPlayerMessage;

public class KeepLeaderCardsCommand extends Command{

    private int[] chosenLeaderCards;
    private ViewController viewController;

    public KeepLeaderCardsCommand(int[] chosenLeaderCards, ViewController viewController) {
        this.viewController = viewController;
        this.chosenLeaderCards = chosenLeaderCards;
    }

    public int[] getChosenLeaderCards() {
        return chosenLeaderCards;
    }

    @Override
    public Message commandOn() throws InitLeaderCardsException {
        throw new InitLeaderCardsException(new KeepLeaderCardsMessage(chosenLeaderCards[0]-1,chosenLeaderCards[1]-1));
    }
}
