package it.polimi.ingsw;

/**
 * this class represents the game in solitary
 */
public class SolitaireGame extends Game{

    /**
     * this attribute represents the action marker deck of the game
     */
    DeckActionMarker deckActionMarker;
    /**
     * this attribute represents the opponent of the player Lorenzo the magnificent
     */
    LorenzoTheMagnificent lorenzoTheMagnificent;

    /**
     * the constructor calls the super class constructor and instantiates the attributes of the solitaire game
     */
    public SolitaireGame() {
        super();
        deckActionMarker = new DeckActionMarker();
        lorenzoTheMagnificent = new LorenzoTheMagnificent();
    }

    /**
     * this method takes the first action marker of the deck and applies its effect
     */
    public void revealAndActivateActionMarker(){
        deckActionMarker.pickUpFirstCard().actionMarkerEffect(this);
    }

    /**
     * this method has been implemented for testing and applies the effect of the action marker passed as a parameter
     * @param actionMarker
     */
    public void activateActionMarker(ActionMarker actionMarker){
        actionMarker.actionMarkerEffect(this);
    }


    /**
     * this method calls the Lorenzo the magnificent method to move the black cross,
     * if an exception is caught it calls the Lorenzo the magnificent method to increase the currCall counter
     */
    public void moveBlackCrossOnce(){
        try {
            lorenzoTheMagnificent.moveBlackCross();
        } catch (CallForCouncilException e) {
            System.out.println("Call for Council");
            try {
                lorenzoTheMagnificent.setCurrCall();
            } catch (EndOfSolitaireGame endOfSolitaireGame) {
                System.out.println("End of solitaire game, Lorenzo has reached the last space of Faith Path and wins");
            }
        }
    }

    /**
     * this method calls the Lorenzo the magnificent method to move the black cross twice,
     * if an exception is caught it calls the Lorenzo the magnificent method to increase the currCall counter
     */
    public void moveBlackCrossDouble(){
        try {
            lorenzoTheMagnificent.moveBlackCross();
        } catch (CallForCouncilException e) {
            System.out.println("Call for Council");
            try {
                lorenzoTheMagnificent.setCurrCall();
            } catch (EndOfSolitaireGame endOfSolitaireGame) {
                System.out.println("End of solitaire game, Lorenzo has reached the last space of Faith Path and wins");
            }
        }
        try {
            lorenzoTheMagnificent.moveBlackCross();
        } catch (CallForCouncilException e) {
            System.out.println("Call for Council");
            try {
                lorenzoTheMagnificent.setCurrCall();
            } catch (EndOfSolitaireGame endOfSolitaireGame) {
                System.out.println("End of solitaire game, Lorenzo has reached the last space of Faith Path and wins");
            }
        }
    }

    /**
     * this method calls the action marker deck method to mix action markers
     */
    public void mixDeckActionMarker(){
        deckActionMarker.mixDeck();
    }

    /**
     * this method is implemented for testing and returns the first action marker of the deck
     * @return ActionMarker : the first action marker of the deck
     */
    public ActionMarker showFirst(){
        return deckActionMarker.showFirst();
    }

    /**
     * this method is implemented for testing and returns the black cross current position on faithPath
     * @return int : the black cross current position on faithPath
     */
    public int getLorenzoFaithIndicator(){
        return lorenzoTheMagnificent.getFaithIndicator();
    }

}
