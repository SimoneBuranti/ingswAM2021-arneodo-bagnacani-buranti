package it.polimi.ingsw.model;

public class LeaderCard {

    protected int points;
    protected Requirements requirements;


    public LeaderCard(Requirements requirements,int points) {
        this.points = points;
        this.requirements=requirements;
    }

    public int getPoints() {
        return points;
    }

    public boolean abilityActivation(GameBoardInterface gameBoard){
        return false;
    }
}
