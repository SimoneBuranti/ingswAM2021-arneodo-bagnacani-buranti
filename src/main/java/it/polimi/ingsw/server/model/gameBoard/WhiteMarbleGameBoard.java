package it.polimi.ingsw.server.model.gameBoard;

import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.exceptions.WhiteMarbleException;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

/**
 * This decorator adds functionality to the personal board when a player activates the first white marble-type leader card
 */
public class WhiteMarbleGameBoard extends GameBoardDecorator{
    /**
     * this attribute represents the type of resource to be taken with the white marble from the market,
     * it is defined by the first activated leader card
     */
    protected Resource resourceTypeFirst;

    /**
     * Constructor for white marble game board decorator
     * @param gameBoard : game board to be decorated
     * @param resourceTypeFirst : resource type of the first white marble-type leader card
     */
    public WhiteMarbleGameBoard(GameBoardInterface gameBoard, Resource resourceTypeFirst) {
        super(gameBoard);
        this.resourceTypeFirst = resourceTypeFirst;
    }

    /**
     * Getter for resource type of the first white marble-type leader card
     * @return Resource : the first type of resource to be exchanged with the white marble
     */
    @Override
    public Resource getResourceTypeFirst() {
        return this.resourceTypeFirst;
    }

    @Override
    public ProductionCard getDevelopmentBoardCell(int i, int j) {
        return gameBoard.getDevelopmentBoardCell(i, j);
    }


    /**
     * Decorated game board method: it returns the type of resource to be exchanged with the white marble from the market
     * @return Resource : the type of resource to be exchanged with the white marble
     * @throws WhiteMarbleException : the exception which is thrown when a player has activated two white marble-type leader cards
     */
    @Override
    public Resource whiteExchange() throws WhiteMarbleException {
        return this.resourceTypeFirst;
    }


}
