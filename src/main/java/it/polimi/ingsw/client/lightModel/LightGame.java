package it.polimi.ingsw.client.lightModel;

import it.polimi.ingsw.client.view.ViewObservable;
import it.polimi.ingsw.client.ligtModelNotification.DeckListNotification;
import it.polimi.ingsw.client.ligtModelNotification.ExtraMarketNotification;
import it.polimi.ingsw.client.ligtModelNotification.MarketNotification;
import it.polimi.ingsw.client.ligtModelNotification.ReserveNotification;
import it.polimi.ingsw.client.lightModel.lightGameBoard.LightGameBoard;
import it.polimi.ingsw.client.lightModel.productionCards.*;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.marbles.Marble;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class LightGame extends ViewObservable {
    private boolean initLeader=false;
    private boolean initResource=false;
    private int position;

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


    protected ArrayList<LightDeckProductionCard> listOfDeck;

    protected String currentPlayer;

    protected LightGameBoard gameBoardOfPlayer;

    protected boolean actionToken;

    protected boolean[] productionTokens = {true,true,true,true,true,true};

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
    }

    public void configInit() throws IOException, InterruptedException {
    }

    public boolean isActionToken() {
        return actionToken;
    }

    public void setActionToken(boolean actionToken) {
        this.actionToken = actionToken;
    }

    public boolean isProductionToken(int n){
        return productionTokens[n];
    }

    public void setProductionToken(int n,boolean token){
        this.productionTokens[n] = token;
    }

    public void resetProductionTokens(){
        for (int i = 0;i<6;i++){
            setProductionToken(i,true);
        }
    }

    public ArrayList<Resource> getWhiteMarbleResourceTypes(){
        ArrayList<Resource> resourceTypes = new ArrayList<>();
        ArrayList<LeaderCard> leaderCards = getLeaderCardActivated();
        for(LeaderCard lc : leaderCards){
            resourceTypes.add(lc.getResourceEffect());
        }
        return resourceTypes;
    }

    public ArrayList<Integer> getAvailableProductionCards(){
        return gameBoardOfPlayer.getAvailableProductionCards();
    }

    public void setMarket(ArrayList<Marble> list) throws IOException, InterruptedException {
        market = new LightMarket(list);
        notifyObserver(new MarketNotification(market.getGrid()).serialize());
        notifyObserver(new ExtraMarketNotification(market.getExtra()).serialize());
    }

    public void setReserve(Map<Resource,Integer> map) throws IOException, InterruptedException {
        reserve.setLightReserve(map);
        notifyObserver(new ReserveNotification(reserve.getReserve()).serialize());
    }

    public void setDeckProductionCard(int deckNumber, ArrayList<Integer> list){
        for(LightDeckProductionCard deck : listOfDeck){
            if(deck.getNumberDeck() == deckNumber)
                deck.setDeckProductionCard(list);
        }
    }

    public void setPlayersInOrder(ArrayList<String> nicknames){}

    public void removeOneProductionCard(int deckNumber) throws IOException, InterruptedException {
        for(LightDeckProductionCard deck : listOfDeck){
            if(deck.getNumberDeck() == deckNumber)
                deck.removeOneCard();
        }
        ArrayList<ProductionCard> list=deckNotification();
        notifyObserver(new DeckListNotification(list).serialize());
    }

    public void pushRow(int chosenRow) throws IOException, InterruptedException {
        market.pushRow(chosenRow);
        notifyObserver(new MarketNotification(market.getGrid()).serialize());
        notifyObserver(new ExtraMarketNotification(market.getExtra()).serialize());
    }

    public void pushColumn(int chosenColumn) throws IOException, InterruptedException {
        market.pushColumn(chosenColumn);
        notifyObserver(new MarketNotification(market.getGrid()).serialize());
        notifyObserver(new ExtraMarketNotification(market.getExtra()).serialize());

    }

    public void useResourceReserve(ArrayList<Resource> list) throws IOException, InterruptedException {
        reserve.useResource(list);
        notifyObserver(new ReserveNotification(reserve.getReserve()).serialize());
    }

    public void useResourceReserve(Resource resource, int quantity) throws IOException, InterruptedException {
        reserve.useResource(resource, quantity);
        notifyObserver(new ReserveNotification(reserve.getReserve()).serialize());
    }

    public void addResourceReserve(ArrayList<Resource> list) throws IOException, InterruptedException {
        reserve.addResource(list);
        notifyObserver(new ReserveNotification(reserve.getReserve()).serialize());
    }

    public void addResourceReserve(Resource resource, int quantity) throws IOException, InterruptedException {
        reserve.addResource(resource, quantity);
        notifyObserver(new ReserveNotification(reserve.getReserve()).serialize());
    }

    public void addStorage(Map<Resource, Integer> map) throws IOException, InterruptedException {}

    public void addStorage(ArrayList<Resource> list) throws IOException, InterruptedException {}
    public void addStorage(Resource resource, int quantity) throws IOException, InterruptedException {}

    public void removeStorage(Map<Resource, Integer> map) throws IOException, InterruptedException {}

    public void removeStorage(Resource resource, int quantity) throws IOException, InterruptedException {}

    public void addStrongbox(Map<Resource, Integer> map) throws IOException, InterruptedException {}

    public void addStrongbox(ArrayList<Resource> list) throws IOException, InterruptedException {}

    public void addStrongbox(Resource resource, int quantity) throws IOException, InterruptedException {}

    public void removeStrongbox(Map<Resource, Integer> map) throws IOException, InterruptedException {}

    public void removeStrongbox(Resource resource, int quantity) throws IOException, InterruptedException {}

    public void buyProductionCard(int deckNumber, int chosenColumn) throws IOException, InterruptedException {

    }

    public void payResourcesProduction(ArrayList<Resource> list){

    }



    public void setLorenzoTheMagnificent(int faithIndicator){
    }

    public void setFaithPath(int faithIndicator, int currCall) throws IOException, InterruptedException {
    }

    public void setProductionCardGameBoard(int[][] productionCards) throws IOException, InterruptedException {

    }

    public void actionMarkerEffect(String actionMarkerType) throws IOException, InterruptedException {}

    public void setCurrentPlayer(String nickname){
        currentPlayer = nickname;
    }


    public void addLeaderCard(ArrayList<Integer> leaderCardKeys) throws IOException, InterruptedException {

    }
    public void addLeaderCardActivated(ArrayList<Integer> leaderCardKeys) throws IOException, InterruptedException {

    }

    public ArrayList<LeaderCard> getLeaderCards() {
        return null;
    }

    public void activateLeaderCard(int index) throws IOException, InterruptedException {

    }


    public void discardLeaderCard(int index) throws IOException, InterruptedException {

    }

    public void faithMove(int pos) throws IOException, InterruptedException {

    }

    public void setPapalCards(int currCall){

    }

    public int getPapalCard(int currCall){
        return 0;
    }

    public int[] getPapalCards(){
        return null;
    }

    public void moveBlackCrossOnce(){}

    public boolean isEachDeckFull(){
        for(LightDeckProductionCard deck : listOfDeck){
            if(deck.isEmpty())
                return false;
        }

        return true;
    }

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


    public boolean isInitLeader() {
        return initLeader;
    }

    public void setInitLeader(boolean initLeader) {
        this.initLeader = initLeader;
    }

    public ArrayList<LeaderCard> getLeaderCardActivated(){
        return gameBoardOfPlayer.getLeaderCardActivated();
    }

    public boolean isInitResource() {
        return initResource;
    }

    public void setInitResource(boolean initResource) {
        this.initResource = initResource;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public LightGameBoard getGameBoardOfPlayer(){

        return gameBoardOfPlayer;
    }

    public int getFaithIndicator() {
        return gameBoardOfPlayer.getIndicator();
    }

    public ProductionCard[][] getProductionCards() {
        return gameBoardOfPlayer.getProductionCards();
    }

    public Map<Resource, Integer> getStorage() {
        return gameBoardOfPlayer.getStorage();
    }

    public Map<Resource, Integer> getStrongbox() {
        return gameBoardOfPlayer.getStrongbox();
    }

    public Map<Resource, Integer> getReserve() {
        return reserve.getReserve();
    }

    public Marble[][] getMarketGrid() {
        return market.getGrid();
    }

    public Marble getMarketExtra() {
        return market.getExtra();
    }





    /*public int getDeckNumberFormColourAndLevel(char c, int level) {

        for (LightDeckProductionCard deck : listOfDeck) {
            if (level == deck.getLevel() && deck.getColour().equals(c)){
                return deck.getNumberDeck();
            }
        }
        return 0;
    }*/
}
