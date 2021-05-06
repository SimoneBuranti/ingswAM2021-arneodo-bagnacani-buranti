package it.polimi.ingsw.server.model.productionCards;

import com.google.gson.Gson;
import it.polimi.ingsw.server.model.colours.Green;
import it.polimi.ingsw.server.model.Mix;
import it.polimi.ingsw.server.model.Resource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * this class represents the third level green production card deck
 */
public class DeckProductionCardThreeGreen extends DeckProductionCard {
    /**
 * file for initial configuration
 */

    FileWriter configDeckGreenThree = null;
    /**
     * this constructor creates all the production cards and adds them to the list and shuffles the newly created deck
     */
    public  DeckProductionCardThreeGreen (){
        Gson g = new Gson();
        String JSONArray;

        Green green = new Green();
        deck = new ArrayList<>(4);
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
        ProductionCard cardTwentyOne =new ProductionCard(greenNine, greenNineIn, greenNineOut, 9, 3, green,2,9);
        deck.add(cardTwentyOne);

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
        ProductionCard cardTwentyTwo =new ProductionCard(greenTen, greenTenIn, greenTenOut, 10, 3, green, 1,10);
        deck.add(cardTwentyTwo);



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
        ProductionCard cardTwentyThree =new ProductionCard(greenEleven, greenElevenIn, greenElevenOut, 11, 3, green, 3,11);
        deck.add(cardTwentyThree);


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
        ProductionCard cardTwentyFour =new ProductionCard(greenTwelve, greenTwelveIn, greenTwEightOut, 12, 3, green, 0,12);
        deck.add(cardTwentyFour);

        Mix.MIXED(deck);

        List<Integer> list = new ArrayList<Integer>();
        list.add(deck.get(0).getKey());
        list.add(deck.get(1).getKey());
        list.add(deck.get(2).getKey());
        list.add(deck.get(3).getKey());

        String jsonStr = g.toJson(list);

        try {

            // Constructs a FileWriter given a file name, using the platform's default charset
            configDeckGreenThree= new FileWriter("src/main/resources/configDeckGreenThree.json");
            configDeckGreenThree.write(jsonStr);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                configDeckGreenThree.flush();
                configDeckGreenThree.close();
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
            config = new FileWriter("src/main/resources/DeckProductionCardThreeGreenLatest.json");
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

    public DeckProductionCardThreeGreen(ProductionCard[] deckRecover){
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
            configDeckGreenThree= new FileWriter("src/main/resources/configDeckGreenThree.json");
            configDeckGreenThree.write(jsonStr);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                configDeckGreenThree.flush();
                configDeckGreenThree.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }}

}

