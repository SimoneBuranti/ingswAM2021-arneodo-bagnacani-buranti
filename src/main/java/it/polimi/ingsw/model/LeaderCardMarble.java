package it.polimi.ingsw.model;

public class LeaderCardMarble extends LeaderCard{
    private Resource whiteMarble;

    public LeaderCardMarble(Requirements requirements, int point ,Resource whiteMarble){
        super(requirements,point);
        this.whiteMarble=whiteMarble;
    }


    /**
     * method  on abilityActivation of the decorator
     */
    @Override
    public boolean abilityActivation(GameBoardInterface gameBoard){
        if(check(gameBoard)){
            if(gameBoard.getWhiteMarbleCardActivated() == 0) {
                gameBoard = new WhiteMarbleGameBoard(gameBoard, whiteMarble);
                gameBoard.setWhiteMarbleCardActivated();
            }else
                gameBoard = new WhiteMarbleGameBoardDouble(gameBoard, gameBoard.getResourceTypeFirst(), whiteMarble);
            return true;
        }else
            return false;
    }

    /**
     * method check for the possibility of activate leader card
     * the ability is the possibility to have a Resource from a whiteMarble in Market
     */
    public boolean check(GameBoardInterface gameBoard){
        if(gameBoard.colourQuantity(requirements.getColourDoubleRequirement()) < 2) {
            return false;
        }else if(gameBoard.colourQuantity(requirements.getColourSingleRequirement()) < 1){
            return false;
        }
        return true;
    }
}
