package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeckProductionCardTwoYellow extends DeckProductionCard {
    public static ArrayList<ProductionCard> deckYellowTwo ;
    public DeckProductionCardTwoYellow (){
        Yellow yellow= new Yellow();
        deckYellowTwo = new ArrayList<ProductionCard>(4);

        Map<Resource,Integer> yellowFive =new HashMap<>();
        yellowFive.put(Resource.COIN, 0);
        yellowFive.put(Resource.ROCK, 4);
        yellowFive.put(Resource.SERVANT, 0);
        yellowFive.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowFiveIn =new HashMap<>() ;
        yellowFiveIn.put(Resource.COIN, 0);
        yellowFiveIn.put(Resource.ROCK, 0);
        yellowFiveIn.put(Resource.SERVANT, 0);
        yellowFiveIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> yellowFiveOut =new HashMap<>();
        yellowFiveOut.put(Resource.COIN, 0);
        yellowFiveOut.put(Resource.ROCK, 0);
        yellowFiveOut.put(Resource.SERVANT, 0);
        yellowFiveOut.put(Resource.SHIELD, 0);
        ProductionCard cardTwentynine =new ProductionCard(yellowFive, yellowFiveIn, yellowFiveOut, 5, 2, yellow,2);
        deckYellowTwo.add(cardTwentynine);

        Map<Resource,Integer> yellowSix =new HashMap<>();
        yellowSix.put(Resource.COIN, 0);
        yellowSix.put(Resource.ROCK, 3);
        yellowSix.put(Resource.SERVANT, 0);
        yellowSix.put(Resource.SHIELD, 2);
        Map<Resource,Integer> yellowSixIn =new HashMap<>() ;
        yellowSixIn.put(Resource.COIN, 0);
        yellowSixIn.put(Resource.ROCK, 1);
        yellowSixIn.put(Resource.SERVANT, 0);
        yellowSixIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> yellowSixOut =new HashMap<>();
        yellowSixOut.put(Resource.COIN, 3);
        yellowSixOut.put(Resource.ROCK, 0);
        yellowSixOut.put(Resource.SERVANT, 0);
        yellowSixOut.put(Resource.SHIELD, 0);
        ProductionCard cardThirty =new ProductionCard(yellowSix, yellowSixIn, yellowSixOut, 6, 2, yellow, 0);
        deckYellowTwo.add(cardThirty);



        Map<Resource,Integer> yellowSeven =new HashMap<>();
        yellowSeven.put(Resource.COIN, 0);
        yellowSeven.put(Resource.ROCK, 5);
        yellowSeven.put(Resource.SERVANT, 0);
        yellowSeven.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowSevenIn =new HashMap<>() ;
        yellowSevenIn.put(Resource.COIN, 0);
        yellowSevenIn.put(Resource.ROCK, 0);
        yellowSevenIn.put(Resource.SERVANT, 0);
        yellowSevenIn.put(Resource.SHIELD, 2);
        Map<Resource,Integer> yellowSevenOut =new HashMap<>();
        yellowSevenOut.put(Resource.COIN, 0);
        yellowSevenOut.put(Resource.ROCK, 0);
        yellowSevenOut.put(Resource.SERVANT, 2);
        yellowSevenOut.put(Resource.SHIELD, 0);
        ProductionCard cardThirtyone =new ProductionCard(yellowSeven, yellowSevenIn, yellowSevenOut, 7, 2, yellow, 2);
        deckYellowTwo.add(cardThirtyone);


        Map<Resource,Integer> yellowEight =new HashMap<>();
        yellowEight.put(Resource.COIN, 0);
        yellowEight.put(Resource.ROCK, 3);
        yellowEight.put(Resource.SERVANT, 3);
        yellowEight.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowEightIn =new HashMap<>() ;
        yellowEightIn.put(Resource.COIN, 0);
        yellowEightIn.put(Resource.ROCK, 0);
        yellowEightIn.put(Resource.SERVANT, 0);
        yellowEightIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> yellowEightOut =new HashMap<>();
        yellowEightOut.put(Resource.COIN, 2);
        yellowEightOut.put(Resource.ROCK, 0);
        yellowEightOut.put(Resource.SERVANT, 0);
        yellowEightOut.put(Resource.SHIELD, 0);
        ProductionCard cardcardThirtytwo =new ProductionCard(yellowEight, yellowEightIn, yellowEightOut, 8, 2, yellow, 1);
        deckYellowTwo.add(cardcardThirtytwo);

        Mix.MIXED(deckYellowTwo);
    }
    public void PickUpFirstCard(Player player , int choosenColumns) throws LevelException, EmptyException {
        if(!deckYellowTwo.isEmpty()){
            player.GivePlayerCard(deckYellowTwo.get(0),choosenColumns);
            deckYellowTwo.remove(0);
            for(int i=0; i<deckYellowTwo.size(); i++)
                deckYellowTwo.set(i,deckYellowTwo.get(i+1));
            deckYellowTwo.remove(deckYellowTwo.size()-1);}
        else
            throw new EmptyException();

    }

}
