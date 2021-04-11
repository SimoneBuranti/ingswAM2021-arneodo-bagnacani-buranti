package it.polimi.ingsw.model;


public class PlayerThird extends Player {


    public PlayerThird(String nickName, Game game){
        super(nickName, game);

    }



    /**
     * @param resourceOne
     * during the pregame playerSecond can choose one type of resource, with a move on faithPath
     *
     */
    @Override
    public void initResource(Resource resourceOne) throws CallForCouncilException, LastSpaceReachedException {
        getGameBoardOfPlayer().addToStorage(resourceOne);
        getGameBoardOfPlayer().faithMove();

    }


}
