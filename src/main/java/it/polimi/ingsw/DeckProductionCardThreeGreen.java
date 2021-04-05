package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeckProductionCardThreeGreen extends DeckProductionCard {
    public static ArrayList<ProductionCard> deckGreenThree;
    public  DeckProductionCardThreeGreen (){
        Green green = new Green();
        deckGreenThree = new ArrayList<ProductionCard>(4);
        Map<Resource,Integer> greenNine =new HashMap<>();
        greenNine.put(Resource.COIN, 0);
        greenNine.put(Resource.ROCK, 0);
        greenNine.put(Resource.SERVANT, 0);
        greenNine.put(Resource.SHIELD, 6);
        Map<Resource,Integer> greenNineIn =new HashMap<>() ;
        greenNineIn.put(Resource.COIN, 0);
        greenNineIn.put(Resource.ROCK, 0);
        greenNineIn.put(Resource.SERVANT, 2);
        greenNineIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenNineOut =new HashMap<>();
        greenNineOut.put(Resource.COIN, 0);
        greenNineOut.put(Resource.ROCK, 3);
        greenNineOut.put(Resource.SERVANT, 0);
        greenNineOut.put(Resource.SHIELD, 0);
        ProductionCard cardTwentyone =new ProductionCard(greenNine, greenNineIn, greenNineOut, 9, 3, green,2);
        deckGreenThree.add(cardTwentyone);

        Map<Resource,Integer> greenTen =new HashMap<>();
        greenTen.put(Resource.COIN, 0);
        greenTen.put(Resource.ROCK, 0);
        greenTen.put(Resource.SERVANT, 2);
        greenTen.put(Resource.SHIELD, 5);
        Map<Resource,Integer> greenTenIn =new HashMap<>() ;
        greenTenIn.put(Resource.COIN, 1);
        greenTenIn.put(Resource.ROCK, 0);
        greenTenIn.put(Resource.SERVANT, 1);
        greenTenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenTenOut =new HashMap<>();
        greenTenOut.put(Resource.COIN, 0);
        greenTenOut.put(Resource.ROCK, 2);
        greenTenOut.put(Resource.SERVANT, 0);
        greenTenOut.put(Resource.SHIELD, 2);
        ProductionCard cardTwentytwo =new ProductionCard(greenTen, greenTenIn, greenTenOut, 10, 3, green, 1);
        deckGreenThree.add(cardTwentytwo);



        Map<Resource,Integer> greenEleven =new HashMap<>();
        greenEleven.put(Resource.COIN, 0);
        greenEleven.put(Resource.ROCK, 0);
        greenEleven.put(Resource.SERVANT, 0);
        greenEleven.put(Resource.SHIELD, 7);
        Map<Resource,Integer> greenElevenIn =new HashMap<>() ;
        greenElevenIn.put(Resource.COIN, 0);
        greenElevenIn.put(Resource.ROCK, 0);
        greenElevenIn.put(Resource.SERVANT, 1);
        greenElevenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenElevenOut =new HashMap<>();
        greenElevenOut.put(Resource.COIN, 1);
        greenElevenOut.put(Resource.ROCK, 0);
        greenElevenOut.put(Resource.SERVANT, 0);
        greenElevenOut.put(Resource.SHIELD, 0);
        ProductionCard cardTwentythree =new ProductionCard(greenEleven, greenElevenIn, greenElevenOut, 11, 3, green, 3);
        deckGreenThree.add(cardTwentythree);


        Map<Resource,Integer> greenTwelve =new HashMap<>();
        greenTwelve.put(Resource.COIN, 4);
        greenTwelve.put(Resource.ROCK, 0);
        greenTwelve.put(Resource.SERVANT, 0);
        greenTwelve.put(Resource.SHIELD, 4);
        Map<Resource,Integer> greenTwelveIn =new HashMap<>() ;
        greenTwelveIn.put(Resource.COIN, 0);
        greenTwelveIn.put(Resource.ROCK, 1);
        greenTwelveIn.put(Resource.SERVANT, 0);
        greenTwelveIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenTwEightOut =new HashMap<>();
        greenTwEightOut.put(Resource.COIN, 3);
        greenTwEightOut.put(Resource.ROCK, 0);
        greenTwEightOut.put(Resource.SERVANT, 0);
        greenTwEightOut.put(Resource.SHIELD, 1);
        ProductionCard cardTwentyfour =new ProductionCard(greenTwelve, greenTwelveIn, greenTwEightOut, 12, 3, green, 0);
        deckGreenThree.add(cardTwentyfour);

        Mix.MIXED(deckGreenThree);
    }
    public void PickUpFirstCard(Player player , int choosenColumns) throws LevelException, EmptyException {
        if(!deckGreenThree.isEmpty()){
            player.GivePlayerCard(deckGreenThree.get(0),choosenColumns);
            for(int i=0; i<deckGreenThree.size()-1; i++)
                deckGreenThree.set(i,deckGreenThree.get(i+1));
            deckGreenThree.remove(deckGreenThree.size()-1);}
        else
            throw new EmptyException();

    }

    /**
     * this method removes the first card from the deck,
     * if the deck is empty it throws the EndOfSolitaireGame exception
     * @throws EndOfSolitaireGame : exception thrown if there are no more cards available of a certain colour
     */
    public static void removeOneCard() throws EndOfSolitaireGame{

        for (int i = 0; i < deckGreenThree.size() - 1; i++)
            deckGreenThree.set(i, deckGreenThree.get(i + 1));
        deckGreenThree.remove(deckGreenThree.size() - 1);

        if(deckGreenThree.isEmpty())
            throw new EndOfSolitaireGame();
    }

    /**
     * this method has been implemented to do the tests and returns the size of the deck
     * @return int: the number of cards in the deck
     */
    public int size(){
        return deckGreenThree.size();
    }

}
