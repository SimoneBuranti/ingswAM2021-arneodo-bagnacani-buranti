package it.polimi.ingsw.client.lightModel.lightGameBoard;

import it.polimi.ingsw.server.model.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the strongbox of the light model
 */
public class LightStrongbox {
    /**
     * This attribute collects the current amount of resources of the strongbox
     */
    private final Map<Resource,Integer> strongboxResource = new HashMap<>();

    /**
     *The constructor initialises the map with every type of resources to zero
     */
    public LightStrongbox(){
        strongboxResource.put(Resource.COIN, 0);
        strongboxResource.put(Resource.ROCK, 0);
        strongboxResource.put(Resource.SERVANT, 0);
        strongboxResource.put(Resource.SHIELD, 0);
    }

    /**
     * This method adds the resources to the strongbox
     * @param map : the map of resources to add
     */
    public void addResource(Map<Resource,Integer> map){
        for(Resource key :map.keySet()){
            strongboxResource.put(key,strongboxResource.remove(key) +  map.get(key));
        }
    }

    /**
     * This method adds the resources to the strongbox
     * @param list : the list of resources to add
     */
    public void addResource(ArrayList<Resource> list){
        for(Resource resource : list){
            strongboxResource.put(resource, strongboxResource.remove(resource) + 1);
        }
    }

    /**
     * This method removes the resources from the strongbox
     * @param list : the list of resources to remove
     */
    public void removeResource(ArrayList<Resource> list){
        for(Resource resource : list){
            if(strongboxResource.get(resource) != 0)
                strongboxResource.put(resource, strongboxResource.remove(resource) - 1);
        }
    }

    /**
     * This method returns the strongbox
     */
    public Map<Resource,Integer> getStrongbox(){
        Map<Resource,Integer> map = strongboxResource;
        return map;
    }

}
