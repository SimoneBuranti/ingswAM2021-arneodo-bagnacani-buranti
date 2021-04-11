package it.polimi.ingsw.model;
/**
 * class for yellowMarble, only 2 objects instantiated in Market
 */
public class PurpleMarble extends Marble{

    /**
     * @param player
     * addResource.servant to player
     */
    public void giveResource(Player player) {
        player.addToBuffer(Resource.SERVANT);
    }
}
