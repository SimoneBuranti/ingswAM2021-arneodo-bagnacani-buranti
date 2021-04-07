package it.polimi.ingsw;

public class Game {

    private Market market;
    private Reserve reserve;
    private static Player[] players;
    private Player currentPlayer;
    protected final DeckProductionCard deckProductionCardOneBlu ;
    protected final DeckProductionCard deckProductionCardTwoBlu ;
    protected final DeckProductionCard deckProductionCardThreeBlu ;

    protected final DeckProductionCard deckProductionCardOneGreen ;
    protected final DeckProductionCard deckProductionCardTwoGreen;
    protected final DeckProductionCard deckProductionCardThreeGreen ;

    protected final DeckProductionCard deckProductionCardOneYellow ;
    protected final DeckProductionCard deckProductionCardTwoYellow ;
    protected final DeckProductionCard deckProductionCardThreeYellow;

    protected final DeckProductionCard deckProductionCardOneViolet ;
    protected final DeckProductionCard deckProductionCardTwoViolet ;
    protected final DeckProductionCard deckProductionCardThreeViolet ;

    public Game(){
        market = new Market();
        reserve = new Reserve();
        //this.players = players;
        //currentPlayer = players[0];

        deckProductionCardOneBlu = new DeckProductionCardOneBlu();
        deckProductionCardTwoBlu = new DeckProductionCardTwoBlu();
        deckProductionCardThreeBlu = new DeckProductionCardThreeBlu();

        deckProductionCardOneGreen = new DeckProductionCardOneGreen();
        deckProductionCardTwoGreen = new DeckProductionCardTwoGreen();
        deckProductionCardThreeGreen = new DeckProductionCardThreeGreen();

        deckProductionCardOneYellow = new DeckProductionCardOneYellow();
        deckProductionCardTwoYellow = new DeckProductionCardTwoYellow();
        deckProductionCardThreeYellow = new DeckProductionCardThreeYellow();

        deckProductionCardOneViolet = new DeckProductionCardOneViolet();
        deckProductionCardTwoViolet = new DeckProductionCardTwoViolet();
        deckProductionCardThreeViolet = new DeckProductionCardThreeViolet();
    }

    public void buyProductionCard(DeckProductionCard deck, int choosenColumn) throws LevelException, NotEnoughResourcesException, EmptyException, FullColumnException, EndGameException {
        currentPlayer.buyProductionCard(deck,choosenColumn);
    }

    public void moveEveryoneExcept(Player player){
        for(Player p : players){
            if (p != player) {
                try {
                    p.faithMove();
                } catch (CallForCouncilException e1) {
                    exceptionHandler(e1);
                } catch (LastSpaceReachedException e2) {
                    exceptionHandler(e2);
                }
            }
        }
    }

    public void productionOn(int choosenColumn){
        try {
            currentPlayer.productionOn(choosenColumn);
        } catch (ImpossibleProductionException e) {
            exceptionHandler(e);
        } catch (EmptyColumnException e) {
            exceptionHandler(e);
        }
    }

// Exceptions Handlers:


    private void exceptionHandler(EmptyColumnException e) {
        //...
    }

    private void exceptionHandler(CallForCouncilException e) {
        for(Player p : players){
            p.setPapal();
        }
    }

    private void exceptionHandler(LastSpaceReachedException e) {
        for(Player p : players){
            p.setPapal();
        }

        //...
    }

    private void exceptionHandler(ImpossibleProductionException e) {
        //...
    }




}
