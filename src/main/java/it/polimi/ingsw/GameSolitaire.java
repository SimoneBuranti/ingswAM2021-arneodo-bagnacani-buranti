package it.polimi.ingsw;

/**
 * this class represents the game in solitary
 */
public class GameSolitaire extends Game{

    /**
     * this attribute represents the action marker deck of the game
     */
    DeckActionMarker deckActionMarker;
    /**
     * this attribute represents the opponent of the player Lorenzo the magnificent
     */
    LorenzoTheMagnificent lorenzoTheMagnificent;
    /**
     * this attribute represents the player of the game
     */
    Player player;
    /**
     * the constructor calls the super class constructor and instantiates the attributes of the solitaire game
     */
    public GameSolitaire(String nickName) {
        super();
        deckActionMarker = new DeckActionMarker();
        lorenzoTheMagnificent = new LorenzoTheMagnificent();
        player = new Player(nickName, this);
        currentPlayer = player;
    }

    /**
     * this method takes the first action marker of the deck and applies its effect
     */
    public void revealAndActivateActionMarker() throws EmptyException, EndOfSolitaireGame {
        deckActionMarker.pickUpFirstCard().actionMarkerEffect(this);
    }

    /**
     * this method has been implemented for testing and applies the effect of the action marker passed as a parameter
     * @param actionMarker
     */
    public void activateActionMarker(ActionMarker actionMarker) throws EmptyException, EndOfSolitaireGame {
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
            exceptionHandler(e);
        }catch(EndOfSolitaireGame endOfSolitaireGame){
            exceptionHandler(endOfSolitaireGame);
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
            exceptionHandler(e);
        }catch(EndOfSolitaireGame endOfSolitaireGame){
            exceptionHandler(endOfSolitaireGame);
        }

        try {
            lorenzoTheMagnificent.moveBlackCross();
        } catch (CallForCouncilException e) {
            exceptionHandler(e);
        }catch(EndOfSolitaireGame endOfSolitaireGame){
            exceptionHandler(endOfSolitaireGame);
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


    public void removeProductionCard(Blue blue) throws EndOfSolitaireGame, EmptyException {
        try {
            deckProductionCardOneBlu.removeOneCard();
        } catch (EmptyException e) {
            try {
                deckProductionCardTwoBlu.removeOneCard();
            } catch (EmptyException emptyException) {
                deckProductionCardThreeBlu.removeOneCard();
            }
        }
    }

    public void removeProductionCard(Yellow yellow) throws EndOfSolitaireGame, EmptyException {
        try {
            deckProductionCardOneYellow.removeOneCard();
        } catch (EmptyException e) {
            try {
                deckProductionCardTwoYellow.removeOneCard();
            } catch (EmptyException emptyException) {
                deckProductionCardThreeYellow.removeOneCard();
            }
        }


    }

    public void removeProductionCard(Green green) throws EndOfSolitaireGame, EmptyException {
        try {
            deckProductionCardOneGreen.removeOneCard();
        } catch (EmptyException e) {
            try {
                deckProductionCardTwoGreen.removeOneCard();
            } catch (EmptyException emptyException) {
                deckProductionCardThreeGreen.removeOneCard();
            }
        }


    }

    public void removeProductionCard(Violet violet) throws EndOfSolitaireGame, EmptyException {
        try {
            deckProductionCardOneViolet.removeOneCard();
        } catch (EmptyException e) {
            try {
                deckProductionCardTwoViolet.removeOneCard();
            } catch (EmptyException emptyException) {
                deckProductionCardThreeViolet.removeOneCard();
            }
        }

    }


    public int deckSize(DeckProductionCard deck){
        return deck.size();
    }

    @Override
    public void moveEveryoneExcept(Player player){
        try {
            lorenzoTheMagnificent.moveBlackCross();
        } catch (CallForCouncilException e1) {
            exceptionHandler(e1);
        }catch (EndOfSolitaireGame e2) {
            exceptionHandler(e2);
        }
    }

    @Override
    protected void exceptionHandler(CallForCouncilException e) {
        player.setPapal();
        lorenzoTheMagnificent.setCurrCall();
    }

    @Override
    protected void exceptionHandler(LastSpaceReachedException e) {
        player.setPapal();
        //...fine partita, calcolo punteggio
    }

    @Override
    protected void exceptionHandler(EndOfSolitaireGame e) {
        System.out.println("Lorenzo the Magnificent WIN");
    }



}
