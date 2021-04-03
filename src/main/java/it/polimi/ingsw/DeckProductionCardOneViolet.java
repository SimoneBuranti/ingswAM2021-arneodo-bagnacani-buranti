package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeckProductionCardOneViolet extends DeckProductionCard {
    public static ArrayList<ProductionCard> deckVioletOne;
    public  DeckProductionCardOneViolet (){
        Violet violet= new Violet();
        deckVioletOne = new ArrayList<ProductionCard>(4);
        Map<Resource,Integer> violetOne =new HashMap<>();
        violetOne.put(Resource.COIN, 0);
        violetOne.put(Resource.ROCK, 0);
        violetOne.put(Resource.SERVANT, 2);
        violetOne.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetOneIn=new HashMap<>() ;
        violetOneIn.put(Resource.COIN, 0);
        violetOneIn.put(Resource.ROCK, 1);
        violetOneIn.put(Resource.SERVANT, 0);
        violetOneIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetOneOut=new HashMap<>();
        violetOneOut.put(Resource.COIN, 0);
        violetOneOut.put(Resource.ROCK, 0);
        violetOneOut.put(Resource.SERVANT, 0);
        violetOneOut.put(Resource.SHIELD, 0);
        ProductionCard cardOne =new ProductionCard(violetOne,violetOneIn,violetOneOut, 1, 1, violet,1);
        deckVioletOne.add(cardOne);

        Map<Resource,Integer> violetTwo =new HashMap<>();
        violetTwo.put(Resource.COIN, 1);
        violetTwo.put(Resource.ROCK, 0);
        violetTwo.put(Resource.SERVANT, 1);
        violetTwo.put(Resource.SHIELD, 1);
        Map<Resource,Integer> violetTwoIn=new HashMap<>() ;
        violetTwoIn.put(Resource.COIN, 1);
        violetTwoIn.put(Resource.ROCK, 0);
        violetTwoIn.put(Resource.SERVANT, 0);
        violetTwoIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetTwoOut=new HashMap<>();
        violetTwoOut.put(Resource.COIN, 0);
        violetTwoOut.put(Resource.ROCK, 0);
        violetTwoOut.put(Resource.SERVANT, 0);
        violetTwoOut.put(Resource.SHIELD, 1);
        ProductionCard cardTwo =new ProductionCard(violetTwo,violetTwoIn,violetTwoOut, 2, 1, violet, 0);
        deckVioletOne.add(cardTwo);



        Map<Resource,Integer> violetThree =new HashMap<>();
        violetThree.put(Resource.COIN, 0);
        violetThree.put(Resource.ROCK, 0);
        violetThree.put(Resource.SERVANT, 3);
        violetThree.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetThreeIn=new HashMap<>() ;
        violetThreeIn.put(Resource.COIN, 2);
        violetThreeIn.put(Resource.ROCK, 0);
        violetThreeIn.put(Resource.SERVANT, 0);
        violetThreeIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetThreeOut=new HashMap<>();
        violetThreeOut.put(Resource.COIN, 0);
        violetThreeOut.put(Resource.ROCK, 1);
        violetThreeOut.put(Resource.SERVANT, 1);
        violetThreeOut.put(Resource.SHIELD, 1);
        ProductionCard cardThree =new ProductionCard(violetThree,violetThreeIn,violetThreeOut, 3, 1, violet, 0);
        deckVioletOne.add(cardThree);


        Map<Resource,Integer> violetFour =new HashMap<>();
        violetFour.put(Resource.COIN, 0);
        violetFour.put(Resource.ROCK, 2);
        violetFour.put(Resource.SERVANT, 2);
        violetFour.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetFourIn=new HashMap<>() ;
        violetFourIn.put(Resource.COIN, 1);
        violetFourIn.put(Resource.ROCK, 0);
        violetFourIn.put(Resource.SERVANT, 0);
        violetFourIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> violetFourOut=new HashMap<>();
        violetFourOut.put(Resource.COIN, 0);
        violetFourOut.put(Resource.ROCK, 2);
        violetFourOut.put(Resource.SERVANT, 0);
        violetFourOut.put(Resource.SHIELD, 0);
        ProductionCard cardSecond =new ProductionCard(violetFour,violetFourIn,violetFourOut, 4, 1, violet, 1);
        deckVioletOne.add(cardSecond);

        Mix.MIXED(deckVioletOne);
    }
    public void PickUpFirstCard(Player player , int choosenColumns) throws LevelException, EmptyException {
        if(!deckVioletOne.isEmpty()){
            player.GivePlayerCard(deckVioletOne.get(0),choosenColumns);
            deckVioletOne.remove(0);
            for(int i=0; i<deckVioletOne.size(); i++)
                deckVioletOne.set(i,deckVioletOne.get(i+1));
            deckVioletOne.remove(deckVioletOne.size()-1);}
        else
            throw new EmptyException();

    }
}
