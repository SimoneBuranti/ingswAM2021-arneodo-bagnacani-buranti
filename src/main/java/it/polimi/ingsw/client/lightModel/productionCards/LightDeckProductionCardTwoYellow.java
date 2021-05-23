package it.polimi.ingsw.client.lightModel.productionCards;

import java.util.ArrayList;

/**
 * this class represents the second level yellow production card deck
 */
public class LightDeckProductionCardTwoYellow extends LightDeckProductionCard {

    public LightDeckProductionCardTwoYellow(){
        numberDeck = 7;
    }

    @Override
    public void setDeckProductionCard(ArrayList<Integer> listKey){
        isConfig = true;
        for(int i = 0; i < listKey.size(); i++) {
            deck.add(productionCards.productionCardByKey(listKey.get(i)));
        }
    }
}


