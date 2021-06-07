package it.polimi.ingsw.client.lightModel.productionCards;

import java.util.ArrayList;

/**
 * this class represents the third level violet production card deck
 */
public class LightDeckProductionCardThreeViolet extends LightDeckProductionCard {

        /**
         * The constructor sets the number of the deck
         */
        public LightDeckProductionCardThreeViolet(){
                numberDeck = 4;
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
