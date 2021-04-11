package it.polimi.ingsw.model;

import java.util.ArrayList;

public class ProductionGameBoardDouble extends ProductionGameBoard{

    private final Resource resourceTypeSecond;

    public ProductionGameBoardDouble(GameBoardInterface gameBoard, Resource resourceTypeFirst, Resource resourceTypeSecond) {
        super(gameBoard, resourceTypeFirst);
        this.resourceTypeSecond = resourceTypeSecond;
    }

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
