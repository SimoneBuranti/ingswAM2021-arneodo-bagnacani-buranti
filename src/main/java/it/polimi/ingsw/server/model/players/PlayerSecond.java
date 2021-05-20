package it.polimi.ingsw.server.model.players;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.server.model.RuntimeTypeAdapterFactory;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.gameBoard.*;
import it.polimi.ingsw.server.model.leaderCards.*;
import it.polimi.ingsw.server.model.requirements.*;
import it.polimi.ingsw.server.virtualview.VirtualView;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
     */
    public PlayerSecond(String nickName, Game game, VirtualView virtualView){
        super(nickName, game,virtualView );
    }


    /**
     * Restore constructor that calls the super class constructor
     * @param nickName : the nickname chosen by the player
     */

    public PlayerSecond(String nickName, Game game, boolean newmatch,VirtualView virtualView){
        super(nickName,game,newmatch,virtualView);
        Gson gson=gsonForEveryone();
        try {
            this.gameBoardOfPlayer= gson.fromJson(new FileReader("src/main/resources/fileInformationPlayerSecond.json"),GameBoardInterface.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.leaderCard= gson.fromJson(new FileReader("src/main/resources/fileInformationLeaderInitPlayerSecond.json"),int[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        reverseAddPersonalLeaderCardAskey();
        try {
            this.init= gson.fromJson(new FileReader("src/main/resources/fileInformationInitPlayerSecond.json"),boolean.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
        Gson gson= gsonForEveryone();
        String jsonStrin = gson.toJson(getGameBoardOfPlayer(),GameBoardInterface.class);
        try {
            fileInformatioPlayerSecond = new FileWriter("src/main/resources/fileInformationPlayerSecond.json");
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
        String jsonStrin2 = gson.toJson(isInit(),boolean.class);
        try {
            fileInformatioPlayerSecond = new FileWriter("src/main/resources/fileInformationInitPlayerSecond.json");
            fileInformatioPlayerSecond.write(jsonStrin2);
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
        getPersonalLeaderCardAskey();

        String jsonStrin3 = gson.toJson(getLeaderCard(),int[].class);
        try {
            fileInformatioPlayerSecond = new FileWriter("src/main/resources/fileInformationLeaderInitPlayerSecond.json");
            fileInformatioPlayerSecond.write(jsonStrin3);
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                fileInformatioPlayerSecond.flush();
                fileInformatioPlayerSecond.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        } }
}
