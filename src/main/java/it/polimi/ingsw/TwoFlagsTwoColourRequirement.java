package it.polimi.ingsw;

public class TwoFlagsTwoColourRequirement extends Requirements{
    private final Colour  colourFirstRequirement;
    private final Colour  colourSecondRequirement;
    public TwoFlagsTwoColourRequirement(Colour colourFirstRequirement, Colour colourSecondRequirement){
        this.colourFirstRequirement=colourFirstRequirement;
        this.colourSecondRequirement=colourSecondRequirement;
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
        return null;
    }

    @Override
    public Resource getResourceRequirement() {
        return null;
    }

    @Override
    public Colour getColourFirstRequirement() {
        return colourFirstRequirement;
    }

    @Override
    public Colour getColourSecondRequirement() {
        return colourSecondRequirement;
    }
}
