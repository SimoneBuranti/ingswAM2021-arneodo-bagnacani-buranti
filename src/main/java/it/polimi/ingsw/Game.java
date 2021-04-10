package it.polimi.ingsw;

public class Game {

    private  Market market;
    private Reserve reserve;
    protected Player currentPlayer;
    protected DeckProductionCard deckProductionCardOneBlu ;
    protected DeckProductionCard deckProductionCardTwoBlu ;
    protected  DeckProductionCard deckProductionCardThreeBlu ;

    protected DeckProductionCard deckProductionCardOneGreen ;
    protected DeckProductionCard deckProductionCardTwoGreen;
    protected DeckProductionCard deckProductionCardThreeGreen ;

    protected DeckProductionCard deckProductionCardOneYellow ;
    protected DeckProductionCard deckProductionCardTwoYellow ;
    protected DeckProductionCard deckProductionCardThreeYellow;

    protected DeckProductionCard deckProductionCardOneViolet ;
    protected DeckProductionCard deckProductionCardTwoViolet ;
    protected DeckProductionCard deckProductionCardThreeViolet ;

    protected DeckLeaderCard deckLeaderCard;

    public Game(){
        market = new Market();
        reserve = new Reserve();

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

    public void buyProductionCard(DeckProductionCard deck, int chosenColumn) throws LevelException, NotEnoughResourcesException, EmptyException, FullColumnException, EndGameException {
        currentPlayer.buyProductionCard(deck,chosenColumn);
    }

    public void moveEveryoneExcept(Player player){
    }

    public void productionOn(int chosenColumn){
        try {
            currentPlayer.productionOn(chosenColumn);
        } catch (ImpossibleProductionException e) {
            exceptionHandler(e);
        } catch (EmptyColumnException e) {
            exceptionHandler(e);
        }
    }

// Exceptions Handlers:


    protected void exceptionHandler(EmptyColumnException e) {
        //...
    }

    protected void exceptionHandler(CallForCouncilException e) {
    }

    protected void exceptionHandler(LastSpaceReachedException e) {
    }

    protected void exceptionHandler(EndOfSolitaireGame e) {
    }

    protected void exceptionHandler(ImpossibleProductionException e) {
        //...
    }

    protected void exceptionHandler(WhiteMarbleException e){
        //...
    }



    /**
     * @param player
     * @param chosenRow
     * @throws CallForCouncilException thrown from player faithPath  if match finished
     */
    public void pushRowInMarket(Player player, int chosenRow) throws CallForCouncilException, LastSpaceReachedException {
        try {
            market.PushRow(chosenRow,player);
        } catch (WhiteMarbleException e) {
            exceptionHandler(e);
        }
    }


    /**
     * @param player
     * @param chosenColumn
     * @throws CallForCouncilException thrown from player faithPath  if match finished
     */
    public void pushColumnInMarket(Player player, int chosenColumn) throws CallForCouncilException, LastSpaceReachedException {
        try {
            market.PushColumn(chosenColumn,player);
        } catch (WhiteMarbleException e) {
            exceptionHandler(e);
        }
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



    public int deckSize(DeckProductionCard deck){
        return deck.size();
    }




    public Market getMarket() {
        return market;
    }



    public Reserve getReserve() {
        return reserve;
    }
}




