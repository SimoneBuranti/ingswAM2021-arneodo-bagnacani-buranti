package it.polimi.ingsw.server.model.productionCards;

import com.google.gson.Gson;
import it.polimi.ingsw.server.model.Mix;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.Yellow;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
/**
 * this class represents the second level yellow production card deck
 */
public class DeckProductionCardTwoYellow extends DeckProductionCard {
    /**
     * file for initial configuration
     */
    FileWriter configDeckYellowTwo= null;



    /**
     * this constructor creates all the production cards and adds them to the list and shuffles the newly created deck
     */
    public DeckProductionCardTwoYellow (){
        Gson g = new Gson();
        String JSONArray;

        Yellow yellow= new Yellow();
        deck = new ArrayList<>(4);

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
        ProductionCard cardTwentyNine =new ProductionCard(yellowFive, yellowFiveIn, yellowFiveOut, 5, 2, yellow,2,5);
        deck.add(cardTwentyNine);

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
        ProductionCard cardThirty =new ProductionCard(yellowSix, yellowSixIn, yellowSixOut, 6, 2, yellow, 0,6);
        deck.add(cardThirty);



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
        ProductionCard cardThirtyOne =new ProductionCard(yellowSeven, yellowSevenIn, yellowSevenOut, 7, 2, yellow, 2,7);
        deck.add(cardThirtyOne);


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
        ProductionCard cardThirtyTwo =new ProductionCard(yellowEight, yellowEightIn, yellowEightOut, 8, 2, yellow, 1,8);
        deck.add(cardThirtyTwo);

        Mix.MIXED(deck);
        List<Integer> list = new ArrayList<Integer>();
        list.add(deck.get(0).getKey());
        list.add(deck.get(1).getKey());
        list.add(deck.get(2).getKey());
        list.add(deck.get(3).getKey());

        String jsonStr = g.toJson(list);

        try {

            // Constructs a FileWriter given a file name, using the platform's default charset
            configDeckYellowTwo= new FileWriter("src/main/resources/configDeckYellowTwo.json");
            configDeckYellowTwo.write(jsonStr);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                configDeckYellowTwo.flush();
                configDeckYellowTwo.close();
            } catch (IOException e) {

                e.printStackTrace();
            }


        }

    }
    /**
     * save information of deck for a possible restart game
     */
    @Override
    public void saveInformationOfProductionDeck(){
        Gson gson=deckSaving();

        FileWriter config = null;
        String jsonStrin = gson.toJson(deck);
        try {
            // Constructs a FileWriter given a file name, using the platform's default charset
            config = new FileWriter("src/main/resources/DeckProductionCardOTwoYellowLatest.json");
            config.write(jsonStrin);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                config.flush();
                config.close();
            } catch (IOException e) {
                e.printStackTrace();
            } } }

}
