package it.polimi.ingsw.server.model.leaderCards;

import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.exceptions.RequirementsException;
import it.polimi.ingsw.server.model.gameBoard.*;
import it.polimi.ingsw.server.model.requirements.Requirements;

/**
 * this class represents the reduction-type leader card
 */
public class LeaderCardReduction extends LeaderCard{
    /**
     * this attribute indicates the type of resource that can be subtracted from the cost of production cards
     */
    private final Resource costReduction;

    /**
     * Default constructor
     * @param requirements : the type of card requirement
     * @param point : the card victory points
     * @param costReduction : the type of resource that can be subtracted from the cost of production cards
     */
    public LeaderCardReduction(Requirements requirements, int point , Resource costReduction){
        super(requirements,point);
        this.costReduction=costReduction;
    }


    /**
     * This method checks if the requirements are met: if so, it adds the reduce functionality to the game board passed
     * as a parameter through the use of the pattern decorator and returns true, otherwise it returns false
     * @param gameBoard : the game board to be updated
     * @return boolean : true if the game board has been updated, false otherwise
     */
    @Override
    public GameBoardInterface abilityActivation(GameBoardInterface gameBoard) throws RequirementsException {
        GameBoardInterface newGameBoard;

        if(check(gameBoard)){
            if(gameBoard.getReductionCardActivated() == 0) {
                newGameBoard = new ReductionGameBoard(gameBoard, costReduction);
                newGameBoard.setReductionCardActivated();
            }else
                newGameBoard = new ReductionGameBoardDouble(gameBoard, gameBoard.getResourceTypeFirst(), costReduction);
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
        if(gameBoard.colourQuantity(requirements.getColourFirstRequirement()) < 1)
            return false;
        else return gameBoard.colourQuantity(requirements.getColourSecondRequirement()) >= 1;
    }
}
