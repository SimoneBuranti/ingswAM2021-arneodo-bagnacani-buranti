package it.polimi.ingsw.server.model.actionMarkers;


import it.polimi.ingsw.server.model.exceptions.EmptyException;
import it.polimi.ingsw.server.model.exceptions.EndOfSolitaireGame;
import it.polimi.ingsw.server.model.GameSolitaire;

/**
 * This interface represents the action markers and contains only one method not implemented
 */
public  class  ActionMarker{

    /**
     * method not implemented that represents the effect of the action marker
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(GameSolitaire game) throws EmptyException, EndOfSolitaireGame{};

    /**
     * @return type of object
     */
    public String getType(){return null;};
}
