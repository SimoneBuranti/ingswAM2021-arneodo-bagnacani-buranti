package it.polimi.ingsw;

public class LeaderCardProduction extends LeaderCard {
    private Resource resourceProduction;
    public LeaderCardProduction(Requirements requirements, int point ,Resource resourceProduction){
        super(requirements,point);
        this.resourceProduction=resourceProduction;
    }

    /**
     * method  on abilityActivation of the decorator
     */
    public void abilityActivation(){}

    /**
     * method check for the possibility of activate leader card
     * the ability is improving on Prodction on resource
     */
    public void check(){}
}
