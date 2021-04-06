package it.polimi.ingsw;

public class LeaderCard {
    private Requirements requirements;
    private int point;

    public LeaderCard(Requirements requirements, int point){
        this.point=point;
        this.requirements=requirements;
    }


    /**
     * @return point
     */
    public int getPoint() {
        return point;
    }

    /**
     * method check for the possibility of activate leader card
     */
    public void check(){}


    /**
     * method empty for the general class on abilityActivation
     */
    public void abilityActivation(){}

}
