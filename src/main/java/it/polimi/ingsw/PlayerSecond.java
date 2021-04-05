package it.polimi.ingsw;

public class PlayerSecond extends Player{


    /**
     * @param resourceOne
     * during the pregame playerSecond can choose one type of resource
     *
     */
    public void initResource(Resource resourceOne) throws UnavailableResourceException {
        getGameBoardOfPlayer().addResourceToStorage(resourceOne);
    }

    /**
     * methods null for the first player
     *
     */

    public void initResource(){}
    public void initResource(Resource resourceOne,Resource resourceTwo){}
}
