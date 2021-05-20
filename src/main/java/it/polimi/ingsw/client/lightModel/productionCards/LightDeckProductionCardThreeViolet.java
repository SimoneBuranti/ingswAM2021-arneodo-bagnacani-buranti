package it.polimi.ingsw.client.lightModel.productionCards;

import java.util.ArrayList;

/**
 * this class represents the third level violet production card deck
 */
public class LightDeckProductionCardThreeViolet extends LightDeckProductionCard {

        public LightDeckProductionCardThreeViolet(){
                numberDeck = 8;
        }

        @Override
        public void setDeckProductionCard(ArrayList<Integer> listKey){

                for(int i = 0; i < listKey.size(); i++) {
                        deck.add(productionCards.productionCardByKey(listKey.get(i)));
                }
        }

}
