package it.polimi.ingsw.server.model.productionCards;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.Observer.Observable;
import it.polimi.ingsw.Observer.Observer;
import it.polimi.ingsw.messages.observable.DeckProductionCardMessage;
import it.polimi.ingsw.server.model.RuntimeTypeAdapterFactory;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.exceptions.EmptyException;
import it.polimi.ingsw.server.model.exceptions.EndOfSolitaireGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * this abstract class represents the production card deck
 */
public abstract class DeckProductionCard extends Observable {




    /**
     * this attribute collects the production cards of the deck
     */
    protected ArrayList<ProductionCard> deck ;


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
     * @throws EmptyException : the exception which is thrown when there are no more cards left in the deck
     */
    public ProductionCard pickUpFirstCard() throws EmptyException {
        if(!deck.isEmpty())

            return deck.remove(0);


        else
            throw new EmptyException();
    }

    /**
     * this method throws an EmptyException if there are no more cards in the deck,
     * otherwise it removes the first card. If after the removal the deck is empty and is a level three
     * the method throws an EndOfSolitaireGame exception.
     * @throws EmptyException  : the exception which is thrown when there are no more cards left in the deck
     * @throws EndOfSolitaireGame : the exception which is thrown when a production cards deck level three is empty
     *                              and states that the solitaire game is over and the winner is Lorenzo The Magnificent
     */
    public void removeOneCard() throws EmptyException, EndOfSolitaireGame, IOException, InterruptedException {
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


    /**
     * Test only method: getter method for the top card victory points
     * @return int : points of the first production card of the deck
     */
    public int getPoints() {
        return deck.get(0).getPoints();
    }


    /**
     * save information of deck for a possible restart game
     */
    public void saveInformationOfProductionDeck(){ }


    public Gson deckSaving(){

        RuntimeTypeAdapterFactory<Colour> adapterColour =
                RuntimeTypeAdapterFactory
                        .of(Colour.class,"type")
                        .registerSubtype(Green.class,"Green")
                        .registerSubtype(Yellow.class,"Yellow")
                        .registerSubtype(Blue.class,"Blue")
                        .registerSubtype(Violet.class,"Violet");

        Gson gson=new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapterFactory(adapterColour)
                .create();

        return gson;
    }

    public int getKey() {
        return 0;
    }



    public ArrayList<Integer> getDeck(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        return list;
    }
    }










