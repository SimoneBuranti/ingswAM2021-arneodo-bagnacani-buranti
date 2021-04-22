package it.polimi.ingsw.model.requirements;

import it.polimi.ingsw.model.Resource;
import it.polimi.ingsw.model.colours.Colour;

/**
 * this abstract class represents the leader card requirement
 */
public abstract class Requirements {

    /**
     * getter method not implemented for specific requirement attribute
     */
    public abstract Colour getColourDoubleRequirement();
    /**
     * getter method not implemented for specific requirement attribute
     */
    public abstract Colour getColourSingleRequirement();
    /**
     * getter method not implemented for specific requirement attribute
     */
    public abstract Colour getColourRequirement();
    /**
     * getter method not implemented for specific requirement attribute
     */
    public abstract Resource getResourceRequirement();
    /**
     * getter method not implemented for specific requirement attribute
     */
    public abstract Colour getColourFirstRequirement();
    /**
     * getter method not implemented for specific requirement attribute
     */
    public abstract Colour getColourSecondRequirement();
}
