package it.polimi.ingsw;

public class LeaderCard {

    private int points;
    private Requirements requirements;


    public LeaderCard(Requirements requirements,int points) {
        this.points = points;
        this.requirements=requirements;
    }

    public int getPoints() {
        return points;
    }
}
