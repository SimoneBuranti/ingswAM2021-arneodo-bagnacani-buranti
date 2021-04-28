package it.polimi.ingsw.server.model.marbles;

import it.polimi.ingsw.server.model.players.Player;
import it.polimi.ingsw.server.model.Resource;

/**
 * this class represents the grey marble
 */
public class GreyMarble extends Marble {
    /**
     * colour marble
     */
    private String colour= "grey";


   @Override
    public String getColour() {
        return colour;
    }

    /**
     * this class adds a rock recourse to the player buffer by calling the addToBuffer method of the player class
     * @param player : the one that has bought from the market
     */
    public void giveResource(Player player)  {

        player.addToBuffer(Resource.ROCK);

    }
}
