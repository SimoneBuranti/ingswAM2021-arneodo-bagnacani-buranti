package it.polimi.ingsw;

import java.util.ArrayList;

public class ProductionGameBoard extends GameBoardDecorator {

    private final Resource resourceTypeFirst;

    public ProductionGameBoard(GameBoardInterface gameBoard, Resource resourceTypeFirst) {
        super(gameBoard);
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

        faithMove();
    }

    @Override
    public Resource getResourceTypeFirst(){
        return resourceTypeFirst;
    }


}
