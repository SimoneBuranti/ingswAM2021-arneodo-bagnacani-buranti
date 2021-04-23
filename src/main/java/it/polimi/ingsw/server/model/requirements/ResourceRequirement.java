package it.polimi.ingsw.server.model.requirements;


import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.Colour;

/**
 * this class represents the requirement that a player must have at least five resources in the storage or strongbox
 * of the resource type specified by this requirement in order to activate the leader card
 */
public class ResourceRequirement extends Requirements{

    /**
     * this attribute defines the type of resource that the player must have with the quantity of 5
     */
    private final Resource resourceRequirement;

    /**
     * Default constructor
     * @param resourceRequirement : the type of resource
     */
    public ResourceRequirement(Resource resourceRequirement){

        this.resourceRequirement=resourceRequirement;
    }

    /**
     * This method returns the type of resource defined by the requirement
     * @return Resource : the type of resource
     */
    @Override
    public Resource getResourceRequirement() {
        return resourceRequirement;
    }
    /**
     * method of the parent class that does nothing
     * @return null
     */
    @Override
    public Colour getColourDoubleRequirement() {
        return null;
    }
    /**
     * method of the parent class that does nothing
     * @return null
     */
    @Override
    public Colour getColourSingleRequirement() {
        return null;
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
