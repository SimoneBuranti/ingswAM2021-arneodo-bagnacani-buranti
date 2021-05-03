package it.polimi.ingsw.server.model.players;

import com.google.gson.Gson;
import it.polimi.ingsw.RuntimeTypeAdapterFactory;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.leaderCards.*;
import it.polimi.ingsw.server.model.requirements.*;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class represents the second player in the multiplayer game to play in a round
 */
public class PlayerSecond extends Player{
    FileWriter fileInformatioPlayerSecond;
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


    /**
     * save information for a possible restart game
     */
    @Override
    public void savePlayerInformation(){
        Gson gson=gameBoardSaving();
        String jsonStrin = gson.toJson(getGameBoardOfPlayer());
        try {

            // Constructs a FileWriter given a file name, using the platform's default charset
            fileInformatioPlayerSecond = new FileWriter("src/main/resources/fileInformatioPlayerThird.json");
            fileInformatioPlayerSecond.write(jsonStrin);
        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                fileInformatioPlayerSecond.flush();
                fileInformatioPlayerSecond.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

    }
}
