package it.polimi.ingsw.Client.lightModel;


import it.polimi.ingsw.Client.lightModel.productionCards.LightDeckProductionCard;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.util.ArrayList;
import java.util.Map;

public class LightGameMultiPlayer extends LightGame{
    private ArrayList<LightPlayer> players;
    //private int currentPlayerPosition;
    private int numberOfPlayer;

    public LightGameMultiPlayer(){
        super();
    }

    @Override
    public void setPlayers(ArrayList<String> nicknameList){
        this.numberOfPlayer = nicknameList.size();
        LightPlayer player;
        for(String nickname : nicknameList){
            player = new LightPlayer(nickname);
            players.add(player);
        }
        //currentPlayerPosition = 0;
        //currentPlayer = players.get(currentPlayerPosition);
    }

    /*@Override
    public void setCurrentPlayer(){
        int cont;
        if(currentPlayerPosition == numberOfPlayer-1)
            cont = 0;
        else
            cont = currentPlayerPosition+1;

        while(!(players.get(cont).isConnected())){
            cont++;
            if(cont == numberOfPlayer)
                cont = 0;
            if(cont == currentPlayerPosition && !(players.get(cont).isConnected())){
                currentPlayer = null;
                return;
            }
        }
        currentPlayerPosition = cont;
        currentPlayer = players.get(currentPlayerPosition);
    }*/



    @Override
    public void setFaithPath(String nickname, int faithIndicator, int currCall){
        for(LightPlayer player : players){
            if(nickname.equals(player.getNickName())){
                player.setFaithPath(faithIndicator, currCall);
            }
        }
    }

    @Override
    public void setProductionCardGameBoard(String nickname, ProductionCard[][] productionCards){
        for(LightPlayer player : players){
            if(nickname.equals(player.getNickName())){
                player.setProductionCards(productionCards);
            }
        }
    }

    @Override
    public void addLeaderCard(String nickname, LeaderCard leaderCard){
        for(LightPlayer player : players){
            if(nickname.equals(player.getNickName())){
                player.addLeaderCard(leaderCard);
            }
        }
    }

    @Override
    public void addLeaderCard(String nickname, ArrayList<LeaderCard> leaderCard){
        for(LightPlayer player : players){
            if(nickname.equals(player.getNickName())){
                player.addLeaderCard(leaderCard);
            }
        }
    }

    @Override
    public void addLeaderCardActivated(String nickname, ArrayList<LeaderCard> leaderCard){
        for(LightPlayer player : players){
            if(nickname.equals(player.getNickName())){
                player.addLeaderCardActivated(leaderCard);
            }
        }
    }

    @Override
    public void activateLeaderCard(String nickname, LeaderCard leaderCard){
        for(LightPlayer player : players){
            if(nickname.equals(player.getNickName())){
                player.activateLeaderCard(leaderCard);
            }
        }
    }

    @Override
    public void activateLeaderCard(String nickname, int index){
        for(LightPlayer player : players){
            if(nickname.equals(player.getNickName())){
                player.activateLeaderCard(index);
            }
        }
    }

    @Override
    public void discardLeaderCard(String nickname, LeaderCard leaderCard){
        for(LightPlayer player : players){
            if(nickname.equals(player.getNickName())){
                player.discardLeaderCard(leaderCard);
            }
        }
    }

    @Override
    public void discardLeaderCard(String nickname, int index){
        for(LightPlayer player : players){
            if(nickname.equals(player.getNickName())){
                player.discardLeaderCard(index);
            }
        }
    }

    @Override
    public void faithMove(String nickname){
        for(LightPlayer player : players){
            if(nickname.equals(player.getNickName())){
                player.moveFaithIndicator();
            }
        }
    }

    @Override
    public void buyProductionCard(String nickname, int deckNumber, int chosenColumn){
        for(LightPlayer player : players) {
            if (nickname.equals(player.getNickName())) {
                for (LightDeckProductionCard deck : listOfDeck) {
                    if (deck.getNumberDeck() == deckNumber)
                        currentPlayer.addProductionCard(chosenColumn, deck.pickUpFirstCard());
                }
            }
        }
    }

    @Override
    public void payResourcesProduction(String nickname, Map<Resource, Integer> map){
        for(LightPlayer player : players) {
            if (nickname.equals(player.getNickName())) {
                player.payResourcesProduction(map);
            }
        }
    }

    @Override
    public void setPapalCards(int currCall){
        for(LightPlayer player : players)
            player.setPapal(currCall);
    }

    @Override
    public void addStorage(String nickname, Map<Resource, Integer> map){
        for(LightPlayer player : players) {
            if (nickname.equals(player.getNickName())) {
                player.addResourceStorage(map);
            }
        }
    }

    @Override
    public void addStorage(String nickname, ArrayList<Resource> list){
        for(LightPlayer player : players) {
            if (nickname.equals(player.getNickName())) {
                player.addResourceStorage(list);
            }
        }
    }

    @Override
    public void addStorage(String nickname, Resource resource, int quantity){
        for(LightPlayer player : players) {
            if (nickname.equals(player.getNickName())) {
                player.addResourceStorage(resource, quantity);
            }
        }
    }

    @Override
    public void removeStorage(String nickname, Map<Resource, Integer> map){
        for(LightPlayer player : players) {
            if (nickname.equals(player.getNickName())) {
                player.removeResourceStorage(map);
            }
        }
    }

    @Override
    public void removeStorage(String nickname, Resource resource, int quantity){
        for(LightPlayer player : players) {
            if (nickname.equals(player.getNickName())) {
                player.removeResourceStorage(resource, quantity);
            }
        }
    }

    @Override
    public void addStrongbox(String nickname, Map<Resource, Integer> map){
        for(LightPlayer player : players) {
            if (nickname.equals(player.getNickName())) {
                player.addResourceStrongbox(map);
            }
        }
    }

    @Override
    public void addStrongbox(String nickname, ArrayList<Resource> list){
        for(LightPlayer player : players) {
            if (nickname.equals(player.getNickName())) {
                player.addResourceStrongbox(list);
            }
        }
    }

    @Override
    public void addStrongbox(String nickname, Resource resource, int quantity){
        for(LightPlayer player : players) {
            if (nickname.equals(player.getNickName())) {
                player.addResourceStrongbox(resource, quantity);
            }
        }
    }

    @Override
    public void removeStrongbox(String nickname, Map<Resource, Integer> map){
        for(LightPlayer player : players) {
            if (nickname.equals(player.getNickName())) {
                player.removeResourceStrongbox(map);
            }
        }
    }

    @Override
    public void removeStrongbox(String nickname, Resource resource, int quantity){
        for(LightPlayer player : players) {
            if (nickname.equals(player.getNickName())) {
                player.removeResourceStrongbox(resource, quantity);
            }
        }
    }

}
