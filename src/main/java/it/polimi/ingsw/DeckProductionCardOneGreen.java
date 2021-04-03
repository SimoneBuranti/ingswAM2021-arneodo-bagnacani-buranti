package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeckProductionCardOneGreen extends DeckProductionCard {
    public static ArrayList<ProductionCard> deckGreenOne ;
    public   DeckProductionCardOneGreen (){
        Green green= new Green();
        deckGreenOne = new ArrayList<ProductionCard>(4);
        Map<Resource,Integer> greenOne =new HashMap<>();
        greenOne.put(Resource.COIN, 0);
        greenOne.put(Resource.ROCK, 0);
        greenOne.put(Resource.SERVANT, 0);
        greenOne.put(Resource.SHIELD, 2);
        Map<Resource,Integer> greenOneIn =new HashMap<>() ;
        greenOneIn.put(Resource.COIN, 1);
        greenOneIn.put(Resource.ROCK, 0);
        greenOneIn.put(Resource.SERVANT, 0);
        greenOneIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenOneOut =new HashMap<>();
        greenOneOut.put(Resource.COIN, 0);
        greenOneOut.put(Resource.ROCK, 0);
        greenOneOut.put(Resource.SERVANT, 0);
        greenOneOut.put(Resource.SHIELD, 0);
        ProductionCard cardThirteen =new ProductionCard(greenOne, greenOneIn, greenOneOut, 1, 1, green ,1);
        deckGreenOne.add(cardThirteen);

        Map<Resource,Integer> greenTwo =new HashMap<>();
        greenTwo.put(Resource.COIN, 0);
        greenTwo.put(Resource.ROCK, 1);
        greenTwo.put(Resource.SERVANT, 1);
        greenTwo.put(Resource.SHIELD, 1);
        Map<Resource,Integer> greenTwoIn =new HashMap<>() ;
        greenTwoIn.put(Resource.COIN, 0);
        greenTwoIn.put(Resource.ROCK, 1);
        greenTwoIn.put(Resource.SERVANT, 0);
        greenTwoIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenTwoOut =new HashMap<>();
        greenTwoOut.put(Resource.COIN, 0);
        greenTwoOut.put(Resource.ROCK, 0);
        greenTwoOut.put(Resource.SERVANT, 1);
        greenTwoOut.put(Resource.SHIELD, 0);
        ProductionCard cardFourteen =new ProductionCard(greenTwo, greenTwoIn, greenTwoOut, 2, 1, green, 0);
        deckGreenOne.add(cardFourteen);



        Map<Resource,Integer> greenThree =new HashMap<>();
        greenThree.put(Resource.COIN, 0);
        greenThree.put(Resource.ROCK, 0);
        greenThree.put(Resource.SERVANT, 0);
        greenThree.put(Resource.SHIELD, 3);
        Map<Resource,Integer> greenThreeIn =new HashMap<>() ;
        greenThreeIn.put(Resource.COIN, 0);
        greenThreeIn.put(Resource.ROCK, 0);
        greenThreeIn.put(Resource.SERVANT, 2);
        greenThreeIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenThreeOut =new HashMap<>();
        greenThreeOut.put(Resource.COIN, 1);
        greenThreeOut.put(Resource.ROCK, 1);
        greenThreeOut.put(Resource.SERVANT, 0);
        greenThreeOut.put(Resource.SHIELD, 1);
        ProductionCard cardFiveteen =new ProductionCard(greenThree, greenThreeIn, greenThreeOut, 3, 1, green, 0);
        deckGreenOne.add(cardFiveteen);


        Map<Resource,Integer> greenFour =new HashMap<>();
        greenFour.put(Resource.COIN, 2);
        greenFour.put(Resource.ROCK, 0);
        greenFour.put(Resource.SERVANT, 0);
        greenFour.put(Resource.SHIELD, 2);
        Map<Resource,Integer> greenFourIn =new HashMap<>() ;
        greenFourIn.put(Resource.COIN, 0);
        greenFourIn.put(Resource.ROCK, 1);
        greenFourIn.put(Resource.SERVANT, 1);
        greenFourIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenFourOut =new HashMap<>();
        greenFourOut.put(Resource.COIN, 2);
        greenFourOut.put(Resource.ROCK, 0);
        greenFourOut.put(Resource.SERVANT, 0);
        greenFourOut.put(Resource.SHIELD, 0);
        ProductionCard cardSixteen =new ProductionCard(greenFour, greenFourIn, greenFourOut, 4, 1,green, 1);
        deckGreenOne.add(cardSixteen);

        Mix.MIXED(deckGreenOne);
    }
    public void PickUpFirstCard(Player player , int choosenColumns) throws LevelException, EmptyException {
        if(!deckGreenOne.isEmpty()){
            player.GivePlayerCard(deckGreenOne.get(0),choosenColumns);
            for(int i=0; i<deckGreenOne.size()-1; i++)
                deckGreenOne.set(i,deckGreenOne.get(i+1));
            deckGreenOne.remove(deckGreenOne.size()-1);}
        else
            throw new EmptyException();
    }
}

