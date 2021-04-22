package it.polimi.ingsw.model.gameBoard;

import it.polimi.ingsw.model.Resource;

import java.util.ArrayList;
/**
 * This decorator adds functionality to the personal board when a player activates the second reduction-type leader card
 */
public class ReductionGameBoardDouble extends ReductionGameBoard{
    /**
     * This attribute represents the type of resource to be removed from the cost of the production card
     * that the player wants to buy if he has activated the second leader card
     */
    private final Resource resourceTypeSecond;

    /**
     * Constructor for reduction game board double decorator
     * @param gameBoard : game board to be decorated
     * @param resourceTypeFirst : resource type of the first reduction-type leader card
     * @param resourceTypeSecond : resource type of the second reduction-type leader card
     */
    public ReductionGameBoardDouble(GameBoardInterface gameBoard, Resource resourceTypeFirst, Resource resourceTypeSecond) {
        super(gameBoard, resourceTypeFirst);
        this.resourceTypeSecond = resourceTypeSecond;
    }

    /**
     * this method reduces the cost of the production card by removing from the list passed as a parameter the resource
     * defined by the second activated leader card after calling the method of the super class
     * The super class method reduces the same list by removing the resource defined by the first activated leader card
     * @param cost : a collection of resources to pay to buy the card
     * @return ArrayList<Resource> : updated collection of resources to pay to buy the card after cost reduction
     */
    @Override
    public ArrayList<Resource> costReduction(ArrayList<Resource> cost) {
        ArrayList<Resource> discounted = super.costReduction(cost);
        discounted.remove(resourceTypeSecond);
        return discounted;
    }

}
