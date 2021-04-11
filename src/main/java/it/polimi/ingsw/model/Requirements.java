package it.polimi.ingsw.model;

/**
 * class for Requirements
 */
public abstract class Requirements {

    public abstract Colour getColourDoubleRequirement();

    public abstract Colour getColourSingleRequirement();

    public abstract Colour getColourRequirement();

    public abstract Resource getResourceRequirement();

    public abstract Colour getColourFirstRequirement();

    public abstract Colour getColourSecondRequirement();
}
