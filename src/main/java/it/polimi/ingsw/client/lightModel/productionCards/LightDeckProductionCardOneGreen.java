package it.polimi.ingsw.client.lightModel.productionCards;

import java.util.ArrayList;

/**
 * this class represents the first level green production card deck
 */
public class LightDeckProductionCardOneGreen extends LightDeckProductionCard {

    public LightDeckProductionCardOneGreen(){
        numberDeck = 9;
    }

    @Override
    public void setDeckProductionCard(ArrayList<Integer> listKey){
        isConfig = true;
        for(int i = 0; i < listKey.size(); i++) {
            deck.add(productionCards.productionCardByKey(listKey.get(i)));
        }
    }

}
