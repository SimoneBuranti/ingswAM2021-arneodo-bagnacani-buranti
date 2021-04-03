package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeckProductionCardOneBlu extends DeckProductionCard {
    public static ArrayList<ProductionCard> deckBlueOne ;
    public DeckProductionCardOneBlu(){
        Blue blue= new Blue();
        deckBlueOne = new ArrayList<ProductionCard>(4);
        Map<Resource,Integer> blueOne =new HashMap<>();
        blueOne.put(Resource.COIN, 2);
        blueOne.put(Resource.ROCK, 0);
        blueOne.put(Resource.SERVANT, 0);
        blueOne.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueOneIn =new HashMap<>() ;
        blueOneIn.put(Resource.COIN, 0);
        blueOneIn.put(Resource.ROCK, 0);
        blueOneIn.put(Resource.SERVANT, 0);
        blueOneIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> blueOneOut =new HashMap<>();
        blueOneOut.put(Resource.COIN, 0);
        blueOneOut.put(Resource.ROCK, 0);
        blueOneOut.put(Resource.SERVANT, 0);
        blueOneOut.put(Resource.SHIELD, 0);
        ProductionCard cardThirtyseven=new ProductionCard(blueOne, blueOneIn, blueOneOut, 1, 1, blue ,1);
        deckBlueOne.add(cardThirtyseven);

        Map<Resource,Integer> blueTwo =new HashMap<>();
        blueTwo.put(Resource.COIN, 1);
        blueTwo.put(Resource.ROCK, 1);
        blueTwo.put(Resource.SERVANT, 1);
        blueTwo.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueTwoIn =new HashMap<>() ;
        blueTwoIn.put(Resource.COIN, 0);
        blueTwoIn.put(Resource.ROCK, 0);
        blueTwoIn.put(Resource.SERVANT, 1);
        blueTwoIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueTwoOut=new HashMap<>();
        blueTwoOut.put(Resource.COIN, 0);
        blueTwoOut.put(Resource.ROCK, 1);
        blueTwoOut.put(Resource.SERVANT, 0);
        blueTwoOut.put(Resource.SHIELD, 0);
        ProductionCard cardThirtyeight =new ProductionCard(blueTwo, blueTwoIn,blueTwoOut, 2, 1, blue, 0);
        deckBlueOne.add(cardThirtyeight);



        Map<Resource,Integer> blueThree =new HashMap<>();
        blueThree.put(Resource.COIN, 3);
        blueThree.put(Resource.ROCK, 0);
        blueThree.put(Resource.SERVANT, 0);
        blueThree.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueThreeIn =new HashMap<>() ;
        blueThreeIn.put(Resource.COIN, 0);
        blueThreeIn.put(Resource.ROCK, 2);
        blueThreeIn.put(Resource.SERVANT, 0);
        blueThreeIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueThreeOut =new HashMap<>();
        blueThreeOut.put(Resource.COIN, 1);
        blueThreeOut.put(Resource.ROCK, 0);
        blueThreeOut.put(Resource.SERVANT, 1);
        blueThreeOut.put(Resource.SHIELD, 1);
        ProductionCard cardThirtynine =new ProductionCard(blueThree, blueThreeIn, blueThreeOut, 3, 1, blue, 0);
        deckBlueOne.add(cardThirtynine);


        Map<Resource,Integer> blueFour =new HashMap<>();
        blueFour.put(Resource.COIN, 2);
        blueFour.put(Resource.ROCK, 0);
        blueFour.put(Resource.SERVANT, 2);
        blueFour.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueFourIn =new HashMap<>() ;
        blueFourIn.put(Resource.COIN, 0);
        blueFourIn.put(Resource.ROCK, 1);
        blueFourIn.put(Resource.SERVANT, 0);
        blueFourIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> blueFourOut=new HashMap<>();
        blueFourOut.put(Resource.COIN, 0);
        blueFourOut.put(Resource.ROCK, 0);
        blueFourOut.put(Resource.SERVANT, 2);
        blueFourOut.put(Resource.SHIELD, 0);
        ProductionCard cardFourty =new ProductionCard(blueFour, blueFourIn,blueFourOut, 4, 1,blue, 1);
        deckBlueOne.add(cardFourty);

        Mix.MIXED(deckBlueOne);
    }
    public void PickUpFirstCard(Player player , int choosenColumns) throws LevelException,EmptyException {

     if(!deckBlueOne.isEmpty()){
     player.GivePlayerCard(deckBlueOne.get(0),choosenColumns);
     deckBlueOne.remove(0);
     for(int i=0; i<deckBlueOne.size(); i++)
        deckBlueOne.set(i,deckBlueOne.get(i+1));
     deckBlueOne.remove(deckBlueOne.size()-1);}
     else
         throw new EmptyException();

    }


}
