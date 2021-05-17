package it.polimi.ingsw.Client.lightModel;

import it.polimi.ingsw.Client.lightModel.lightGameBoard.LightGameBoard;
import it.polimi.ingsw.Client.lightModel.productionCards.*;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.server.model.Market;
import it.polimi.ingsw.server.model.Reserve;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarker;
import it.polimi.ingsw.server.model.leaderCards.DeckLeaderCard;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.marbles.Marble;
import it.polimi.ingsw.server.model.players.Player;
import it.polimi.ingsw.server.model.productionCards.*;

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

    public void setMarket(ArrayList<Marble> list) {
        market = new LightMarket(list);
    }

    public void setReserve(Map<Resource,Integer> map) {
        reserve.setLightReserve(map);
    }

    public void setDeckProductionCard(int deckNumber, ArrayList<Integer> list){
        for(LightDeckProductionCard deck : listOfDeck){
            if(deck.getNumberDeck() == deckNumber)
                deck.setDeckProductionCard(list);
        }
    }

    public void setPlayersInOrder(ArrayList<String> nicknames){}

    public void removeOneProductionCard(int deckNumber){
        for(LightDeckProductionCard deck : listOfDeck){
            if(deck.getNumberDeck() == deckNumber)
                deck.removeOneCard();
        }
    }

    public void pushRow(int chosenRow){
        market.pushRow(chosenRow);
    }

    public void pushColumn(int chosenColumn){
        market.pushColumn(chosenColumn);
    }

    public void useResourceReserve(ArrayList<Resource> list){
        reserve.useResource(list);
    }

    public void useResourceReserve(Resource resource, int quantity){
        reserve.useResource(resource, quantity);
    }

    public void addResourceReserve(ArrayList<Resource> list){
        reserve.addResource(list);
    }

    public void addResourceReserve(Resource resource, int quantity){
        reserve.addResource(resource, quantity);
    }

    public void addStorage(Map<Resource, Integer> map){}

    public void addStorage(ArrayList<Resource> list){}
    public void addStorage(Resource resource, int quantity){}

    public void removeStorage(Map<Resource, Integer> map){}

    public void removeStorage(Resource resource, int quantity){}

    public void addStrongbox(Map<Resource, Integer> map){}

    public void addStrongbox(ArrayList<Resource> list){}

    public void addStrongbox(Resource resource, int quantity){}

    public void removeStrongbox(Map<Resource, Integer> map){}

    public void removeStrongbox(Resource resource, int quantity){}

    public void buyProductionCard(int deckNumber, int chosenColumn){

    }

    public void payResourcesProduction(ArrayList<Resource> list){

    }



    public void setLorenzoTheMagnificent(int faithIndicator){
    }

    public void setFaithPath(int faithIndicator, int currCall){
    }

    public void setProductionCardGameBoard(int[][] productionCards){

    }

    public void actionMarkerEffect(String actionMarkerType){}

    public void setCurrentPlayer(String nickname){
        currentPlayer = nickname;
    }


    public void addLeaderCard(ArrayList<Integer> leaderCardKeys){

    }
    public void addLeaderCardActivated(ArrayList<Integer> leaderCardKeys){

    }


    public void activateLeaderCard(int index){

    }


    public void discardLeaderCard(int index){

    }

    public void faithMove(int pos){

    }

    public void setPapalCards(int currCall){

    }

    public void moveBlackCrossOnce(){}


}
