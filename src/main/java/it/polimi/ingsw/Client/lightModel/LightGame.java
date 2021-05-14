package it.polimi.ingsw.Client.lightModel;

import it.polimi.ingsw.Client.lightModel.productionCards.*;
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

public class LightGame{

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

    protected LightPlayer currentPlayer;
    /**
     * this constructor instantiates all the game attributes
     */
    public LightGame(){
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

    public void useResourceReserve(Map<Resource, Integer> map){
        reserve.useResource(map);
    }

    public void useResourceReserve(Resource resource, int quantity){
        reserve.useResource(resource, quantity);
    }

    public void addResourceReserve(Map<Resource, Integer> map){
        reserve.addResource(map);
    }

    public void addResourceReserve(Resource resource, int quantity){
        reserve.addResource(resource, quantity);
    }

    public void addStorage(String nickname, Map<Resource, Integer> map){}

    public void addStorage(String nickname, ArrayList<Resource> list){}
    public void addStorage(String nickname, Resource resource, int quantity){}

    public void removeStorage(String nickname, Map<Resource, Integer> map){}

    public void removeStorage(String nickname, Resource resource, int quantity){}

    public void addStrongbox(String nickname, Map<Resource, Integer> map){}

    public void addStrongbox(String nickname,ArrayList<Resource> list){}

    public void addStrongbox(String nickname, Resource resource, int quantity){}

    public void removeStrongbox(String nickname, Map<Resource, Integer> map){}

    public void removeStrongbox(String nickname, Resource resource, int quantity){}

    public void buyProductionCard(String nickname, int deckNumber, int chosenColumn){

    }

    public void payResourcesProduction(String nickname, Map<Resource, Integer> map){

    }



    public void setLorenzoTheMagnificent(int faithIndicator){
    }

    public void setFaithPath(String nickname, int faithIndicator, int currCall){
    }

    public void setProductionCardGameBoard(String nickname,int[][] productionCards){

    }

    public void actionMarkerEffect(String actionMarkerType){}

    public void setCurrentPlayer(){
    }


    public void addLeaderCard(String nickname, ArrayList<Integer> leaderCardKeys){

    }
    public void addLeaderCardActivated(String nickname, ArrayList<Integer> leaderCardKeys){

    }


    public void activateLeaderCard(String nickname, int index){

    }


    public void discardLeaderCard(String nickname, int index){

    }

    public void faithMove(String nickname){

    }

    public void setPapalCards(int currCall){

    }

    public void moveBlackCrossOnce(){}

    public void setPlayers(ArrayList<String> nickname){}

}
