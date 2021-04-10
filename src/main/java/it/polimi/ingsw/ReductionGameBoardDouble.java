package it.polimi.ingsw;

import java.util.ArrayList;

public class ReductionGameBoardDouble extends ReductionGameBoard{

    private final Resource resourceTypeSecond;

    public ReductionGameBoardDouble(GameBoardInterface gameBoard, Resource resourceTypeFirst, Resource resourceTypeSecond) {
        super(gameBoard, resourceTypeFirst);
        this.resourceTypeSecond = resourceTypeSecond;
    }

    @Override
    public ArrayList<Resource> costReduction(ArrayList<Resource> cost) {
        ArrayList<Resource> discounted = super.costReduction(cost);
        discounted.remove(resourceTypeSecond);
        return discounted;
    }

}
