package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeckProductionCardThreeBlu extends DeckProductionCard {
    public static ArrayList<ProductionCard> deckBlueThree;
    public  DeckProductionCardThreeBlu(){
        Blue blue= new Blue();
        deckBlueThree = new ArrayList<ProductionCard>(4);
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
        ProductionCard cardFourtyfive =new ProductionCard(blueNine, blueNineIn, blueNineOut, 9, 3, blue,2);
        deckBlueThree .add(cardFourtyfive);

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
        ProductionCard cardFourtysix =new ProductionCard(blueTen, blueTenIn, blueTenOut, 10, 3, blue, 1);
        deckBlueThree.add(cardFourtysix);



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
        ProductionCard cardFourtyseven =new ProductionCard(blueEleven, blueElevenIn, blueElevenOut, 11, 3, blue, 3);
        deckBlueThree.add(cardFourtyseven);


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
        ProductionCard cardFourtyeight =new ProductionCard(blueTwelve, blueTwelveIn, blueTwEightOut, 12, 3, blue, 0);
        deckBlueThree.add(cardFourtyeight);

        Mix.MIXED(deckBlueThree );
    }
    public void PickUpFirstCard(Player player , int choosenColumns) throws LevelException, EmptyException {
        if(!deckBlueThree.isEmpty()){
            player.GivePlayerCard(deckBlueThree.get(0),choosenColumns);
            for(int i=0; i<deckBlueThree.size()-1; i++)
                deckBlueThree.set(i,deckBlueThree.get(i+1));
            deckBlueThree.remove(deckBlueThree.size()-1);}
        else
            throw new EmptyException();

    }

    /**
     * this method removes the first card from the deck,
     * if the deck is empty it throws the EndOfSolitaireGame exception
     * @throws EndOfSolitaireGame : exception thrown if there are no more cards available of a certain colour
     */
    public static void removeOneCard() throws EndOfSolitaireGame{

        for (int i = 0; i < deckBlueThree.size() - 1; i++)
            deckBlueThree.set(i, deckBlueThree.get(i + 1));
        deckBlueThree.remove(deckBlueThree.size() - 1);

        if(deckBlueThree.isEmpty())
            throw new EndOfSolitaireGame();
    }


    /**
     * this method has been implemented to do the tests and returns the size of the deck
     * @return int: the number of cards in the deck
     */
    public int size(){
        return deckBlueThree.size();
    }
}




