package it.polimi.ingsw.Client.lightModel.productionCards;

import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.exceptions.EmptyException;
import it.polimi.ingsw.server.model.exceptions.EndOfSolitaireGame;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.util.ArrayList;
import java.util.Map;

/**
 * this abstract class represents the production card deck
 */
public abstract class LightDeckProductionCard {

    /**
     * this attribute collects the production cards of the deck
     */
    protected ArrayList<ProductionCard> deck ;

    protected int numberDeck;

    public void setDeckProductionCard(ArrayList<Integer> listKey){
    }
    /**
     * this method returns the cost of the first deck card
     * @return ArrayList<Resource> : a collection of all the resources of the first card cost
     */
    public ArrayList<Resource> requiredResources() {
        ArrayList<Resource> cost = new ArrayList<>();

        Map<Resource,Integer> m = deck.get(0).getCost();

        for(Resource key : m.keySet()) {
            for(int i=0;i<m.get(key);i++)
                cost.add(key);
        }
        return cost;
    }

    /**
     * this method removes the first deck card returning it to the caller if the deck is not empty,
     * otherwise it throws an EmptyException
     * @return ProductionCard : the first production card of the deck
     */
    public ProductionCard pickUpFirstCard(){
        if(!deck.isEmpty())
            return deck.get(0);
        else
            return null;
    }

    /**
     * this method throws an EmptyException if there are no more cards in the deck,
     * otherwise it removes the first card. If after the removal the deck is empty and is a level three
     * the method throws an EndOfSolitaireGame exception.
     */
    public void removeOneCard(){
        if(!(deck.isEmpty())){
            deck.remove(0);
        }
    }

    /**
     * Getter method for the top card victory level
     * @return int : level of the first production card of the deck
     */
    public int getLevel(){
        return deck.get(0).getLevel();
    }

    /**
     * Getter method for the deck size
     * @return int: the number of cards in the deck
     */
    public int size(){
        return deck.size();
    }

    public boolean isEmpty(){
        return deck.isEmpty();
    }

    /**
     * Test only method: getter method for the top card victory points
     * @return int : points of the first production card of the deck
     */
    public int getPoints() {
        return deck.get(0).getPoints();
    }

    public int getNumberDeck(){
        return numberDeck;
    }
}









