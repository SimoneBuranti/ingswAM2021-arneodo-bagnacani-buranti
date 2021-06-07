package it.polimi.ingsw.client.lightModel.lightGameBoard;

import it.polimi.ingsw.server.model.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the storage of the light model
 */
public class LightStorage {
    /**
     * This attribute collects the current amount of resources of the storage
     */
    private final Map<Resource,Integer> storageResource = new HashMap<>();

    /**
     *The constructor initialises the map with every type of resources to zero
     */
    public LightStorage(){
        storageResource.put(Resource.COIN, 0);
        storageResource.put(Resource.ROCK, 0);
        storageResource.put(Resource.SERVANT, 0);
        storageResource.put(Resource.SHIELD, 0);
    }

    /**
     * This method adds the quantity of the resource passed as a parameter to the storage
     * @param resource : the type of resource
     * @param quantity : the quantity to add
     */
    public void addResource(Resource resource, int quantity){
        storageResource.put(resource, storageResource.remove(resource) + quantity);
    }

    /**
     * This method adds the resources to the storage
     * @param map : the map of resources to add
     */
    public void addResource(Map<Resource,Integer> map){
        for(Resource key :map.keySet()){
            storageResource.put(key,storageResource.remove(key) +  map.get(key));
        }
    }

    /**
     * This method adds the resources to the storage
     * @param list : the list of resources to add
     */
    public void addResource(ArrayList<Resource> list){
        for(Resource resource : list){
            storageResource.put(resource, storageResource.remove(resource) + 1);
        }
    }

    /**
     * This method removes all possible resources passed as a parameter from the storage and return the resources
     * that failed to pay
     * @param cost : the resources to be paid
     * @return ArrayList<Resource> : the resources still to be paid
     */
    public ArrayList<Resource> removeAvailableResource(ArrayList<Resource> cost){
        ArrayList<Resource> unpaid = new ArrayList<>();

        for(Resource resource : cost){
            if(storageResource.get(resource) > 0)
                useResource(resource);
            else
                unpaid.add(resource);
        }

        return unpaid;
    }


    /**
     * This method returns the storage
     */
    public Map<Resource,Integer> getStorage(){
        Map<Resource,Integer> map = storageResource;
        return map;
    }

    /**
     * This method removes one resource of the type passed as a parameter from the storage
     * @param resource : resource type to remove
     */
    public void useResource(Resource resource) {
        int value = storageResource.get(resource) - 1;
        storageResource.put(resource, value);
    }


}
