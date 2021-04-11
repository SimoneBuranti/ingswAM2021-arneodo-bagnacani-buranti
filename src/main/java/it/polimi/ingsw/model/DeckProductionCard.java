package it.polimi.ingsw.model;

import java.util.*;

public abstract class DeckProductionCard {

    protected ArrayList<ProductionCard> deck ;



    public ArrayList<Resource> requiredResources() {
        ArrayList<Resource> cost = new ArrayList<>();

        Map<Resource,Integer> m = deck.get(0).getCost();

        for(Resource key : m.keySet()) {
            for(int i=0;i<m.get(key);i++)
                cost.add(key);
        }

        return cost;
    }


    public ProductionCard pickUpFirstCard() throws EmptyException {
        if(!deck.isEmpty())
            return deck.remove(0);
        else
            throw new EmptyException();
    }

    /**
     * Test only method: getter method for the top card victory points
     * @return int
     */
    public int getPoints() {
        return deck.get(0).getPoints();
    }


    public int getLevel(){
        return deck.get(0).getLevel();
    }





    /**
     * this method removes the first card from the deck,
     * if the deck is empty it calls the level two deck method of the same colour
     * @throws EndOfSolitaireGame : exception thrown if there are no more cards available of a certain colour
     */
    public void removeOneCard() throws EmptyException, EndOfSolitaireGame {
        if(deck.isEmpty()) {
            throw new EmptyException();
        } else {
            int level= getLevel();
            deck.remove(0);
            if (deck.isEmpty() && level ==3)
                throw new EndOfSolitaireGame();
        }

    }

    /**
     * this method has been implemented to do the tests and returns the size of the deck
     * @return int: the number of cards in the deck
     */
    public int size(){
        return deck.size();
    }



}









