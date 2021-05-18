package it.polimi.ingsw.client.lightModel.productionCards;

import java.util.ArrayList;

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

        for(int i = 0; i < listKey.size(); i++) {
            deck.add(productionCards.productionCardByKey(listKey.get(i)));
        }
    }
}

