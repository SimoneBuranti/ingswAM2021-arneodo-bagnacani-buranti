package it.polimi.ingsw.client.lightModel.productionCards;

import java.util.ArrayList;

/**
 * this class represents the third level yellow production card deck
 */
public class LightDeckProductionCardThreeYellow extends LightDeckProductionCard {

    /**
     * The constructor sets the number of the deck
     */
    public LightDeckProductionCardThreeYellow(){
        numberDeck = 3;
    }

    /**
     * This method sets the boolean isConfig to true and the initial deck production cards
     * @param listKey : array containing card keys
     */
    @Override
    public void setDeckProductionCard(ArrayList<Integer> listKey){
        isConfig = true;
        for(int i = 0; i < listKey.size(); i++) {
            deck.add(productionCards.productionCardByKey(listKey.get(i)));
        }
    }
}
