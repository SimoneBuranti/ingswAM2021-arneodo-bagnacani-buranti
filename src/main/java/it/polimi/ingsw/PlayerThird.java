package it.polimi.ingsw;

import java.util.ArrayList;

public class PlayerThird extends Player {

    private ArrayList<LeaderCard> personalLeaderCard = new ArrayList<LeaderCard>(4);



    public PlayerThird(String nickName){
        super(nickName);

    }



    /**
     * @param resourceOne
     * during the pregame playerSecond can choose one type of resource, with a move on faithpath
     *
     */
    public void initResource(Resource resourceOne) throws UnavailableResourceException, CallForCouncilException, LastSpaceReachedException {
        getGameBoardOfPlayer().addToStorage(resourceOne);
        getGameBoardOfPlayer().faithMove();

    }

    /**
     * methods null for the third player, ThirdPlayer can't do these actions
     *
     */
    public void initResource(Resource resourceOne,Resource resourceTwo){}
    public void initResource(){}

}
