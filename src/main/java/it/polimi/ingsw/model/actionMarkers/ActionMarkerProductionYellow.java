package it.polimi.ingsw.model.actionMarkers;

import it.polimi.ingsw.model.exceptions.EmptyException;
import it.polimi.ingsw.model.exceptions.EndOfSolitaireGame;
import it.polimi.ingsw.model.GameSolitaire;
import it.polimi.ingsw.model.colours.Yellow;

/**
 * this class implements the ActionMarker interface and
 * represents the action marker that discards two yellow production cards from level one deck up to level three deck
 */
public class ActionMarkerProductionYellow implements ActionMarker{

    /**
     * the class constructor
     */
    public ActionMarkerProductionYellow() {
    }

    /**
     * the implemented method of the interface that calls twice the removeProductionCard game method passing it a yellow colour
     * and that spreads the two exceptions EmptyException and EndOfSolitaireGame
     * @param game : the instantiated solitaire game a player is playing
     * @throws EmptyException : the exception which is thrown when there are no more cards left in the deck
     * @throws EndOfSolitaireGame : the exception which is thrown when all the yellow production cards decks are empty
     *                              and states that the solitaire game is over and the winner is Lorenzo The Magnificent
     */
    public void actionMarkerEffect(GameSolitaire game) throws EmptyException, EndOfSolitaireGame {
        game.removeProductionCard(new Yellow());
        game.removeProductionCard(new Yellow());
    }
}
