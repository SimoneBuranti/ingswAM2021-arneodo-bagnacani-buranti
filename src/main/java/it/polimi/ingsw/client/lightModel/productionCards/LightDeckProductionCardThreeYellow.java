package it.polimi.ingsw.client.lightModel.productionCards;

import java.util.ArrayList;

/**
 * this class represents the third level yellow production card deck
 */
public class LightDeckProductionCardThreeYellow extends LightDeckProductionCard {

    public LightDeckProductionCardThreeYellow(){
        numberDeck = 11;
    }

    @Override
    public void setDeckProductionCard(ArrayList<Integer> listKey){
        deck = new ArrayList<>();

        for(int i = 0; i < listKey.size(); i++) {
            deck.add(productionCards.productionCardByKey(listKey.get(i)));
        }
    }
}
