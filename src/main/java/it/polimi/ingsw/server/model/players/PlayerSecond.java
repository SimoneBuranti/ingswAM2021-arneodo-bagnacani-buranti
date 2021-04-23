package it.polimi.ingsw.server.model.players;

import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.model.Resource;

/**
 * This class represents the second player in the multiplayer game to play in a round
 */
public class PlayerSecond extends Player{

    /**
     * Default constructor that calls the super class constructor
     * @param nickName : the nickname chosen by the player
     * @param game : the game the player is playing
     */
    public PlayerSecond(String nickName, Game game){
        super(nickName, game);
    }

    /**
     * This method initializes the second player's storage with the resource passed as a parameter
     * @param resourceOne : player's starting resource
     */
    @Override
    public void initResource(Resource resourceOne){
        getGameBoardOfPlayer().addToStorage(resourceOne);
    }

}
