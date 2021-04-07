package it.polimi.ingsw;

/**
 * class for SecondLevelRequirement, playera need a cardlevel2 of colorRequirements
 */
public class SecondLevelRequirement extends Requirements {
    private  Colour  colourRequirement;
    public SecondLevelRequirement(Colour colourRequirement){
        this.colourRequirement=colourRequirement;

    }
}
