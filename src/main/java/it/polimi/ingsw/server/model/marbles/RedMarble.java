package it.polimi.ingsw.server.model.marbles;

import it.polimi.ingsw.server.model.players.Player;
import it.polimi.ingsw.server.model.exceptions.CallForCouncilException;
import it.polimi.ingsw.server.model.exceptions.LastSpaceReachedException;

/**
 * this class represents the red marble
 */
public class RedMarble extends Marble{
    /**
     * colour marble
     */
    private String colour= "red";


    @Override
    public String getColour() {
        return colour;
    }
    /**
     * this method moves forward the faith indicator of the player in the faithPath by calling the faithMove method of the player class
     * @param player : the one that has bought from the market
     * @throws CallForCouncilException : the exception that is thrown when the player reaches a papal space in the faithPath
     * @throws LastSpaceReachedException :: the exception that is thrown when the player reaches the last papal space in the faithPath
     */
    public void giveResource(Player player) throws CallForCouncilException, LastSpaceReachedException {
        player.faithMove();
    }
}
