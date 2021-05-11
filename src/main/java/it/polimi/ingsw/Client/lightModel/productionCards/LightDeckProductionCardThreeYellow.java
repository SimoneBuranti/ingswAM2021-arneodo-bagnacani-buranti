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
 * this class represents the third level yellow production card deck
 */
public class LightDeckProductionCardThreeYellow extends LightDeckProductionCard {

    public LightDeckProductionCardThreeYellow(){
        numberDeck = 7;
    }

    @Override
    public void setDeckProductionCard(ArrayList<Integer> listKey){
        Yellow yellow= new Yellow();
        deck = new ArrayList<>();
        ArrayList<ProductionCard> listCards = new ArrayList<>();
        Map<Resource,Integer> yellowNine =new HashMap<>();
        yellowNine.put(Resource.COIN, 0);
        yellowNine.put(Resource.ROCK, 6);
        yellowNine.put(Resource.SERVANT, 0);
        yellowNine.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowNineIn =new HashMap<>() ;
        yellowNineIn.put(Resource.COIN, 0);
        yellowNineIn.put(Resource.ROCK, 0);
        yellowNineIn.put(Resource.SERVANT, 0);
        yellowNineIn.put(Resource.SHIELD, 2);
        Map<Resource,Integer> yellowNineOut =new HashMap<>();
        yellowNineOut.put(Resource.COIN, 0);
        yellowNineOut.put(Resource.ROCK, 0);
        yellowNineOut.put(Resource.SERVANT, 3);
        yellowNineOut.put(Resource.SHIELD, 0);
        ProductionCard cardThirtyThree =new ProductionCard(yellowNine, yellowNineIn, yellowNineOut, 9, 3, yellow,2,9);
        listCards.add(cardThirtyThree);

        Map<Resource,Integer> yellowTen =new HashMap<>();
        yellowTen.put(Resource.COIN, 0);
        yellowTen.put(Resource.ROCK, 5);
        yellowTen.put(Resource.SERVANT, 2);
        yellowTen.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowTenIn =new HashMap<>() ;
        yellowTenIn.put(Resource.COIN, 0);
        yellowTenIn.put(Resource.ROCK, 1);
        yellowTenIn.put(Resource.SERVANT, 1);
        yellowTenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowTenOut =new HashMap<>();
        yellowTenOut.put(Resource.COIN, 2);
        yellowTenOut.put(Resource.ROCK, 0);
        yellowTenOut.put(Resource.SERVANT, 0);
        yellowTenOut.put(Resource.SHIELD, 2);
        ProductionCard cardThirtyFour =new ProductionCard(yellowTen, yellowTenIn, yellowTenOut, 10, 3, yellow, 1,10);
        listCards.add(cardThirtyFour);



        Map<Resource,Integer> yellowEleven =new HashMap<>();
        yellowEleven.put(Resource.COIN, 0);
        yellowEleven.put(Resource.ROCK, 7);
        yellowEleven.put(Resource.SERVANT, 0);
        yellowEleven.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowElevenIn =new HashMap<>() ;
        yellowElevenIn.put(Resource.COIN, 0);
        yellowElevenIn.put(Resource.ROCK, 0);
        yellowElevenIn.put(Resource.SERVANT, 0);
        yellowElevenIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> yellowElevenOut =new HashMap<>();
        yellowElevenOut.put(Resource.COIN, 0);
        yellowElevenOut.put(Resource.ROCK, 0);
        yellowElevenOut.put(Resource.SERVANT, 1);
        yellowElevenOut.put(Resource.SHIELD, 0);
        ProductionCard cardThirtyFive =new ProductionCard(yellowEleven, yellowElevenIn, yellowElevenOut, 11, 3, yellow, 3,11);
        listCards.add(cardThirtyFive);


        Map<Resource,Integer> yellowTwelve =new HashMap<>();
        yellowTwelve.put(Resource.COIN, 0);
        yellowTwelve.put(Resource.ROCK, 4);
        yellowTwelve.put(Resource.SERVANT, 4);
        yellowTwelve.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowTwelveIn =new HashMap<>() ;
        yellowTwelveIn.put(Resource.COIN, 0);
        yellowTwelveIn.put(Resource.ROCK, 0);
        yellowTwelveIn.put(Resource.SERVANT, 0);
        yellowTwelveIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> yellowTwEightOut =new HashMap<>();
        yellowTwEightOut.put(Resource.COIN, 0);
        yellowTwEightOut.put(Resource.ROCK, 1);
        yellowTwEightOut.put(Resource.SERVANT, 3);
        yellowTwEightOut.put(Resource.SHIELD, 0);
        ProductionCard cardThirtySix =new ProductionCard(yellowTwelve, yellowTwelveIn, yellowTwEightOut, 12, 3, yellow, 0,12);
        listCards.add(cardThirtySix);

        for(Integer key : listKey) {
            for (ProductionCard card : listCards) {
                if (card.getKey() == key)
                    deck.add(card);
            }
        }
    }
}
