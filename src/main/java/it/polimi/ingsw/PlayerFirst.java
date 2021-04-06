package it.polimi.ingsw;

import java.util.ArrayList;

public class PlayerFirst extends Player{
    private ArrayList<LeaderCard> personalLeaderCard = new ArrayList<LeaderCard>(4);






    public PlayerFirst(String nickName){
        super(nickName);

    }

    /**
     * methods null for the first player
     *
     */
    public void initResource(){}
    public void initResource(Resource resource){}
    public void initResource(Resource resourceOne,Resource resourceTwo){}

}
