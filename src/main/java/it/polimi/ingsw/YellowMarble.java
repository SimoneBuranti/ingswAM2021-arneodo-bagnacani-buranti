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
        try {
            Reserve.getResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
        }
        player.addToBuffer(Resource.COIN);


    }
}
