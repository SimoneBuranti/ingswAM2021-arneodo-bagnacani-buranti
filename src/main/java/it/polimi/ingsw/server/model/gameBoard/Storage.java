package it.polimi.ingsw.server.model.gameBoard;

import it.polimi.ingsw.server.model.Reserve;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.exceptions.UnavailableResourceException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the storage of the game board
 */
public class Storage {
    /**
     * This attribute collects the current amount of resources of the storage
     */
    protected final Map<Resource,Integer> storageResource = new HashMap<>();

    /**
     *The constructor initialises the map with every type of resources to zero
     */
    public Storage(){
        storageResource.put(Resource.COIN, 0);
        storageResource.put(Resource.ROCK, 0);
        storageResource.put(Resource.SERVANT, 0);
        storageResource.put(Resource.SHIELD, 0);
    }

    /**
     * The constructor initialises the map by copying all the values of the map passed as a parameter
     * @param map : the map to be copied
     */
    public Storage(Map<Resource, Integer> map){
        storageResource.putAll(map);
    }


    /**
     * This method returns an ArrayList containing the whole available resources
     * inside the storage
     * @return ArrayList<Resource> : collection of all the resources present in the storage
     */
    public ArrayList<Resource> availableResources() {
        ArrayList<Resource> storageResources = new ArrayList<>();

        for(Resource key : storageResource.keySet()) {
            for(int i=0;i<storageResource.get(key);i++)
                storageResources.add(key);
        }

        return storageResources;
    }

    /**
     * This method gets as an input the cost and after paying all possible resources it returns the unpaid resources
     * @param cost : a collection of resources to pay for
     * @return ArrayList<Resource> : a collection of unpaid resources
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
    public void addResource(Resource resource){
        int value;

        try {
            Reserve.getResource(resource);
            if(storageResource.containsKey(resource))
                value = storageResource.get(resource) + 1;
            else
                value = 1;
            storageResource.put(resource, value);
        } catch (UnavailableResourceException ignored) {}
    }

    /**
     * This method removes a resource type from the map if available and adds it to the reserve,
     * throws an exception otherwise
     * @param resource: type of resource to remove
     * @throws UnavailableResourceException : the exception which is thrown when there are no more resources in the storage
     *                                        of the resource type to be withdrawn
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
     * This method checks that there are at most 3 resources of a first type, 2 of a second type and 1 of a third type
     * in the storage with added the resources passed as a parameter and that there are not 4 different type
     * of resources at the same time
     * @param list : a list of resources to check before adding
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
     * This method returns the current number of a resource type
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
     * This method returns the total number of resources in the map
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
     * This method returns a copy of the map to the caller
     * @return Map<Resource, Integer> : a copy of the map
     */
    public Map<Resource, Integer> getStorageResource() {
        Map<Resource,Integer> map = new HashMap<>();
        map.putAll(storageResource);
        return map;
    }

    /**
     * method of the subclass that does nothing
     * @return boolean : false
     */
    public boolean isStorageExtraFirstFull(){
        return false;
    }

    /**
     * method of the subclass that does nothing
     * @return boolean : false
     */
    public boolean isStorageExtraFirstEmpty(){
        return false;
    }

    /**
     * method of the subclass that does nothing
     * @return Resource : null
     */
    public Resource getFirstResourceType() {
        return null;
    }

    /**
     * method of the subclass that does nothing
     * @return int : 0
     */
    public int getNumExtraFirstAvailable(){return 0;}

    /**
     * method of the subclass that does nothing
     * @return boolean : false
     */
    public boolean isStorageExtraSecondFull(){
        return false;
    }

    /**
     * method of the subclass that does nothing
     * @return boolean : false
     */
    public boolean isStorageExtraSecondEmpty(){
        return false;
    }

    /**
     * method of the subclass that does nothing
     * @return Resource : null
     */
    public Resource getSecondResourceType() {
        return null;
    }

    /**
     * method of the subclass that does nothing
     * @return int : 0
     */
    public int getNUmExtraSecondAvailable(){
        return 0;
    }
}
