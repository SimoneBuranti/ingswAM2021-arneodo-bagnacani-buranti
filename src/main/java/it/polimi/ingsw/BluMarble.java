package it.polimi.ingsw;

/**
 * class for blueMarble, only 2 objects instantiated in Market
 */
public class BluMarble extends Marble{

    /**
     * @param player
     * addResource.shield to player
     */
    public void giveResource(Player player) {
        try {
            Reserve.getResource(Resource.SHIELD);
            player.addToBuffer(Resource.SHIELD);
        } catch (UnavailableResourceException ignored) {}

        }
    }

