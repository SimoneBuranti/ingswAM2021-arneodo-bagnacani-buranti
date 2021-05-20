package it.polimi.ingsw.server.model.players;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.server.model.RuntimeTypeAdapterFactory;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.gameBoard.*;
import it.polimi.ingsw.server.model.leaderCards.*;
import it.polimi.ingsw.server.model.requirements.*;
import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.virtualview.VirtualView;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
     */
    public PlayerFirst(String nickName, Game game, VirtualView virtualView){
        super(nickName, game ,virtualView);
    }



    /**
     * Restore constructor that calls the super class constructor
     * @param nickName : the nickname chosen by the player
     */

    public PlayerFirst(String nickName, Game game, boolean newmatch,VirtualView virtualView){
        super(nickName,game,newmatch,virtualView);

       Gson gson=gsonForEveryone();
       try {
           this.gameBoardOfPlayer= gson.fromJson(new FileReader("src/main/resources/fileInformationPlayerFirst.json"),GameBoardInterface.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.leaderCard= gson.fromJson(new FileReader("src/main/resources/fileInformationLeaderInitPlayerFirst.json"),int[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        reverseAddPersonalLeaderCardAskey();
        try {
            this.init= gson.fromJson(new FileReader("src/main/resources/fileInformationInitPlayerFirst.json"),boolean.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }





    /**
     * save information for a possible restart game
     */
    @Override
    public void savePlayerInformation(){
        Gson gson= gsonForEveryone();
        String jsonStrin = gson.toJson(getGameBoardOfPlayer(),GameBoardInterface.class);
        try {
            fileInformatioPlayerFirst = new FileWriter("src/main/resources/fileInformationPlayerFirst.json");
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
        String jsonStrin2 = gson.toJson(isInit(),boolean.class);
        try {
            fileInformatioPlayerFirst = new FileWriter("src/main/resources/fileInformationInitPlayerFirst.json");
            fileInformatioPlayerFirst.write(jsonStrin2);
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

        getPersonalLeaderCardAskey();
        String jsonStrin3 = gson.toJson(getLeaderCard(),int[].class);
        try {
            fileInformatioPlayerFirst = new FileWriter("src/main/resources/fileInformationLeaderInitPlayerFirst.json");
            fileInformatioPlayerFirst.write(jsonStrin3);
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                fileInformatioPlayerFirst.flush();
                fileInformatioPlayerFirst.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        } }
}
