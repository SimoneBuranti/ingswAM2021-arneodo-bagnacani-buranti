package it.polimi.ingsw.model;

/**
 * this class represents the grey marble
 */
public class GreyMarble extends Marble{

    /**
     * this class adds a rock recourse to the player buffer by calling the addToBuffer method of the player class
     * @param player : the one that has bought from the market
     */
    public void giveResource(Player player)  {

        player.addToBuffer(Resource.ROCK);

    }
}
