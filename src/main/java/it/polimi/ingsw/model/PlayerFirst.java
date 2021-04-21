package it.polimi.ingsw.model;

/**
 * This class represents the first player in the multiplayer game to play in a round, he is the one who has the inkwell
 */
public class PlayerFirst extends Player{

    /**
     * Default constructor that calls the super class constructor
     * @param nickName : the nickname chosen by the player
     * @param game : the game the player is playing
     */
    public PlayerFirst(String nickName, Game game){
        super(nickName, game);
    }

}
