package it.polimi.ingsw.server.model.productionCards;

import com.google.gson.Gson;
import it.polimi.ingsw.server.model.colours.Green;
import it.polimi.ingsw.server.model.Mix;
import it.polimi.ingsw.server.model.Resource;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * this class represents the first level green production card deck
 */
public class DeckProductionCardOneGreen extends DeckProductionCard {

    /**
     * this constructor creates all the production cards and adds them to the list and shuffles the newly created deck
     */
    public   DeckProductionCardOneGreen () throws IOException, InterruptedException {

        deckNumber = 9;

        Green green= new Green();
        deck = new ArrayList<>(4);
        Map<Resource,Integer> greenOne =new HashMap<>();
        greenOne.put(Resource.COIN, 0);
        greenOne.put(Resource.ROCK, 0);
        greenOne.put(Resource.SERVANT, 0);
        greenOne.put(Resource.SHIELD, 2);
        Map<Resource,Integer> greenOneIn =new HashMap<>() ;
        greenOneIn.put(Resource.COIN, 1);
        greenOneIn.put(Resource.ROCK, 0);
        greenOneIn.put(Resource.SERVANT, 0);
        greenOneIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenOneOut =new HashMap<>();
        greenOneOut.put(Resource.COIN, 0);
        greenOneOut.put(Resource.ROCK, 0);
        greenOneOut.put(Resource.SERVANT, 0);
        greenOneOut.put(Resource.SHIELD, 0);
        ProductionCard cardThirteen =new ProductionCard(greenOne, greenOneIn, greenOneOut, 1, 1, green ,1,13);
        deck.add(cardThirteen);

        Map<Resource,Integer> greenTwo =new HashMap<>();
        greenTwo.put(Resource.COIN, 0);
        greenTwo.put(Resource.ROCK, 1);
        greenTwo.put(Resource.SERVANT, 1);
        greenTwo.put(Resource.SHIELD, 1);
        Map<Resource,Integer> greenTwoIn =new HashMap<>() ;
        greenTwoIn.put(Resource.COIN, 0);
        greenTwoIn.put(Resource.ROCK, 1);
        greenTwoIn.put(Resource.SERVANT, 0);
        greenTwoIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenTwoOut =new HashMap<>();
        greenTwoOut.put(Resource.COIN, 0);
        greenTwoOut.put(Resource.ROCK, 0);
        greenTwoOut.put(Resource.SERVANT, 1);
        greenTwoOut.put(Resource.SHIELD, 0);
        ProductionCard cardFourteen =new ProductionCard(greenTwo, greenTwoIn, greenTwoOut, 2, 1, green, 0,14);
        deck.add(cardFourteen);



        Map<Resource,Integer> greenThree =new HashMap<>();
        greenThree.put(Resource.COIN, 0);
        greenThree.put(Resource.ROCK, 0);
        greenThree.put(Resource.SERVANT, 0);
        greenThree.put(Resource.SHIELD, 3);
        Map<Resource,Integer> greenThreeIn =new HashMap<>() ;
        greenThreeIn.put(Resource.COIN, 0);
        greenThreeIn.put(Resource.ROCK, 0);
        greenThreeIn.put(Resource.SERVANT, 2);
        greenThreeIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenThreeOut =new HashMap<>();
        greenThreeOut.put(Resource.COIN, 1);
        greenThreeOut.put(Resource.ROCK, 1);
        greenThreeOut.put(Resource.SERVANT, 0);
        greenThreeOut.put(Resource.SHIELD, 1);
        ProductionCard cardFifteen =new ProductionCard(greenThree, greenThreeIn, greenThreeOut, 3, 1, green, 0,15);
        deck.add(cardFifteen);


        Map<Resource,Integer> greenFour =new HashMap<>();
        greenFour.put(Resource.COIN, 2);
        greenFour.put(Resource.ROCK, 0);
        greenFour.put(Resource.SERVANT, 0);
        greenFour.put(Resource.SHIELD, 2);
        Map<Resource,Integer> greenFourIn =new HashMap<>() ;
        greenFourIn.put(Resource.COIN, 0);
        greenFourIn.put(Resource.ROCK, 1);
        greenFourIn.put(Resource.SERVANT, 1);
        greenFourIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenFourOut =new HashMap<>();
        greenFourOut.put(Resource.COIN, 2);
        greenFourOut.put(Resource.ROCK, 0);
        greenFourOut.put(Resource.SERVANT, 0);
        greenFourOut.put(Resource.SHIELD, 0);
        ProductionCard cardSixteen =new ProductionCard(greenFour, greenFourIn, greenFourOut, 4, 1,green, 1,16);
        deck.add(cardSixteen);

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
            config = new FileWriter("src/main/resources/fileConfiguration/DeckProductionCardOneGreenLatest.json");
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
    public DeckProductionCardOneGreen(ProductionCard[] deckRecover) throws IOException, InterruptedException {
        this.deck = new ArrayList<>();
        deckNumber = 9;
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

