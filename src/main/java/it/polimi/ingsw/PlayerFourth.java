package it.polimi.ingsw;

import java.util.ArrayList;

public class PlayerFourth extends Player {

    private ArrayList<LeaderCard> personalLeaderCard = new ArrayList<LeaderCard>(4);

    public PlayerFourth(String nickName){
        super(nickName);

    }


    /**
     * methods null for the fourth player, fourthPlayer can't do these actions
     *
     */

    public void initResource(){}
    public void initResource(Resource resource){}





    /**
     * @param resourceOne
     * @param resourceTwo
     * during the pregame playerSecond can choose one type of resource, with a move on faithpath
     *
     */
    public void initResource(Resource resourceOne,Resource resourceTwo) throws UnavailableResourceException, CallForCouncilException, LastSpaceReachedException {
        getGameBoardOfPlayer().addToStorage(resourceOne);
        getGameBoardOfPlayer().addToStorage(resourceTwo);
        getGameBoardOfPlayer().faithMove();

    }


}
