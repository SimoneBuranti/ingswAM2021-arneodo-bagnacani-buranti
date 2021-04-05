package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeckProductionCardTwoBlu extends DeckProductionCard {
    public static ArrayList<ProductionCard> deckBlueTwo ;

    public DeckProductionCardTwoBlu(){
        Blue blue= new Blue();
        deckBlueTwo = new ArrayList<ProductionCard>(4);

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
        ProductionCard cardFourtyone =new ProductionCard(blueFive, blueFiveIn, blueFiveOut, 5, 2, blue,2);
        deckBlueTwo.add(cardFourtyone);

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
        ProductionCard cardFourtyTwo =new ProductionCard(blueSix, blueSixIn, blueSixOut, 6, 2, blue, 0);
        deckBlueTwo.add(cardFourtyTwo);



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
        ProductionCard cardFourtyThree =new ProductionCard(blueSeven, blueSevenIn, blueSevenOut, 7, 2, blue, 2);
        deckBlueTwo.add(cardFourtyThree);


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
        ProductionCard cardFourtyfour =new ProductionCard(blueEight, blueEightIn, blueEightOut, 8, 2, blue, 1);
        deckBlueTwo.add(cardFourtyfour);

        Mix.MIXED(deckBlueTwo);
    }
    public void PickUpFirstCard(Player player , int choosenColumns) throws LevelException, EmptyException {
        if(!deckBlueTwo.isEmpty()){
            player.GivePlayerCard(deckBlueTwo.get(0),choosenColumns);
            for(int i=0; i<deckBlueTwo.size()-1; i++)
                deckBlueTwo.set(i,deckBlueTwo.get(i+1));
            deckBlueTwo.remove(deckBlueTwo.size()-1);}
        else
            throw new EmptyException();

    }

    /**
     * this method removes the first card from the deck,
     * if the deck is empty it calls the level three deck method of the same colour
     * @throws EndOfSolitaireGame : exception thrown if there are no more cards available of a certain colour
     */
    public static void removeOneCard() throws EndOfSolitaireGame{
        if(deckBlueTwo.isEmpty())
            DeckProductionCardThreeBlu.removeOneCard();
        else {
            for (int i = 0; i < deckBlueTwo.size() - 1; i++)
                deckBlueTwo.set(i, deckBlueTwo.get(i + 1));
            deckBlueTwo.remove(deckBlueTwo.size() - 1);
        }
    }

    /**
     * this method has been implemented to do the tests and returns the size of the deck
     * @return int: the number of cards in the deck
     */
    public int size(){
        return deckBlueTwo.size();
    }
}


