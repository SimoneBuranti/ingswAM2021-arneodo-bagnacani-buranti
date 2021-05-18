package it.polimi.ingsw.client.lightModel.lightGameBoard;

import it.polimi.ingsw.client.lightModel.productionCards.LightProductionCards;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LightGameBoard {
    private final String nickname;
    private final LightStorage storage;
    private final LightStrongbox strongbox;
    private final LightFaithPath faithPath;
    private final ProductionCard[][] productionCards;
    private final ArrayList<LeaderCard> leaderCards;
    private final ArrayList<LeaderCard> leaderCardsActivated;
    private final LightProductionCards productionCardsByKey;
    private final LightLeaderCards leaderCardsByKey;

    public LightGameBoard(String nickname){
        this.nickname = nickname;
        storage = new LightStorage();
        strongbox = new LightStrongbox();
        faithPath = new LightFaithPath();
        productionCards = new ProductionCard[3][3];
        leaderCards = new ArrayList<>();
        leaderCardsActivated = new ArrayList<>();
        productionCardsByKey = new LightProductionCards();
        leaderCardsByKey = new LightLeaderCards();
    }

    public String getNickname(){
        return nickname;
    }
    public void setFaithPath(int faithIndicator, int currCall){
        this.faithPath.setFaithPath(faithIndicator, currCall);
    }

    public void setProductionCards(int[][] keys){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(keys[i][j] == 0){
                    this.productionCards[i][j] = null;
                }else {
                    this.productionCards[i][j] = productionCardsByKey.productionCardByKey(keys[i][j]);
                }
            }
        }
    }
    public int firstRowFree(int chosenColumn){
        int i;
        for(i=0; i<3; i++)
            if(productionCards[i][chosenColumn]==null)
                return i;
        return i;
    }

    public int lastRowOccupied(int chosenColumn) {
        int i=0;

        for(; i<3; i++)
            if(productionCards[i][chosenColumn]==null)
                return i-1;

        return 2;
    }

    public void addProductionCard(int chosenColumn, ProductionCard productionCard){
        int row = firstRowFree(chosenColumn);

        if(row < 3)
            productionCards[row][chosenColumn] = productionCard;
    }

    public ProductionCard getProductionCard(int chosenColumn){
        int row = lastRowOccupied(chosenColumn);

        return productionCards[row][chosenColumn];
    }

    public void addLeaderCard(LeaderCard leaderCard){
        leaderCards.add(leaderCard);
    }

    public void addLeaderCard(ArrayList<Integer> leaderCardKeys){
        for(int i = 0; i < leaderCardKeys.size(); i++) {
            leaderCards.add(leaderCardsByKey.leaderCardByKey(leaderCardKeys.get(i)));
        }
    }
    public void addLeaderCardActivated(ArrayList<Integer> leaderCardKeys){
        for(int i = 0; i < leaderCardKeys.size(); i++) {
            leaderCardsActivated.add(leaderCardsByKey.leaderCardByKey(leaderCardKeys.get(i)));
        }
    }

    public LeaderCard getLeaderCard(int index){
        return leaderCards.get(index);
    }


    public void activateLeaderCard(int index){
        leaderCardsActivated.add(leaderCards.remove(index));
    }


    public void discardLeaderCard(int index){
        leaderCards.remove(index);
    }

    public LeaderCard getLeaderCardActivated(int index){
        return leaderCardsActivated.get(index);
    }

    public void payResourcesProduction(ArrayList<Resource> list){
        strongbox.removeResource(storage.removeAvailableResource(fromListToMap(list)));
    }

    public Map<Resource, Integer> fromListToMap(ArrayList<Resource> list){
        Map<Resource,Integer> map = new HashMap<>();
        for(Resource resource : list){
            if(map.containsKey(resource)){
                map.put(resource, map.remove(resource)+1);
            }else{
                map.put(resource, 1);
            }
        }
        return map;
    }

    public void addResourceStorage(Resource resource){
        storage.addResource(resource);
    }

    public void addResourceStorage(Resource resource, int quantity){
        storage.addResource(resource, quantity);
    }

    public void addResourceStorage(Map<Resource,Integer> map){
        storage.addResource(map);
    }

    public void addResourceStorage(ArrayList<Resource> list){
        storage.addResource(list);
    }

    public void removeResourceStorage(Resource resource, int quantity){
        storage.removeResource(resource, quantity);
    }

    public void removeResourceStorage(Map<Resource,Integer> map){
        storage.removeResource(map);
    }

    public Map<Resource,Integer> removeAvailableResourceStorage(Map<Resource,Integer> map){
        return storage.removeAvailableResource(map);
    }

    public void removeResourceStorage(ArrayList<Resource> list){
        storage.removeResource(list);
    }

    public Map<Resource,Integer> getStorage(){
        return storage.getStorage();
    }

    public ArrayList<Resource> availableResourcesStorage(){
        return storage.availableResources();
    }

    public int getResourceStorage(Resource resource){
        return storage.getResource(resource);
    }

    public void addResourceStrongbox(Resource resource, int quantity){
        strongbox.addResource(resource, quantity);
    }

    public void addResourceStrongbox(Map<Resource,Integer> map){
        strongbox.addResource(map);
    }

    public void addResourceStrongbox(ArrayList<Resource> list){
        strongbox.addResource(list);
    }

    public void removeResourceStrongbox(Resource resource, int quantity){
        strongbox.removeResource(resource, quantity);
    }

    public void removeResourceStrongbox(Map<Resource,Integer> map){
        strongbox.removeResource(map);
    }

    public void removeResourceStrongbox(ArrayList<Resource> list){
        strongbox.removeResource(list);
    }

    public Map<Resource,Integer> getStrongbox(){
        return strongbox.getStrongbox();
    }

    public ArrayList<Resource> availableResourcesStrongbox(){
        return strongbox.availableResources();
    }

    public int getResourceStrongbox(Resource resource){
        return strongbox.getResource(resource);
    }

    public void moveFaithIndicator(int pos){
        faithPath.move(pos);
    }


    /**
     * This method checks the current position compared with the current vatican space
     * and the related papal cards will be assigned or not depending on player position
     * It also increases the currCall attribute
     */
    public void setPapal(int currCall) {
        faithPath.setPapal(currCall);
    }

    /**
     * Test only method: getter method for the current position of the faithIndicator
     * @return int : current position of the faithIndicator
     */
    public int getIndicator() {
        return faithPath.getIndicator();
    }

    /**
     * Test only method: getter method for the currCall attribute
     * @return int : the current value of the currCall attribute
     */
    public int getCurrCall() {
        return faithPath.getCurrCall();
    }

    /**
     * Test only method: getter method to show if the papal card in papalCardNumber position has been gained or not
     * @param papalCardNumber : the position of the papal card
     * @return int : 1 if the card has been gained, 0 if the card has not been gained, -1 if no player has reached the papal space
     */
    public int getPapalCard(int papalCardNumber){
        return faithPath.getPapalCard(papalCardNumber);
    }


    public ProductionCard[][] getProductionCards() {
        return productionCards;
    }

    public ArrayList<LeaderCard> getLeaderCards() {
        return leaderCards;
    }


    public ArrayList<LeaderCard> getLeaderCardsActivated() {
        return leaderCardsActivated;
    }
}
