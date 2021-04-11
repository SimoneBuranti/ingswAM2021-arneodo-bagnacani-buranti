package it.polimi.ingsw.model;

public class ThreeFlagsTwoColourRequirement extends Requirements{
    private final Colour  colourDoubleRequirement;
    private final Colour colourSingleRequirement;
    public ThreeFlagsTwoColourRequirement(Colour colourDoubleRequirement, Colour colourSecondRequirement){
        this.colourDoubleRequirement=colourDoubleRequirement;
        this.colourSingleRequirement =colourSecondRequirement;
    }

    @Override
    public Colour getColourDoubleRequirement() {
        return colourDoubleRequirement;
    }

    @Override
    public Colour getColourSingleRequirement() {
        return colourSingleRequirement;
    }

    @Override
    public Colour getColourRequirement() {
        return null;
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
