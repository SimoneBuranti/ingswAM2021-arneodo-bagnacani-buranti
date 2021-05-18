package it.polimi.ingsw.lightModel.productionCards;

import java.util.ArrayList;

/**
 * this class represents the second level yellow production card deck
 */
public class LightDeckProductionCardTwoYellow extends LightDeckProductionCard {

    public LightDeckProductionCardTwoYellow(){
        numberDeck = 10;
    }

    @Override
    public void setDeckProductionCard(ArrayList<Integer> listKey){
        deck = new ArrayList<>();

        for(int i = 0; i < listKey.size(); i++) {
            deck.add(productionCards.productionCardByKey(listKey.get(i)));
        }
    }
}


