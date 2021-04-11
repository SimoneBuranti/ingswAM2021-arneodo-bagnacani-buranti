package it.polimi.ingsw;
/**
 * class for yellowMarble, only 2 objects instantiated in Market
 */
public class YellowMarble extends Marble{
    /**
     * @param player
     * addResource.coin to player
     */

    public void giveResource(Player player) {
        player.addToBuffer(Resource.COIN);
    }
}
