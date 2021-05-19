package it.polimi.ingsw.client.lightModel.lightGameBoard;

import it.polimi.ingsw.server.model.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LightStrongbox {
    /**
     * This attribute collects the current amount of resources of the storage
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


    public void addResource(Resource resource, int quantity){
        strongboxResource.put(resource, strongboxResource.remove(resource) + quantity);
    }

    public void addResource(Map<Resource,Integer> map){
        for(Resource key :map.keySet()){
            strongboxResource.put(key,strongboxResource.remove(key) +  map.get(key));
        }
    }

    public void addResource(ArrayList<Resource> list){
        for(Resource resource : list){
            strongboxResource.put(resource, strongboxResource.remove(resource) + 1);
        }
    }

    public void removeResource(Resource resource, int quantity){
        if(strongboxResource.get(resource) >= quantity)
            strongboxResource.put(resource, strongboxResource.remove(resource) - quantity);
    }

    public void removeResource(Map<Resource,Integer> map){
        for(Resource key :map.keySet()){
            if(strongboxResource.get(key) >= map.get(key))
                strongboxResource.put(key,strongboxResource.remove(key) -  map.get(key));
        }
    }

    public void removeResource(ArrayList<Resource> list){
        for(Resource resource : list){
            if(strongboxResource.get(resource) != 0)
                strongboxResource.put(resource, strongboxResource.remove(resource) - 1);
        }
    }

    public Map<Resource,Integer> getStrongbox(){
        Map<Resource,Integer> map = strongboxResource;
        return map;
    }

    public ArrayList<Resource> availableResources(){
        ArrayList<Resource> list = new ArrayList<>();

        for(Resource key : strongboxResource.keySet()) {
            for(int i=0;i<strongboxResource.get(key);i++)
                list.add(key);
        }

        return list;
    }

    public int getResource(Resource resource){
        return strongboxResource.get(resource);
    }

}
