package it.polimi.ingsw.server.model.leaderCards;

import it.polimi.ingsw.server.model.gameBoard.GameBoardInterface;
import it.polimi.ingsw.server.model.requirements.Requirements;
import it.polimi.ingsw.server.model.Resource;

/**
 * this class represents the storage-type leader card
 */
public class LeaderCardStorage extends LeaderCard {
    /**
     * this attribute indicates the type of resource that can be contained in the extra storage
     * obtained by activating this card
     */
    private final Resource specialStorage;

    /**
     * Default constructor
     * @param requirements : the type of card requirement
     * @param point : the card victory points
     * @param specialStorage : the type of resource that can be contained in the extra storage
     */
    public LeaderCardStorage(Requirements requirements, int point, Resource specialStorage) {
        super(requirements, point);
        this.specialStorage=specialStorage;
    }

    /**
     * This method checks if the requirements are met: if so, it changes the storage of the game board passed as a parameter
     * to extra first or second storage and returns true, otherwise it returns false
     * @param gameBoard : the game board to be updated
     * @return boolean : true if the game board has been updated, false otherwise
     */
    @Override
    public boolean abilityActivation(GameBoardInterface gameBoard){
        if(check(gameBoard)){
            gameBoard.setStorageExtra(specialStorage);
            gameBoard.setStorageCardActivated();
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
        return gameBoard.resourceQuantity(requirements.getResourceRequirement()) >= 5;
    }
}
