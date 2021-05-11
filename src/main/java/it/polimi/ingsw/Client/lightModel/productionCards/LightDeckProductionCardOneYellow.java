package it.polimi.ingsw.Client.lightModel.productionCards;

import com.google.gson.Gson;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.Yellow;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * this class represents the first level yellow production card deck
 */
public class LightDeckProductionCardOneYellow extends LightDeckProductionCard {

    public LightDeckProductionCardOneYellow(){
        numberDeck = 3;
    }

    @Override
    public void setDeckProductionCard(ArrayList<Integer> listKey){
        Yellow yellow= new Yellow();
        deck = new ArrayList<>();
        ArrayList<ProductionCard> listCards = new ArrayList<>();
        Map<Resource,Integer> yellowOne =new HashMap<>();
        yellowOne.put(Resource.COIN, 0);
        yellowOne.put(Resource.ROCK, 2);
        yellowOne.put(Resource.SERVANT, 0);
        yellowOne.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowOneIn =new HashMap<>() ;
        yellowOneIn.put(Resource.COIN, 0);
        yellowOneIn.put(Resource.ROCK, 0);
        yellowOneIn.put(Resource.SERVANT, 1);
        yellowOneIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowOneOut =new HashMap<>();
        yellowOneOut.put(Resource.COIN, 0);
        yellowOneOut.put(Resource.ROCK, 0);
        yellowOneOut.put(Resource.SERVANT, 0);
        yellowOneOut.put(Resource.SHIELD, 0);
        ProductionCard cardTwentyFive =new ProductionCard(yellowOne, yellowOneIn, yellowOneOut, 1, 1, yellow ,1,1);
        listCards.add(cardTwentyFive);

        Map<Resource,Integer> yellowTwo =new HashMap<>();
        yellowTwo.put(Resource.COIN, 1);
        yellowTwo.put(Resource.ROCK, 1);
        yellowTwo.put(Resource.SERVANT, 0);
        yellowTwo.put(Resource.SHIELD, 1);
        Map<Resource,Integer> yellowTwoIn =new HashMap<>() ;
        yellowTwoIn.put(Resource.COIN, 0);
        yellowTwoIn.put(Resource.ROCK, 0);
        yellowTwoIn.put(Resource.SERVANT, 0);
        yellowTwoIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> yellowTwoOut=new HashMap<>();
        yellowTwoOut.put(Resource.COIN, 1);
        yellowTwoOut.put(Resource.ROCK, 0);
        yellowTwoOut.put(Resource.SERVANT, 0);
        yellowTwoOut.put(Resource.SHIELD, 0);
        ProductionCard cardTwentySix =new ProductionCard(yellowTwo, yellowTwoIn,yellowTwoOut, 2, 1, yellow, 0,2);
        listCards.add(cardTwentySix );



        Map<Resource,Integer> yellowThree =new HashMap<>();
        yellowThree.put(Resource.COIN, 0);
        yellowThree.put(Resource.ROCK, 3);
        yellowThree.put(Resource.SERVANT, 0);
        yellowThree.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowThreeIn =new HashMap<>() ;
        yellowThreeIn.put(Resource.COIN, 0);
        yellowThreeIn.put(Resource.ROCK, 0);
        yellowThreeIn.put(Resource.SERVANT, 2);
        yellowThreeIn.put(Resource.SHIELD, 2);
        Map<Resource,Integer> yellowThreeOut =new HashMap<>();
        yellowThreeOut.put(Resource.COIN, 1);
        yellowThreeOut.put(Resource.ROCK, 1);
        yellowThreeOut.put(Resource.SERVANT, 1);
        yellowThreeOut.put(Resource.SHIELD, 0);
        ProductionCard cardTwentySeven =new ProductionCard(yellowThree, yellowThreeIn, yellowThreeOut, 3, 1, yellow, 0,3);
        listCards.add(cardTwentySeven);


        Map<Resource,Integer> yellowFour =new HashMap<>();
        yellowFour.put(Resource.COIN, 0);
        yellowFour.put(Resource.ROCK, 2);
        yellowFour.put(Resource.SERVANT, 0);
        yellowFour.put(Resource.SHIELD, 2);
        Map<Resource,Integer> yellowFourIn =new HashMap<>() ;
        yellowFourIn.put(Resource.COIN, 1);
        yellowFourIn.put(Resource.ROCK, 0);
        yellowFourIn.put(Resource.SERVANT, 1);
        yellowFourIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowFourOut=new HashMap<>();
        yellowFourOut.put(Resource.COIN, 0);
        yellowFourOut.put(Resource.ROCK, 0);
        yellowFourOut.put(Resource.SERVANT, 0);
        yellowFourOut.put(Resource.SHIELD, 2);
        ProductionCard cardTwentyEight =new ProductionCard(yellowFour, yellowFourIn,yellowFourOut, 4, 1,yellow, 1,4);
        listCards.add(cardTwentyEight);

        for(Integer key : listKey) {
            for (ProductionCard card : listCards) {
                if (card.getKey() == key)
                    deck.add(card);
            }
        }
    }
}
