package it.polimi.ingsw.server.model.leaderCards;

import it.polimi.ingsw.server.model.exceptions.RequirementsException;
import it.polimi.ingsw.server.model.gameBoard.GameBoardInterface;
import it.polimi.ingsw.server.model.requirements.Requirements;
import it.polimi.ingsw.server.model.Resource;

/**
 * this class represents the storage-type leader card
 */
public class LeaderCardStorage extends LeaderCard {

    /**
     * Default constructor
     * @param requirements : the type of card requirement
     * @param points : the card victory points
     * @param resourceEffect : the type of resource that can be contained in the extra storage
     */
    public LeaderCardStorage(Requirements requirements, int points, Resource resourceEffect,int key) {
        super(requirements, points,resourceEffect,key);
    }

    /**
     * This method checks if the requirements are met: if so, it changes the storage of the game board passed as a parameter
     * to extra first or second storage and returns true, otherwise it returns false
     * @param gameBoard : the game board to be updated
     * @return boolean : true if the game board has been updated, false otherwise
     */
    @Override
    public GameBoardInterface abilityActivation(GameBoardInterface gameBoard) throws RequirementsException {
        if(check(gameBoard)){
            gameBoard.setStorageExtra(resourceEffect);
            gameBoard.setStorageCardActivated();
            return gameBoard;
        }else
            throw new RequirementsException();
    }

    /**
     * this method checks if the leader card requirements are met by the game board of the player who wants to activate the card
     * @param gameBoard : the game board that must meet the requirements
     * @return boolean : true if the game board meets the requirements, false otherwise
     */
    public boolean check(GameBoardInterface gameBoard){
        return gameBoard.resourceQuantity(requirements.getResourceRequirement()) >= 5;
    }

    public String toString(){
        return "Ability: an extra storage where you can put 2 " + resourceEffect;
    }
}
