package it.polimi.ingsw;

/**
 * class for greyMarble, only 2 objects instantiated in Market
 */
public class GreyMarble extends Marble{


    public void giveResource(Player player)  {
        /**
         * @param player
         * addresource.Rock to player
         */
        try {
            Reserve.getResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        player.addToBuffer(Resource.ROCK);


    }
}
