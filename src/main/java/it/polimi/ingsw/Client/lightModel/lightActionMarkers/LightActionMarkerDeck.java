package it.polimi.ingsw.Client.lightModel.lightActionMarkers;

import it.polimi.ingsw.server.model.actionMarkers.*;

import java.util.ArrayList;

public class LightActionMarkerDeck{
    ArrayList<ActionMarker> deck;

    public LightActionMarkerDeck(){
        deck = new ArrayList<>();
    }

    public void setDeck(ArrayList<ActionMarker> deck){
        this.deck = deck;
    }

    public void useActionMarker(){
        ActionMarker temp = deck.remove(0);
        deck.add(temp);
    }
}
