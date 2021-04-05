package it.polimi.ingsw;

/**
 * this class implements the ActionMarker interface and
 * represents the action marker that discards two yellow production cards from level one deck up to level three deck
 */
public class ActionMarkerProductionYellow implements ActionMarker{

    /**
     * the class constructor
     */
    public ActionMarkerProductionYellow() {
    }

    /**
     * the implemented method of the interface that calls twice a first-level yellow production card deck static method
     * and makes the catch of the EndOfSolitaireGame exception if all yellow production cards are no longer available
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(SolitaireGame game) {
        try {
            DeckProductionCardOneYellow.removeOneCard();
        } catch (EndOfSolitaireGame endOfSolitaireGame) {
            System.out.println("End of Solitaire Game, the yellow production cards are finished and Lorenzo wins");
        }
        try {
            DeckProductionCardOneYellow.removeOneCard();
        } catch (EndOfSolitaireGame endOfSolitaireGame) {
            System.out.println("End of Solitaire Game, the yellow production cards are finished and Lorenzo wins");
        }
    }
}
