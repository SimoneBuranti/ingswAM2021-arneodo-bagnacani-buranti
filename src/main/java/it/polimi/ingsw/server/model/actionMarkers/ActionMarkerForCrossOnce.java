package it.polimi.ingsw.server.model.actionMarkers;

import it.polimi.ingsw.server.model.GameSolitaire;

import java.io.IOException;

/**
 * this class implements the ActionMarker interface and
 * represents the action marker that moves the black cross forward one spaces and shuffles the action marker deck
 */
public class ActionMarkerForCrossOnce extends ActionMarker {

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
    public ActionMarkerForCrossOnce() {
    }

    /**
     * the implemented method of the interface that calls two methods of solitaireGame:
     * moveBlackCrossOnce and mixDeckActionMarker
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(GameSolitaire game) throws IOException, InterruptedException {
        game.moveBlackCrossOnce();
        game.mixDeckActionMarker();
    }
}
