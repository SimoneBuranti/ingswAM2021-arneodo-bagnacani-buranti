package it.polimi.ingsw.Client.lightModel.lightActionMarkers;

import it.polimi.ingsw.Client.lightModel.LightGame;
import it.polimi.ingsw.Client.lightModel.LightGameSolitaire;
import it.polimi.ingsw.server.model.GameSolitaire;
import it.polimi.ingsw.server.model.colours.Green;
import it.polimi.ingsw.server.model.exceptions.EmptyException;
import it.polimi.ingsw.server.model.exceptions.EndOfSolitaireGame;

/**
 * this class implements the ActionMarker interface and
 * represents the action marker that discards two green production cards from level one deck up to level three deck
 */
public class LightActionMarkerProductionGreen extends LightActionMarker {

    /**
     * type of object
     */
    private final String type="ActionMarkerProductionGreen";


    @Override
    public String getType() {
        return type;
    }

    /**
     * the class constructor
     */
    public LightActionMarkerProductionGreen() {
    }

    /**
     * the implemented method of the interface that calls twice the removeProductionCard game method passing it a green colour
     * and that spreads the two exceptions EmptyException and EndOfSolitaireGame
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(LightGameSolitaire game) {
        game.removeProductionCard(new Green());
        game.removeProductionCard(new Green());
    }
}
