package it.polimi.ingsw.server.model.marbles;

import it.polimi.ingsw.server.model.players.Player;
import it.polimi.ingsw.server.model.Resource;

/**
 * this class represents the purple marble
 */
public class PurpleMarble extends Marble {

    public PurpleMarble(){
      this.colour = "purple";
    }

    /**
     * this class adds a servant recourse to the player buffer by calling the addToBuffer method of the player class
     * @param player : the one that has bought from the market
     */
    public void giveResource(Player player) {
        player.addToBuffer(Resource.SERVANT);
    }
}
