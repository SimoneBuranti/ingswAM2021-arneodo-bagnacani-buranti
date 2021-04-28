package it.polimi.ingsw.server.model.actionMarkers;

import it.polimi.ingsw.server.model.exceptions.EmptyException;
import it.polimi.ingsw.server.model.exceptions.EndOfSolitaireGame;
import it.polimi.ingsw.server.model.GameSolitaire;
import it.polimi.ingsw.server.model.colours.Green;

/**
 * this class implements the ActionMarker interface and
 * represents the action marker that discards two green production cards from level one deck up to level three deck
 */
public class ActionMarkerProductionGreen implements ActionMarker{

    /**
     * type of object
     */
    private String type="ActionMarkerProductionGreen";


    @Override
    public String getType() {
        return type;
    }

    /**
     * the class constructor
     */
    public ActionMarkerProductionGreen() {
    }

    /**
     * the implemented method of the interface that calls twice the removeProductionCard game method passing it a green colour
     * and that spreads the two exceptions EmptyException and EndOfSolitaireGame
     * @param game : the instantiated solitaire game a player is playing
     * @throws EmptyException : the exception which is thrown when there are no more cards left in the deck
     * @throws EndOfSolitaireGame : the exception which is thrown when all the green production cards decks are empty
     *                              and states that the solitaire game is over and the winner is Lorenzo The Magnificent
     */
    public void actionMarkerEffect(GameSolitaire game) throws EmptyException, EndOfSolitaireGame {
        game.removeProductionCard(new Green());
        game.removeProductionCard(new Green());
    }
}
