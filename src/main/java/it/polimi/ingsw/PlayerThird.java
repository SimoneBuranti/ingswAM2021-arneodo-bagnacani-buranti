package it.polimi.ingsw;

public class PlayerThird extends Player {



    /**
     * @param resourceOne
     * during the pregame playerSecond can choose one type of resource, with a move on faithpath
     *
     */
    public void initResource(Resource resourceOne) throws UnavailableResourceException, CallForCouncilException {
        getGameBoardOfPlayer().addResourceToStorage(resourceOne);
        getGameBoardOfPlayer().faithMove();
    }

    /**
     * methods null for the first player
     *
     */

    public void initResource(Resource resourceOne,Resource resourceTwo){}
    public void initResource(){}
}
