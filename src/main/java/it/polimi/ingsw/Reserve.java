package it.polimi.ingsw;

import java.util.*;

public class Reserve {

    private static final int AMOUNT = 28;

    private static final Map<Resource , Integer> reservePools = new HashMap<>();

    public Reserve() {
        reservePools.put(Resource.COIN,AMOUNT);
        reservePools.put(Resource.ROCK,AMOUNT);
        reservePools.put(Resource.SHIELD,AMOUNT);
        reservePools.put(Resource.SERVANT,AMOUNT);
    }

    public static Integer getAmountOf(Resource resource) {

        return reservePools.get(resource);
    }

    public static void addResource(Resource resource) {

        reservePools.put(resource, reservePools.remove(resource) + 1);
    }

    public static void getResource(Resource resource) throws UnavailableResourceException{

        if (reservePools.get(resource) != 0) {
            reservePools.put(resource , reservePools.remove(resource) -1);

            return;
        }

        throw new UnavailableResourceException();
    }

}
