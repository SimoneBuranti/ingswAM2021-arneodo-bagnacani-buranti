package it.polimi.ingsw.client.lightModel.productionCards;

import java.util.ArrayList;

/**
 * this class represents the second level blue production card deck
 */
public class LightDeckProductionCardTwoBlu extends LightDeckProductionCard {

    public LightDeckProductionCardTwoBlu(){
        numberDeck = 1;
    }

    @Override
    public void setDeckProductionCard(ArrayList<Integer> listKey){

        for(int i = 0; i < listKey.size(); i++) {
            deck.add(productionCards.productionCardByKey(listKey.get(i)));
        }
    }

}


