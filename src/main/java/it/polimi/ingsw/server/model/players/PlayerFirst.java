package it.polimi.ingsw.server.model.players;

import com.google.gson.Gson;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarker;
import it.polimi.ingsw.server.model.gameBoard.*;
import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.virtualview.VirtualView;

import java.io.*;
import java.nio.charset.StandardCharsets;

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
           this.gameBoardOfPlayer= gson.fromJson(new FileReader("fileConfiguration/fileInformationPlayerFirst.json"),GameBoardInterface.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.leaderCard= gson.fromJson(new FileReader("fileConfiguration/fileInformationLeaderInitLeaderPlayerFirst.json"),int[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        reverseAddPersonalLeaderCardAskey();
        try {
            this.initLeader = gson.fromJson(new FileReader("fileConfiguration/fileInformationInitOnLeaderPlayerFirst.json"),boolean.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            this.initResource = gson.fromJson(new FileReader("fileConfiguration/fileInformationInitOnResourcePlayerFirst.json"),boolean.class);
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
            fileInformatioPlayerFirst = new FileWriter("fileConfiguration/fileInformationPlayerFirst.json");
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
        String jsonStrin2 = gson.toJson(isInitLeader(),boolean.class);
        try {
            fileInformatioPlayerFirst = new FileWriter("fileConfiguration/fileInformationInitOnLeaderPlayerFirst.json");
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
            fileInformatioPlayerFirst = new FileWriter("fileConfiguration/fileInformationLeaderInitLeaderPlayerFirst.json");
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
        }
        String jsonStrin4 = gson.toJson(isInitResource(),boolean.class);
        try {
            fileInformatioPlayerFirst = new FileWriter("fileConfiguration/fileInformationInitOnResourcePlayerFirst.json");
            fileInformatioPlayerFirst.write(jsonStrin4);
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
    }
}
