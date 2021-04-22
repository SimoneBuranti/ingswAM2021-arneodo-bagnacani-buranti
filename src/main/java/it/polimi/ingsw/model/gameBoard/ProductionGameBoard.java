package it.polimi.ingsw.model.gameBoard;

import it.polimi.ingsw.model.Resource;
import it.polimi.ingsw.model.exceptions.CallForCouncilException;
import it.polimi.ingsw.model.exceptions.ImpossibleProductionException;
import it.polimi.ingsw.model.exceptions.LastSpaceReachedException;

import java.util.ArrayList;

/**
 * This decorator adds functionality to the personal board when a player activates the first production-type leader card
 */
public class ProductionGameBoard extends GameBoardDecorator {

    /**
     * this attribute represents the type of resource that must be input to the first extra production
     * defined by the activated leader card
     */
    private final Resource resourceTypeFirst;

    /**
     * Constructor for production game board decorator
     * @param gameBoard : game board to be decorated
     * @param resourceTypeFirst : resource type of the first production-type leader card
     */
    public ProductionGameBoard(GameBoardInterface gameBoard, Resource resourceTypeFirst) {
        super(gameBoard);
        this.resourceTypeFirst = resourceTypeFirst;
    }

    /**
     * Decorated game board method: it represents the gameBoard's function of extra production.
     * The method uses as input of the extra production the type of resource defined by the leader card and
     * as output the type of resource passed as parameter, it also moves forward one position the faith indicator
     * of the player who activated this production.
     * In case of lack in available resources an ImpossibleProductionException is thrown.
     * Moreover, it spreads CallForCouncilException and LastSpaceReachedException.
     * @param resource : the resource type of the extra production output
     * @throws ImpossibleProductionException : the exception which is thrown when the input resource is not available
     * @throws CallForCouncilException : the exception which is thrown when the faith indicator has reached the current papal space
     * @throws LastSpaceReachedException : the exception which is thrown when the faith indicator has reached the last papal space
     */
    @Override
    public void extraProductionOn(Resource resource) throws ImpossibleProductionException, CallForCouncilException, LastSpaceReachedException {
        ArrayList<Resource> available = availableResources();
        ArrayList<Resource> cost = new ArrayList<>();
        ArrayList<Resource> output = new ArrayList<>();


        cost.add(this.resourceTypeFirst);

        if (!available.remove(this.resourceTypeFirst))
                throw new ImpossibleProductionException();

        payResources(cost);
        output.add(resource);

        addToProductionBuffer(output);

        faithMove();
    }

    /**
     * Getter for resource type of the first production-type leader card
     * @return Resource : the type of resource entering the first extra production
     */
    @Override
    public Resource getResourceTypeFirst(){
        return resourceTypeFirst;
    }


}
