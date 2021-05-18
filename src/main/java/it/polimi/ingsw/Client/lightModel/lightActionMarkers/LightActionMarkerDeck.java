package it.polimi.ingsw.client.lightModel.lightActionMarkers;

import it.polimi.ingsw.client.lightModel.LightGameSolitaire;

import java.io.IOException;
import java.util.ArrayList;

public class LightActionMarkerDeck{
    ArrayList<LightActionMarker> deck;

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

    public void actionMarkerEffect(String type, LightGameSolitaire game) throws IOException, InterruptedException {
        for(LightActionMarker actionMarker: deck){
            if(actionMarker.getType().equals(type))
                actionMarker.actionMarkerEffect(game);
        }
    }
}
