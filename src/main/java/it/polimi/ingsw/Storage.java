package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the storage of the gameboard
 */
public class Storage {
    /**
     * This attribute collects the current amount of resources of the storage
     */
    private final Map<Resource,Integer> storageResource = new HashMap<>();

    /**
     *The constructor initialises the map with every type of resources
     */
    public Storage(){
        storageResource.put(Resource.COIN, 0);
        storageResource.put(Resource.ROCK, 0);
        storageResource.put(Resource.SERVANT, 0);
        storageResource.put(Resource.SHIELD, 0);
    }

    /**
     *This method removes a resource type from the reserve if available by adding it to the map,
     * it does nothing otherwise
     * @param resource :type of resource to add
     */
    public void addResource(Resource resource) throws UnavailableResourceException{
        int value;

        Reserve.getResource(resource);

        if(storageResource.containsKey(resource))
            value = storageResource.get(resource) + 1;
        else
            value = 1;
        storageResource.put(resource, value);
    }

    /**
     *This method removes a resource type from the map if available and adds it to the reserve,
     * throws an exception otherwise
     * @param resource: type of resource to remove
     */
    public void useResource(Resource resource) throws UnavailableResourceException {
        int value;
        if (!storageResource.containsKey(resource) || storageResource.get(resource) == 0) {
            throw new UnavailableResourceException();
        }else{
            value = storageResource.get(resource) - 1;
            Reserve.addResource(resource);
            storageResource.put(resource, value);
        }
    }

    /**
     * This method check that there are at most 3 resources of a first type, 2 of a second type and 1 of a third type
     * and that there are not 4 different type of resources at the same time
     * @return boolean : if it checks the conditions returns true, false otherwise
     */
    public boolean check(ArrayList<Resource> list){
        Map<Resource,Integer> map = new HashMap<>();
        map.putAll(storageResource);
        int[] restrictions = {0,0,0,0};

        for(Resource resource : list) {
            map.put(resource, map.remove(resource) + 1);
        }

        for(Resource key : map.keySet()){
            int cont = map.get(key);
            boolean flag = false;
            while(!flag && cont<4 ){
                if (restrictions[cont] == 0){
                    flag = true;
                    restrictions[cont] = 1;
                }else{
                    cont++;
                }
            }
        }

        for(int i = 0; i < 4; i++){
            if(restrictions[i] == 0)
                return false;
        }

        return true;
    }

    /**
     * This method discards the surplus resources by placing them in the reserve and throws an exception
     */
    public void discard(Resource resource) throws discardException{
        Reserve.addResource(resource);

        throw new discardException();
    }

    /**
     *This method returns the current number of a resource type
     * @param resource : type of resource
     * @return int : the current amount of the resource
     */
    public int getResource(Resource resource){
        int numResource = 0;
        if(!storageResource.isEmpty() && storageResource.containsKey(resource)){
            numResource = storageResource.get(resource);
        }

        return numResource;
    }

    /**
     *This method returns the total number of resources in the map
     * @return int : the total amount of resources
     */
    public int resourceScore(){
        int numResourceTot = 0;

        if(!storageResource.isEmpty()) {
            for (Resource key : storageResource.keySet()) {
                numResourceTot = numResourceTot + storageResource.get(key);
            }
        }

        return numResourceTot;
    }

    /**
     * This method return a copy of the map to the caller
     * @return Map<Resource, Integer> : a copy of the map
     */
    public Map<Resource, Integer> getStorageResource() {
        Map<Resource,Integer> map = new HashMap<>();
        map.putAll(storageResource);
        return map;
    }
}
