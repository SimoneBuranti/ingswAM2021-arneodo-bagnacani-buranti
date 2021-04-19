package it.polimi.ingsw.model;

/**
 * this class represents the marble of the market and it is the super class of all marbles
 */
public class Marble {
    /**
     * not implemented method that gives the player the resource corresponding to the marble and spreads tre exception
     * @param player : the one that has bought from the market
     * @throws CallForCouncilException : the exception that is thrown when the player reaches a papal space in the faithPath
     * @throws LastSpaceReachedException : the exception that is thrown when the player reaches the last papal space in the faithPath
     * @throws WhiteMarbleException : the exception that is thrown when the player gets a white marble from the market
     *                                 having activated two white marble leader cards
     */
    public void giveResource(Player player) throws CallForCouncilException, LastSpaceReachedException, WhiteMarbleException {}
}
