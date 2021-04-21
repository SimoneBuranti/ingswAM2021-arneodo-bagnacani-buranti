package it.polimi.ingsw.model;

import java.util.*;

/**
 * this class represents the game resource reserve common to all players
 */
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
     * The constructor initialise every resource type to the value of AMOUNT
     */
    public Reserve() {
        reservePools.put(Resource.COIN,AMOUNT);
        reservePools.put(Resource.ROCK,AMOUNT);
        reservePools.put(Resource.SHIELD,AMOUNT);
        reservePools.put(Resource.SERVANT,AMOUNT);
    }

    /**
     * static method that adds the resource passed as a parameter to the reserve
     * @param resource : resource type to add
     */
    public static void addResource(Resource resource) {

        reservePools.put(resource, reservePools.remove(resource) + 1);
    }

    /**
     * static method that decreases a resource type counter one at a time only if
     * available, otherwise it throws an UnavailableResourceException
     * @param resource : resource type to remove
     * @throws UnavailableResourceException : the exception which is thrown when there are no more resources in the reserve
     *                                        of the resource type to be withdrawn
     */
    public static void getResource(Resource resource) throws UnavailableResourceException{

        if (reservePools.get(resource) != 0) {
            reservePools.put(resource , reservePools.remove(resource) -1);
            return;
        }

        throw new UnavailableResourceException();
    }

    /**
     * Test only method: getter method for the amount of the resource passed as a parameter in the reserve
     * @param resource : type of resource
     * @return int : resource current amount
     */
    public static Integer getAmountOf(Resource resource) {

        return reservePools.get(resource);
    }

}
