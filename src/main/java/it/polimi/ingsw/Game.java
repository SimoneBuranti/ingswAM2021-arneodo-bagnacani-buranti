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

    protected final DeckLeaderCard deckLeaderCard;

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

        deckLeaderCard= new DeckLeaderCard();

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



    /**
     * @param player
     * @param chosenRow
     * @throws CallForCouncilException thrown from player faithPath  if match finished
     */
    public void pushRowInMarket(Player player, int chosenRow) throws CallForCouncilException, LastSpaceReachedException {
        market.PushRow(chosenRow,player);
    }


    /**
     * @param player
     * @param chosenColumn
     * @throws CallForCouncilException thrown from player faithPath  if match finished
     */
    public void pushColumnInMarket(Player player, int chosenColumn) throws CallForCouncilException, LastSpaceReachedException {
        market.PushColumn(chosenColumn,player);
    }


    /**
     * @return deckLeaderCard.size()
     */
    public int leaderDeckSize(){
        return deckLeaderCard.size();
    }


    /**
     * method which returns cell in MarketGrid
     * used in test
     * @param i
     * @param j
     * @return market.getCellGrid(i,j)
     */
    public Marble getCellGridMarket(int i, int j){

        return market.getCellGrid(i,j);
    }



    /**
     * method which returns extraMarble in market
     * used in test
     * @return market.getExtra()
     */
    public Marble getExtraMarket(){

        return market.getExtra();}



    /**
     * method which returns cell in InitialMarbleListMarket
     * used in test
     * @param index
     * @return market.getCellGrid(index)
     */
    public Marble getInitialMarbleListMarket(int index){

        return market.getCellInitialMarbleList(index);}


}
