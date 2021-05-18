package it.polimi.ingsw.client.lightModel.productionCards;

import java.util.ArrayList;

/**
 * this class represents the second level violet production card deck
 */
public class LightDeckProductionCardTwoViolet extends LightDeckProductionCard {

    public LightDeckProductionCardTwoViolet(){
        numberDeck = 7;
    }

    @Override
    public void setDeckProductionCard(ArrayList<Integer> listKey){
        deck = new ArrayList<>();

        for(int i = 0; i < listKey.size(); i++) {
            deck.add(productionCards.productionCardByKey(listKey.get(i)));
        }
    }

}
