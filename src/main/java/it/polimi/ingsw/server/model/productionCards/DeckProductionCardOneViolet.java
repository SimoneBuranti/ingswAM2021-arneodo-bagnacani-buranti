package it.polimi.ingsw.server.model.productionCards;

import com.google.gson.Gson;
import it.polimi.ingsw.messages.DeckProductionCardConfigMessage;
import it.polimi.ingsw.server.model.Mix;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.Violet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


/**
 * this class represents the first level violet production card deck
 */
public class DeckProductionCardOneViolet extends DeckProductionCard {
    /**
     * file for initial configuration
     */

    FileWriter configDeckVioletOne = null;

    /**
     * this constructor creates all the production cards and adds them to the list and shuffles the newly created deck
     */
    public  DeckProductionCardOneViolet (){


        Violet violet= new Violet();
        deck = new ArrayList<>(4);
        Map<Resource,Integer> violetOne =new HashMap<>();
        violetOne.put(Resource.COIN, 0);
        violetOne.put(Resource.ROCK, 0);
        violetOne.put(Resource.SERVANT, 2);
        violetOne.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetOneIn=new HashMap<>() ;
        violetOneIn.put(Resource.COIN, 0);
        violetOneIn.put(Resource.ROCK, 1);
        violetOneIn.put(Resource.SERVANT, 0);
        violetOneIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetOneOut=new HashMap<>();
        violetOneOut.put(Resource.COIN, 0);
        violetOneOut.put(Resource.ROCK, 0);
        violetOneOut.put(Resource.SERVANT, 0);
        violetOneOut.put(Resource.SHIELD, 0);
        ProductionCard cardOne =new ProductionCard(violetOne,violetOneIn,violetOneOut, 1, 1, violet,1,1);
        deck.add(cardOne);

        Map<Resource,Integer> violetTwo =new HashMap<>();
        violetTwo.put(Resource.COIN, 1);
        violetTwo.put(Resource.ROCK, 0);
        violetTwo.put(Resource.SERVANT, 1);
        violetTwo.put(Resource.SHIELD, 1);
        Map<Resource,Integer> violetTwoIn=new HashMap<>() ;
        violetTwoIn.put(Resource.COIN, 1);
        violetTwoIn.put(Resource.ROCK, 0);
        violetTwoIn.put(Resource.SERVANT, 0);
        violetTwoIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetTwoOut=new HashMap<>();
        violetTwoOut.put(Resource.COIN, 0);
        violetTwoOut.put(Resource.ROCK, 0);
        violetTwoOut.put(Resource.SERVANT, 0);
        violetTwoOut.put(Resource.SHIELD, 1);
        ProductionCard cardTwo =new ProductionCard(violetTwo,violetTwoIn,violetTwoOut, 2, 1, violet, 0, 2);
        deck.add(cardTwo);



        Map<Resource,Integer> violetThree =new HashMap<>();
        violetThree.put(Resource.COIN, 0);
        violetThree.put(Resource.ROCK, 0);
        violetThree.put(Resource.SERVANT, 3);
        violetThree.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetThreeIn=new HashMap<>() ;
        violetThreeIn.put(Resource.COIN, 2);
        violetThreeIn.put(Resource.ROCK, 0);
        violetThreeIn.put(Resource.SERVANT, 0);
        violetThreeIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetThreeOut=new HashMap<>();
        violetThreeOut.put(Resource.COIN, 0);
        violetThreeOut.put(Resource.ROCK, 1);
        violetThreeOut.put(Resource.SERVANT, 1);
        violetThreeOut.put(Resource.SHIELD, 1);
        ProductionCard cardThree =new ProductionCard(violetThree,violetThreeIn,violetThreeOut, 3, 1, violet, 0, 3);
        deck.add(cardThree);


        Map<Resource,Integer> violetFour =new HashMap<>();
        violetFour.put(Resource.COIN, 0);
        violetFour.put(Resource.ROCK, 2);
        violetFour.put(Resource.SERVANT, 2);
        violetFour.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetFourIn=new HashMap<>() ;
        violetFourIn.put(Resource.COIN, 1);
        violetFourIn.put(Resource.ROCK, 0);
        violetFourIn.put(Resource.SERVANT, 0);
        violetFourIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> violetFourOut=new HashMap<>();
        violetFourOut.put(Resource.COIN, 0);
        violetFourOut.put(Resource.ROCK, 2);
        violetFourOut.put(Resource.SERVANT, 0);
        violetFourOut.put(Resource.SHIELD, 0);
        ProductionCard cardSecond =new ProductionCard(violetFour,violetFourIn,violetFourOut, 4, 1, violet, 1, 4);
        deck.add(cardSecond);

        Mix.MIXED(deck);

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(deck.get(0).getKey());
        list.add(deck.get(1).getKey());
        list.add(deck.get(2).getKey());
        list.add(deck.get(3).getKey());
        notifyObserver(new DeckProductionCardConfigMessage(2,list));

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
            config = new FileWriter("src/main/resources/DeckProductionCardOneVioletLatest.json");
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

    /**
     * this constructor creates all the production cards and adds them to the list and shuffles the newly created deck
     */
    public DeckProductionCardOneViolet(ProductionCard[] deckRecover){
        this.deck = new ArrayList<>();
        deck = new ArrayList<>();
        int l=deckRecover.length;
        for(int i=0; i < l; i++)
            deck.add(deckRecover[i]);


        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i < deck.size(); i++)
            list.add(deck.get(i).getKey());

        notifyObserver(new DeckProductionCardConfigMessage(2,list));
    }}




