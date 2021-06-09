package it.polimi.ingsw.client.lightModel;

import it.polimi.ingsw.client.ligtModelNotification.*;
import it.polimi.ingsw.client.view.ViewObservable;
import it.polimi.ingsw.client.lightModel.lightGameBoard.LightGameBoard;
import it.polimi.ingsw.client.lightModel.productionCards.*;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.marbles.Marble;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

 /**
 * This class represent the multiplayer game of the light model
 */
public class LightGame extends ViewObservable {

     /**
      * This attribute indicates if the initial leader cards have already been selected
      */
    protected boolean initLeader=false;

     /**
      * This attribute indicates if the initial resources have already been chosen
      */
    protected boolean initResource=false;

     /**
      * This attribute indicates the player's position in the rounds
      */
    protected int position;

    /**
     * this attribute represents the game market
     */
    protected LightMarket market;
    /**
     * this attribute represents the game reserve
     */
    protected LightReserve reserve;
    /**
     * this attribute represents the game first level blue production card deck
     */
    protected LightDeckProductionCard deckProductionCardOneBlu ;
    /**
     * this attribute represents the game second level blue production card deck
     */
    protected LightDeckProductionCard deckProductionCardTwoBlu ;
    /**
     * this attribute represents the game third level blue production card deck
     */
    protected  LightDeckProductionCard deckProductionCardThreeBlu ;

    /**
     * this attribute represents the game first level green production card deck
     */
    protected LightDeckProductionCard deckProductionCardOneGreen ;
    /**
     * this attribute represents the game second level green production card deck
     */
    protected LightDeckProductionCard deckProductionCardTwoGreen;
    /**
     * this attribute represents the game third level green production card deck
     */
    protected LightDeckProductionCard deckProductionCardThreeGreen ;

    /**
     * this attribute represents the game first level yellow production card deck
     */
    protected LightDeckProductionCard deckProductionCardOneYellow ;
    /**
     * this attribute represents the game second level yellow production card deck
     */
    protected LightDeckProductionCard deckProductionCardTwoYellow ;
    /**
     * this attribute represents the game third level yellow production card deck
     */
    protected LightDeckProductionCard deckProductionCardThreeYellow;

    /**
     * this attribute represents the game first level violet production card deck
     */
    protected LightDeckProductionCard deckProductionCardOneViolet ;
    /**
     * this attribute represents the game second level violet production card deck
     */
    protected LightDeckProductionCard deckProductionCardTwoViolet ;
    /**
     * this attribute represents the game third level violet production card deck
     */
    protected LightDeckProductionCard deckProductionCardThreeViolet ;

     /**
      * This attribute contains the reference to all decks in the game
      */
    protected ArrayList<LightDeckProductionCard> listOfDeck;

     /**
      * This attribute represents the game board of the player
      */
    protected LightGameBoard gameBoardOfPlayer;

     /**
      * This attribute indicates whether an action has already been taken
      */
    protected boolean actionToken;

     /**
      * This attribute indicates which production have been activated
      */
    protected boolean[] productionTokens = {true,true,true,true,true,true};

     /**
      * This attribute contains the number of the last production activated
      */
    protected int lastProduction = -1;

    /**
     * this constructor instantiates all the game attributes
     */
    public LightGame(String nickname){
        initLeader =false;

        listOfDeck = new ArrayList<>();

        deckProductionCardOneBlu = new LightDeckProductionCardOneBlu();
        listOfDeck.add(deckProductionCardOneBlu);
        deckProductionCardTwoBlu = new LightDeckProductionCardTwoBlu();
        listOfDeck.add(deckProductionCardTwoBlu);
        deckProductionCardThreeBlu = new LightDeckProductionCardThreeBlu();
        listOfDeck.add(deckProductionCardThreeBlu);

        deckProductionCardOneGreen = new LightDeckProductionCardOneGreen();
        listOfDeck.add(deckProductionCardOneGreen);
        deckProductionCardTwoGreen = new LightDeckProductionCardTwoGreen();
        listOfDeck.add(deckProductionCardTwoGreen);
        deckProductionCardThreeGreen = new LightDeckProductionCardThreeGreen();
        listOfDeck.add(deckProductionCardThreeGreen);

        deckProductionCardOneYellow = new LightDeckProductionCardOneYellow();
        listOfDeck.add(deckProductionCardOneYellow);
        deckProductionCardTwoYellow = new LightDeckProductionCardTwoYellow();
        listOfDeck.add(deckProductionCardTwoYellow);
        deckProductionCardThreeYellow = new LightDeckProductionCardThreeYellow();
        listOfDeck.add(deckProductionCardThreeYellow);

        deckProductionCardOneViolet = new LightDeckProductionCardOneViolet();
        listOfDeck.add(deckProductionCardOneViolet);
        deckProductionCardTwoViolet = new LightDeckProductionCardTwoViolet();
        listOfDeck.add(deckProductionCardTwoViolet);
        deckProductionCardThreeViolet = new LightDeckProductionCardThreeViolet();
        listOfDeck.add(deckProductionCardThreeViolet);

        reserve = new LightReserve();

        gameBoardOfPlayer = new LightGameBoard(nickname);

        actionToken = true;
    }

    /**
     * This method notifies the observer a list containing the first production card of each deck
     */
    public void configInit() throws IOException, InterruptedException {
        ArrayList<ProductionCard> list = new ArrayList<>();
        list=deckNotification();
        notifyObserver(new DeckListNotification(list).serialize());

    }

     /**
      * This method returns the value of the boolean actionToken
      */
    public boolean isActionToken() {
        return actionToken;
    }

     /**
      * This method sets the value of the boolean actionToken with the value passed as a parameter
      */
    public void setActionToken(boolean actionToken) {
        this.actionToken = actionToken;
    }

     /**
      * This method returns the value of the boolean in position n in the vector productionTokens
      */
    public boolean isProductionToken(int n){
        return productionTokens[n];
    }

     /**
      * This method sets the value of the boolean in position n in the vector productionTokens with the value passed as a parameter
      */
    public void setProductionToken(int n,boolean token){
        this.productionTokens[n] = token;
        if(!token){
            lastProduction = n;
        }
    }

     /**
      * This method resets the value of all vector productionTokens booleans to true
      */
    public void resetProductionTokens(){
        for (int i = 0;i<6;i++){
            setProductionToken(i,true);
        }
    }
     /**
      * @return true if at least one production has been activated, false otherwise
      */
     public boolean isProductionMode() {
         for(int i = 0; i < 6 ; i++){
             if(!productionTokens[i])
                 return true;
         }
         return false;
     }

     /**
      * This method resets the value of the last production activated in the productionTokens vector
      */
     public void resetLastProduction(){
         productionTokens[lastProduction] = true;
     }

     /**
      * This method returns the types of the resources with which to exchange the white marble
      */
    public ArrayList<Resource> getWhiteMarbleResourceTypes(){
        ArrayList<Resource> resourceTypes = new ArrayList<>();
        ArrayList<LeaderCard> leaderCards = getLeaderCardActivated();
        for(LeaderCard lc : leaderCards){
            resourceTypes.add(lc.getResourceEffect());
        }
        return resourceTypes;
    }

     /**
      * This method returns the game board columns where there is at least one production card
      */
    public ArrayList<Integer> getAvailableProductionCards(){
        return gameBoardOfPlayer.getAvailableProductionCards();
    }

     /**
      * This method sets the initial order of the market and notifies the observer
      * @param list : the initial orders of the marbles
      */
    public void setMarket(ArrayList<Marble> list) throws IOException, InterruptedException {
        market = new LightMarket(list);
        notifyObserver(new MarketNotification(market.getGrid()).serialize());
        notifyObserver(new ExtraMarketNotification(market.getExtra()).serialize());
    }

     /**
      * This method sets the initial values of the reserve and notifies the observer
      */
    public void setReserve(Map<Resource,Integer> map) throws IOException, InterruptedException {
        reserve.setLightReserve(map);
        notifyObserver(new ReserveNotification(reserve.getReserve()).serialize());
    }

     /**
      * This method sets the initial production cards of the deck passed as a parameter and notifies the observer
      */
    public void setDeckProductionCard(int deckNumber, ArrayList<Integer> list){
        for(LightDeckProductionCard deck : listOfDeck){
            if(deck.getNumberDeck() == deckNumber)
                deck.setDeckProductionCard(list);
        }
    }

     /**
      * This method removes one card from the deck passed as a parameter and notifies the observer
      */
    public void removeOneProductionCard(int deckNumber) throws IOException, InterruptedException {
        for(LightDeckProductionCard deck : listOfDeck){
            if(deck.getNumberDeck() == deckNumber)
                deck.removeOneCard();
        }
        ArrayList<ProductionCard> list=deckNotification();
        notifyObserver(new DeckListNotification(list).serialize());
    }

     /**
      * This method calls the pushRow method of the market and notifies the observer
      */
    public void pushRow(int chosenRow) throws IOException, InterruptedException {
        market.pushRow(chosenRow);
        notifyObserver(new MarketNotification(market.getGrid()).serialize());
        notifyObserver(new ExtraMarketNotification(market.getExtra()).serialize());
    }

     /**
      * This method calls the pushColumn method of the market and notifies the observer
      */
    public void pushColumn(int chosenColumn) throws IOException, InterruptedException {
        market.pushColumn(chosenColumn);
        notifyObserver(new MarketNotification(market.getGrid()).serialize());
        notifyObserver(new ExtraMarketNotification(market.getExtra()).serialize());

    }

     /**
      * This method removes the resources passed as a parameter from the reserve and notifies the observer
      * @param list : the collection of resources to remove
      */
    public void useResourceReserve(ArrayList<Resource> list) throws IOException, InterruptedException {
        reserve.useResource(list);
        notifyObserver(new ReserveNotification(reserve.getReserve()).serialize());
    }

     /**
      * This method removes the quantity passed as a parameter of the resource passed as a parameter from the reserve
      * and notifies the observer
      * @param resource : the resource type
      * @param quantity : the quantity to remove
      */
    public void useResourceReserve(Resource resource, int quantity) throws IOException, InterruptedException {
        reserve.useResource(resource, quantity);
        notifyObserver(new ReserveNotification(reserve.getReserve()).serialize());
    }

     /**
      * This method adds the resources passed as a parameter to the reserve and notifies the observer
      * @param list : the collection of resources to add
      */
    public void addResourceReserve(ArrayList<Resource> list) throws IOException, InterruptedException {
        reserve.addResource(list);
        notifyObserver(new ReserveNotification(reserve.getReserve()).serialize());
    }

    /**
     * This method adds the resources to the storage and notifies the observer
     * @param map : the map of resources to add
     */
    public void addStorage(Map<Resource, Integer> map) throws IOException, InterruptedException {
        gameBoardOfPlayer.addResourceStorage(map);
        notifyObserver(new StorageNotification(gameBoardOfPlayer.getStorage()).serialize());
    }

    /**
     * This method adds the resources to the storage and notifies the observer
     * @param list : the list of resources to add
     */
    public void addStorage(ArrayList<Resource> list) throws IOException, InterruptedException {
        gameBoardOfPlayer.addResourceStorage(list);
        notifyObserver(new StorageNotification(gameBoardOfPlayer.getStorage()).serialize());
    }


    /**
     * This method adds the quantity of the resource passed as a parameter to the storage and notifies the observer
     * @param resource : the type of resource
     * @param quantity : the quantity to add
     */
    public void addStorage(Resource resource, int quantity) throws IOException, InterruptedException {
        gameBoardOfPlayer.addResourceStorage(resource, quantity);
        notifyObserver(new StorageNotification(gameBoardOfPlayer.getStorage()).serialize());
    }

    /**
     * This method adds the resources to the strongbox and notifies the observer
     * @param map : the map of resources to add
     */
    public void addStrongbox(Map<Resource, Integer> map) throws IOException, InterruptedException {
        gameBoardOfPlayer.addResourceStrongbox(map);
        notifyObserver(new StrongboxNotification(gameBoardOfPlayer.getStrongbox()).serialize());
    }

    /**
     * This method adds the resources to the strongbox and notifies the observer
     * @param list : the list of resources to add
     */
    public void addStrongbox(ArrayList<Resource> list) throws IOException, InterruptedException {
        gameBoardOfPlayer.addResourceStrongbox(list);
        notifyObserver(new StrongboxNotification(gameBoardOfPlayer.getStrongbox()).serialize());
    }

    /**
     * This method buys athe first card of the deck passed as parameter putting it in the chosen column and paying the cost
     * and notifies the observer
     * @param deckNumber : the deck number from which buy the card
     * @param chosenColumn : the column in which to put the purchased card
     */
    public void buyProductionCard(int deckNumber, int chosenColumn) throws IOException, InterruptedException {
        for (LightDeckProductionCard deck : listOfDeck) {
            if (deck.getNumberDeck() == deckNumber)
                if(deck.getNumberDeck() == deckNumber) {
                    ProductionCard productionCard = deck.pickUpFirstCard();
                    gameBoardOfPlayer.addProductionCard(chosenColumn, productionCard);
                    ArrayList<Resource> list = gameBoardOfPlayer.payResourcesBuy(productionCard.getCost());
                    reserve.addResource(list);
                }
        }
        notifyObserver(new GameboardListNotification(gameBoardOfPlayer.getProductionCards()).serialize());
        notifyObserver(new StorageNotification(gameBoardOfPlayer.getStorage()).serialize());
        notifyObserver(new StrongboxNotification(gameBoardOfPlayer.getStrongbox()).serialize());
        notifyObserver((new ReserveNotification(reserve.getReserve())).serialize());
    }

    public void buyProductionCardOpponent(int deckNumber) throws IOException, InterruptedException {
        for(LightDeckProductionCard deck : listOfDeck){
            if(deck.getNumberDeck() == deckNumber)
                reserve.addResource(deck.pickUpFirstCard().getCost());
        }
        notifyObserver(new ReserveNotification(reserve.getReserve()).serialize());
    }

    /**
     * This method pays the cost of the activated production and notifies the observer
     * @param list : the cost to be paid
     */
    public void payResourcesProduction(ArrayList<Resource> list) throws IOException, InterruptedException {
        gameBoardOfPlayer.payResourcesProduction(list);
        notifyObserver(new StorageNotification(gameBoardOfPlayer.getStorage()).serialize());
        notifyObserver(new StrongboxNotification(gameBoardOfPlayer.getStrongbox()).serialize());
    }

    /**
     * This method sets the values of player faith path and notifies the observer the position of the faith indicator of the player
     * @param faithIndicator : the position of player faith indicator
     * @param currCall : the current currCall value
     */
    public void setFaithPath(int faithIndicator, int currCall) throws IOException, InterruptedException {
        gameBoardOfPlayer.setFaithPath(faithIndicator, currCall);
        notifyObserver(new FaithPathNotification(faithIndicator).serialize());
    }

    /**
     * This method sets the initial production cards of the player's game board and notifies the observer
     */
    public void setProductionCardGameBoard(int[][] productionCards) throws IOException, InterruptedException {
        gameBoardOfPlayer.setProductionCards(productionCards);
        notifyObserver(new GameboardListNotification(gameBoardOfPlayer.getProductionCards()).serialize());
    }

     /**
      * This method sets the chosen leader cards and notifies the observer
      * @param cardFirst : the position of the first leader card
      * @param cardSec : the position of the second leader card
      */
    public void setLeaderPersonal(int cardFirst, int cardSec) throws IOException, InterruptedException {
        gameBoardOfPlayer.setLeaderPersonal(cardFirst, cardSec);
        notifyObserver(new InitLeaderNotification(gameBoardOfPlayer.getLeaderCards(), false).serialize());
    }


    /**
     * This method initialises the initial leader cards of the player and notifies the observer
     * @param leaderCardKeys : the keys of the initial leader cards
     */
    public void addLeaderCard(ArrayList<Integer> leaderCardKeys) throws IOException, InterruptedException {
        gameBoardOfPlayer.addLeaderCard(leaderCardKeys);
        notifyObserver(new LeaderListCardNotification(gameBoardOfPlayer.getLeaderCards(),false).serialize());
        if(leaderCardKeys.size() < 3 && leaderCardKeys.size() > 0) {
            notifyObserver(new InitLeaderNotification(gameBoardOfPlayer.getLeaderCards(), false).serialize());
        }
    }

    /**
     * This method initialises the initial activated leader cards of the player and notifies the observer
     * @param leaderCardKeys : the keys of the initial activated leader cards
     */
    public void addLeaderCardActivated(ArrayList<Integer> leaderCardKeys) throws IOException, InterruptedException {
        gameBoardOfPlayer.addLeaderCardActivated(leaderCardKeys);
        notifyObserver(new LeaderListCardNotification(gameBoardOfPlayer.getLeaderCardsActivated(),true).serialize());
        if(leaderCardKeys.size() > 0) {
            notifyObserver(new InitLeaderNotification(gameBoardOfPlayer.getLeaderCardsActivated(), true).serialize());
        }
    }

    /**
     * This method returns the player's leader cards
     * @return ArrayList<LeaderCard> : the player's leader cards
     */
    public ArrayList<LeaderCard> getLeaderCards() {
        return gameBoardOfPlayer.getLeaderCards();
    }

    /**
     * This method activates the leader card in index position and notifies the observer
     * @param index : the position of the leader card to activate
     */
    public void activateLeaderCard(int index) throws IOException, InterruptedException {
        int key = gameBoardOfPlayer.getLeaderCard(index).getKey();
        gameBoardOfPlayer.activateLeaderCard(index);
        notifyObserver(new LeaderListCardNotification(gameBoardOfPlayer.getLeaderCards(),false).serialize());
        notifyObserver(new LeaderListCardNotification(gameBoardOfPlayer.getLeaderCardsActivated(),true).serialize());
        notifyObserver(new ActivateLeaderNotification(key, gameBoardOfPlayer.getLeaderCardsActivated().size()-1).serialize());
    }

    /**
     * This method discards the leader card in index position and notifies the observer
     * @param index : the position of the leader card to discard
     */
    public void discardLeaderCard(int index) throws IOException, InterruptedException {
        gameBoardOfPlayer.discardLeaderCard(index);
        notifyObserver(new LeaderListCardNotification(gameBoardOfPlayer.getLeaderCards(),false).serialize());
        notifyObserver(new DiscardLeaderNotification(index).serialize());

    }

    /**
     * This method moves the player's faith indicator to pos positions and notifies the observer
     * @param pos : the number of positions to move forward the indicator
     */
    public void faithMove(int pos) throws IOException, InterruptedException {
        gameBoardOfPlayer.moveFaithIndicator(pos);
        notifyObserver(new FaithPathNotification(gameBoardOfPlayer.getIndicator()).serialize());
    }

    /**
     * This method sets the value of the papal card in the current position with the value passed as a parameter
     * @param papalCard : the value to set
     */
    public void setPapalCard(int papalCard){
        gameBoardOfPlayer.setPapal(papalCard);
    }

    /**
     * This method sets the initial values of the player's papal cards and notifies the observer
     * @param papalCards : the initial values of the player's papal cards
     */
    public void setPapalCards(int[] papalCards){
        gameBoardOfPlayer.setPapalCards(papalCards);
        try {
            notifyObserver(new PapalCardsConfigNotification(gameBoardOfPlayer.getPapalCards()).serialize());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the value of the papal card in currCall position
     * @param currCall : the position of the papal card
     * @return int : the value of the papal card
     */
    public int getPapalCard(int currCall){
        return gameBoardOfPlayer.getPapalCard(currCall);
    }

    /**
     * This method returns the values of the player's papal cards
     * @return int[] : the values of the player's papal cards
     */
    public int[] getPapalCards(){
        return gameBoardOfPlayer.getPapalCards();
    }

     /**
      * This method returns an array containing the first production card of each deck or null if the deck is empty
      */
    public ArrayList<ProductionCard> deckNotification(){
        ArrayList<ProductionCard> list = new ArrayList<>();
        if(!deckProductionCardOneBlu.isEmpty()) {
            list.add(deckProductionCardOneBlu.get(0));
        }else
            list.add(null);
        if(!deckProductionCardTwoBlu.isEmpty()) {
            list.add(deckProductionCardTwoBlu.get(0));
        }else
            list.add(null);
        if(!deckProductionCardThreeBlu.isEmpty()) {
            list.add(deckProductionCardThreeBlu.get(0));
        }else
            list.add(null);

        if(!deckProductionCardOneGreen.isEmpty()) {
            list.add(deckProductionCardOneGreen.get(0));
        }else
            list.add(null);
        if(!deckProductionCardTwoGreen.isEmpty()) {
            list.add(deckProductionCardTwoGreen.get(0));
        }else
            list.add(null);
        if(!deckProductionCardThreeGreen.isEmpty()) {
            list.add(deckProductionCardThreeGreen.get(0));
        }else
            list.add(null);

        if(!deckProductionCardOneYellow.isEmpty()) {
            list.add(deckProductionCardOneYellow.get(0));
        }else
            list.add(null);
        if(!deckProductionCardTwoYellow.isEmpty()) {
            list.add(deckProductionCardTwoYellow.get(0));
        }else
            list.add(null);
        if(!deckProductionCardThreeYellow.isEmpty()) {
            list.add(deckProductionCardThreeYellow.get(0));
        }else
            list.add(null);


        if(!deckProductionCardOneViolet.isEmpty()) {
            list.add(deckProductionCardOneViolet.get(0));
        }else
            list.add(null);
        if(!deckProductionCardTwoViolet.isEmpty()) {
            list.add(deckProductionCardTwoViolet.get(0));
        }else
            list.add(null);
        if(!deckProductionCardThreeViolet.isEmpty()) {
            list.add(deckProductionCardThreeViolet.get(0));
        }else
            list.add(null);
        return list;

    }

     /**
      * This method returns the value of the boolean initLeader
      */
    public boolean isInitLeader() {
        return initLeader;
    }

     /**
      * This method sets the value of the boolean initLeader
      */
    public void setInitLeader(boolean initLeader) {
        this.initLeader = initLeader;
    }

     /**
      * This method returns the activated leader cards of the player
      */
    public ArrayList<LeaderCard> getLeaderCardActivated(){
        return gameBoardOfPlayer.getLeaderCardActivated();
    }

     /**
      * This method returns the value of the boolean initResource
      */
    public boolean isInitResource() {
        return initResource;
    }

     /**
      * This method sets the value of the boolean initResource
      */
    public void setInitResource(boolean initResource) {
        this.initResource = initResource;
    }

     /**
      * This method returns the player's position
      */
    public int getPosition() {
        return position;
    }

     /**
      * This method sets the player's position
      */
    public void setPosition(int position) {
        this.position = position;
    }

     /**
      * This method returns the player's game board
      */
    public LightGameBoard getGameBoardOfPlayer(){
        return gameBoardOfPlayer;
    }

     /**
      * This method returns the player's faith indicator position
      */
    public int getFaithIndicator() {
        return gameBoardOfPlayer.getIndicator();
    }

     /**
      * This method returns the player's production cards
      */
    public ProductionCard[][] getProductionCards() {
        return gameBoardOfPlayer.getProductionCards();
    }

     /**
      * This method returns the player's storage
      */
    public Map<Resource, Integer> getStorage() {
        return gameBoardOfPlayer.getStorage();
    }

     /**
      * This method returns the player's strongbox
      */
    public Map<Resource, Integer> getStrongbox() {
        return gameBoardOfPlayer.getStrongbox();
    }

     /**
      * This method returns the game's reserve
      */
    public Map<Resource, Integer> getReserve() {
        return reserve.getReserve();
    }

     /**
      * This method returns the game's market grid
      */
    public Marble[][] getMarketGrid() {
        return market.getGrid();
    }

     /**
      * This method returns the game's market extra
      */
    public Marble getMarketExtra() {
        return market.getExtra();
    }

     /**
      * This method return true if all decks have been set, false otherwise
      */
    public boolean isEachDeckConfig() {
        for(LightDeckProductionCard deck : listOfDeck){
            if(!deck.isConfig()) {
                return false;
            }
        }

        return true;
    }

     /**
      * These methods are implemented in the sub-class
      */
    public void setLorenzoTheMagnificent(int faithIndicator){}

    public void actionMarkerEffect(String actionMarkerType) throws IOException, InterruptedException {}

    public void moveBlackCrossOnce(){}

    public int getLorenzoPosition(){
        return 0;
    }

 }
