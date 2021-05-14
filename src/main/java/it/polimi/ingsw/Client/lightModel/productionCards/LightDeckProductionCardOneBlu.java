package it.polimi.ingsw.Client.lightModel.productionCards;

import com.google.gson.Gson;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.Blue;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * this class represents the first level blue production card deck
 */
public class LightDeckProductionCardOneBlu extends LightDeckProductionCard {

    public LightDeckProductionCardOneBlu(){
        numberDeck = 0;
    }
    /**
     * this constructor creates all the production cards and adds them to the list and shuffles the newly created deck
     */

    @Override
    public void setDeckProductionCard(ArrayList<Integer> listKey){
        deck = new ArrayList<>();

        for(Integer key : listKey) {
            deck.add(productionCards.productionCardByKey(key));
        }
    }
}

