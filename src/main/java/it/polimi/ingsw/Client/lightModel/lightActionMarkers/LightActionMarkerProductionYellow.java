package it.polimi.ingsw.Client.lightModel.lightActionMarkers;

import it.polimi.ingsw.Client.lightModel.LightGame;
import it.polimi.ingsw.Client.lightModel.LightGameSolitaire;
import it.polimi.ingsw.server.model.GameSolitaire;
import it.polimi.ingsw.server.model.colours.Yellow;
import it.polimi.ingsw.server.model.exceptions.EmptyException;
import it.polimi.ingsw.server.model.exceptions.EndOfSolitaireGame;

/**
 * this class implements the ActionMarker interface and
 * represents the action marker that discards two yellow production cards from level one deck up to level three deck
 */
public class LightActionMarkerProductionYellow extends LightActionMarker {

    /**
     * type of object
     */
    private String type="ActionMarkerProductionYellow";


    @Override
    public String getType() {
        return type;
    }


    /**
     * the class constructor
     */
    public LightActionMarkerProductionYellow() {
    }

    /**
     * the implemented method of the interface that calls twice the removeProductionCard game method passing it a yellow colour
     * and that spreads the two exceptions EmptyException and EndOfSolitaireGame
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(LightGameSolitaire game){
        game.removeProductionCard(new Yellow());
        game.removeProductionCard(new Yellow());
    }
}
