package it.polimi.ingsw.client.lightModel.productionCards;

import java.util.ArrayList;

/**
 * this class represents the third level green production card deck
 */
public class LightDeckProductionCardThreeGreen extends LightDeckProductionCard {

    public LightDeckProductionCardThreeGreen(){
        numberDeck = 1;
    }

    @Override
    public void setDeckProductionCard(ArrayList<Integer> listKey){
        isConfig = true;
        for(int i = 0; i < listKey.size(); i++) {
            deck.add(productionCards.productionCardByKey(listKey.get(i)));
        }
    }
}

