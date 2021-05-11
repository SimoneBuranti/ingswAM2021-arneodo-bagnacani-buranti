package it.polimi.ingsw.Client.lightModel.productionCards;

import com.google.gson.Gson;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.Blue;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * this class represents the third level blue production card deck
 */
public class LightDeckProductionCardThreeBlu extends LightDeckProductionCard {

    public LightDeckProductionCardThreeBlu(){
        numberDeck = 4;
    }

    @Override
    public void setDeckProductionCard(ArrayList<Integer> listKey){
        Blue blue= new Blue();
        deck = new ArrayList<>();
        ArrayList<ProductionCard> listCards = new ArrayList<>();
        Map<Resource,Integer> blueNine =new HashMap<>();
        blueNine.put(Resource.COIN, 6);
        blueNine.put(Resource.ROCK, 0);
        blueNine.put(Resource.SERVANT, 0);
        blueNine.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueNineIn =new HashMap<>() ;
        blueNineIn.put(Resource.COIN, 0);
        blueNineIn.put(Resource.ROCK, 0);
        blueNineIn.put(Resource.SERVANT, 2);
        blueNineIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueNineOut =new HashMap<>();
        blueNineOut.put(Resource.COIN, 0);
        blueNineOut.put(Resource.ROCK, 0);
        blueNineOut.put(Resource.SERVANT, 0);
        blueNineOut.put(Resource.SHIELD, 3);
        ProductionCard cardFortyFive =new ProductionCard(blueNine, blueNineIn, blueNineOut, 9, 3, blue,2,9);
        listCards.add(cardFortyFive);

        Map<Resource,Integer> blueTen =new HashMap<>();
        blueTen.put(Resource.COIN, 5);
        blueTen.put(Resource.ROCK, 2);
        blueTen.put(Resource.SERVANT, 0);
        blueTen.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueTenIn =new HashMap<>() ;
        blueTenIn.put(Resource.COIN, 1);
        blueTenIn.put(Resource.ROCK, 0);
        blueTenIn.put(Resource.SERVANT, 0);
        blueTenIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> blueTenOut =new HashMap<>();
        blueTenOut.put(Resource.COIN, 0);
        blueTenOut.put(Resource.ROCK, 2);
        blueTenOut.put(Resource.SERVANT, 2);
        blueTenOut.put(Resource.SHIELD, 0);
        ProductionCard cardFortySix =new ProductionCard(blueTen, blueTenIn, blueTenOut, 10, 3, blue, 1,10);
        listCards.add(cardFortySix);



        Map<Resource,Integer> blueEleven =new HashMap<>();
        blueEleven.put(Resource.COIN, 7);
        blueEleven.put(Resource.ROCK, 0);
        blueEleven.put(Resource.SERVANT, 0);
        blueEleven.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueElevenIn =new HashMap<>() ;
        blueElevenIn.put(Resource.COIN, 0);
        blueElevenIn.put(Resource.ROCK, 1);
        blueElevenIn.put(Resource.SERVANT, 0);
        blueElevenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueElevenOut =new HashMap<>();
        blueElevenOut.put(Resource.COIN, 0);
        blueElevenOut.put(Resource.ROCK, 0);
        blueElevenOut.put(Resource.SERVANT, 0);
        blueElevenOut.put(Resource.SHIELD, 1);
        ProductionCard cardFortySeven =new ProductionCard(blueEleven, blueElevenIn, blueElevenOut, 11, 3, blue, 3,11);
        listCards.add(cardFortySeven);


        Map<Resource,Integer> blueTwelve =new HashMap<>();
        blueTwelve.put(Resource.COIN, 4);
        blueTwelve.put(Resource.ROCK, 4);
        blueTwelve.put(Resource.SERVANT, 0);
        blueTwelve.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueTwelveIn =new HashMap<>() ;
        blueTwelveIn.put(Resource.COIN, 0);
        blueTwelveIn.put(Resource.ROCK, 0);
        blueTwelveIn.put(Resource.SERVANT, 1);
        blueTwelveIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueTwEightOut =new HashMap<>();
        blueTwEightOut.put(Resource.COIN, 1);
        blueTwEightOut.put(Resource.ROCK, 0);
        blueTwEightOut.put(Resource.SERVANT, 0);
        blueTwEightOut.put(Resource.SHIELD, 3);
        ProductionCard cardFortyEight =new ProductionCard(blueTwelve, blueTwelveIn, blueTwEightOut, 12, 3, blue, 0,12);
        listCards.add(cardFortyEight);

        for(Integer key : listKey) {
            for (ProductionCard card : listCards) {
                if (card.getKey() == key)
                    deck.add(card);
            }
        }
    }

}




