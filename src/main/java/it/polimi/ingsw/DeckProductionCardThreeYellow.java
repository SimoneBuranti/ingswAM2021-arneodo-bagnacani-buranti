package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeckProductionCardThreeYellow extends DeckProductionCard {



    public DeckProductionCardThreeYellow(){
        Yellow yellow= new Yellow();
        deck = new ArrayList<ProductionCard>(4);
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
        ProductionCard cardThirtythree =new ProductionCard(yellowNine, yellowNineIn, yellowNineOut, 9, 3, yellow,2);
        deck.add(cardThirtythree);

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
        ProductionCard cardThirtyfour =new ProductionCard(yellowTen, yellowTenIn, yellowTenOut, 10, 3, yellow, 1);
        deck.add(cardThirtyfour);



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
        ProductionCard cardThirtyfive =new ProductionCard(yellowEleven, yellowElevenIn, yellowElevenOut, 11, 3, yellow, 3);
        deck.add(cardThirtyfive);


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
        ProductionCard cardThirtysix =new ProductionCard(yellowTwelve, yellowTwelveIn, yellowTwEightOut, 12, 3, yellow, 0);
        deck.add(cardThirtysix);

        Mix.MIXED(deck);
    }

}
