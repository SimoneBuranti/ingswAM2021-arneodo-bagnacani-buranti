package it.polimi.ingsw.server.model.requirements;

import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.Colour;

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

    public abstract String toString();
}
