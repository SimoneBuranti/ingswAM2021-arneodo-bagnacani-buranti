package it.polimi.ingsw.Client.lightModel.productionCards;

import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.Green;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * this class represents the first level green production card deck
 */
public class LightDeckProductionCardOneGreen extends LightDeckProductionCard {

    public LightDeckProductionCardOneGreen(){
        numberDeck = 3;
    }

    @Override
    public void setDeckProductionCard(ArrayList<Integer> listKey){
        deck = new ArrayList<>();

        for(Integer key : listKey) {
            deck.add(productionCards.productionCardByKey(key));
        }
    }

}
