package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeckProductionCardThreeYellow extends DeckProductionCard {
    public static ArrayList<ProductionCard> deckYellowThree;
    public DeckProductionCardThreeYellow(){
        Yellow yellow= new Yellow();
        deckYellowThree = new ArrayList<ProductionCard>(4);
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
        deckYellowThree.add(cardThirtythree);

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
        deckYellowThree.add(cardThirtyfour);



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
        deckYellowThree.add(cardThirtyfive);


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
        deckYellowThree.add(cardThirtysix);

        Mix.MIXED(deckYellowThree);
    }
    public void PickUpFirstCard(Player player , int choosenColumns) throws LevelException, EmptyException {
        if(!deckYellowThree.isEmpty()){
            player.GivePlayerCard(deckYellowThree.get(0),choosenColumns);
            for(int i=0; i<deckYellowThree.size()-1; i++)
                deckYellowThree.set(i,deckYellowThree.get(i+1));
            deckYellowThree.remove(deckYellowThree.size()-1);}
        else
            throw new EmptyException();

    }

    /**
     * this method removes the first card from the deck,
     * if the deck is empty it throws the EndOfSolitaireGame exception
     * @throws EndOfSolitaireGame : exception thrown if there are no more cards available of a certain colour
     */
    public static void removeOneCard() throws EndOfSolitaireGame{

        for (int i = 0; i < deckYellowThree.size() - 1; i++)
            deckYellowThree.set(i, deckYellowThree.get(i + 1));
        deckYellowThree.remove(deckYellowThree.size() - 1);

        if(deckYellowThree.isEmpty())
            throw new EndOfSolitaireGame();
    }

    /**
     * this method has been implemented to do the tests and returns the size of the deck
     * @return int: the number of cards in the deck
     */
    public int size(){
        return deckYellowThree.size();
    }
}
