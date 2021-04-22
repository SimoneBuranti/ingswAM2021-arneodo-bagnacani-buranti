package it.polimi.ingsw.model.marbles;

import it.polimi.ingsw.model.players.Player;
import it.polimi.ingsw.model.Resource;

/**
 * this class represents the purple marble
 */
public class PurpleMarble extends Marble {

    /**
     * this class adds a servant recourse to the player buffer by calling the addToBuffer method of the player class
     * @param player : the one that has bought from the market
     */
    public void giveResource(Player player) {
        player.addToBuffer(Resource.SERVANT);
    }
}
