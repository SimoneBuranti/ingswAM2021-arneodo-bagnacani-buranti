package it.polimi.ingsw.server.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.observer.Observable;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.exceptions.UnavailableResourceException;
import it.polimi.ingsw.server.model.marbles.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * this class represents the game resource reserve common to all players
 */
public class Reserve extends Observable {

    /**
     * AMOUNT indicates the finite initial amount per resource type
     */
    private static final int AMOUNT = 100;

    /**
     * A static final map reservePools collects the current resource amount of the reserve
     */
    private static Map<Resource , Integer> reservePools = new HashMap<>();

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
    public static void getResource(Resource resource) throws UnavailableResourceException {

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
    /**
     * method for saveInformationOfReserve
     */
    public void saveInformationOfReserve(){

        Gson g=gsonForEveryoneReserve();
        FileWriter config = null;
        String jsonStrin = g.toJson(reservePools);
        try {
            // Constructs a FileWriter given a file name, using the platform's default charset
            config = new FileWriter("src/main/resources/fileConfiguration/Reserve.json");
            config.write(jsonStrin);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                config.flush();
                config.close();
            } catch (IOException e) {
                e.printStackTrace();
            } } }



    public  int getAmountOfInMAp(Map map,Resource resource) {
        int amount;
        amount= (int) map.get(resource);
        return amount;
    }

    public Reserve(Map map) throws IOException, InterruptedException {
        int amount;
        amount=getAmountOfInMAp(map,Resource.COIN);
        reservePools.put(Resource.COIN,amount);
        amount=getAmountOfInMAp(map,Resource.ROCK);
        reservePools.put(Resource.ROCK,amount);
        amount=getAmountOfInMAp(map,Resource.SERVANT);
        reservePools.put(Resource.SERVANT,amount);
        amount=getAmountOfInMAp(map,Resource.SHIELD);
        reservePools.put(Resource.SHIELD,amount);
    }

    public Map<Resource , Integer> getReservePool(){
        return reservePools;
    }

    public static Gson gsonForEveryoneReserve(){
        RuntimeTypeAdapterFactory<Colour> adapterColour =
                RuntimeTypeAdapterFactory
                        .of(Colour.class)
                        .registerSubtype(Green.class)
                        .registerSubtype(Yellow.class)
                        .registerSubtype(Blue.class)
                        .registerSubtype(Violet.class);

        RuntimeTypeAdapterFactory<Marble> adapterMarble =
                RuntimeTypeAdapterFactory
                        .of(Marble.class)
                        .registerSubtype(Marble.class)
                        .registerSubtype(GreyMarble.class)
                        .registerSubtype(YellowMarble.class)
                        .registerSubtype(BluMarble.class)
                        .registerSubtype(WhiteMarble.class)
                        .registerSubtype(PurpleMarble.class)
                        .registerSubtype(RedMarble.class);



        Gson gson=new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapterFactory(adapterMarble)
                .registerTypeAdapterFactory(adapterColour)
                .create();

        return gson;

    }
}


