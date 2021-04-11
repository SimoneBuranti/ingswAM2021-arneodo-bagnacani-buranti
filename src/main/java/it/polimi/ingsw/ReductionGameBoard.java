package it.polimi.ingsw;

import java.util.ArrayList;

public class ReductionGameBoard extends GameBoardDecorator{

    private final Resource resourceTypeFirst;

    public ReductionGameBoard(GameBoardInterface gameBoard,Resource resourceType) {
        super(gameBoard);
        this.resourceTypeFirst = resourceType;
    }

    @Override
    public ArrayList<Resource> costReduction(ArrayList<Resource> cost) {
        cost.remove(resourceTypeFirst);
        return cost;
    }

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

    @Override
    public Resource getResourceTypeFirst(){
        return resourceTypeFirst;
    }



}

