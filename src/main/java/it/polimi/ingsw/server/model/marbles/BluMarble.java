package it.polimi.ingsw.server.model.marbles;

import it.polimi.ingsw.server.model.players.Player;
import it.polimi.ingsw.server.model.Resource;

/**
 * this class represents the blue marble
 */
public class BluMarble extends Marble {

    /**
     * this class adds a shield recourse to the player buffer by calling the addToBuffer method of the player class
     * @param player : the one that has bought from the market
     */
    public void giveResource(Player player) {
        player.addToBuffer(Resource.SHIELD);
    }
}
