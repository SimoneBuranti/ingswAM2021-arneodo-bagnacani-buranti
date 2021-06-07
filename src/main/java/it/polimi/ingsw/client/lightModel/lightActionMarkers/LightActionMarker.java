package it.polimi.ingsw.client.lightModel.lightActionMarkers;


import it.polimi.ingsw.client.lightModel.LightGameSolitaire;

import java.io.IOException;

/**
 * This class represents the action markers of the light model
 */
public abstract  class LightActionMarker {

    /**
     * method not implemented that represents the effect of the action marker
     * @param game : the instantiated solitaire game a player is playing
     */
    public void actionMarkerEffect(LightGameSolitaire game) throws IOException, InterruptedException {};

    /**
     * @return type of action marker
     */
    public String getType(){return null;};
}
