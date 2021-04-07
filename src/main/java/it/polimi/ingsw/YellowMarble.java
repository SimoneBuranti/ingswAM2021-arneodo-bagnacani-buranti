package it.polimi.ingsw;
/**
 * class for yellowMarble, only 2 objects instantiated in Market
 */
public class YellowMarble extends Marble{
    /**
     * @param player
     * addresource.coin to player
     */

    public void giveResource(Player player) {
        try {
            Reserve.getResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        player.addToBuffer(Resource.COIN);


    }
}
