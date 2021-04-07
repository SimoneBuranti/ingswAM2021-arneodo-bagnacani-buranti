package it.polimi.ingsw;


public class WhiteMarbleGameboardDouble extends WhiteMarbleGameboard{

    private Resource resourceTypeSecond;

    public WhiteMarbleGameboardDouble(GameboardInterface gameboard, Resource resourceTypeFirst, Resource resourceTypeSecond) {
        super(gameboard,resourceTypeFirst);
        this.resourceTypeSecond = resourceTypeSecond;
    }

    public Resource getResourceTypeSecond() {
        return resourceTypeSecond;
    }

    @Override
    public Resource whiteExchange() {
        /*
        Resource resource;

        --facciamo scegliere quale tipo di risorsa--

        if (resource != resourceTypeFirst and resource != resourceTypeSecond)
            throw exception
        return whiteExchange(resource);
         */

        return null;
    }

    public Resource whiteExchange(Resource resourceType) throws UnavailableResourceException {
        Reserve.getResource(resourceType);

        return resourceType;
    }
}