package it.polimi.ingsw.model;

/**
 * this class implements the ActionMarker interface and
 * represents the action marker that discards two blue production cards from level one deck up to level three deck
 */
public class ActionMarkerProductionBlue implements ActionMarker{
    /**
     * the class constructor
     */
    public ActionMarkerProductionBlue(){

    }

    /**
     * the implemented method of the interface that calls twice a first-level blue production card deck static method
     * and makes the catch of the EndOfSolitaireGame exception if all blue production cards are no longer available
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(GameSolitaire game) throws EmptyException, EndOfSolitaireGame {
        game.removeProductionCard(new Blue());
        game.removeProductionCard(new Blue());
    }
}
