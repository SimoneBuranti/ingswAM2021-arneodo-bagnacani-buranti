package it.polimi.ingsw.model.requirements;

import it.polimi.ingsw.model.Resource;
import it.polimi.ingsw.model.colours.Colour;

/**
 * this class represents the requirement that a player must have at least two production cards on his board with the colours
 * specified by this requirement in order to activate the leader card
 */
public class TwoFlagsTwoColourRequirement extends Requirements{
    /**
     * this attribute defines the first colour of the production card that the player must have
     */
    private final Colour  colourFirstRequirement;
    /**
     * this attribute defines the second colour of the production card that the player must have
     */
    private final Colour  colourSecondRequirement;

    /**
     * Default constructor
     * @param colourFirstRequirement : the first production card colour
     * @param colourSecondRequirement : the second production card colour
     */
    public TwoFlagsTwoColourRequirement(Colour colourFirstRequirement, Colour colourSecondRequirement){
        this.colourFirstRequirement=colourFirstRequirement;
        this.colourSecondRequirement=colourSecondRequirement;
    }

    /**
     * This method returns the first colour of the production card defined by the requirement
     * @return Colour : the first production card colour
     */
    @Override
    public Colour getColourFirstRequirement() {
        return colourFirstRequirement;
    }

    /**
     * This method returns the second colour of the production card defined by the requirement
     * @return Colour : the second production card colour
     */
    @Override
    public Colour getColourSecondRequirement() {
        return colourSecondRequirement;
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
    public Colour getColourRequirement() {
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
}
