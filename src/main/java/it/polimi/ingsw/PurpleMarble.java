package it.polimi.ingsw;
/**
 * class for yellowMarble, only 2 objects instantiated in Market
 */
public class PurpleMarble extends Marble{

    /**
     * @param player
     * addresource.servant to player
     */
    public void giveResource(Player player) {
        try {
            Reserve.getResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        player.addToBuffer(Resource.SERVANT);


    }
}
