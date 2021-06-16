package it.polimi.ingsw.client.lightModel;

import it.polimi.ingsw.server.model.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represent the resource reserve of the light model
 */

public class LightReserve {
    /**
     * AMOUNT indicates the finite initial amount per resource type
     */
    private final int AMOUNT = 100;

    /**
     * A static final map reservePools collects the current resource amount of the reserve
     */
    private final Map<Resource, Integer> reservePools = new HashMap<>();

    /**
     * The constructor initialise every resource type to the value of AMOUNT
     */
    public LightReserve() {
        reservePools.put(Resource.COIN,AMOUNT);
        reservePools.put(Resource.ROCK,AMOUNT);
        reservePools.put(Resource.SHIELD,AMOUNT);
        reservePools.put(Resource.SERVANT,AMOUNT);
    }


    /**
     * This method sets the initial reserve values when a match is resumed
     * @param map : contains the values to subtract for each resource from the reservePools map
     */
    public void setLightReserve(Map<Resource, Integer> map){
        for(Resource resource : map.keySet()){
            reservePools.put(resource, reservePools.remove(resource) - map.get(resource));
        }
    }



    /**
     * This method adds the resources passed as a parameter to the reserve
     */
    public void addResource(ArrayList<Resource> list) {
        if (list == null || list.size() == 0){
            System.out.println("La lista passata è nulla e sono in addResource");
            return;
        }
        /*System.out.println("Stampo reserve\n");
        for(Resource resource : reservePools.keySet()){
            System.out.println(resource+": "+reservePools.get(resource));
        }
        System.out.println("Stampo list: "+list+"\n");*/

        for(Resource resource : list){
            reservePools.put(resource,reservePools.remove(resource) + 1);
        }

    }

    /**
     * This method removes the resources passed as a parameter from the reserve
     */
    public void useResource(ArrayList<Resource> list){

        for(Resource resource : list)
            if(reservePools.get(resource) > 0)
                reservePools.put(resource, reservePools.remove(resource) - 1);
    }

    /**
     * This method removes the amount passed as a parameter of the resource passed as a parameter to the reserve
     */
    public void useResource(Resource resource, int quantity){

        if(reservePools.get(resource) >= quantity)
            reservePools.put(resource, reservePools.remove(resource) - quantity);
    }

    /**
     *  This method return the reserve
     */
    public Map<Resource, Integer> getReserve(){
        return reservePools;
    }

    /**
     * This method adds the resource values to the reserve
     * @param cost : the map containing the values to be added,it represents the cost of the production card bought by an opponent
     */
    public void addResource(Map<Resource, Integer> cost) {
        for(Resource resource : cost.keySet()){
            reservePools.put(resource, reservePools.remove(resource) + cost.get(resource));
        }
    }
}
