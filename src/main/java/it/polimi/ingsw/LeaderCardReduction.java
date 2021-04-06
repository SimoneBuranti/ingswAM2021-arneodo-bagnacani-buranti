package it.polimi.ingsw;

public class LeaderCardReduction extends LeaderCard{
    private Resource costReduction;
    public LeaderCardReduction(Requirements requirements, int point ,Resource costReduction){
        super(requirements,point);
        this.costReduction=costReduction;
    }


    /**
     * method  on abilityActivation of the decorator
     */
    public void abilityActivation(){

    }

    /**
     * method check for the possibility of activate leader card
     * the ability is Reduction on resource
     */
    public void check(){

    }
}
