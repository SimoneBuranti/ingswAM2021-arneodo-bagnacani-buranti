package it.polimi.ingsw.model;

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
    public ProductionCard(Map<Resource,Integer> cost, Map<Resource,Integer> in, Map<Resource,Integer> out, int points, int level, Colour colour, int faithPoint) {
        this.costProductionCard = cost;
        this.inputResources = in;
        this.outputResources = out;
        this.points = points;
        this.level = level;
        this.colour = colour;
        this.faithPoint = faithPoint;
    }



    /**
     * Getter method for the card cost
     * It returns a copy of the private attribute
     */
    public Map<Resource,Integer> getCost() {
        Map<Resource,Integer> m = new HashMap<>();
        m.putAll(costProductionCard);
        return m;
    }

    /**
     * getter method for the card input resources which are required for production effect
     * It returns a copy of the private attribute
     */
    public ArrayList<Resource> getIn() {
        ArrayList<Resource>  input= new ArrayList<>();
        for (Resource key : inputResources.keySet())
            for(int i=0;i<inputResources.get(key);i++)
                input.add(key);
        return input;
    }

    /**
     *getter method for the card output resources which are produced by production effect
     * It returns a copy of the private attribute
     */
    public ArrayList<Resource> getOut() {
        ArrayList<Resource>  output = new ArrayList<>();
        for (Resource key : outputResources.keySet())
            for(int i=0;i<outputResources.get(key);i++)
                output.add(key);
        return output;
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
     * getter method for activate or not move on faithPath
     */
    public int isFaithPoint() {
        return faithPoint;
    }
}