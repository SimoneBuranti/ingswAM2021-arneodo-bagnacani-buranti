package it.polimi.ingsw.server.model.marbles;

import it.polimi.ingsw.server.model.players.Player;
import it.polimi.ingsw.server.model.exceptions.CallForCouncilException;
import it.polimi.ingsw.server.model.exceptions.LastSpaceReachedException;
import it.polimi.ingsw.server.model.exceptions.WhiteMarbleException;

/**
 * this class represents the marble of the market and it is the super class of all marbles
 */
public class Marble {

    protected String colour = null;
    /**
     * not implemented method that gives the player the resource corresponding to the marble and spreads tre exception
     * @param player : the one that has bought from the market
     * @throws WhiteMarbleException : the exception that is thrown when the player gets a white marble from the market
     *                                 having activated two white marble leader cards
     */
    public void giveResource(Player player) throws WhiteMarbleException {}
    /**
     * @return colour marble
     */
    public String getColour(){return colour;}
}
