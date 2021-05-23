package it.polimi.ingsw.client.lightModel.lightActionMarkers;

import it.polimi.ingsw.client.lightModel.LightGameSolitaire;
import it.polimi.ingsw.server.model.colours.Violet;

import java.io.IOException;

/**
 * this class implements the ActionMarker interface and
 * represents the action marker that discards two violet production cards from level one deck up to level three deck
 */
public class LightActionMarkerProductionViolet extends LightActionMarker {


    /**
     * type of object
     */
    private String type="ActionMarkerProductionViolet";


    @Override
    public String getType() {
        return type;
    }

    /**
     * the class constructor
     */
    public LightActionMarkerProductionViolet() {
    }


    /**
     * the implemented method of the interface that calls twice the removeProductionCard game method passing it a violet colour
     * and that spreads the two exceptions EmptyException and EndOfSolitaireGame
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(LightGameSolitaire game) throws IOException, InterruptedException {
        game.removeProductionCard(new Violet());
    }
}
