package it.polimi.ingsw.client.lightModel.lightActionMarkers;

import it.polimi.ingsw.client.lightModel.LightGameSolitaire;
import it.polimi.ingsw.server.model.colours.Violet;

import java.io.IOException;

/**
 * this class represents the action marker that discards two violet production cards from level one deck up to level three deck
 */
public class LightActionMarkerProductionViolet extends LightActionMarker {


    /**
     * This attributes represents the type of action marker
     */
    private String type="ActionMarkerProductionViolet";

    /**
     * @return type of action marker
     */
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
     * This method calls the removeProductionCard SolitaireGame method by passing it a violet colour
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(LightGameSolitaire game) throws IOException, InterruptedException {
        game.removeProductionCard(new Violet());
    }
}
