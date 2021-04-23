package it.polimi.ingsw.server.model.requirements;

import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.Colour;

/**
 * this class represents the requirement that a player must have on his board at least one second level production card
 * with the colour specified by this requirement in order to activate the leader card
 */
public class SecondLevelRequirement extends Requirements {
    /**
     * this attribute defines the colour of the second level production card that the player must have
     */
    private final Colour  colourRequirement;

    /**
     * Default constructor
     * @param colourRequirement : the second level production card colour
     */
    public SecondLevelRequirement(Colour colourRequirement){
        this.colourRequirement=colourRequirement;

    }

    /**
     * This method returns the colour of the second level production card defined by the requirement
     * @return Colour : the second level production card colour
     */
    @Override
    public Colour getColourRequirement() {
        return colourRequirement;
    }

    /**
     * method of the parent class that does nothing
     * @return null
     */
    @Override
    public Colour getColourDoubleRequirement() {
        return null;
    }

    /**
     * method of the parent class that does nothing
     * @return null
     */
    @Override
    public Colour getColourSingleRequirement() {
        return null;
    }

    /**
     * method of the parent class that does nothing
     * @return null
     */
    @Override
    public Resource getResourceRequirement() {
        return null;
    }

    /**
     * method of the parent class that does nothing
     * @return null
     */
    @Override
    public Colour getColourFirstRequirement() {
        return null;
    }

    /**
     * method of the parent class that does nothing
     * @return null
     */
    @Override
    public Colour getColourSecondRequirement() {
        return null;
    }
}
