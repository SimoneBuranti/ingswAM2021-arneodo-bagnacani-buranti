package it.polimi.ingsw;

import java.util.ArrayList;

public class ProductionGameboard extends GameboardDecorator {

    private final Resource resourceTypeFirst;

    public ProductionGameboard(GameboardInterface gameboard, Resource resourceTypeFirst) {
        super(gameboard);
        this.resourceTypeFirst = resourceTypeFirst;
    }



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
        addToFaithPathBuffer(1);
    }



}
