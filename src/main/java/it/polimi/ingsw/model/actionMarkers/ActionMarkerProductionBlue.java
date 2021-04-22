package it.polimi.ingsw.model.actionMarkers;

import it.polimi.ingsw.model.colours.Blue;
import it.polimi.ingsw.model.exceptions.EmptyException;
import it.polimi.ingsw.model.exceptions.EndOfSolitaireGame;
import it.polimi.ingsw.model.GameSolitaire;

/**
 * this class implements the ActionMarker interface and
 * represents the action marker that discards two blue production cards from level one deck up to level three deck
 */
public class ActionMarkerProductionBlue implements ActionMarker{
    /**
     * the class constructor
     */
    public ActionMarkerProductionBlue(){

    }

    /**
     * the implemented method of the interface that calls twice the removeProductionCard game method passing it a blue colour
     * and that spreads the two exceptions EmptyException and EndOfSolitaireGame
     * @param game : the instantiated solitaire game a player is playing
     * @throws EmptyException : the exception which is thrown when there are no more cards left in the deck
     * @throws EndOfSolitaireGame : the exception which is thrown when all the blue production cards decks are empty
     *                              and states that the solitaire game is over and the winner is Lorenzo The Magnificent
     */
    public void actionMarkerEffect(GameSolitaire game) throws EmptyException, EndOfSolitaireGame {
        game.removeProductionCard(new Blue());
        game.removeProductionCard(new Blue());
    }
}
