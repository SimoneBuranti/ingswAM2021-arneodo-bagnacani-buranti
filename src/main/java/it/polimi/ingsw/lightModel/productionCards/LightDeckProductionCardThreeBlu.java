package it.polimi.ingsw.lightModel.productionCards;

import java.util.ArrayList;

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

        for(int i = 0; i < listKey.size(); i++) {
            deck.add(productionCards.productionCardByKey(listKey.get(i)));
        }
    }

}




