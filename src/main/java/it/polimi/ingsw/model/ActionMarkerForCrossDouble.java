package it.polimi.ingsw.model;

/**
 * this class implements the ActionMarker interface and
 * represents the action marker that moves the black cross forward two spaces
 */
public class ActionMarkerForCrossDouble implements ActionMarker{
    /**
     * the class constructor
     */
    public ActionMarkerForCrossDouble() {
    }

    /**
     * the implemented method of the interface that calls a SolitaireGame method: moveBlackCrossDouble
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(GameSolitaire game) {
        game.moveBlackCrossDouble();
    }
}
