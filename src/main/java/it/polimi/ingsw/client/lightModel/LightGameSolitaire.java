package it.polimi.ingsw.client.lightModel;


import it.polimi.ingsw.client.ligtModelNotification.*;
import it.polimi.ingsw.client.lightModel.lightActionMarkers.LightActionMarkerDeck;
import it.polimi.ingsw.client.lightModel.productionCards.LightDeckProductionCard;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.Blue;
import it.polimi.ingsw.server.model.colours.Green;
import it.polimi.ingsw.server.model.colours.Violet;
import it.polimi.ingsw.server.model.colours.Yellow;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class LightGameSolitaire extends LightGame{

    private final LightLorenzoTheMagnificent lorenzoTheMagnificent;
    private final LightActionMarkerDeck actionMarkerDeck;

    public LightGameSolitaire(String nickname) throws IOException, InterruptedException {
        super(nickname);
        //configInit();
        lorenzoTheMagnificent = new LightLorenzoTheMagnificent();
        actionMarkerDeck = new LightActionMarkerDeck();
    }

    public void configInit() throws IOException, InterruptedException {
        ArrayList<ProductionCard> list = new ArrayList<>();
        list=deckNotification();
        notifyObserver(new DeckListNotification(list).serialize());
    }

    @Override
    public void setLorenzoTheMagnificent(int faithIndicator){
        lorenzoTheMagnificent.setLightLorenzoTheMagnificent(faithIndicator);
    }

    @Override
    public void setFaithPath(int faithIndicator, int currCall) throws IOException, InterruptedException {
        gameBoardOfPlayer.setFaithPath(faithIndicator, currCall);
        notifyObserver(new FaithPathNotification(faithIndicator).serialize());
    }

    @Override
    public void setProductionCardGameBoard(int[][] productionCards) throws IOException, InterruptedException {
        gameBoardOfPlayer.setProductionCards(productionCards);
        notifyObserver(new GameboardListNotification(gameBoardOfPlayer.getProductionCards()).serialize());
    }

    @Override
    public void actionMarkerEffect(String actionMarkerType) throws IOException, InterruptedException {
        actionMarkerDeck.actionMarkerEffect(actionMarkerType, this);
    }


    /**
     * this method calls the Lorenzo the magnificent method to move the black cross,
     * if CallForCouncilException or EndOfSolitaireGame is caught it calls the exceptionHandler method to handle it
     */
    @Override
    public void moveBlackCrossOnce(){
        lorenzoTheMagnificent.moveBlackCross();
    }

    /**
     * this method calls the Lorenzo the magnificent method to move the black cross twice,
     * if CallForCouncilException or EndOfSolitaireGame is caught it calls the exceptionHandler method to handle it
     */
    public void moveBlackCrossDouble(){
        lorenzoTheMagnificent.moveBlackCrossDouble();
    }

    /**
     * this method removes a blue production card due to action marker effect starting from the level one deck up
     * to the level three deck. It spreads the EndOfSolitaireGame exception if all three blue decks are empty.
     * @param blue : the colour of the decks
     */
    public void removeProductionCard(Blue blue) throws IOException, InterruptedException {
        if(!deckProductionCardOneBlu.isEmpty())
            deckProductionCardOneBlu.removeOneCard();
        else if(!deckProductionCardTwoBlu.isEmpty())
            deckProductionCardTwoBlu.removeOneCard();
        else
            deckProductionCardThreeBlu.removeOneCard();

        ArrayList<ProductionCard> list=deckNotification();
        notifyObserver(new DeckListNotification(list).serialize());
    }
    /**
     * this method removes a yellow production card due to action marker effect starting from the level one deck up
     * to the level three deck. It spreads the EndOfSolitaireGame exception if all three yellow decks are empty.
     * @param yellow : the colour of the decks
     */
    public void removeProductionCard(Yellow yellow) throws IOException, InterruptedException {
        if(!deckProductionCardOneYellow.isEmpty())
            deckProductionCardOneYellow.removeOneCard();
        else if(!deckProductionCardTwoYellow.isEmpty())
            deckProductionCardTwoYellow.removeOneCard();
        else
            deckProductionCardThreeYellow.removeOneCard();
        ArrayList<ProductionCard> list=deckNotification();
        notifyObserver(new DeckListNotification(list).serialize());
    }
    /**
     * this method removes a green production card due to action marker effect starting from the level one deck up
     * to the level three deck. It spreads the EndOfSolitaireGame exception if all three green decks are empty.
     * @param green : the colour of the decks
     */
    public void removeProductionCard(Green green) throws IOException, InterruptedException {
        if(!deckProductionCardOneGreen.isEmpty())
            deckProductionCardOneGreen.removeOneCard();
        else if(!deckProductionCardTwoGreen.isEmpty())
            deckProductionCardTwoGreen.removeOneCard();
        else
            deckProductionCardThreeGreen.removeOneCard();

        ArrayList<ProductionCard> list=deckNotification();
        notifyObserver(new DeckListNotification(list).serialize());
    }
    /**
     * this method removes a violet production card due to action marker effect starting from the level one deck up
     * to the level three deck. It spreads the EndOfSolitaireGame exception if all three violet decks are empty.
     * @param violet : the colour of the decks
     */
    public void removeProductionCard(Violet violet) throws IOException, InterruptedException {
        if(!deckProductionCardOneViolet.isEmpty())
            deckProductionCardOneViolet.removeOneCard();
        else if(!deckProductionCardTwoViolet.isEmpty())
            deckProductionCardTwoViolet.removeOneCard();
        else
            deckProductionCardThreeViolet.removeOneCard();
        ArrayList<ProductionCard> list=deckNotification();
        notifyObserver(new DeckListNotification(list).serialize());
    }

    @Override
    public void addLeaderCard(ArrayList<Integer> leaderCardKeys) throws IOException, InterruptedException {
        gameBoardOfPlayer.addLeaderCard(leaderCardKeys);
        notifyObserver(new LeaderListCardNotification(gameBoardOfPlayer.getLeaderCards(),false).serialize());
    }

    @Override
    public void addLeaderCardActivated(ArrayList<Integer> leaderCardKeys) throws IOException, InterruptedException {
        gameBoardOfPlayer.addLeaderCardActivated(leaderCardKeys);
        notifyObserver(new LeaderListCardNotification(gameBoardOfPlayer.getLeaderCardsActivated(),true).serialize());
    }

    @Override
    public ArrayList<LeaderCard> getLeaderCards() {
        return gameBoardOfPlayer.getLeaderCards();
    }

    public int getPapalCard(int currCall){
        return gameBoardOfPlayer.getPapalCard(currCall);
    }

    public int[] getPapalCards(){
        return gameBoardOfPlayer.getPapalCards();
    }

    @Override
    public void activateLeaderCard(int index) throws IOException, InterruptedException {
        gameBoardOfPlayer.activateLeaderCard(index);
        notifyObserver(new LeaderListCardNotification(gameBoardOfPlayer.getLeaderCards(),false).serialize());
        notifyObserver(new LeaderListCardNotification(gameBoardOfPlayer.getLeaderCardsActivated(),true).serialize());
    }

    @Override
    public void discardLeaderCard(int index) throws IOException, InterruptedException {
        gameBoardOfPlayer.discardLeaderCard(index);
        notifyObserver(new LeaderListCardNotification(gameBoardOfPlayer.getLeaderCards(),false).serialize());
    }

    @Override
    public void faithMove(int pos) throws IOException, InterruptedException {
        gameBoardOfPlayer.moveFaithIndicator(pos);
        notifyObserver(new FaithPathNotification(gameBoardOfPlayer.getIndicator()).serialize());
    }

    @Override
    public void buyProductionCard(int deckNumber, int chosenColumn) throws IOException, InterruptedException {
        for(LightDeckProductionCard deck : listOfDeck){
            if(deck.getNumberDeck() == deckNumber)
                gameBoardOfPlayer.addProductionCard(chosenColumn, deck.pickUpFirstCard());
        }
        ArrayList<ProductionCard> list=deckNotification();
        notifyObserver(new DeckListNotification(list).serialize());
        notifyObserver(new GameboardListNotification(gameBoardOfPlayer.getProductionCards()).serialize());
    }

    @Override
    public void payResourcesProduction(ArrayList<Resource> list){
        gameBoardOfPlayer.payResourcesProduction(list);
    }

    @Override
    public void setPapalCards(int currCall){
        gameBoardOfPlayer.setPapal(currCall);
    }

    @Override
    public void addStorage(Map<Resource, Integer> map) throws IOException, InterruptedException {
        gameBoardOfPlayer.addResourceStorage(map);
        notifyObserver(new StorageNotification(gameBoardOfPlayer.getStorage()).serialize());
    }

    @Override
    public void addStorage(Resource resource, int quantity) throws IOException, InterruptedException {
        gameBoardOfPlayer.addResourceStorage(resource, quantity);
        notifyObserver(new StorageNotification(gameBoardOfPlayer.getStorage()).serialize());
    }

    @Override
    public void addStorage( ArrayList<Resource> list) throws IOException, InterruptedException {
        gameBoardOfPlayer.addResourceStorage(list);
        notifyObserver(new StorageNotification(gameBoardOfPlayer.getStorage()).serialize());
    }

    @Override
    public void removeStorage(Map<Resource, Integer> map) throws IOException, InterruptedException {
        gameBoardOfPlayer.removeResourceStorage(map);
        notifyObserver(new StorageNotification(gameBoardOfPlayer.getStorage()).serialize());
    }

    @Override
    public void removeStorage(Resource resource, int quantity) throws IOException, InterruptedException {
        gameBoardOfPlayer.removeResourceStorage(resource, quantity);
        notifyObserver(new StorageNotification(gameBoardOfPlayer.getStorage()).serialize());
    }

    @Override
    public void addStrongbox(Map<Resource, Integer> map) throws IOException, InterruptedException {
        gameBoardOfPlayer.addResourceStrongbox(map);
        notifyObserver(new StrongboxNotification(gameBoardOfPlayer.getStrongbox()).serialize());
    }

    @Override
    public void addStrongbox(ArrayList<Resource> list) throws IOException, InterruptedException {
        gameBoardOfPlayer.addResourceStrongbox(list);
        notifyObserver(new StrongboxNotification(gameBoardOfPlayer.getStrongbox()).serialize());
    }

    @Override
    public void addStrongbox(Resource resource, int quantity) throws IOException, InterruptedException {
        gameBoardOfPlayer.addResourceStrongbox(resource, quantity);
        notifyObserver(new StrongboxNotification(gameBoardOfPlayer.getStrongbox()).serialize());
    }

    @Override
    public void removeStrongbox(Map<Resource, Integer> map) throws IOException, InterruptedException {
        gameBoardOfPlayer.removeResourceStrongbox(map);
        notifyObserver(new StrongboxNotification(gameBoardOfPlayer.getStrongbox()).serialize());
    }

    @Override
    public void removeStrongbox(Resource resource, int quantity) throws IOException, InterruptedException {
        gameBoardOfPlayer.removeResourceStrongbox(resource, quantity);
        notifyObserver(new StrongboxNotification(gameBoardOfPlayer.getStrongbox()).serialize());
    }

    @Override
    public int getLorenzoPosition(){
        return lorenzoTheMagnificent.getFaithIndicator();
    }
}
