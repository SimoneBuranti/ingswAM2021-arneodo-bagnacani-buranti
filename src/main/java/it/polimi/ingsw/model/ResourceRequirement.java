package it.polimi.ingsw.model;


/**
 * class for ResourceRequirement, player need five of resourceRequirement
 */

public class ResourceRequirement extends Requirements{
    private Resource resourceRequirement;
    public ResourceRequirement(Resource resourceRequirement){

        this.resourceRequirement=resourceRequirement;
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
        return resourceRequirement;
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
