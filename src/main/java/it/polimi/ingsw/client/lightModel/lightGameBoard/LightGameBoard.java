package it.polimi.ingsw.client.lightModel.lightGameBoard;

import it.polimi.ingsw.client.lightModel.productionCards.LightProductionCards;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.leaderCards.LeaderCardReduction;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.util.ArrayList;
import java.util.Map;

/**
 * This class represents the player's game board of the light model
 */
public class LightGameBoard {
    /**
     * This attribute represents the nickname of the player
     */
    private final String nickname;
    /**
     * This attribute represents the storage of the player
     */
    private final LightStorage storage;
    /**
     * This attribute represents the strongbox of the player
     */
    private final LightStrongbox strongbox;
    /**
     * This attribute represents the faith path of the player
     */
    private final LightFaithPath faithPath;
    /**
     * This attribute represents the production cards of the player
     */
    private final ProductionCard[][] productionCards;
    /**
     * This attribute represents the leader cards of the player
     */
    private ArrayList<LeaderCard> leaderCards;
    /**
     * This attribute represents the activated leader cards of the player
     */
    private final ArrayList<LeaderCard> leaderCardsActivated;
    /**
     * This attribute contains all the production cards
     */
    private final LightProductionCards productionCardsByKey;
    /**
     * This attribute contains all the leader cards
     */
    private final LightLeaderCards leaderCardsByKey;


    /**
     * This constructor initialises all the attributes of the game board
     */
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

    /**
     * This method sets the values of player faith path
     * @param faithIndicator : the position of player faith indicator
     * @param currCall : the current currCall value
     */
    public void setFaithPath(int faithIndicator, int currCall){
        this.faithPath.setFaithPath(faithIndicator, currCall);
    }

    /**
     * This method returns the game board columns where there is at least one production card
     */
    public ArrayList<Integer> getAvailableProductionCards(){
        ArrayList<Integer> available = new ArrayList<>();
        for(int i= 0;i<3;i++){
            if(productionCards[0][i] != null)
                available.add(i+1);
        }
        return available;
    }

    /**
     * This method sets the initial production cards of the player's game board
     */
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

    /**
     * This method returns the first available position in the chosen column received as a parameter
     */
    public int firstRowFree(int chosenColumn){
        int i;
        for(i=0; i<3; i++)
            if(productionCards[i][chosenColumn]==null)
                return i;
        return i;
    }

    /**
     * This method returns the top card position in the chosen column received as a parameter
     */
    public int lastRowOccupied(int chosenColumn) {
        int i=0;

        for(; i< 3; i++)
            if(productionCards[i][chosenColumn]==null)
                return i-1;

        return 2;
    }

    /**
     * This method adds the production card passed as a parameter to the first row free of the column passed as a parameter
     * @param chosenColumn : the column in which add the card
     * @param productionCard : the card to add
     */
    public void addProductionCard(int chosenColumn, ProductionCard productionCard){
        int row = firstRowFree(chosenColumn);

        if(row < 3)
            productionCards[row][chosenColumn] = productionCard;
    }

    /**
     * This method returns the highest level production card in the column passed as a parameter if there is, null otherwise
     * @param chosenColumn : the column of the game board
     * @return ProductionCard : the production card in the chosenColumn
     */
    public ProductionCard getProductionCard(int chosenColumn){
        int row = lastRowOccupied(chosenColumn);

        if ( row == -1)
            return null;

        return productionCards[row][chosenColumn];
    }

    /**
     * This method initialises the initial leader cards of the player
     * @param leaderCardKeys : the keys of the initial leader cards
     */
    public void addLeaderCard(ArrayList<Integer> leaderCardKeys){
        for(int i = 0; i < leaderCardKeys.size(); i++) {
            leaderCards.add(leaderCardsByKey.leaderCardByKey(leaderCardKeys.get(i)));
        }
    }

    /**
     * This method initialises the initial activated leader cards of the player
     * @param leaderCardKeys : the keys of the initial activated leader cards
     */
    public void addLeaderCardActivated(ArrayList<Integer> leaderCardKeys){
        for(int i = 0; i < leaderCardKeys.size(); i++) {
            leaderCardsActivated.add(leaderCardsByKey.leaderCardByKey(leaderCardKeys.get(i)));
        }
    }

    /**
     * This method return the leader card in position index
     * @param index : the position of the card
     * @return LeaderCard : the card in index position
     */
    public LeaderCard getLeaderCard(int index){
        return leaderCards.get(index);
    }


    /**
     * This method activates the leader card in index position by removing it from the leaderCards list and adding
     * to the leaderCardsActivated list
     * @param index : the position of the leader card to activate
     */
    public void activateLeaderCard(int index){
        leaderCardsActivated.add(leaderCards.remove(index));
    }

    /**
     * This method discards the leader card in index position by removing it from the leaderCards list
     * @param index : the position of the leader card to discard
     */
    public void discardLeaderCard(int index){
        leaderCards.remove(index);
    }

    /**
     * This method returns the list of activated leader cards
     */
    public ArrayList<LeaderCard> getLeaderCardActivated(){
        return (ArrayList) leaderCardsActivated.clone();
    }

    /**
     * This method pays the cost of the activated production
     * @param list : the cost to be paid
     */
    public void payResourcesProduction(ArrayList<Resource> list){
        strongbox.removeResource(storage.removeAvailableResource(list));
    }

    /**
     * This method pays the cost of the bought production card
     * @param map : the cost to be paid
     */
    public ArrayList<Resource> payResourcesBuy(Map<Resource, Integer> map){
        ArrayList<Resource> list = fromMapToList(map);
        for(LeaderCard lc : leaderCardsActivated){
            if(lc instanceof LeaderCardReduction){
                list.remove(lc.getResourceEffect());
            }
        }
        strongbox.removeResource(storage.removeAvailableResource(list));

        return list;
    }

    /**
     * This method produces a list from the map passed as a parameter
     */
    public ArrayList<Resource> fromMapToList(Map<Resource, Integer> map){
        ArrayList<Resource> list = new ArrayList<>();
        for(Resource resource : map.keySet()){
            for(int i = 0; i < map.get(resource); i++){
                list.add(resource);
            }
        }
        return list;
    }

    /**
     * This method adds the quantity of the resource passed as a parameter to the storage
     * @param resource : the type of resource
     * @param quantity : the quantity to add
     */
    public void addResourceStorage(Resource resource, int quantity){
        storage.addResource(resource, quantity);
    }

    /**
     * This method adds the resources to the storage
     * @param map : the map of resources to add
     */
    public void addResourceStorage(Map<Resource,Integer> map){
        storage.addResource(map);
    }

    /**
     * This method adds the resources to the storage
     * @param list : the list of resources to add
     */
    public void addResourceStorage(ArrayList<Resource> list){
        storage.addResource(list);
    }

    /**
     * This method returns the storage of the game board
     */
    public Map<Resource,Integer> getStorage(){
        return storage.getStorage();
    }

    /**
     * This method adds the resources to the strongbox
     * @param map : the map of resources to add
     */
    public void addResourceStrongbox(Map<Resource,Integer> map){
        strongbox.addResource(map);
    }
    /**
     * This method adds the resources to the strongbox
     * @param list : the list of resources to add
     */
    public void addResourceStrongbox(ArrayList<Resource> list){
        strongbox.addResource(list);
    }

    /**
     * This method returns the strongbox of the game board
     */
    public Map<Resource,Integer> getStrongbox(){
        return strongbox.getStrongbox();
    }

    /**
     * This method moves the player's faith indicator to pos positions
     * @param pos : the number of positions to move forward the indicator
     */
    public void moveFaithIndicator(int pos){
        faithPath.move(pos);
    }

    /**
     * This method sets the value of the papal card in the current position with the value passed as a parameter
     * and increases the currCall attribute
     * @param papalCard : the value to set
     */
    public void setPapal(int papalCard) {
        faithPath.setPapal(papalCard);
    }

    /**
     * Getter method for the current position of the faithIndicator
     * @return int : current position of the faithIndicator
     */
    public int getIndicator() {
        return faithPath.getIndicator();
    }

    /**
     * Getter method for the currCall attribute
     * @return int : the current value of the currCall attribute
     */
    public int getCurrCall() {
        return faithPath.getCurrCall();
    }

    /**
     * This method returns the value of the papal card in papalCardNumber position
     * @param papalCardNumber : the position of the papal card
     * @return int : the value of the papal card
     */
    public int getPapalCard(int papalCardNumber){
        return faithPath.getPapalCard(papalCardNumber);
    }

    /**
     * This method returns the values of the player's papal cards
     * @return int[] : the values of the player's papal cards
     */
    public int[] getPapalCards(){
        return faithPath.getPapalCards();
    }

    /**
     * This method returns the player's production cards
     */
    public ProductionCard[][] getProductionCards() {
        return productionCards;
    }

    /**
     * This method returns the player's leader cards
     * @return ArrayList<LeaderCard> : the player's leader cards
     */
    public ArrayList<LeaderCard> getLeaderCards() {
        return leaderCards;
    }

    /**
     * This method returns the player's activated leader cards
     * @return ArrayList<LeaderCard> : the player's activated leader cards
     */
    public ArrayList<LeaderCard> getLeaderCardsActivated() {
        return leaderCardsActivated;
    }

    /**
     * This method sets the chosen leader cards
     * @param cardFirst : the position of the first leader card
     * @param cardSec : the position of the second leader card
     */
    public void setLeaderPersonal(int cardFirst, int cardSec) {
        ArrayList<LeaderCard> arrayList = new ArrayList<>();
        arrayList.add(LightLeaderCards.leaderCardByKey(leaderCards.get(cardFirst).getKey()));
        arrayList.add(LightLeaderCards.leaderCardByKey(leaderCards.get(cardSec).getKey()));
        leaderCards=arrayList;
    }

    /**
     * This method sets the initial values of the player's papal cards
     * @param papalCards : the initial values of the player's papal cards
     */
    public void setPapalCards(int[] papalCards) {
        faithPath.setPapalCards(papalCards);
    }
}
