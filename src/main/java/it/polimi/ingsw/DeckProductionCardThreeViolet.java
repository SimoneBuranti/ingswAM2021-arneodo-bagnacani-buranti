package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeckProductionCardThreeViolet extends DeckProductionCard {
        public static ArrayList<ProductionCard> deckVioletThree ;
        public  DeckProductionCardThreeViolet (){
        Violet violet= new Violet();
        deckVioletThree = new ArrayList<ProductionCard>(4);
        Map<Resource,Integer> violetNine =new HashMap<>();
        violetNine.put(Resource.COIN, 0);
        violetNine.put(Resource.ROCK, 0);
        violetNine.put(Resource.SERVANT, 6);
        violetNine.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetNineIn=new HashMap<>() ;
        violetNineIn.put(Resource.COIN, 0);
        violetNineIn.put(Resource.ROCK, 2);
        violetNineIn.put(Resource.SERVANT, 0);
        violetNineIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetNineOut=new HashMap<>();
        violetNineOut.put(Resource.COIN, 3);
        violetNineOut.put(Resource.ROCK, 0);
        violetNineOut.put(Resource.SERVANT, 0);
        violetNineOut.put(Resource.SHIELD, 0);
        ProductionCard cardNine =new ProductionCard(violetNine,violetNineIn,violetNineOut, 9, 3, violet,2);
        deckVioletThree.add(cardNine);

        Map<Resource,Integer> violetTen =new HashMap<>();
        violetTen.put(Resource.COIN, 2);
        violetTen.put(Resource.ROCK, 0);
        violetTen.put(Resource.SERVANT, 5);
        violetTen.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetTenIn =new HashMap<>() ;
        violetTenIn.put(Resource.COIN, 0);
        violetTenIn.put(Resource.ROCK, 1);
        violetTenIn.put(Resource.SERVANT, 0);
        violetTenIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> violetTenOut =new HashMap<>();
        violetTenOut.put(Resource.COIN, 2);
        violetTenOut.put(Resource.ROCK, 0);
        violetTenOut.put(Resource.SERVANT, 2);
        violetTenOut.put(Resource.SHIELD, 0);
        ProductionCard cardTen =new ProductionCard(violetTen, violetTenIn, violetTenOut, 10, 3, violet, 1);
        deckVioletThree.add(cardTen);



        Map<Resource,Integer> violetEleven =new HashMap<>();
        violetEleven.put(Resource.COIN, 0);
        violetEleven.put(Resource.ROCK, 0);
        violetEleven.put(Resource.SERVANT, 7);
        violetEleven.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetElevenIn=new HashMap<>() ;
        violetElevenIn.put(Resource.COIN, 1);
        violetElevenIn.put(Resource.ROCK, 0);
        violetElevenIn.put(Resource.SERVANT, 0);
        violetElevenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetElevenOut =new HashMap<>();
        violetElevenOut.put(Resource.COIN, 0);
        violetElevenOut.put(Resource.ROCK, 1);
        violetElevenOut.put(Resource.SERVANT, 0);
        violetElevenOut.put(Resource.SHIELD, 0);
        ProductionCard cardEleven =new ProductionCard(violetEleven,violetElevenIn, violetElevenOut, 11, 3, violet, 3);
        deckVioletThree.add(cardEleven);


        Map<Resource,Integer> violetTwelve =new HashMap<>();
        violetTwelve.put(Resource.COIN, 0);
        violetTwelve.put(Resource.ROCK, 0);
        violetTwelve.put(Resource.SERVANT, 4);
        violetTwelve.put(Resource.SHIELD, 4);
        Map<Resource,Integer> violetTwelveIn =new HashMap<>() ;
        violetTwelveIn.put(Resource.COIN, 1);
        violetTwelveIn.put(Resource.ROCK, 0);
        violetTwelveIn.put(Resource.SERVANT, 0);
        violetTwelveIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetTwEightOut =new HashMap<>();
        violetTwEightOut.put(Resource.COIN, 0);
        violetTwEightOut.put(Resource.ROCK, 3);
        violetTwEightOut.put(Resource.SERVANT, 1);
        violetTwEightOut.put(Resource.SHIELD, 0);
        ProductionCard cardTwelve =new ProductionCard(violetTwelve, violetTwelveIn, violetTwEightOut, 12, 3, violet, 0);
        deckVioletThree.add(cardTwelve);

        Mix.MIXED(deckVioletThree);
    }
        public void PickUpFirstCard(Player player , int choosenColumns) throws LevelException, EmptyException {
                if(!deckVioletThree.isEmpty()){
                        player.GivePlayerCard(deckVioletThree.get(0),choosenColumns);
                        for(int i=0; i<deckVioletThree.size()-1; i++)
                                deckVioletThree.set(i,deckVioletThree.get(i+1));
                        deckVioletThree.remove(deckVioletThree.size()-1);}
                else
                        throw new EmptyException();

        }

        /**
         * this method removes the first card from the deck,
         * if the deck is empty it throws the EndOfSolitaireGame exception
         * @throws EndOfSolitaireGame : exception thrown if there are no more cards available of a certain colour
         */
        public static void removeOneCard() throws EndOfSolitaireGame{

                for (int i = 0; i < deckVioletThree.size() - 1; i++)
                        deckVioletThree.set(i, deckVioletThree.get(i + 1));
                deckVioletThree.remove(deckVioletThree.size() - 1);

                if(deckVioletThree.isEmpty())
                        throw new EndOfSolitaireGame();
        }

        /**
         * this method has been implemented to do the tests and returns the size of the deck
         * @return int: the number of cards in the deck
         */
        public int size(){
                return deckVioletThree.size();
        }
}
