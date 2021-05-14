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
 * this class represents the third level blue production card deck
 */
public class LightDeckProductionCardThreeBlu extends LightDeckProductionCard {

    public LightDeckProductionCardThreeBlu(){
        numberDeck = 2;
    }

    @Override
    public void setDeckProductionCard(ArrayList<Integer> listKey){
        deck = new ArrayList<>();

        for(Integer key : listKey) {
            deck.add(productionCards.productionCardByKey(key));
        }
    }

}




