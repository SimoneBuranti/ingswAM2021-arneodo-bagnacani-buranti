package it.polimi.ingsw;
import java.util.*;

/**
 * This class represents the strongbox of the gameboard
 */
public class Strongbox {

    /**
     * This attribute collects the current amount of resources of the strongbox
     */
    private final Map<Resource,Integer> storageStrongBox = new HashMap<>();

    /**
     *The constructor initialises the map with every type of resources
     */
    public Strongbox(){
        storageStrongBox.put(Resource.COIN, 0);
        storageStrongBox.put(Resource.ROCK, 0);
        storageStrongBox.put(Resource.SERVANT, 0);
        storageStrongBox.put(Resource.SHIELD, 0);
    }


    /**
     * This method returns an ArrayList containing the whole available resources
     * inside the storage
     * @return
     */
    public ArrayList<Resource> availableResources() {
        ArrayList<Resource> strongboxResources = new ArrayList<>();

        for(Resource key : storageStrongBox.keySet()) {
            for(int i=0;i<storageStrongBox.get(key);i++)
                strongboxResources.add(key);
        }
        return strongboxResources;
    }


    /**
     * This method gets as an input the resource ArrayList containing the cost and return the unpaid resources.
     * @param cost
     * @return
     */
    public ArrayList<Resource> payResources(ArrayList<Resource> cost) {

        ArrayList<Resource> unpaid = new ArrayList<>();

        for(Resource resource : cost){
            try {
                useResource(resource);
            } catch (UnavailableResourceException e) {
                unpaid.add(resource);
            }
        }

        return unpaid;
    }


    /**
     * This method removes a resource type from the reserve if available by adding it to the map,
     * it does nothing otherwise
     * @param resource :type of resource to add
     */
    public void addResource(Resource resource) {
        int value;

        try {
            Reserve.getResource(resource);
            if(storageStrongBox.containsKey(resource))
                value = storageStrongBox.get(resource) + 1;
            else
                value = 1;
            storageStrongBox.put(resource, value);
        } catch (UnavailableResourceException ignored) {}
    }

    /**
     *This method removes a resource type from the map if available and adds it to the reserve,
     * throws an exception otherwise
     * @param resource: type of resource to remove
     */
    public void useResource(Resource resource) throws UnavailableResourceException{
        int value;
        if (!storageStrongBox.containsKey(resource) || storageStrongBox.get(resource) == 0) {
            throw new UnavailableResourceException();
        }else{
            value = storageStrongBox.get(resource) - 1;
            Reserve.addResource(resource);
            storageStrongBox.put(resource, value);
        }
    }

    /**
     *This method returns the current number of a resource type
     * @param resource : type of resource
     * @return int : the current amount of the resource
     */
    public int getResource(Resource resource){
        int numResource = 0;
        if(!storageStrongBox.isEmpty() && storageStrongBox.containsKey(resource)){
            numResource = storageStrongBox.get(resource);
        }

        return numResource;
    }

    /**
     * This method returns the total number of resources in the map
     * @return int : the total amount of resources
     */
    public int resourceScore(){
        int numResourceTot = 0;

        if(!storageStrongBox.isEmpty()) {
            for (Resource key : storageStrongBox.keySet()) {
                numResourceTot = numResourceTot + storageStrongBox.get(key);
            }
        }

        return numResourceTot;
    }

}
