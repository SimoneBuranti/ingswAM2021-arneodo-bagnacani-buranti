package it.polimi.ingsw.model;


public class PlayerFourth extends Player {


    public PlayerFourth(String nickName, Game game){
        super(nickName, game);

    }


    /**
     * @param resourceOne
     * @param resourceTwo
     * during the pregame playerSecond can choose one type of resource, with a move on faithPath
     *
     */
    @Override
    public void initResource(Resource resourceOne,Resource resourceTwo) throws CallForCouncilException, LastSpaceReachedException {
        getGameBoardOfPlayer().addToStorage(resourceOne);
        getGameBoardOfPlayer().addToStorage(resourceTwo);
        getGameBoardOfPlayer().faithMove();

    }


}
