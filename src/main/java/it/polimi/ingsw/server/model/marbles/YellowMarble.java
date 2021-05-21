package it.polimi.ingsw.server.model.marbles;


import it.polimi.ingsw.server.model.players.Player;
import it.polimi.ingsw.server.model.Resource;

/**
 * this class represents the yellow marble
 */
public class YellowMarble extends Marble {


    public YellowMarble(){
        this.colour = "yellow";
    }

    /**
     * this class adds a coin recourse to the player buffer by calling the addToBuffer method of the player class
     * @param player : the one that has bought from the market
     */
    public void giveResource(Player player) {
        player.addToBuffer(Resource.COIN);
    }
}
