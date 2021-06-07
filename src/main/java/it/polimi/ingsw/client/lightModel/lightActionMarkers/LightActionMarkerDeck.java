package it.polimi.ingsw.client.lightModel.lightActionMarkers;

import it.polimi.ingsw.client.lightModel.LightGameSolitaire;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class represents the action markers deck of the light model
 */
public class LightActionMarkerDeck{
    /**
     * This attribute collects all the types of action markers
     */
    ArrayList<LightActionMarker> deck;

    /**
     * This constructor adds all the types of action markers to the deck
     */
    public LightActionMarkerDeck(){
        deck = new ArrayList<>();

        LightActionMarker actionMarkerBlue = new LightActionMarkerProductionBlue();
        deck.add(actionMarkerBlue);
        LightActionMarker actionMarkerGreen = new LightActionMarkerProductionGreen();
        deck.add(actionMarkerGreen);
        LightActionMarker actionMarkerViolet = new LightActionMarkerProductionViolet();
        deck.add(actionMarkerViolet);
        LightActionMarker actionMarkerYellow = new LightActionMarkerProductionYellow();
        deck.add(actionMarkerYellow);
        LightActionMarker actionMarkerCrossOnce = new LightActionMarkerForCrossOnce();
        deck.add(actionMarkerCrossOnce);
        LightActionMarker actionMarkerCrossDouble = new LightActionMarkerForCrossDouble();
        deck.add(actionMarkerCrossDouble);
    }

    /**
     * This method activates the effect of the type of action marker passed as a parameter
     * @param type : the type of action marker
     */
    public void actionMarkerEffect(String type, LightGameSolitaire game) throws IOException, InterruptedException {
        for(LightActionMarker actionMarker: deck){
            if(actionMarker.getType().equals(type))
                actionMarker.actionMarkerEffect(game);
        }
    }
}
