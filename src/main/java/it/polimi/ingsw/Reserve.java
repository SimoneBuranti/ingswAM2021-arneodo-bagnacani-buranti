package it.polimi.ingsw;

import java.util.*;

public class Reserve {

    /**
     * AMOUNT indicates the finite initial amount per resource type
     */
    private static final int AMOUNT = 100;

    /**
     * A static final map reservePools collects the current resource amount of the reserve
     */
    private static final Map<Resource , Integer> reservePools = new HashMap<>();

    /**
     * The constructor initialise every resource type to the requirement parameter
     * @return Reserve
     */
    public Reserve() {
        reservePools.put(Resource.COIN,AMOUNT);
        reservePools.put(Resource.ROCK,AMOUNT);
        reservePools.put(Resource.SHIELD,AMOUNT);
        reservePools.put(Resource.SERVANT,AMOUNT);
    }

    /**
     *Getter for tests
     * @return int  (resource current amount)
     */
    public static Integer getAmountOf(Resource resource) {

        return reservePools.get(resource);
    }

    /** Static method
     *addResource(Resource) adds a resource type one at a time without restrictions
     */
    public static void addResource(Resource resource) {

        reservePools.put(resource, reservePools.remove(resource) + 1);
    }

    /** Static method
     *getResource(Resource) decrease a resource type counter one at a time only if
     * available, an UnavailableResourceException otherwise.
     */
    public static void getResource(Resource resource) throws UnavailableResourceException{

        if (reservePools.get(resource) != 0) {
            reservePools.put(resource , reservePools.remove(resource) -1);

            return;
        }

        throw new UnavailableResourceException();
    }

}
