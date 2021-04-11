package it.polimi.ingsw;

/**
 * class for greyMarble, only 2 objects instantiated in Market
 */
public class GreyMarble extends Marble{

    /**
     * @param player
     * addResource.Rock to player
     */
    public void giveResource(Player player)  {

        player.addToBuffer(Resource.ROCK);

    }
}
