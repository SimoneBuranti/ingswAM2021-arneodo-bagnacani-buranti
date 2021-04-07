package it.polimi.ingsw;

import java.util.ArrayList;

public class ProductionGameboardDouble extends ProductionGameboard{

    private final Resource resourceTypeSecond;

    public ProductionGameboardDouble(GameboardInterface gameboard, Resource resourceTypeFirst, Resource resourceTypeSecond) {
        super(gameboard, resourceTypeFirst);
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
        addToFaithPathBuffer(1);
    }
}
