package it.polimi.ingsw.server.model.players;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.RuntimeTypeAdapterFactory;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.gameBoard.*;
import it.polimi.ingsw.server.model.leaderCards.*;
import it.polimi.ingsw.server.model.requirements.*;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class represents the first player in the multiplayer game to play in a round, he is the one who has the inkwell
 */
public class PlayerFirst extends Player{
    FileWriter fileInformatioPlayerFirst;

    /**
     * Default constructor that calls the super class constructor
     * @param nickName : the nickname chosen by the player
     * @param game : the game the player is playing
     */
    public PlayerFirst(String nickName, Game game){
        super(nickName, game);
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
            fileInformatioPlayerFirst = new FileWriter("src/main/resources/fileInformatioPlayerThird.json");
            fileInformatioPlayerFirst.write(jsonStrin);
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                fileInformatioPlayerFirst.flush();
                fileInformatioPlayerFirst.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
    }




}}
