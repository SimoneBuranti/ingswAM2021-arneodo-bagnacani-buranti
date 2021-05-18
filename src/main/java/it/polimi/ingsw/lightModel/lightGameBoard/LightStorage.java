package it.polimi.ingsw.lightModel.lightGameBoard;

import it.polimi.ingsw.server.model.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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


    public void addResource(Resource resource){
        storageResource.put(resource, storageResource.remove(resource) + 1);
    }

    public void addResource(Resource resource, int quantity){
        storageResource.put(resource, storageResource.remove(resource) + quantity);
    }

    public void addResource(Map<Resource,Integer> map){
        for(Resource key :map.keySet()){
            storageResource.put(key,storageResource.remove(key) +  map.get(key));
        }
    }

    public void addResource(ArrayList<Resource> list){
        for(Resource resource : list){
            storageResource.put(resource, storageResource.remove(resource) + 1);
        }
    }

    public void removeResource(Resource resource, int quantity){
        if(storageResource.get(resource) >= quantity)
            storageResource.put(resource, storageResource.remove(resource) - quantity);
    }

    public void removeResource(Map<Resource,Integer> map){
        for(Resource key :map.keySet()){
            if(storageResource.get(key) >= map.get(key))
                storageResource.put(key,storageResource.remove(key) -  map.get(key));
        }
    }

    public Map<Resource,Integer> removeAvailableResource(Map<Resource,Integer> map){
        for(Resource key :map.keySet()){
            if(storageResource.get(key) >= map.get(key)) {
                storageResource.put(key, storageResource.remove(key) - map.get(key));
                map.remove(key);
            }else{
                storageResource.put(key, 0);
                map.put(key, map.get(key) - storageResource.remove(key));
            }
        }
        return map;
    }

    public void removeResource(ArrayList<Resource> list){
        for(Resource resource : list){
            if(storageResource.get(resource) != 0)
                storageResource.put(resource, storageResource.remove(resource) - 1);
        }
    }

    public Map<Resource,Integer> getStorage(){
        Map<Resource,Integer> map = storageResource;
        return map;
    }

    public ArrayList<Resource> availableResources(){
        ArrayList<Resource> list = new ArrayList<>();

        for(Resource key : storageResource.keySet()) {
            for(int i=0;i<storageResource.get(key);i++)
                list.add(key);
        }

        return list;
    }

    public int getResource(Resource resource){
        return storageResource.get(resource);
    }


}
