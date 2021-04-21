package it.polimi.ingsw.model;
/**
 * this class represents the production-type leader card
 */
public class LeaderCardProduction extends LeaderCard {
    /**
     * this attribute indicates the type of resource that can be used to activate the extra production of the leader card
     */
    private final Resource resourceProduction;

    /**
     * Default constructor
     * @param requirements : the type of card requirement
     * @param point : the card victory points
     * @param resourceProduction : the type of resource that can be used to activate the extra production
     */
    public LeaderCardProduction(Requirements requirements, int point ,Resource resourceProduction){
        super(requirements,point);
        this.resourceProduction=resourceProduction;
    }

    /**
     * This method checks if the requirements are met: if so, it adds the extra production functionality to the game board
     * passed as a parameter through the use of the pattern decorator and returns true, otherwise it returns false
     * @param gameBoard : the game board to be updated
     * @return boolean : true if the game board has been updated, false otherwise
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
     * this method checks if the leader card requirements are met by the game board of the player who wants to activate the card
     * @param gameBoard : the game board that must meet the requirements
     * @return boolean : true if the game board meets the requirements, false otherwise
     */
    public boolean check(GameBoardInterface gameBoard){
        return gameBoard.levelAndColourQuantity(requirements.getColourRequirement(), 2) >= 1;
    }
}
