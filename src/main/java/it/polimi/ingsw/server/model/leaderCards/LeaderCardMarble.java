package it.polimi.ingsw.server.model.leaderCards;

import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.gameBoard.GameBoardInterface;
import it.polimi.ingsw.server.model.gameBoard.WhiteMarbleGameBoard;
import it.polimi.ingsw.server.model.gameBoard.WhiteMarbleGameBoardDouble;
import it.polimi.ingsw.server.model.requirements.Requirements;

/**
 * this class represents the white marble-type leader card
 */
public class LeaderCardMarble extends LeaderCard{
    /**
     * this attribute indicates the type of resource that can be taken through the white marble in the market action
     */
    private final Resource whiteMarble;

    /**
     * Default constructor
     * @param requirements : the type of card requirement
     * @param point : the card victory points
     * @param whiteMarble : the type of resource that can be taken through the white marble
     */
    public LeaderCardMarble(Requirements requirements, int point , Resource whiteMarble){
        super(requirements,point);
        this.whiteMarble=whiteMarble;
    }


    /**
     * This method checks if the requirements are met: if so, it adds the white marble exchange functionality to the game
     * board passed as a parameter through the use of the pattern decorator and returns true, otherwise it returns false
     * @param gameBoard : the game board to be updated
     * @return boolean : true if the game board has been updated, false otherwise
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
     * this method checks if the leader card requirements are met by the game board of the player who wants to activate the card
     * @param gameBoard : the game board that must meet the requirements
     * @return boolean : true if the game board meets the requirements, false otherwise
     */
    public boolean check(GameBoardInterface gameBoard){
        if(gameBoard.colourQuantity(requirements.getColourDoubleRequirement()) < 2) {
            return false;
        }else return gameBoard.colourQuantity(requirements.getColourSingleRequirement()) >= 1;
    }
}
