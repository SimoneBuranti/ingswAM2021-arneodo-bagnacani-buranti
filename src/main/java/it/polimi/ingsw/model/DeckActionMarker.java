package it.polimi.ingsw.model;

import java.util.ArrayList;

/**
 * this class represents the action marker deck
 */
public class DeckActionMarker {
    /**
     * this attribute collects the action markers of the deck
     */
    private final ArrayList<ActionMarker> actionMarkerDeck;

    /**
     * this constructor create all action markers and add them to the list and shuffle the newly created deck
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
    }

    /**
     * this method returns the first action marker of the deck after putting it in the last place of the list and
     * after moving all the action markers of the deck forward one position in the list
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
     * this method show the first action marker of the deck by returning it
     * this method has been implemented for testing
     * @return ActionMarker: the action marker in zero position in the list
     */
    public ActionMarker showFirst(){
        return actionMarkerDeck.get(0);
    }
}
