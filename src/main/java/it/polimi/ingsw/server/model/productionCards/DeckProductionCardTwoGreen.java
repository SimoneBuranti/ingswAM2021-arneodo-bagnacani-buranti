package it.polimi.ingsw.server.model.productionCards;

import com.google.gson.Gson;
import it.polimi.ingsw.server.model.colours.Green;
import it.polimi.ingsw.server.model.Mix;
import it.polimi.ingsw.server.model.Resource;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * this class represents the second level green production card deck
 */
public class DeckProductionCardTwoGreen extends DeckProductionCard {

    /**
     * this constructor creates all the production cards and adds them to the list and shuffles the newly created deck
     */
    public DeckProductionCardTwoGreen () throws IOException, InterruptedException {

        deckNumber = 5;

        Green green= new Green();
        deck  = new ArrayList<>(4);

        Map<Resource,Integer> greenFive =new HashMap<>();
        greenFive.put(Resource.COIN, 0);
        greenFive.put(Resource.ROCK, 0);
        greenFive.put(Resource.SERVANT, 0);
        greenFive.put(Resource.SHIELD, 4);
        Map<Resource,Integer> greenFiveIn =new HashMap<>() ;
        greenFiveIn.put(Resource.COIN, 0);
        greenFiveIn.put(Resource.ROCK, 1);
        greenFiveIn.put(Resource.SERVANT, 0);
        greenFiveIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenFiveOut =new HashMap<>();
        greenFiveOut.put(Resource.COIN, 0);
        greenFiveOut.put(Resource.ROCK, 0);
        greenFiveOut.put(Resource.SERVANT, 0);
        greenFiveOut.put(Resource.SHIELD, 0);
        ProductionCard cardSeventeen =new ProductionCard(greenFive, greenFiveIn, greenFiveOut, 5, 2, green,2,17 );
        deck.add(cardSeventeen);

        Map<Resource,Integer> greenSix =new HashMap<>();
        greenSix.put(Resource.COIN, 0);
        greenSix.put(Resource.ROCK, 0);
        greenSix.put(Resource.SERVANT, 2);
        greenSix.put(Resource.SHIELD, 3);
        Map<Resource,Integer> greenSixIn =new HashMap<>() ;
        greenSixIn.put(Resource.COIN, 0);
        greenSixIn.put(Resource.ROCK, 0);
        greenSixIn.put(Resource.SERVANT, 1);
        greenSixIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> greenSixOut =new HashMap<>();
        greenSixOut.put(Resource.COIN, 0);
        greenSixOut.put(Resource.ROCK, 3);
        greenSixOut.put(Resource.SERVANT, 0);
        greenSixOut.put(Resource.SHIELD, 0);
        ProductionCard cardEighteen =new ProductionCard(greenSix, greenSixIn, greenSixOut, 6, 2, green, 0,18 );
        deck.add(cardEighteen);



        Map<Resource,Integer> greenSeven =new HashMap<>();
        greenSeven.put(Resource.COIN, 0);
        greenSeven.put(Resource.ROCK, 0);
        greenSeven.put(Resource.SERVANT, 0);
        greenSeven.put(Resource.SHIELD, 5);
        Map<Resource,Integer> greenSevenIn =new HashMap<>() ;
        greenSevenIn.put(Resource.COIN, 2);
        greenSevenIn.put(Resource.ROCK, 0);
        greenSevenIn.put(Resource.SERVANT, 0);
        greenSevenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenSevenOut =new HashMap<>();
        greenSevenOut.put(Resource.COIN, 0);
        greenSevenOut.put(Resource.ROCK, 2);
        greenSevenOut.put(Resource.SERVANT, 0);
        greenSevenOut.put(Resource.SHIELD, 0);
        ProductionCard cardNineteen =new ProductionCard(greenSeven, greenSevenIn, greenSevenOut, 7, 2, green, 2,19);
        deck.add(cardNineteen);


        Map<Resource,Integer> greenEight =new HashMap<>();
        greenEight.put(Resource.COIN, 3);
        greenEight.put(Resource.ROCK, 0);
        greenEight.put(Resource.SERVANT, 0);
        greenEight.put(Resource.SHIELD, 3);
        Map<Resource,Integer> greenEightIn =new HashMap<>() ;
        greenEightIn.put(Resource.COIN, 1);
        greenEightIn.put(Resource.ROCK, 0);
        greenEightIn.put(Resource.SERVANT, 0);
        greenEightIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenEightOut =new HashMap<>();
        greenEightOut.put(Resource.COIN, 0);
        greenEightOut.put(Resource.ROCK, 0);
        greenEightOut.put(Resource.SERVANT, 0);
        greenEightOut.put(Resource.SHIELD, 2);
        ProductionCard cardTwenty =new ProductionCard(greenEight, greenEightIn, greenEightOut, 8, 2, green, 1,20);
        deck.add(cardTwenty);

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
            config = new FileWriter("fileConfiguration/DeckProductionCardTwoGreenLatest.json");
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


    public DeckProductionCardTwoGreen(ProductionCard[] deckRecover) throws IOException, InterruptedException {
        this.deck = new ArrayList<>();
        deckNumber = 5;
        int l=deckRecover.length;
        for(int i=0; i < l; i++)
            deck.add(deckRecover[i]);


    }

    @Override
    public ArrayList<Integer> getDeck(){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < deck.size(); i++){
            list.add(deck.get(i).getKey());
        }
        return list;
    }

}
