package it.polimi.ingsw.client.lightModel.lightActionMarkers;

import it.polimi.ingsw.client.lightModel.LightGameSolitaire;
import it.polimi.ingsw.server.model.colours.Blue;

import java.io.IOException;

/**
 * this class represents the action marker that discards two blue production cards from level one deck up to level three deck
 */
public class LightActionMarkerProductionBlue extends LightActionMarker {

    /**
     * This attributes represents the type of action marker
     */
    private String type="ActionMarkerProductionBlue";

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
    public LightActionMarkerProductionBlue(){

    }

    /**
     * This method calls the removeProductionCard SolitaireGame method by passing it a blue colour
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(LightGameSolitaire game) throws IOException, InterruptedException {
        game.removeProductionCard(new Blue());
    }
}
