package it.polimi.ingsw.server.model.players;

import com.google.gson.Gson;
import it.polimi.ingsw.RuntimeTypeAdapterFactory;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.exceptions.CallForCouncilException;
import it.polimi.ingsw.server.model.exceptions.LastSpaceReachedException;
import it.polimi.ingsw.server.model.leaderCards.*;
import it.polimi.ingsw.server.model.requirements.*;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class represents the third player in the multiplayer game to play in a round
 */
public class PlayerFourth extends Player {
    FileWriter fileInformatioPlayerFourth;
    /**
     * Default constructor that calls the super class constructor
     * @param nickName : the nickname chosen by the player
     * @param game : the game the player is playing
     */
    public PlayerFourth(String nickName, Game game){
        super(nickName, game);
    }

    /**
     * This method initializes the second player's storage with the resources passed as a parameter
     * and moves the player's faith indicator one position forward
     * @param resourceOne : first player's starting resource
     * @param resourceTwo : second player's starting resource
     * @throws CallForCouncilException : the exception which is thrown when the faith indicator has reached the current papal space
     * @throws LastSpaceReachedException : the exception which is thrown when the faith indicator has reached the last papal space
     */
    @Override
    public void initResource(Resource resourceOne, Resource resourceTwo) throws CallForCouncilException, LastSpaceReachedException {
        getGameBoardOfPlayer().addToStorage(resourceOne);
        getGameBoardOfPlayer().addToStorage(resourceTwo);
        getGameBoardOfPlayer().faithMove();
    }

    /**
     * save information for a possible restart game
     */
    @Override
    public void savePlayerInformation(){
        Gson gson=gameBoardSaving();
        String jsonStrin = gson.toJson(getGameBoardOfPlayer());
        try {

            // Constructs a FileWriter given a file name, using the platform's default charset
            fileInformatioPlayerFourth = new FileWriter("src/main/resources/fileInformatioPlayerFourth.json");
            fileInformatioPlayerFourth.write(jsonStrin);
        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                fileInformatioPlayerFourth.flush();
                fileInformatioPlayerFourth.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

    }}
