package it.polimi.ingsw.model;

/**
 * class for SecondLevelRequirement, player need a cardLevel2 of colorRequirements
 */
public class SecondLevelRequirement extends Requirements {
    private  Colour  colourRequirement;
    public SecondLevelRequirement(Colour colourRequirement){
        this.colourRequirement=colourRequirement;

    }

    @Override
    public Colour getColourDoubleRequirement() {
        return null;
    }

    @Override
    public Colour getColourSingleRequirement() {
        return null;
    }

    @Override
    public Colour getColourRequirement() {
        return colourRequirement;
    }

    @Override
    public Resource getResourceRequirement() {
        return null;
    }

    @Override
    public Colour getColourFirstRequirement() {
        return null;
    }

    @Override
    public Colour getColourSecondRequirement() {
        return null;
    }
}
