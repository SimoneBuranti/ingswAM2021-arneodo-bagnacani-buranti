package it.polimi.ingsw.client.lightModel;


import it.polimi.ingsw.client.ligtModelNotification.*;
import it.polimi.ingsw.client.lightModel.productionCards.LightDeckProductionCard;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class LightGameMultiPlayer extends LightGame{
    
    private ArrayList<String> nicknameInOrder = new ArrayList<>();
    
    public LightGameMultiPlayer(String nickname) throws IOException, InterruptedException {
        super(nickname);
        //configInit();
    }

    public void configInit() throws IOException, InterruptedException {
        ArrayList<ProductionCard> list = new ArrayList<>();
        list=deckNotification();
        notifyObserver(new DeckListNotification(list).serialize());

    }

    @Override
    public void setPlayersInOrder(ArrayList<String> nicknames){
        nicknameInOrder.addAll(nicknames);
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
    public void addLeaderCard(ArrayList<Integer> leaderCardKeys) throws IOException, InterruptedException {
        gameBoardOfPlayer.addLeaderCard(leaderCardKeys);
        notifyObserver(new LeaderListCardNotification(gameBoardOfPlayer.getLeaderCards(),false).serialize());
        if(leaderCardKeys.size() < 3 && leaderCardKeys.size() > 0) {
            notifyObserver(new InitLeaderNotification(gameBoardOfPlayer.getLeaderCards(), false).serialize());
        }
    }

    @Override
    public void addLeaderCardActivated(ArrayList<Integer> leaderCardKeys) throws IOException, InterruptedException {
       gameBoardOfPlayer.addLeaderCardActivated(leaderCardKeys);
        notifyObserver(new LeaderListCardNotification(gameBoardOfPlayer.getLeaderCardsActivated(),true).serialize());
        if(leaderCardKeys.size() > 0) {
            notifyObserver(new InitLeaderNotification(gameBoardOfPlayer.getLeaderCardsActivated(), true).serialize());
        }
    }


    @Override
    public ArrayList<LeaderCard> getLeaderCards() {
        return gameBoardOfPlayer.getLeaderCards();
    }

    @Override
    public void activateLeaderCard(int index) throws IOException, InterruptedException {
        int key = gameBoardOfPlayer.getLeaderCard(index).getKey();
        gameBoardOfPlayer.activateLeaderCard(index);
        notifyObserver(new LeaderListCardNotification(gameBoardOfPlayer.getLeaderCards(),false).serialize());
        notifyObserver(new LeaderListCardNotification(gameBoardOfPlayer.getLeaderCardsActivated(),true).serialize());
        notifyObserver(new ActivateLeaderNotification(key, gameBoardOfPlayer.getLeaderCardsActivated().size()-1).serialize());
    }


    @Override
    public void discardLeaderCard(int index) throws IOException, InterruptedException {
       gameBoardOfPlayer.discardLeaderCard(index);
        notifyObserver(new LeaderListCardNotification(gameBoardOfPlayer.getLeaderCards(),false).serialize());
        notifyObserver(new DiscardLeaderNotification(index).serialize());

    }

    @Override
    public void faithMove(int pos) throws IOException, InterruptedException {
       gameBoardOfPlayer.moveFaithIndicator(pos);
        notifyObserver(new FaithPathNotification(gameBoardOfPlayer.getIndicator()).serialize());
    }

    @Override
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
        //ArrayList<ProductionCard> list=deckNotification();
        //notifyObserver(new DeckListNotification(list).serialize());
        notifyObserver(new GameboardListNotification(gameBoardOfPlayer.getProductionCards()).serialize());
        notifyObserver(new StorageNotification(gameBoardOfPlayer.getStorage()).serialize());
        notifyObserver(new StrongboxNotification(gameBoardOfPlayer.getStrongbox()).serialize());
        notifyObserver((new ReserveNotification(reserve.getReserve())).serialize());
    }

    @Override
    public void payResourcesProduction(ArrayList<Resource> list) throws IOException, InterruptedException {
       gameBoardOfPlayer.payResourcesProduction(list);
        notifyObserver(new StorageNotification(gameBoardOfPlayer.getStorage()).serialize());
        notifyObserver(new StrongboxNotification(gameBoardOfPlayer.getStrongbox()).serialize());
    }

    @Override
    public void setPapalCard(int papalCard){
       gameBoardOfPlayer.setPapal(papalCard);
    }

    public void setPapalCards(int[] papalCards){
        gameBoardOfPlayer.setPapalCards(papalCards);
        try {
            notifyObserver(new PapalCardsConfigNotification(gameBoardOfPlayer.getPapalCards()).serialize());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getPapalCard(int currCall){
        return gameBoardOfPlayer.getPapalCard(currCall);
    }

    public int[] getPapalCards(){
        return gameBoardOfPlayer.getPapalCards();
    }

    @Override
    public void addStorage(Map<Resource, Integer> map) throws IOException, InterruptedException {
       gameBoardOfPlayer.addResourceStorage(map);
        notifyObserver(new StorageNotification(gameBoardOfPlayer.getStorage()).serialize());
    }

    @Override
    public void addStorage(ArrayList<Resource> list) throws IOException, InterruptedException {
       gameBoardOfPlayer.addResourceStorage(list);
        notifyObserver(new StorageNotification(gameBoardOfPlayer.getStorage()).serialize());
    }

    @Override
    public void addStorage(Resource resource, int quantity) throws IOException, InterruptedException {
       gameBoardOfPlayer.addResourceStorage(resource, quantity);
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



}
