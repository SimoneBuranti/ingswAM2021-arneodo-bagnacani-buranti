package it.polimi.ingsw.Client.lightModel.lightActionMarkers;


import it.polimi.ingsw.Client.lightModel.LightGame;
import it.polimi.ingsw.Client.lightModel.LightGameSolitaire;
import it.polimi.ingsw.server.model.GameSolitaire;
import it.polimi.ingsw.server.model.exceptions.EmptyException;
import it.polimi.ingsw.server.model.exceptions.EndOfSolitaireGame;

/**
 * This interface represents the action markers and contains only one method not implemented
 */
public  class LightActionMarker {

    /**
     * method not implemented that represents the effect of the action marker
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(LightGameSolitaire game){};

    /**
     * @return type of object
     */
    public String getType(){return null;};
}
