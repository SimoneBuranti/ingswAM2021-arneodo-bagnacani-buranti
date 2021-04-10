package it.polimi.ingsw;


public class PlayerSecond extends Player{




    public PlayerSecond(String nickName, Game game){
        super(nickName, game);
    }


    /**
     * @param resourceOne
     * during the pregame playerSecond can choose one type of resource
     *
     */
    @Override
    public void initResource(Resource resourceOne) throws UnavailableResourceException {
        getGameBoardOfPlayer().addToStorage(resourceOne);
    }



}
