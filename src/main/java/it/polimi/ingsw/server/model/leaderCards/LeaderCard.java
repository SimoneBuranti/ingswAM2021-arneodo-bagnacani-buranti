package it.polimi.ingsw.server.model.leaderCards;

import it.polimi.ingsw.server.model.gameBoard.GameBoardInterface;
import it.polimi.ingsw.server.model.requirements.Requirements;

/**
 * This class represents the leader card
 */
public class LeaderCard {

    /**
     * this attribute indicates the card own victory points
     */
    protected int points;
    /**
     * this attribute indicates the requirements that must be met to activate the card
     */
    protected Requirements requirements;

    /**
     * Default constructor
     * @param requirements : the type of card requirement
     * @param points : the card victory points
     */
    public LeaderCard(Requirements requirements,int points) {
        this.points = points;
        this.requirements=requirements;
    }

    /**
     * Getter method for the card victory points
     * @return int : the card victory points
     */
    public int getPoints() {
        return points;
    }

    /**
     * method not implemented for activating the leader card
     * @param gameBoard : the game board to be updated
     * @return boolean : false
     */
    public boolean abilityActivation(GameBoardInterface gameBoard){
        return false;
    }
}
