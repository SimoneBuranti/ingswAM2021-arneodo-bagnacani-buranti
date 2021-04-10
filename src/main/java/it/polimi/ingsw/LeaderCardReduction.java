package it.polimi.ingsw;

public class LeaderCardReduction extends LeaderCard{
    private Resource costReduction;
    public LeaderCardReduction(Requirements requirements, int point ,Resource costReduction){
        super(requirements,point);
        this.costReduction=costReduction;
    }


    /**
     * method  on abilityActivation of the decorator
     */
    @Override
    public boolean abilityActivation(GameBoardInterface gameBoard){
        if(check(gameBoard)){
            if(gameBoard.getReductionCardActivated() == 0) {
                gameBoard = new ReductionGameBoard(gameBoard, costReduction);
                gameBoard.setReductionCardActivated();
            }else
                gameBoard = new ReductionGameBoardDouble(gameBoard, gameBoard.getResourceTypeFirst(), costReduction);
            return true;
        }else
            return false;
    }

    /**
     * method check for the possibility of activate leader card
     * the ability is improving on Production on resource
     */
    public boolean check(GameBoardInterface gameBoard){
        if(gameBoard.colourQuantity(requirements.getColourFirstRequirement()) < 1)
            return false;
        else if(gameBoard.colourQuantity(requirements.getColourSecondRequirement()) < 1)
            return false;
        else
            return true;
    }
}
