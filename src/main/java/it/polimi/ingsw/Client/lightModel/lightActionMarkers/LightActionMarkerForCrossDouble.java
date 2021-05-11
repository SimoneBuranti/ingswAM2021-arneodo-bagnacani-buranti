package it.polimi.ingsw.Client.lightModel.lightActionMarkers;

import it.polimi.ingsw.Client.lightModel.LightGame;
import it.polimi.ingsw.Client.lightModel.LightGameSolitaire;
import it.polimi.ingsw.server.model.GameSolitaire;

/**
 * this class implements the ActionMarker interface and
 * represents the action marker that moves the black cross forward two spaces
 */
public class LightActionMarkerForCrossDouble extends LightActionMarker {


    private String type="ActionMarkerForCrossDouble";

    /**
     * the class constructor
     */
    public LightActionMarkerForCrossDouble() {
    }

    @Override
    public String getType() {
        return type;
    }



    /**
     * the implemented method of the interface that calls a SolitaireGame method: moveBlackCrossDouble
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(LightGameSolitaire game) {
        game.moveBlackCrossDouble();
    }
}
