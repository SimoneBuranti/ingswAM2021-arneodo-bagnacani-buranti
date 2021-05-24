package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.messages.KeepLeaderCardsMessage;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.NumberPlayerMessage;

public class KeepLeaderCardsCommand extends Command{

    private int[] chosenLeaderCards;

    public KeepLeaderCardsCommand(int[] chosenLeaderCards) {
        this.chosenLeaderCards = chosenLeaderCards;
    }

    public int[] getChosenLeaderCards() {
        return chosenLeaderCards;
    }

    @Override
    public Message commandOn(){
        return new KeepLeaderCardsMessage(chosenLeaderCards[0],chosenLeaderCards[1]);
    }
}
