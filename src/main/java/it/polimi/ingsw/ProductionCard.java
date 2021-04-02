package it.polimi.ingsw;

import java.util.*;

public class ProductionCard {
    private final int faithPoint;

    /**
     * costProductionCard represents the card cost as a map containing resources and their quantities
     */
    private final Map<Resource,Integer> costProductionCard;

    /**
     * inputResources contains the input set of resources for the card own production effect
     */
    private final Map<Resource,Integer> inputResources;

    /**
     * outputResources contains the output set of resources of the card own production effect
     */
    private final Map<Resource,Integer> outputResources;

    /**
     * Card own points
     */
    private final int points;

    /**
     * level indicates the card level
     */
    private final Integer level;

    /**
     * colour indicates the card colour
     */
    private final Colour colour;


    /**
     * Base Constructor of the class: every attribute is needed as a constructor parameter
     */
    public ProductionCard(Map<Resource,Integer> cost, Map<Resource,Integer> in, Map<Resource,Integer> out, int points, int level, Colour colour, int faithpoint) {
        this.costProductionCard = cost;
        this.inputResources = in;
        this.outputResources = out;
        this.points = points;
        this.level = level;
        this.colour = colour;
        this.faithPoint = faithpoint;
    }








    /**
     * Getter method for the card cost
     * It returns a copy of the private attribute
     */
    public Map<Resource,Integer> getCost() {
        Map<Resource,Integer> m = new HashMap<>();
        costProductionCard.putAll(m);
        return m;
    }

    /**
     * getter method for the card input resources which are required for production effect
     * It returns a copy of the private attribute
     */
    public Map<Resource,Integer> getIn() {
        Map<Resource,Integer> m = new HashMap<>();
        inputResources.putAll(m);
        return m;
    }

    /**
     *getter method for the card output resources which are produced by production effect
     * It returns a copy of the private attribute
     */
    public Map<Resource,Integer> getOut() {
        Map<Resource,Integer> m = new HashMap<>();
        outputResources.putAll(m);
        return m;
    }

    /**
     * getter method for the card colour
     */
    public Colour getColour() {
        return colour;
    }

    /**
     * getter method for the card level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * getter method for the card points
     */
    public Integer getPoints() {
        return this.points;
    }

    /**
     * productionOn activates the card production effect paying the required resources and providing
     * the ones specified in the attribute. All the exchanges are made with the Reserve.
     */
    public void productionOn() {}



    /**
     * getter method for activqte or not move on faithPath
     */
    public int isFaithPoint() {
        return faithPoint;
    }
}