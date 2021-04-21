package it.polimi.ingsw.model;

/**
 * This class represents the third player in the multiplayer game to play in a round
 */
public class PlayerThird extends Player {

    /**
     * Default constructor that calls the super class constructor
     * @param nickName : the nickname chosen by the player
     * @param game : the game the player is playing
     */
    public PlayerThird(String nickName, Game game){
        super(nickName, game);
    }

    /**
     * This method initializes the second player's storage with the resource passed as a parameter
     * and moves the player's faith indicator one position forward
     * @param resourceOne : player's starting resource
     * @throws CallForCouncilException : the exception which is thrown when the faith indicator has reached the current papal space
     * @throws LastSpaceReachedException : the exception which is thrown when the faith indicator has reached the last papal space
     */
    @Override
    public void initResource(Resource resourceOne) throws CallForCouncilException, LastSpaceReachedException {
        getGameBoardOfPlayer().addToStorage(resourceOne);
        getGameBoardOfPlayer().faithMove();
    }

}
