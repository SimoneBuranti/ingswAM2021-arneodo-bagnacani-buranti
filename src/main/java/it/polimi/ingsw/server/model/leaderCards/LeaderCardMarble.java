package it.polimi.ingsw.server.model.leaderCards;

import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.exceptions.RequirementsException;
import it.polimi.ingsw.server.model.gameBoard.GameBoardInterface;
import it.polimi.ingsw.server.model.gameBoard.WhiteMarbleGameBoard;
import it.polimi.ingsw.server.model.gameBoard.WhiteMarbleGameBoardDouble;
import it.polimi.ingsw.server.model.requirements.Requirements;

/**
 * this class represents the white marble-type leader card
 */
public class LeaderCardMarble extends LeaderCard{

    /**
     * Default constructor
     * @param requirements : the type of card requirement
     * @param points : the card victory points
     * @param resourceEffect : the type of resource that can be taken through the white marble
     */
    public LeaderCardMarble(Requirements requirements,int points,Resource resourceEffect,int key){
        super(requirements,points,resourceEffect,key);
    }


    /**
     * This method checks if the requirements are met: if so, it adds the white marble exchange functionality to the game
     * board passed as a parameter through the use of the pattern decorator and returns true, otherwise it returns false
     * @param gameBoard : the game board to be updated
     * @return boolean : true if the game board has been updated, false otherwise
     */
    @Override
    public GameBoardInterface abilityActivation(GameBoardInterface gameBoard) throws RequirementsException {
        GameBoardInterface newGameBoard;

        if(check(gameBoard)){
            if(gameBoard.getWhiteMarbleCardActivated() == 0) {
                newGameBoard = new WhiteMarbleGameBoard(gameBoard, resourceEffect);
                newGameBoard.setWhiteMarbleCardActivated();
            }else
                newGameBoard = new WhiteMarbleGameBoardDouble(gameBoard, gameBoard.getResourceTypeFirst(), resourceEffect);
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
        if(gameBoard.colourQuantity(requirements.getColourDoubleRequirement()) < 2) {
            return false;
        }else return gameBoard.colourQuantity(requirements.getColourSingleRequirement()) >= 1;
    }

    public String toString(){
        return "Ability: white marble exchange with " + resourceEffect + " resource";
    }
}
