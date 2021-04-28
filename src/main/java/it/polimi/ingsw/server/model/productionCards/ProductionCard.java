package it.polimi.ingsw.server.model.productionCards;

import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.Colour;

import java.util.*;

/**
 * This class represents the production card
 */
public class ProductionCard {
    /**
     * this attribute indicates how many cells of the faith path to move forward the faith indicator
     * of the player who activated the production of the production card
     */
    private final int faithPoint;

    /**
     * this attribute represents the card cost as a map containing resources and their quantities
     */
    private final Map<Resource,Integer> costProductionCard;

    /**
     * this attribute contains the input set of resources for the card own production effect
     */
    private final Map<Resource,Integer> inputResources;

    /**
     * this attribute contains the output set of resources of the card own production effect
     */
    private final Map<Resource,Integer> outputResources;

    /**
     * this attribute indicates the card own victory points
     */
    private final int points;

    /**
     * this attribute indicates the card level
     */
    private final Integer level;

    /**
     * this attribute indicates the card colour
     */
    private final Colour colour;

    /**
     * this attribute indicates the key
     */
    private final int key;




    /**
     * Base Constructor of the class: every attribute is needed as a constructor parameter
     */
    public ProductionCard(Map<Resource,Integer> cost, Map<Resource,Integer> in, Map<Resource,Integer> out, int points, int level, Colour colour, int faithPoint, int key) {
        this.costProductionCard = cost;
        this.inputResources = in;
        this.outputResources = out;
        this.points = points;
        this.level = level;
        this.colour = colour;
        this.faithPoint = faithPoint;
        this.key=key;
    }


    /**
     * Getter method for the card cost
     * @return Map<Resource,Integer> : a copy of the private attribute costProductionCard
     */
    public Map<Resource,Integer> getCost() {
        Map<Resource,Integer> m = new HashMap<>();
        m.putAll(costProductionCard);
        return m;
    }

    /**
     * Getter method for the card input resources which are required for production effect
     * @return ArrayList<Resource> : a list copy of the private attribute inputResources
     */
    public ArrayList<Resource> getIn() {
        ArrayList<Resource>  input= new ArrayList<>();
        for (Resource key : inputResources.keySet())
            for(int i=0;i<inputResources.get(key);i++)
                input.add(key);
        return input;
    }

    /**
     * Getter method for the card output resources which are produced by production effect
     * @return ArrayList<Resource> : a list copy of the private attribute outputResources
     */
    public ArrayList<Resource> getOut() {
        ArrayList<Resource>  output = new ArrayList<>();
        for (Resource key : outputResources.keySet())
            for(int i=0;i<outputResources.get(key);i++)
                output.add(key);
        return output;
    }


    /**
     * Getter method for the card colour
     * @return Colour : the card colour
     */
    public Colour getColour() {
        return colour;
    }

    /**
     * Getter method for the card level
     * @return Integer : the card level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * Getter method for the card victory points
     * @return int : the card victory points
     */
    public int getPoints() {
        return this.points;
    }


    /**
     * Getter method for the card faithPoint
     * @return int : the card faithPoint
     */
    public int isFaithPoint() {
        return faithPoint;
    }

    public int getKey() {
        return key;
    }
}