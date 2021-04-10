package it.polimi.ingsw;

public class LeaderCardProduction extends LeaderCard {
    private Resource resourceProduction;
    public LeaderCardProduction(Requirements requirements, int point ,Resource resourceProduction){
        super(requirements,point);
        this.resourceProduction=resourceProduction;
    }

    /**
     * method  on abilityActivation of the decorator
     */
    @Override
    public boolean abilityActivation(GameBoardInterface gameBoard){
        if(check(gameBoard)){
            if(gameBoard.getProductionCardActivated() == 0) {
                gameBoard = new ProductionGameBoard(gameBoard, resourceProduction);
                gameBoard.setProductionCardActivated();
            }else
                gameBoard = new ProductionGameBoardDouble(gameBoard, gameBoard.getResourceTypeFirst(), resourceProduction);
            return true;
        }else
            return false;
    }

    /**
     * method check for the possibility of activate leader card
     * the ability is improving on Production on resource
     */
    public boolean check(GameBoardInterface gameBoard){
        if(gameBoard.levelAndColourQuantity(requirements.getColourRequirement(), 2) < 1)
            return false;
        else
            return true;
    }
}
