package it.polimi.ingsw.server.model.actionMarkers;

import com.google.gson.Gson;
import it.polimi.ingsw.server.model.Mix;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * this class represents the action marker deck
 */
public class DeckActionMarker {



    /**
     * file for initial configuration
     */

    private FileWriter configActionMarker= null;





    /**
     * this attribute collects the action markers of the deck
     */
    private final ArrayList<ActionMarker> actionMarkerDeck;

    /**
     * this constructor creates all the action markers and adds them to the list and shuffles the newly created deck
     */
    public DeckActionMarker(){
        String JSONArray = null;
        Gson g = new Gson();
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
        List<String> list = new ArrayList<String>();
        list.add(actionMarkerDeck.get(0).getType());
        list.add(actionMarkerDeck.get(1).getType());
        list.add(actionMarkerDeck.get(2).getType());
        list.add(actionMarkerDeck.get(3).getType());
        list.add(actionMarkerDeck.get(4).getType());
        list.add(actionMarkerDeck.get(5).getType());
        list.add(actionMarkerDeck.get(6).getType());



        String jsonStr = g.toJson(list);

        try {

            // Constructs a FileWriter given a file name, using the platform's default charset
            configActionMarker = new FileWriter("src/main/resources/configActionMarker.json");
            configActionMarker.write(jsonStr);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                configActionMarker.flush();
                configActionMarker.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }





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
    }

    /**
     * Test only method: this method show the first action marker of the deck by returning it
     * @return ActionMarker: the action marker in zero position in the list
     */
    public ActionMarker showFirst(){
        return actionMarkerDeck.get(0);
    }
}
