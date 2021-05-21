package it.polimi.ingsw.server.model.players;

import com.google.gson.Gson;
import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.exceptions.*;
import it.polimi.ingsw.server.model.gameBoard.*;
import it.polimi.ingsw.server.virtualview.VirtualView;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class represents the third player in the multiplayer game to play in a round
 */
public class PlayerThird extends Player {

    FileWriter fileInformatioPlayerThird;
    /**
     * Default constructor that calls the super class constructor
     * @param nickName : the nickname chosen by the player
     */
    public PlayerThird(String nickName,Game game,VirtualView virtualView){
        super(nickName, game,virtualView );
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
        try {
            getGameBoardOfPlayer().faithMove();
        } catch (CallForCouncilException e) {
            e.setNickName(nickName);
            throw e;
        } catch (LastSpaceReachedException e) {
            e.setNickName(nickName);
            throw e;
        }
    }

    /**
     * Restore constructor that calls the super class constructor
     * @param nickName : the nickname chosen by the player
     */

    public PlayerThird(String nickName, Game game, boolean newmatch,VirtualView virtualView){
        super(nickName,game,newmatch,virtualView);

        Gson gson=gsonForEveryone();
        try {
            this.gameBoardOfPlayer= gson.fromJson(new FileReader("src/main/resources/fileInformationPlayerThird.json"),GameBoardInterface.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.leaderCard= gson.fromJson(new FileReader("src/main/resources/fileInformationLeaderInitLeaderPlayerThird.json"),int[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        reverseAddPersonalLeaderCardAskey();
        try {
            this.initLeader = gson.fromJson(new FileReader("src/main/resources/fileInformationInitOnLeaderPlayerThird.json"),boolean.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            this.initResource = gson.fromJson(new FileReader("src/main/resources/fileInformationInitOnResourcePlayerThird.json"),boolean.class);
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
            fileInformatioPlayerThird = new FileWriter("src/main/resources/fileInformationPlayerThird.json");
            fileInformatioPlayerThird.write(jsonStrin);
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                fileInformatioPlayerThird.flush();
                fileInformatioPlayerThird.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        String jsonStrin2 = gson.toJson(isInitLeader(),boolean.class);
        try {
            fileInformatioPlayerThird = new FileWriter("src/main/resources/fileInformationInitOnLeaderPlayerThird.json");
            fileInformatioPlayerThird.write(jsonStrin2);
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                fileInformatioPlayerThird.flush();
                fileInformatioPlayerThird.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        getPersonalLeaderCardAskey();
        String jsonStrin3 = gson.toJson(getLeaderCard(),int[].class);
        try {
            fileInformatioPlayerThird = new FileWriter("src/main/resources/fileInformationLeaderInitLeaderPlayerThird.json");
            fileInformatioPlayerThird.write(jsonStrin3);
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                fileInformatioPlayerThird.flush();
                fileInformatioPlayerThird.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        String jsonStrin4 = gson.toJson(isInitResource(),boolean.class);
        try {
            fileInformatioPlayerThird = new FileWriter("src/main/resources/fileInformationInitOnResourcePlayerThird.json");
            fileInformatioPlayerThird.write(jsonStrin4);
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                fileInformatioPlayerThird.flush();
                fileInformatioPlayerThird.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
}
