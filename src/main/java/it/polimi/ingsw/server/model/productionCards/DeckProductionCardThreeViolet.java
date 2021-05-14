package it.polimi.ingsw.server.model.productionCards;

import com.google.gson.Gson;
import it.polimi.ingsw.server.model.Mix;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.Violet;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * this class represents the third level violet production card deck
 */
public class DeckProductionCardThreeViolet extends DeckProductionCard {
        /**
         * this constructor creates all the production cards and adds them to the list and shuffles the newly created deck
         */
        public  DeckProductionCardThreeViolet () throws IOException, InterruptedException {
        deckNumber = 8;

        Violet violet= new Violet();
        deck = new ArrayList<>(4);

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
        ProductionCard cardNine =new ProductionCard(violetNine,violetNineIn,violetNineOut, 9, 3, violet,2,33);
        deck.add(cardNine);

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
        ProductionCard cardTen =new ProductionCard(violetTen, violetTenIn, violetTenOut, 10, 3, violet, 1,34);
        deck.add(cardTen);



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
        ProductionCard cardEleven =new ProductionCard(violetEleven,violetElevenIn, violetElevenOut, 11, 3, violet, 3,35);
        deck.add(cardEleven);


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
        ProductionCard cardTwelve =new ProductionCard(violetTwelve, violetTwelveIn, violetTwEightOut, 12, 3, violet, 0,36);
        deck.add(cardTwelve);

        Mix.MIXED(deck);


    }
        /**
         * save information of deck for a possible restart game
         */
        @Override
        public void saveInformationOfProductionDeck(){
                Gson gson= gsonForEveryoneDeckProduction();

                FileWriter config = null;
                String jsonStrin = gson.toJson(deck);
                try {
                        // Constructs a FileWriter given a file name, using the platform's default charset
                        config = new FileWriter("src/main/resources/DeckProductionCardThreeVioletLatest.json");
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

        public DeckProductionCardThreeViolet(ProductionCard[] deckRecover) throws IOException, InterruptedException {
                this.deck = new ArrayList<>();
                int l=deckRecover.length;
                for(int i=0; i < l; i++)
                        deck.add(deckRecover[i]);

        }

        @Override
        public ArrayList<Integer> getDeck(){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(deck.get(0).getKey());
                list.add(deck.get(1).getKey());
                list.add(deck.get(2).getKey());
                list.add(deck.get(3).getKey());
                return list;
        }

}

