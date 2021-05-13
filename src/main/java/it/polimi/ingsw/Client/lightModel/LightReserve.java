package it.polimi.ingsw.Client.lightModel;

import com.google.gson.Gson;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.exceptions.UnavailableResourceException;
import it.polimi.ingsw.server.model.marbles.Marble;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

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

    public LightReserve(File file){
        Gson gson = new Gson();

        try {
            Map mapResource = gson.fromJson(new FileReader(file), Map.class);

            reservePools.putAll(mapResource);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setLightReserve(Map<Resource, Integer> map){
        reservePools.putAll(map);
    }



    /**
     * static method that adds the resource passed as a parameter to the reserve
     */
    public void addResource(Map<Resource, Integer> map) {

        for(Resource key : map.keySet())
            reservePools.put(key, reservePools.remove(key) + map.get(key));
    }

    public void addResource(Resource resource, int quantity) {
        reservePools.put(resource, reservePools.remove(resource) + quantity);
    }

    /**
     * static method that decreases a resource type counter one at a time only if
     * available, otherwise it throws an UnavailableResourceException
     */
    public void useResource(Map<Resource, Integer> map){

        for(Resource key : map.keySet())
            if(reservePools.get(key) >= map.get(key))
                reservePools.put(key, reservePools.remove(key) + map.get(key));
    }

    public void useResource(Resource resource, int quantity){

        if(reservePools.get(resource) >= quantity)
            reservePools.put(resource, reservePools.remove(resource) + quantity);
    }

    /**
     * Test only method: getter method for the amount of the resource passed as a parameter in the reserve
     * @param resource : type of resource
     * @return int : resource current amount
     */
    public int getAmountOf(Resource resource) {

        return reservePools.get(resource);
    }

}