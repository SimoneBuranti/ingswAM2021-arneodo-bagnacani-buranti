package it.polimi.ingsw;

/**
 * this class implements the ActionMarker interface and
 * represents the action marker that moves the black cross forward one spaces and shuffles the action marker deck
 */
public class ActionMarkerForCrossOnce implements ActionMarker{
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
    public void actionMarkerEffect(SolitaireGame game) {
        game.moveBlackCrossOnce();
        game.mixDeckActionMarker();
    }
}
