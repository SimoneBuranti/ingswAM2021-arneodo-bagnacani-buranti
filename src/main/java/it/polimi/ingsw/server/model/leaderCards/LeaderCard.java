package it.polimi.ingsw.server.model.leaderCards;

import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.exceptions.RequirementsException;
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

    protected final Resource resourceEffect;

    protected  int key;

    /**
     * Default constructor
     * @param requirements : the type of card requirement
     * @param points : the card victory points
     */
    public LeaderCard(Requirements requirements,int points,Resource resourceEffect,int key) {
        this.points = points;
        this.requirements=requirements;
        this.resourceEffect = resourceEffect;
        this.key=key;
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
    public GameBoardInterface abilityActivation(GameBoardInterface gameBoard) throws RequirementsException {
        return null;
    }

    public Requirements getRequirements(){
        return requirements;
    }

    public int getKey(){
        return key;
    }

    public Resource getResourceEffect(){
        return resourceEffect;
    }

    public String toString(){
        return null;
    }
}
