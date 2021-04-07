package it.polimi.ingsw;

import java.util.ArrayList;

public class ReductionGameboardDouble extends ReductionGameboard{

    private final Resource resourceTypeSecond;

    public ReductionGameboardDouble(GameboardInterface gameboard, Resource resourceTypeFirst, Resource resourceTypeSecond) {
        super(gameboard, resourceTypeFirst);
        this.resourceTypeSecond = resourceTypeSecond;
    }

    @Override
    public ArrayList<Resource> costReduction(ArrayList<Resource> cost) {
        ArrayList<Resource> discounted = super.costReduction(cost);
        discounted.remove(resourceTypeSecond);
        return discounted;
    }

}
