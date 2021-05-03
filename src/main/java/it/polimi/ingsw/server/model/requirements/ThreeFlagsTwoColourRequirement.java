package it.polimi.ingsw.server.model.requirements;

import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.Colour;

/**
 * This class represents the requirement that a player must have at least two production cards of one colour and
 * one production card of another colour on his game board in order to activate the leader card.
 * The two colours are specified by this requirement.
 */
public class ThreeFlagsTwoColourRequirement extends Requirements{

    private static final String requirementType = "ThreeFlagsTwoColourRequirement";

    /**
     * This attribute defines the colour of the production card that the player must have on two distinct cards
     */
    private final Colour  colourDoubleRequirement;
    /**
     * This attribute defines the color of the production card that the player must have on one card
     */
    private final Colour colourSingleRequirement;

    /**
     * Default constructor
     * @param colourDoubleRequirement : the production card colour to have twice
     * @param colourSecondRequirement : the production card colour to have once
     */
    public ThreeFlagsTwoColourRequirement(Colour colourDoubleRequirement, Colour colourSecondRequirement){
        this.colourDoubleRequirement=colourDoubleRequirement;
        this.colourSingleRequirement =colourSecondRequirement;
    }

    /**
     * This method returns the colour of the production card to have in two cards defined by the requirement
     * @return : the production card colour to have twice
     */
    @Override
    public Colour getColourDoubleRequirement() {
        return colourDoubleRequirement;
    }

    /**
     * This method returns the colour of the production card to have in one card defined by the requirement
     * @return : the production card colour to have once
     */
    @Override
    public Colour getColourSingleRequirement() {
        return colourSingleRequirement;
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
