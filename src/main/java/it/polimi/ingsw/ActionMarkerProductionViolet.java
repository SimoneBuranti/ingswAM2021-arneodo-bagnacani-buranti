package it.polimi.ingsw;

/**
 * this class implements the ActionMarker interface and
 * represents the action marker that discards two violet production cards from level one deck up to level three deck
 */
public class ActionMarkerProductionViolet implements ActionMarker{

    /**
     * the class constructor
     */
    public ActionMarkerProductionViolet() {
    }


    /**
     * the implemented method of the interface that calls twice a first-level violet production card deck static method
     * and makes the catch of the EndOfSolitaireGame exception if all violet production cards are no longer available
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(GameSolitaire game) {
        try {
            DeckProductionCardOneViolet.removeOneCard();
        } catch (EndOfSolitaireGame endOfSolitaireGame) {
            System.out.println("End of Solitaire Game, the violet production cards are finished and Lorenzo wins");
        }
        try {
            DeckProductionCardOneViolet.removeOneCard();
        } catch (EndOfSolitaireGame endOfSolitaireGame) {
            System.out.println("End of Solitaire Game, the violet production cards are finished and Lorenzo wins");
        }
    }
}
