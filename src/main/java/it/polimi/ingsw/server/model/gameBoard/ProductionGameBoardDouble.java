package it.polimi.ingsw.server.model.gameBoard;

import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.exceptions.CallForCouncilException;
import it.polimi.ingsw.server.model.exceptions.ImpossibleProductionException;
import it.polimi.ingsw.server.model.exceptions.LastSpaceReachedException;

import java.util.ArrayList;

/**
 * This decorator adds functionality to the personal board when a player activates the second production-type leader card
 */
public class ProductionGameBoardDouble extends ProductionGameBoard{
    /**
     * this attribute represents the type of resource that must be input to the second extra production
     * defined by the activated leader card
     */
    private final Resource resourceTypeSecond;

    /**
     * Constructor for production game board double decorator
     * @param gameBoard : game board to be decorated
     * @param resourceTypeFirst : resource type of the first production-type leader card
     * @param resourceTypeSecond : resource type of the second production-type leader card
     */
    public ProductionGameBoardDouble(GameBoardInterface gameBoard, Resource resourceTypeFirst, Resource resourceTypeSecond) {
        super(gameBoard, resourceTypeFirst);
        this.resourceTypeSecond = resourceTypeSecond;
    }

    /**
     * Decorated game board method: it represents the gameBoard's function of another extra production.
     * The method uses as input of the another extra production the type of resource defined by the leader card and
     * as output the type of resource passed as parameter, it also moves forward one position the faith indicator
     * of the player who activated this production.
     * In case of lack in available resources an ImpossibleProductionException is thrown.
     * Moreover, it spreads CallForCouncilException and LastSpaceReachedException.
     * @param resource : the resource type of the another extra production output
     * @throws ImpossibleProductionException : the exception which is thrown when the input resource is not available
     * @throws CallForCouncilException : the exception which is thrown when the faith indicator has reached the current papal space
     * @throws LastSpaceReachedException : the exception which is thrown when the faith indicator has reached the last papal space
     */
    @Override
    public void anotherExtraProductionOn(Resource resource) throws ImpossibleProductionException, CallForCouncilException, LastSpaceReachedException {
        ArrayList<Resource> available = availableResources();
        ArrayList<Resource> cost = new ArrayList<>();
        ArrayList<Resource> output = new ArrayList<>();


        cost.add(this.resourceTypeSecond);

        if (!available.remove(this.resourceTypeSecond))
            throw new ImpossibleProductionException();

        payResources(cost);
        output.add(resource);

        addToProductionBuffer(output);
        faithMove();
    }
}
