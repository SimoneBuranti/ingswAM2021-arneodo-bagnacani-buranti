package it.polimi.ingsw.server.model.gameBoard;

import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.exceptions.WhiteMarbleException;

/**
 * This decorator adds functionality to the personal board when a player activates the second white marble-type leader card
 */
public class WhiteMarbleGameBoardDouble extends WhiteMarbleGameBoard{
    /**
     * this attribute represents the type of resource to be taken with the white marble from the market,
     * it is defined by the second activated leader card
     */
    private final Resource resourceTypeSecond;

    /**
     * Constructor for white marble game board double decorator
     * @param gameBoard : game board to be decorated
     * @param resourceTypeFirst : resource type of the first white marble-type leader card
     * @param resourceTypeSecond : resource type of the second white marble-type leader card
     */
    public WhiteMarbleGameBoardDouble(GameBoardInterface gameBoard, Resource resourceTypeFirst, Resource resourceTypeSecond) {
        super(gameBoard,resourceTypeFirst);
        this.resourceTypeSecond = resourceTypeSecond;
    }

    /**
     * Getter for resource type of the second white marble-type leader card
     * @return Resource : the second type of resource to be exchanged with the white marble
     */
    public Resource getResourceTypeSecond() {
        return resourceTypeSecond;
    }

    /**
     * Decorated game board method: it throws an WhiteMarbleException
     * to allow the player to choose what type of resource to exchange with the white marble
     * @throws WhiteMarbleException : the exception which is thrown when a player has activated two white marble-type leader cards
     */
    @Override
    public Resource whiteExchange() throws WhiteMarbleException {

        throw new WhiteMarbleException(1);

    }
}