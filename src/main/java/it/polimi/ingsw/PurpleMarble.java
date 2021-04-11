package it.polimi.ingsw;
/**
 * class for yellowMarble, only 2 objects instantiated in Market
 */
public class PurpleMarble extends Marble{

    /**
     * @param player
     * addResource.servant to player
     */
    public void giveResource(Player player) {
        try {
            Reserve.getResource(Resource.SERVANT);
            player.addToBuffer(Resource.SERVANT);
        } catch (UnavailableResourceException ignored) {}

    }
}
