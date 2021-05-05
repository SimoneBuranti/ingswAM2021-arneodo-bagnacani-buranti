package it.polimi.ingsw.server.model.productionCards;

import com.google.gson.Gson;
import it.polimi.ingsw.server.model.Mix;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.Yellow;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * this class represents the third level yellow production card deck
 */
public class DeckProductionCardThreeYellow extends DeckProductionCard {
    /**
     * file for initial configuration
     */
    FileWriter configDeckYellowThree = null;


    /**
     * this constructor creates all the production cards and adds them to the list and shuffles the newly created deck
     */
    public DeckProductionCardThreeYellow(){
        Gson g = new Gson();
        String JSONArray;

        Yellow yellow= new Yellow();
        deck = new ArrayList<>(4);
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
        ProductionCard cardThirtyThree =new ProductionCard(yellowNine, yellowNineIn, yellowNineOut, 9, 3, yellow,2,9);
        deck.add(cardThirtyThree);

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
        ProductionCard cardThirtyFour =new ProductionCard(yellowTen, yellowTenIn, yellowTenOut, 10, 3, yellow, 1,10);
        deck.add(cardThirtyFour);



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
        ProductionCard cardThirtyFive =new ProductionCard(yellowEleven, yellowElevenIn, yellowElevenOut, 11, 3, yellow, 3,11);
        deck.add(cardThirtyFive);


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
        ProductionCard cardThirtySix =new ProductionCard(yellowTwelve, yellowTwelveIn, yellowTwEightOut, 12, 3, yellow, 0,12);
        deck.add(cardThirtySix);

        Mix.MIXED(deck);

        List<Integer> list = new ArrayList<Integer>();
        list.add(deck.get(0).getKey());
        list.add(deck.get(1).getKey());
        list.add(deck.get(2).getKey());
        list.add(deck.get(3).getKey());

        String jsonStr = g.toJson(list);

        try {

            // Constructs a FileWriter given a file name, using the platform's default charset
            configDeckYellowThree= new FileWriter("src/main/resources/configDeckYellowThree.json");
            configDeckYellowThree.write(jsonStr);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                configDeckYellowThree.flush();
                configDeckYellowThree.close();
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
            config = new FileWriter("src/main/resources/DeckProductionCardThreeYellowLatest.json");
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



    public DeckProductionCardThreeYellow(ProductionCard[] deckRecover){
        this.deck = new ArrayList<>();
        int l=deckRecover.length;
        for(int i=0; i < l; i++)
            deck.add(deckRecover[i]);
        Gson gson = new Gson();

        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i < deck.size(); i++)
            list.add(deck.get(i).getKey());

        String jsonStr = gson.toJson(list);

        try {

            // Constructs a FileWriter given a file name, using the platform's default charset
            configDeckYellowThree = new FileWriter("src/main/resources/configDeckThreeYellow.json");
            configDeckYellowThree.write(jsonStr);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                configDeckYellowThree.flush();
                configDeckYellowThree.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }}



}
