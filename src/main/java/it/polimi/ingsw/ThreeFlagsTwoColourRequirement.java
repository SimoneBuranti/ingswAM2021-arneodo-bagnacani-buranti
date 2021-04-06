package it.polimi.ingsw;

public class ThreeFlagsTwoColourRequirement extends Requirements{
    private  Colour  colourDoubleRequirement;
    private  Colour colourSingolRequirement;
    public ThreeFlagsTwoColourRequirement(Colour colourDoubleRequirement, Colour colourSecondRequirement){
        this.colourDoubleRequirement=colourDoubleRequirement;
        this.colourSingolRequirement =colourSecondRequirement;
    }

}
