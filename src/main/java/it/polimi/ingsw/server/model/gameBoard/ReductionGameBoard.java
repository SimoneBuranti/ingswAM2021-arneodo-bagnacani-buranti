package it.polimi.ingsw.server.model.gameBoard;

import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.exceptions.*;
import it.polimi.ingsw.server.model.productionCards.DeckProductionCard;

import java.util.ArrayList;

/**
 * This decorator adds functionality to the personal board when a player activates the first reduction-type leader card
 */
public class ReductionGameBoard extends GameBoardDecorator{

    /**
     * This attribute represents the type of resource to be removed from the cost of the production card
     * that the player wants to buy if he has activated the first leader card
     */
    private final Resource resourceTypeFirst;

    /**
     * Constructor for reduction game board decorator
     * @param gameBoard : game board to be decorated
     * @param resourceType : resource type of the first reduction-type leader card
     */
    public ReductionGameBoard(GameBoardInterface gameBoard,Resource resourceType) {
        super(gameBoard);
        this.resourceTypeFirst = resourceType;
    }

    /**
     * this method removes from the resource list that represents the cost of the production card to buy
     * the resource defined by the activated leader card
     * @param cost : a collection of resources to pay to buy the card
     * @return ArrayList<Resource> : updated collection of resources to pay to buy the card after cost reduction
     */
    @Override
    public ArrayList<Resource> costReduction(ArrayList<Resource> cost) {
        cost.remove(resourceTypeFirst);
        return cost;
    }

    /**
     * Decorated game board method: it buys the production card as in the base game board method but removes the reduction
     * obtained with the leader card from the cost of the card to be bought by calling the costReduction method
     * @param deck : the deck from which to draw the card
     * @param chosenColumn : the column in which to put the card
     * @throws LevelException : the exception which is thrown when the deck level doesn't match the available position in the column
     * @throws NotEnoughResourcesException : the exception which is thrown when the player cannot afford that card
     * @throws EmptyException : the exception which is thrown when there are no cards in the deck
     * @throws FullColumnException : the exception which is thrown when all the rows of the chosen column are occupied
     * @throws EndGameException : the exception which is thrown when there are seven card in the player's development board
     */
    @Override
    public void buyProductionCard(DeckProductionCard deck, int chosenColumn) throws LevelException, NotEnoughResourcesException, EmptyException, FullColumnException, EndGameException {
        ArrayList<Resource> availableResources = availableResources();
        ArrayList<Resource> requiredResources = costReduction(deck.requiredResources());

        if(deck.size() == 0)
            throw new EmptyException();
        if(deck.getLevel()!=firstRowFree(chosenColumn)+1)
            throw new LevelException();
        for(Resource resource : requiredResources)
            if (!availableResources.remove(resource))
                throw new NotEnoughResourcesException();

        payResources(requiredResources);

        setNewProductionCard(deck,chosenColumn);

        seventhCardCheck();
    }

    /**
     * Getter for resource type of the first reduction-type leader card
     * @return Resource : the first type of resource to be reduced in the cost of the production card
     */
    @Override
    public Resource getResourceTypeFirst(){
        return resourceTypeFirst;
    }



}

