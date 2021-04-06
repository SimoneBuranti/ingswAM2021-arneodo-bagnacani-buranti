package it.polimi.ingsw;

public class LeaderCardMarble extends LeaderCard{
    private Resource whiteMarble;

    public LeaderCardMarble(Requirements requirements, int point ,Resource whiteMarble){
        super(requirements,point);
        this.whiteMarble=whiteMarble;
    }


    /**
     * method  on abilityActivation of the decorator
     */
    public void abilityActivation(){}

    /**
     * method check for the possibility of activate leader card
     * the ability is the possibility to have a Resource from a whiteMarble in Market
     */
    public void check(){}
}
