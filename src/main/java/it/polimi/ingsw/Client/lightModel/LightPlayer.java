package it.polimi.ingsw.Client.lightModel;

import it.polimi.ingsw.Client.lightModel.lightGameBoard.LightGameBoard;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.util.ArrayList;
import java.util.Map;

public class LightPlayer {

    private final String nickName;
    private final LightGameBoard gameBoard;
    private boolean isConnected = true;

    public LightPlayer(String nickName){
        this.nickName = nickName;
        gameBoard = new LightGameBoard();
    }

    public String getNickName(){
        return nickName;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected() {
        isConnected = !isConnected;
    }

    public void setFaithPath(int faithIndicator, int currCall){
        gameBoard.setFaithPath(faithIndicator, currCall);
    }

    public void setProductionCards(int[][] productionCards){
        gameBoard.setProductionCards(productionCards);
    }
    public void addProductionCard(int chosenColumn, ProductionCard productionCard){
        gameBoard.addProductionCard(chosenColumn, productionCard);
    }

    public ProductionCard getProductionCard(int chosenColumn){
        return gameBoard.getProductionCard(chosenColumn);
    }

    public void addLeaderCard(LeaderCard leaderCard){
        gameBoard.addLeaderCard(leaderCard);
    }

    public void addLeaderCard(ArrayList<Integer> leaderCardKeys){
        gameBoard.addLeaderCard(leaderCardKeys);
    }

    public void addLeaderCardActivated(ArrayList<Integer> leaderCardKeys){
        gameBoard.addLeaderCardActivated(leaderCardKeys);
    }

    public LeaderCard getLeaderCard(int index){
        return gameBoard.getLeaderCard(index);
    }

    public void activateLeaderCard(int index){
        gameBoard.activateLeaderCard(index);
    }


    public void discardLeaderCard(int index){
        gameBoard.discardLeaderCard(index);
    }

    public LeaderCard getLeaderCardActivated(int index){
        return gameBoard.getLeaderCardActivated(index);
    }

    public void payResourcesProduction(Map<Resource,Integer> map){
        gameBoard.payResourcesProduction(map);
    }

    public void addResourceStorage(Resource resource){
        gameBoard.addResourceStorage(resource);
    }

    public void addResourceStorage(Resource resource, int quantity){
        gameBoard.addResourceStorage(resource, quantity);
    }

    public void addResourceStorage(Map<Resource,Integer> map){
        gameBoard.addResourceStorage(map);
    }

    public void addResourceStorage(ArrayList<Resource> list){
        gameBoard.addResourceStorage(list);
    }

    public void removeResourceStorage(Resource resource, int quantity){
        gameBoard.removeResourceStorage(resource, quantity);
    }

    public void removeResourceStorage(Map<Resource,Integer> map){
        gameBoard.removeResourceStorage(map);
    }

    public void removeResourceStorage(ArrayList<Resource> list){
        gameBoard.removeResourceStorage(list);
    }

    public Map<Resource,Integer> getStorage(){
        return gameBoard.getStorage();
    }

    public ArrayList<Resource> availableResourcesStorage(){
        return gameBoard.availableResourcesStorage();
    }

    public int getResourceStorage(Resource resource){
        return gameBoard.getResourceStorage(resource);
    }

    public void addResourceStrongbox(Resource resource, int quantity){
        gameBoard.addResourceStrongbox(resource, quantity);
    }

    public void addResourceStrongbox(Map<Resource,Integer> map){
        gameBoard.addResourceStrongbox(map);
    }

    public void addResourceStrongbox(ArrayList<Resource> list){
        gameBoard.addResourceStrongbox(list);
    }

    public void removeResourceStrongbox(Resource resource, int quantity){
        gameBoard.removeResourceStrongbox(resource, quantity);
    }

    public void removeResourceStrongbox(Map<Resource,Integer> map){
        gameBoard.removeResourceStrongbox(map);
    }

    public void removeResourceStrongbox(ArrayList<Resource> list){
        gameBoard.removeResourceStrongbox(list);
    }

    public Map<Resource,Integer> getStrongbox(){
        return gameBoard.getStrongbox();
    }

    public ArrayList<Resource> availableResourcesStrongbox(){
        return gameBoard.availableResourcesStrongbox();
    }

    public int getResourceStrongbox(Resource resource){
        return gameBoard.getResourceStrongbox(resource);
    }

    public void moveFaithIndicator(){
        gameBoard.moveFaithIndicator();
    }


    /**
     * This method checks the current position compared with the current vatican space
     * and the related papal cards will be assigned or not depending on player position
     * It also increases the currCall attribute
     */
    public void setPapal(int currCall) {
        gameBoard.setPapal(currCall);
    }

    /**
     * Test only method: getter method for the current position of the faithIndicator
     * @return int : current position of the faithIndicator
     */
    public int getIndicator() {
        return gameBoard.getIndicator();
    }

    /**
     * Test only method: getter method for the currCall attribute
     * @return int : the current value of the currCall attribute
     */
    public int getCurrCall() {
        return gameBoard.getCurrCall();
    }

    /**
     * Test only method: getter method to show if the papal card in papalCardNumber position has been gained or not
     * @param papalCardNumber : the position of the papal card
     * @return int : 1 if the card has been gained, 0 if the card has not been gained, -1 if no player has reached the papal space
     */
    public int getPapalCard(int papalCardNumber){
        return gameBoard.getPapalCard(papalCardNumber);
    }
}
