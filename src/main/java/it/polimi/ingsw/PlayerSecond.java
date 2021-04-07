package it.polimi.ingsw;

import java.util.ArrayList;

public class PlayerSecond extends Player{

    private ArrayList<LeaderCard> personalLeaderCard = new ArrayList<LeaderCard>(4);



    public PlayerSecond(String nickName){
        super(nickName);
    }


    /**
     * @param resourceOne
     * during the pregame playerSecond can choose one type of resource
     *
     */
    public void initResource(Resource resourceOne) throws UnavailableResourceException {
        getGameBoardOfPlayer().addToStorage(resourceOne);
    }

    /**
     * methods null for thesecond player,secondPlayer can't do these actions
     *
     */

    public void initResource(){}
    public void initResource(Resource resourceOne,Resource resourceTwo){}

}
