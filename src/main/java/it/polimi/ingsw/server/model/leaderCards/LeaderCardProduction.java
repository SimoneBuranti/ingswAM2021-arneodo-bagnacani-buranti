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
     * Default constructor
     * @param requirements : the type of card requirement
     * @param points : the card victory points
     * @param resourceEffect : the type of resource that can be used to activate the extra production
     */
    public LeaderCardProduction(Requirements requirements, int points , Resource resourceEffect,int key){
        super(requirements,points,resourceEffect,key);
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
                newGameBoard = new ProductionGameBoard(gameBoard, resourceEffect);
                newGameBoard.setProductionCardActivated();
            }else
                newGameBoard = new ProductionGameBoardDouble(gameBoard, gameBoard.getResourceTypeFirst(), resourceEffect);
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


    public String toString(){
        return "Ability: extra production with input = 1 " + resourceEffect + ", output = 1 resource of your choice and 1 faith point";
    }
}
