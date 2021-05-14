package it.polimi.ingsw.Client.lightModel;


import it.polimi.ingsw.Client.lightModel.productionCards.LightDeckProductionCard;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.util.ArrayList;
import java.util.Map;

public class LightGameMultiPlayer extends LightGame{
    
    private ArrayList<String> nicknameInOrder = new ArrayList<>();
    
    public LightGameMultiPlayer(String nickname){
        super(nickname);
    }
    
    @Override
    public void setPlayersInOrder(ArrayList<String> nicknames){
        nicknameInOrder.addAll(nicknames);
    }

    @Override
    public void setFaithPath(int faithIndicator, int currCall){
        gameBoardOfPlayer.setFaithPath(faithIndicator, currCall);
    }

    @Override
    public void setProductionCardGameBoard(int[][] productionCards){
        gameBoardOfPlayer.setProductionCards(productionCards);
    }


    @Override
    public void addLeaderCard(ArrayList<Integer> leaderCardKeys){
        gameBoardOfPlayer.addLeaderCard(leaderCardKeys);
    }

    @Override
    public void addLeaderCardActivated(ArrayList<Integer> leaderCardKeys){
       gameBoardOfPlayer.addLeaderCardActivated(leaderCardKeys);
    }


    @Override
    public void activateLeaderCard(int index){
       gameBoardOfPlayer.activateLeaderCard(index);
    }


    @Override
    public void discardLeaderCard(int index){
       gameBoardOfPlayer.discardLeaderCard(index);
    }

    @Override
    public void faithMove(int pos){
       gameBoardOfPlayer.moveFaithIndicator(pos);
    }

    @Override
    public void buyProductionCard(int deckNumber, int chosenColumn){
        for (LightDeckProductionCard deck : listOfDeck) {
            if (deck.getNumberDeck() == deckNumber)
               gameBoardOfPlayer.addProductionCard(chosenColumn, deck.pickUpFirstCard());
        }
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
    public void addStorage(Map<Resource, Integer> map){
       gameBoardOfPlayer.addResourceStorage(map);
    }

    @Override
    public void addStorage(ArrayList<Resource> list){
       gameBoardOfPlayer.addResourceStorage(list);
    }

    @Override
    public void addStorage(Resource resource, int quantity){
       gameBoardOfPlayer.addResourceStorage(resource, quantity);
    }

    @Override
    public void removeStorage(Map<Resource, Integer> map){
       gameBoardOfPlayer.removeResourceStorage(map);
    }

    @Override
    public void removeStorage(Resource resource, int quantity){
       gameBoardOfPlayer.removeResourceStorage(resource, quantity);
    }

    @Override
    public void addStrongbox(Map<Resource, Integer> map){
       gameBoardOfPlayer.addResourceStrongbox(map);
    }

    @Override
    public void addStrongbox(ArrayList<Resource> list){
       gameBoardOfPlayer.addResourceStrongbox(list);
    }

    @Override
    public void addStrongbox(Resource resource, int quantity){
       gameBoardOfPlayer.addResourceStrongbox(resource, quantity);
    }

    @Override
    public void removeStrongbox(Map<Resource, Integer> map){
       gameBoardOfPlayer.removeResourceStrongbox(map);
    }

    @Override
    public void removeStrongbox(Resource resource, int quantity){
       gameBoardOfPlayer.removeResourceStrongbox(resource, quantity);
    }

}
