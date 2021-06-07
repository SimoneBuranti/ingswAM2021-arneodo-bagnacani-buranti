package it.polimi.ingsw.client.lightModel.lightActionMarkers;

import it.polimi.ingsw.client.lightModel.LightGameSolitaire;

/**
 * this class represents the action marker that moves the black cross forward two spaces
 */
public class LightActionMarkerForCrossDouble extends LightActionMarker {

    /**
     * This attributes represents the type of action marker
     */
    private String type="ActionMarkerForCrossDouble";

    /**
     * the class constructor
     */
    public LightActionMarkerForCrossDouble() {
    }

    /**
     * @return type of action marker
     */
    @Override
    public String getType() {
        return type;
    }



    /**
     * This method calls a SolitaireGame method: moveBlackCrossDouble
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(LightGameSolitaire game) {
        game.moveBlackCrossDouble();
    }
}
