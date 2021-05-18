package it.polimi.ingsw.lightModel.lightActionMarkers;


import it.polimi.ingsw.lightModel.LightGameSolitaire;

import java.io.IOException;

/**
 * This interface represents the action markers and contains only one method not implemented
 */
public  class LightActionMarker {

    /**
     * method not implemented that represents the effect of the action marker
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(LightGameSolitaire game) throws IOException, InterruptedException {};

    /**
     * @return type of object
     */
    public String getType(){return null;};
}
