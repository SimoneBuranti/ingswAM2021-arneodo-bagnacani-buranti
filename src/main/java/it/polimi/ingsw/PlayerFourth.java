package it.polimi.ingsw;

public class PlayerFourth extends Player {



    /**
     * methods null for the first player
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
    public void initResource(Resource resourceOne,Resource resourceTwo) throws UnavailableResourceException, CallForCouncilException {
        getGameBoardOfPlayer().addResourceToStorage(resourceOne);
        getGameBoardOfPlayer().addResourceToStorage(resourceTwo);
        getGameBoardOfPlayer().faithMove();

    }
}
