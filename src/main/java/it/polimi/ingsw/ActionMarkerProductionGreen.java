package it.polimi.ingsw;

/**
 * this class implements the ActionMarker interface and
 * represents the action marker that discards two green production cards from level one deck up to level three deck
 */
public class ActionMarkerProductionGreen implements ActionMarker{

    /**
     * the class constructor
     */
    public ActionMarkerProductionGreen() {
    }

    /**
     * the implemented method of the interface that calls twice a first-level green production card deck static method
     * and makes the catch of the EndOfSolitaireGame exception if all green production cards are no longer available
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(SolitaireGame game) {
        try {
            DeckProductionCardOneGreen.removeOneCard();
        } catch (EndOfSolitaireGame endOfSolitaireGame) {
            System.out.println("End of Solitaire Game, the green production cards are finished and Lorenzo wins");
        }
        try {
            DeckProductionCardOneGreen.removeOneCard();
        } catch (EndOfSolitaireGame endOfSolitaireGame) {
            System.out.println("End of Solitaire Game,the green production cards are finished and Lorenzo wins");
        }
    }
}
