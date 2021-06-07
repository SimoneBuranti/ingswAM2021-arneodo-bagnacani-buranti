package it.polimi.ingsw.client.lightModel.productionCards;

import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.util.ArrayList;

/**
 * this abstract class represents the production card deck of light model
 */
public abstract class LightDeckProductionCard {

    /**
     * this attribute collects the production cards of the deck
     */
    protected ArrayList<ProductionCard> deck = new ArrayList<>();

    /**
     * This attribute represents the number of the deck
     */
    protected int numberDeck;

    /**
     * This attributes indicates if the deck has been set
     */
    protected boolean isConfig = false;

    /**
     * This attributes collects all the production cards
     */
    protected LightProductionCards productionCards = new LightProductionCards();

    /**
     * This method sets the deck
     */
    public void setDeckProductionCard(ArrayList<Integer> listKey){
    }

    /**
     * this method returns the first deck card if the deck is not empty
     * @return ProductionCard : the first production card of the deck
     */
    public ProductionCard pickUpFirstCard(){
        if(!deck.isEmpty())
            return deck.get(0);
        else
            return null;
    }

    /**
     * this method removes the first card if the deck is not empty
     */
    public void removeOneCard(){
        if(!(deck.isEmpty())){
            deck.remove(0);
        }
    }

    /**
     * This method return true if the deck is empty, false otherwise
     */
    public boolean isEmpty(){
        return deck.isEmpty();
    }

    /**
     * This method return the number of the deck
     */
    public int getNumberDeck(){
        return numberDeck;
    }

    /**
     * This method returns the production card to position i in the deck
     */
    public ProductionCard get(int i) {
        return  deck.get(i);
    }

    /**
     * This method returns the value of the boolean isConfig
     */
    public boolean isConfig(){
        return isConfig;
    }
}









