package it.polimi.ingsw.server.model.productionCards;

import com.google.gson.Gson;
import it.polimi.ingsw.messages.observable.DeckProductionCardConfigMessage;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.Mix;
import it.polimi.ingsw.server.model.Resource;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * this class represents the first level blue production card deck
 */
public class DeckProductionCardOneBlu extends DeckProductionCard {

    /**
     * this constructor creates all the production cards and adds them to the list and shuffles the newly created deck
     */
    public DeckProductionCardOneBlu() throws IOException, InterruptedException {

        deckNumber = 0;

        Blue blue= new Blue();
        deck = new ArrayList<>(4);
        Map<Resource,Integer> blueOne =new HashMap<>();
        blueOne.put(Resource.COIN, 2);
        blueOne.put(Resource.ROCK, 0);
        blueOne.put(Resource.SERVANT, 0);
        blueOne.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueOneIn =new HashMap<>() ;
        blueOneIn.put(Resource.COIN, 0);
        blueOneIn.put(Resource.ROCK, 0);
        blueOneIn.put(Resource.SERVANT, 0);
        blueOneIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> blueOneOut =new HashMap<>();
        blueOneOut.put(Resource.COIN, 0);
        blueOneOut.put(Resource.ROCK, 0);
        blueOneOut.put(Resource.SERVANT, 0);
        blueOneOut.put(Resource.SHIELD, 0);
        ProductionCard cardThirtySeven=new ProductionCard(blueOne, blueOneIn, blueOneOut, 1, 1, blue ,1,1);
        deck.add(cardThirtySeven);

        Map<Resource,Integer> blueTwo =new HashMap<>();
        blueTwo.put(Resource.COIN, 1);
        blueTwo.put(Resource.ROCK, 1);
        blueTwo.put(Resource.SERVANT, 1);
        blueTwo.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueTwoIn =new HashMap<>() ;
        blueTwoIn.put(Resource.COIN, 0);
        blueTwoIn.put(Resource.ROCK, 0);
        blueTwoIn.put(Resource.SERVANT, 1);
        blueTwoIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueTwoOut=new HashMap<>();
        blueTwoOut.put(Resource.COIN, 0);
        blueTwoOut.put(Resource.ROCK, 1);
        blueTwoOut.put(Resource.SERVANT, 0);
        blueTwoOut.put(Resource.SHIELD, 0);
        ProductionCard cardThirtyEight =new ProductionCard(blueTwo, blueTwoIn,blueTwoOut, 2, 1, blue, 0, 2);
        deck.add(cardThirtyEight);



        Map<Resource,Integer> blueThree =new HashMap<>();
        blueThree.put(Resource.COIN, 3);
        blueThree.put(Resource.ROCK, 0);
        blueThree.put(Resource.SERVANT, 0);
        blueThree.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueThreeIn =new HashMap<>() ;
        blueThreeIn.put(Resource.COIN, 0);
        blueThreeIn.put(Resource.ROCK, 2);
        blueThreeIn.put(Resource.SERVANT, 0);
        blueThreeIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueThreeOut =new HashMap<>();
        blueThreeOut.put(Resource.COIN, 1);
        blueThreeOut.put(Resource.ROCK, 0);
        blueThreeOut.put(Resource.SERVANT, 1);
        blueThreeOut.put(Resource.SHIELD, 1);
        ProductionCard cardThirtyNine =new ProductionCard(blueThree, blueThreeIn, blueThreeOut, 3, 1, blue, 0,3);
        deck.add(cardThirtyNine);


        Map<Resource,Integer> blueFour =new HashMap<>();
        blueFour.put(Resource.COIN, 2);
        blueFour.put(Resource.ROCK, 0);
        blueFour.put(Resource.SERVANT, 2);
        blueFour.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueFourIn =new HashMap<>() ;
        blueFourIn.put(Resource.COIN, 0);
        blueFourIn.put(Resource.ROCK, 1);
        blueFourIn.put(Resource.SERVANT, 0);
        blueFourIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> blueFourOut=new HashMap<>();
        blueFourOut.put(Resource.COIN, 0);
        blueFourOut.put(Resource.ROCK, 0);
        blueFourOut.put(Resource.SERVANT, 2);
        blueFourOut.put(Resource.SHIELD, 0);
        ProductionCard cardForty =new ProductionCard(blueFour, blueFourIn,blueFourOut, 4, 1,blue, 1,4);
        deck.add(cardForty);

        Mix.MIXED(deck);



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
            config = new FileWriter("src/main/resources/DeckProductionCardOneBluLatest.json");
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
    public DeckProductionCardOneBlu(ProductionCard[] deckRecover) throws IOException, InterruptedException {
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
