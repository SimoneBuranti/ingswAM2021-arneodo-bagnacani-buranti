package it.polimi.ingsw.server.model.leaderCards;

import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.exceptions.RequirementsException;
import it.polimi.ingsw.server.model.gameBoard.*;
import it.polimi.ingsw.server.model.requirements.Requirements;

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
    public LeaderCardProduction(Requirements requirements, int point , Resource resourceProduction){
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
    public GameBoardInterface abilityActivation(GameBoardInterface gameBoard) throws RequirementsException {
        GameBoardInterface newGameBoard;

        if(check(gameBoard)){
            if(gameBoard.getProductionCardActivated() == 0) {
                newGameBoard = new ProductionGameBoard(gameBoard, resourceProduction);
                newGameBoard.setProductionCardActivated();
            }else
                newGameBoard = new ProductionGameBoardDouble(gameBoard, gameBoard.getResourceTypeFirst(), resourceProduction);
            return newGameBoard;
        }else
            throw new RequirementsException();
    }

    /**
     * this method checks if the leader card requirements are met by the game board of the player who wants to activate the card
     * @param gameBoard : the game board that must meet the requirements
     * @return boolean : true if the game board meets the requirements, false otherwise
     */
    public boolean check(GameBoardInterface gameBoard){
        return gameBoard.levelAndColourQuantity(requirements.getColourRequirement(), 2) >= 1;
    }


    public Resource getResourceProduction(){
        return resourceProduction;
    }
}
