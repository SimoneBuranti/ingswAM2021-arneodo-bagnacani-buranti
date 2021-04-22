package it.polimi.ingsw.model.productionCards;

import it.polimi.ingsw.model.Mix;
import it.polimi.ingsw.model.Resource;
import it.polimi.ingsw.model.colours.Violet;

import java.util.*;

/**
 * this class represents the second level violet production card deck
 */
public class DeckProductionCardTwoViolet extends DeckProductionCard {

    /**
     * this constructor creates all the production cards and adds them to the list and shuffles the newly created deck
     */
    public DeckProductionCardTwoViolet (){

        Violet violet= new Violet();
        deck = new ArrayList<>(4);
        Map<Resource,Integer> violetFive =new HashMap<>();
        violetFive.put(Resource.COIN, 0);
        violetFive.put(Resource.ROCK, 0);
        violetFive.put(Resource.SERVANT, 4);
        violetFive.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetFiveIn=new HashMap<>() ;
        violetFiveIn.put(Resource.COIN, 1);
        violetFiveIn.put(Resource.ROCK, 0);
        violetFiveIn.put(Resource.SERVANT, 0);
        violetFiveIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetFiveOut=new HashMap<>();
        violetFiveOut.put(Resource.COIN, 0);
        violetFiveOut.put(Resource.ROCK, 0);
        violetFiveOut.put(Resource.SERVANT, 0);
        violetFiveOut.put(Resource.SHIELD, 0);
        ProductionCard cardFive =new ProductionCard(violetFive,violetFiveIn,violetFiveOut, 5, 2, violet,2);
        deck.add(cardFive);

        Map<Resource,Integer> violetSix =new HashMap<>();
        violetSix.put(Resource.COIN, 2);
        violetSix.put(Resource.ROCK, 0);
        violetSix.put(Resource.SERVANT, 3);
        violetSix.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetSixIn=new HashMap<>() ;
        violetSixIn.put(Resource.COIN, 1);
        violetSixIn.put(Resource.ROCK, 0);
        violetSixIn.put(Resource.SERVANT, 1);
        violetSixIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetSixOut=new HashMap<>();
        violetSixOut.put(Resource.COIN, 0);
        violetSixOut.put(Resource.ROCK, 0);
        violetSixOut.put(Resource.SERVANT, 0);
        violetSixOut.put(Resource.SHIELD, 3);
        ProductionCard cardSix =new ProductionCard(violetSix,violetSixIn,violetSixOut, 6, 2, violet, 0);
        deck.add(cardSix);



        Map<Resource,Integer> violetSeven =new HashMap<>();
        violetSeven.put(Resource.COIN, 0);
        violetSeven.put(Resource.ROCK, 0);
        violetSeven.put(Resource.SERVANT, 5);
        violetSeven.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetSevenIn=new HashMap<>() ;
        violetSevenIn.put(Resource.COIN, 0);
        violetSevenIn.put(Resource.ROCK, 2);
        violetSevenIn.put(Resource.SERVANT, 0);
        violetSevenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetSevenOut=new HashMap<>();
        violetSevenOut.put(Resource.COIN, 2);
        violetSevenOut.put(Resource.ROCK, 0);
        violetSevenOut.put(Resource.SERVANT, 0);
        violetSevenOut.put(Resource.SHIELD, 0);
        ProductionCard cardSeven =new ProductionCard(violetSeven,violetSevenIn,violetSevenOut, 7, 2, violet, 2);
        deck.add(cardSeven);


        Map<Resource,Integer> violetEight =new HashMap<>();
        violetEight.put(Resource.COIN, 0);
        violetEight.put(Resource.ROCK, 0);
        violetEight.put(Resource.SERVANT, 3);
        violetEight.put(Resource.SHIELD, 3);
        Map<Resource,Integer> violetEightIn=new HashMap<>() ;
        violetEightIn.put(Resource.COIN, 0);
        violetEightIn.put(Resource.ROCK, 1);
        violetEightIn.put(Resource.SERVANT, 0);
        violetEightIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetEightOut=new HashMap<>();
        violetEightOut.put(Resource.COIN, 0);
        violetEightOut.put(Resource.ROCK, 0);
        violetEightOut.put(Resource.SERVANT, 2);
        violetEightOut.put(Resource.SHIELD, 0);
        ProductionCard cardEight =new ProductionCard(violetEight,violetEightIn,violetEightOut, 8, 2, violet, 1);
        deck.add(cardEight);

        Mix.MIXED(deck);

    }



}
