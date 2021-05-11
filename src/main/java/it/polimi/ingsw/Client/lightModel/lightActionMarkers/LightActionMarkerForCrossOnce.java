package it.polimi.ingsw.Client.lightModel.lightActionMarkers;

import it.polimi.ingsw.Client.lightModel.LightGame;
import it.polimi.ingsw.Client.lightModel.LightGameSolitaire;

/**
 * this class implements the ActionMarker interface and
 * represents the action marker that moves the black cross forward one spaces and shuffles the action marker deck
 */
public class LightActionMarkerForCrossOnce extends LightActionMarker {

    /**
     * type of object
     */
    private String type="ActionMarkerForCrossOnce";


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
     * the implemented method of the interface that calls two methods of solitaireGame:
     * moveBlackCrossOnce and mixDeckActionMarker
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(LightGameSolitaire game) {
        game.moveBlackCrossOnce();
    }
}
