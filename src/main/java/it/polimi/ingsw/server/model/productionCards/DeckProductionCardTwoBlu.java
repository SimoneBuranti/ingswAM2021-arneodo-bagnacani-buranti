package it.polimi.ingsw.server.model.productionCards;

import it.polimi.ingsw.server.model.colours.Blue;
import it.polimi.ingsw.server.model.Mix;
import it.polimi.ingsw.server.model.Resource;

import java.util.*;

/**
 * this class represents the second level blue production card deck
 */
public class DeckProductionCardTwoBlu extends DeckProductionCard {


    /**
     * this constructor creates all the production cards and adds them to the list and shuffles the newly created deck
     */
    public DeckProductionCardTwoBlu(){
        Blue blue= new Blue();
        deck = new ArrayList<>(4);

        Map<Resource,Integer> blueFive =new HashMap<>();
        blueFive.put(Resource.COIN, 4);
        blueFive.put(Resource.ROCK, 0);
        blueFive.put(Resource.SERVANT, 0);
        blueFive.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueFiveIn =new HashMap<>() ;
        blueFiveIn.put(Resource.COIN, 0);
        blueFiveIn.put(Resource.ROCK, 0);
        blueFiveIn.put(Resource.SERVANT, 1);
        blueFiveIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueFiveOut =new HashMap<>();
        blueFiveOut.put(Resource.COIN, 0);
        blueFiveOut.put(Resource.ROCK, 0);
        blueFiveOut.put(Resource.SERVANT, 0);
        blueFiveOut.put(Resource.SHIELD, 0);
        ProductionCard cardFortyOne =new ProductionCard(blueFive, blueFiveIn, blueFiveOut, 5, 2, blue,2);
        deck.add(cardFortyOne);

        Map<Resource,Integer> blueSix =new HashMap<>();
        blueSix.put(Resource.COIN, 3);
        blueSix.put(Resource.ROCK, 2);
        blueSix.put(Resource.SERVANT, 0);
        blueSix.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueSixIn =new HashMap<>() ;
        blueSixIn.put(Resource.COIN, 1);
        blueSixIn.put(Resource.ROCK, 1);
        blueSixIn.put(Resource.SERVANT, 0);
        blueSixIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueSixOut =new HashMap<>();
        blueSixOut.put(Resource.COIN, 0);
        blueSixOut.put(Resource.ROCK, 0);
        blueSixOut.put(Resource.SERVANT, 3);
        blueSixOut.put(Resource.SHIELD, 0);
        ProductionCard cardFortyTwo =new ProductionCard(blueSix, blueSixIn, blueSixOut, 6, 2, blue, 0);
        deck.add(cardFortyTwo);



        Map<Resource,Integer> blueSeven =new HashMap<>();
        blueSeven.put(Resource.COIN, 5);
        blueSeven.put(Resource.ROCK, 0);
        blueSeven.put(Resource.SERVANT, 0);
        blueSeven.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueSevenIn =new HashMap<>() ;
        blueSevenIn.put(Resource.COIN, 0);
        blueSevenIn.put(Resource.ROCK, 0);
        blueSevenIn.put(Resource.SERVANT, 2);
        blueSevenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueSevenOut =new HashMap<>();
        blueSevenOut.put(Resource.COIN, 0);
        blueSevenOut.put(Resource.ROCK, 0);
        blueSevenOut.put(Resource.SERVANT, 0);
        blueSevenOut.put(Resource.SHIELD, 2);
        ProductionCard cardFortyThree =new ProductionCard(blueSeven, blueSevenIn, blueSevenOut, 7, 2, blue, 2);
        deck.add(cardFortyThree);


        Map<Resource,Integer> blueEight =new HashMap<>();
        blueEight.put(Resource.COIN, 3);
        blueEight.put(Resource.ROCK, 3);
        blueEight.put(Resource.SERVANT, 0);
        blueEight.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueEightIn =new HashMap<>() ;
        blueEightIn.put(Resource.COIN, 0);
        blueEightIn.put(Resource.ROCK, 0);
        blueEightIn.put(Resource.SERVANT, 1);
        blueEightIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueEightOut =new HashMap<>();
        blueEightOut.put(Resource.COIN, 0);
        blueEightOut.put(Resource.ROCK, 2);
        blueEightOut.put(Resource.SERVANT, 0);
        blueEightOut.put(Resource.SHIELD, 0);
        ProductionCard cardFortyFour =new ProductionCard(blueEight, blueEightIn, blueEightOut, 8, 2, blue, 1);
        deck.add(cardFortyFour);

        Mix.MIXED(deck);

    }

}

