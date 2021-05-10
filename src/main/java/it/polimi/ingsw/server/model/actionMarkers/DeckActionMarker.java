package it.polimi.ingsw.server.model.actionMarkers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.Observer.Observable;
import it.polimi.ingsw.messages.observable.ActionMarkerChangeMessage;
import it.polimi.ingsw.messages.observable.ActionMarkerConfigMessage;
import it.polimi.ingsw.server.model.RuntimeTypeAdapterFactory;
import it.polimi.ingsw.server.model.Mix;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.gameBoard.*;
import it.polimi.ingsw.server.model.leaderCards.*;
import it.polimi.ingsw.server.model.requirements.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public DeckActionMarker(){

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

        notifyObserver(new ActionMarkerConfigMessage(actionMarkerDeck));

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
    public void mixDeck(){
        Mix.MIXED(actionMarkerDeck);
        notifyObserver(new ActionMarkerChangeMessage(actionMarkerDeck));
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
            config = new FileWriter("src/main/resources/DeckActionMarker.json");
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




    public Gson DeckActionMarkerSaving(){

        RuntimeTypeAdapterFactory<Storage> adapterStorage =
                RuntimeTypeAdapterFactory
                        .of(Storage.class)
                        .registerSubtype(Storage.class)
                        .registerSubtype(StorageExtraFirst.class)
                        .registerSubtype(StorageExtraSecond.class);


        RuntimeTypeAdapterFactory<Colour> adapterColour =
                RuntimeTypeAdapterFactory
                        .of(Colour.class)
                        .registerSubtype(Green.class)
                        .registerSubtype(Yellow.class)
                        .registerSubtype(Blue.class)
                        .registerSubtype(Violet.class);

        RuntimeTypeAdapterFactory<GameBoardInterface> adapterGameBoard =
                RuntimeTypeAdapterFactory
                        .of(GameBoardInterface.class)
                        .registerSubtype(GameBoard.class)
                        .registerSubtype(ProductionGameBoardDouble.class)
                        .registerSubtype(ProductionGameBoard.class)
                        .registerSubtype(WhiteMarbleGameBoard.class)
                        .registerSubtype(WhiteMarbleGameBoardDouble.class)
                        .registerSubtype(ReductionGameBoard.class)
                        .registerSubtype(ReductionGameBoardDouble.class);


        RuntimeTypeAdapterFactory<Requirements> adapterRequirements =
                RuntimeTypeAdapterFactory
                        .of(Requirements.class)
                        .registerSubtype(ResourceRequirement.class)
                        .registerSubtype(SecondLevelRequirement.class)
                        .registerSubtype(ThreeFlagsTwoColourRequirement.class)
                        .registerSubtype(TwoFlagsTwoColourRequirement.class);

        RuntimeTypeAdapterFactory<LeaderCard> adapterLeader =
                RuntimeTypeAdapterFactory
                        .of(LeaderCard.class)
                        .registerSubtype(LeaderCardMarble.class)
                        .registerSubtype(LeaderCardProduction.class)
                        .registerSubtype(LeaderCardReduction.class)
                        .registerSubtype(LeaderCardStorage.class);


        RuntimeTypeAdapterFactory<ActionMarker> adapterAction =
                RuntimeTypeAdapterFactory
                        .of(ActionMarker.class)
                        .registerSubtype(ActionMarker.class)
                        .registerSubtype(ActionMarkerProductionViolet.class)
                        .registerSubtype(ActionMarkerProductionYellow.class)
                .registerSubtype(ActionMarkerProductionGreen.class)
                .registerSubtype(ActionMarkerProductionBlue.class)
                        .registerSubtype(ActionMarkerForCrossDouble.class)
                        .registerSubtype(ActionMarkerForCrossOnce.class)
                ;


        Gson gson=new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapterFactory(adapterAction)
                .registerTypeAdapterFactory(adapterGameBoard)
                .registerTypeAdapterFactory(adapterStorage)
                .registerTypeAdapterFactory(adapterColour)
                .registerTypeAdapterFactory(adapterRequirements)
                .registerTypeAdapterFactory(adapterLeader)
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
            actionMarkerDeck.add(list[i]);

        notifyObserver(new ActionMarkerConfigMessage(actionMarkerDeck));
    }}
