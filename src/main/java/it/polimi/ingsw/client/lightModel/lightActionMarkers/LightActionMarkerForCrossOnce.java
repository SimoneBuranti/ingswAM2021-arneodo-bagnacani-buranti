package it.polimi.ingsw.client.lightModel.lightActionMarkers;

import it.polimi.ingsw.client.lightModel.LightGameSolitaire;

/**
 * this class represents the action marker that moves the black cross forward one spaces and shuffles the action marker deck
 */
public class LightActionMarkerForCrossOnce extends LightActionMarker {

    /**
     * This attributes represents the type of action marker
     */
    private String type="ActionMarkerForCrossOnce";

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
    public LightActionMarkerForCrossOnce() {
    }

    /**
     * This method calls a SolitaireGame method: moveBlackCrossOnce
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(LightGameSolitaire game) {
        game.moveBlackCrossOnce();
    }
}
