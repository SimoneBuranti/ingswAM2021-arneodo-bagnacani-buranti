package it.polimi.ingsw.client.lightModel;

import it.polimi.ingsw.client.ligtModelNotification.DeckListNotification;
import it.polimi.ingsw.client.ligtModelNotification.ExtraMarketNotification;
import it.polimi.ingsw.client.ligtModelNotification.MarketNotification;
import it.polimi.ingsw.client.ligtModelNotification.ReserveNotification;
import it.polimi.ingsw.client.lightModel.lightGameBoard.LightGameBoard;
import it.polimi.ingsw.client.lightModel.productionCards.*;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.marbles.Marble;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class LightGame extends ViewObservable {

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


    /**
     * this constructor instantiates all the game attributes
     */
    public LightGame(String nickname){

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


    public void activateLeaderCard(int index){

    }


    public void discardLeaderCard(int index) throws IOException, InterruptedException {

    }

    public void faithMove(int pos) throws IOException, InterruptedException {

    }

    public void setPapalCards(int currCall){

    }

    public void moveBlackCrossOnce(){}

    public ArrayList<ProductionCard> deckNotification(){
        ArrayList<ProductionCard> list = new ArrayList<>();
        list.add(deckProductionCardOneBlu.get(0));
        list.add(deckProductionCardTwoBlu.get(0));
        list.add(deckProductionCardThreeBlu.get(0));

        list.add(deckProductionCardOneGreen.get(0));
        list.add(deckProductionCardTwoGreen.get(0));
        list.add(deckProductionCardThreeGreen.get(0));

        list.add(deckProductionCardOneYellow.get(0));
        list.add(deckProductionCardTwoYellow.get(0));
        list.add(deckProductionCardThreeYellow.get(0));

        list.add(deckProductionCardOneViolet.get(0));
        list.add(deckProductionCardTwoViolet.get(0));
        list.add(deckProductionCardThreeViolet.get(0));
        return list;

    }


}