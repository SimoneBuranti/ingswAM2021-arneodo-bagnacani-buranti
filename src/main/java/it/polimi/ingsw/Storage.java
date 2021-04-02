package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<Resource,Integer> storageResource = new HashMap<>();




    public Storage(){
        storageResource.put(Resource.COIN, 0);
        storageResource.put(Resource.ROCK, 0);
        storageResource.put(Resource.SERVANT, 0);
        storageResource.put(Resource.SHIELD, 0);

    }




    /**
     * @param resource
     * method for add a resource to storage
     */
    public void addResource(Resource resource){
        Integer value;



        if(storageResource.containsKey(resource))
            value = storageResource.get(resource) + 1;
        else
            value = 1;

        storageResource.put(resource, value);

    }




    /**
     * @param resource
     * @param reserve
     * method for remove a resource from storage
     */
    public void useResource(Resource resource, Reserve reserve){
        Integer value = 0;
        if (storageResource.containsKey(resource) && storageResource.get(resource) != 0) {
            value = storageResource.get(resource) - 1;
            reserve.addResource(resource);
        }
        storageResource.put(resource, value);
    }




    public boolean check(ArrayList<Resource> list){
        Map<Resource,Integer> map = storageResource;

        for(Resource resource : list){
            map.put(resource, map.get(resource) +1);
        }
        return false;
    }




    public void discard(){

    }



    /**
     * number of given type of resourse, from storage
     * @param resource
     * @return numResource
     */
    public int getResource(Resource resource){
        int numResource = 0;
        if(!storageResource.isEmpty() && storageResource.containsKey(resource)){
            numResource = storageResource.get(resource);
        }

        return numResource;
    }



    /**
     * points from victory, from storage
     * @return numResourceTot
     */
    public int resourceScore(){
        int numResourceTot = 0;
        if(!storageResource.isEmpty()) {
            for (Resource key : storageResource.keySet()) {
                numResourceTot = numResourceTot + storageResource.get(key);
            } }
        return numResourceTot;
    }
}