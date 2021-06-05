package it.polimi.ingsw.server.model.actionMarkers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.observer.Observable;
import it.polimi.ingsw.server.model.RuntimeTypeAdapterFactory;
import it.polimi.ingsw.server.model.Mix;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.gameBoard.*;
import it.polimi.ingsw.server.model.leaderCards.*;
import it.polimi.ingsw.server.model.requirements.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * this class represents the action marker deck
 */
public class DeckActionMarker extends Observable {



    /**
     * file for initial configuration
     */

    private FileWriter configActionMarker= null;

    /**
     * this attribute collects the action markers of the deck
     */
    private  ArrayList<ActionMarker> actionMarkerDeck;

    /**
     * this constructor creates all the action markers and adds them to the list and shuffles the newly created deck
     */
    public DeckActionMarker() throws IOException, InterruptedException {

        actionMarkerDeck = new ArrayList<>(7);
        ActionMarker actionMarkerBlue = new ActionMarkerProductionBlue();
        actionMarkerDeck.add(actionMarkerBlue);
        ActionMarker actionMarkerGreen = new ActionMarkerProductionGreen();
        actionMarkerDeck.add(actionMarkerGreen);
        ActionMarker actionMarkerViolet = new ActionMarkerProductionViolet();
        actionMarkerDeck.add(actionMarkerViolet);
        ActionMarker actionMarkerYellow = new ActionMarkerProductionYellow();
        actionMarkerDeck.add(actionMarkerYellow);
        ActionMarker actionMarkerCrossOnce = new ActionMarkerForCrossOnce();
        actionMarkerDeck.add(actionMarkerCrossOnce);
        ActionMarker actionMarkerCrossDouble = new ActionMarkerForCrossDouble();
        actionMarkerDeck.add(actionMarkerCrossDouble);
        ActionMarker actionMarkerCrossDoubleSecond = new ActionMarkerForCrossDouble();
        actionMarkerDeck.add(actionMarkerCrossDoubleSecond);

        Mix.MIXED(actionMarkerDeck);


        }



    /**
     * this method returns the first action marker of the deck after putting it in the last place of the list and
     * moving all the action markers of the deck forward one position in the list
     * @return ActionMarker: the first action marker of the deck
     */
    public ActionMarker pickUpFirstCard(){
        ActionMarker firstCard = actionMarkerDeck.get(0);

        for(int i = 0; i < actionMarkerDeck.size()-1; i++)
            actionMarkerDeck.set(i ,actionMarkerDeck.get(i+1));

        actionMarkerDeck.set(actionMarkerDeck.size()-1, firstCard);

        return firstCard;
    }

    /**
     * this method mixes the action markers of the deck
     */
    public void mixDeck() {
        Mix.MIXED(actionMarkerDeck);

    }

    /**
     * Test only method: this method show the first action marker of the deck by returning it
     * @return ActionMarker: the action marker in zero position in the list
     */
    public ActionMarker showFirst(){
        return actionMarkerDeck.get(0);
    }


    /**
     * method for saveInformationOfActionMarker
     */
    public void saveInformationOfActionMarker(){
        Gson gson=DeckActionMarkerSaving();

        FileWriter config = null;
        String jsonStrin = gson.toJson(actionMarkerDeck);
        try {
            // Constructs a FileWriter given a file name, using the platform's default charset
            config = new FileWriter("src/main/resources/fileConfiguration/DeckActionMarker.json");
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
     * @return Gson adapter for deckactionMarker saving and restoring
     */

    public static Gson DeckActionMarkerSaving(){


        RuntimeTypeAdapterFactory<ActionMarker> adapterAction =
                RuntimeTypeAdapterFactory
                        .of(ActionMarker.class)
                        .registerSubtype(ActionMarkerProductionViolet.class)
                        .registerSubtype(ActionMarkerProductionYellow.class)
                        .registerSubtype(ActionMarkerProductionGreen.class)
                        .registerSubtype(ActionMarkerProductionBlue.class)
                        .registerSubtype(ActionMarkerForCrossDouble.class)
                        .registerSubtype(ActionMarkerForCrossOnce.class);


        Gson gson=new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapterFactory(adapterAction)
                .create();

        return gson;
    }


    /**
     * this constructor creates all the action markers and adds them to the list and shuffles the newly created deck
     */
    public DeckActionMarker(ActionMarker[] list){
        this.actionMarkerDeck =new ArrayList<ActionMarker>();
        int l=list.length;
        for(int i=0; i < l; i++)
            actionMarkerDeck.add(list[i]); }}
