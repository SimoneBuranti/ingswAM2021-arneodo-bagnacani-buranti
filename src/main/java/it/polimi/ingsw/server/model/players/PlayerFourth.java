package it.polimi.ingsw.server.model.players;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.server.model.RuntimeTypeAdapterFactory;
import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.exceptions.*;
import it.polimi.ingsw.server.model.gameBoard.*;
import it.polimi.ingsw.server.model.leaderCards.*;
import it.polimi.ingsw.server.model.requirements.*;
import it.polimi.ingsw.server.virtualview.VirtualView;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
     */
    public PlayerFourth(String nickName, Game game, VirtualView virtualView){
        super(nickName, game,virtualView );
    }

    /**
     * Restore constructor that calls the super class constructor
     * @param nickName : the nickname chosen by the player
     */

    public PlayerFourth(String nickName, Game game, boolean newmatch,VirtualView virtualView){
        super(nickName,game,newmatch,virtualView);
        Gson gson=gsonForEveryone();

        try {
            this.gameBoardOfPlayer= gson.fromJson(new FileReader("src/main/resources/fileInformationPlayerFourth.json"),GameBoardInterface.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.leaderCard= gson.fromJson(new FileReader("src/main/resources/fileInformationLeaderInitPlayerFourth.json"),int[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        reverseAddPersonalLeaderCardAskey();
        try {
            this.init= gson.fromJson(new FileReader("src/main/resources/fileInformationInitPlayerFourth.json"),boolean.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
     * save information for a possible restart game
     */
    @Override
    public void savePlayerInformation(){
        Gson gson= gsonForEveryone();
        String jsonStrin = gson.toJson(getGameBoardOfPlayer(),GameBoardInterface.class);
        try {
            fileInformatioPlayerFourth = new FileWriter("src/main/resources/fileInformationPlayerFourth.json");
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
        String jsonStrin2 = gson.toJson(isInit(),boolean.class);
        try {
            fileInformatioPlayerFourth = new FileWriter("src/main/resources/fileInformationInitPlayerFourth.json");
            fileInformatioPlayerFourth.write(jsonStrin2);
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
        getPersonalLeaderCardAskey();

        String jsonStrin3 = gson.toJson(getLeaderCard(),int[].class);
        try {
            fileInformatioPlayerFourth = new FileWriter("src/main/resources/fileInformationLeaderInitPlayerFourth.json");
            fileInformatioPlayerFourth.write(jsonStrin3);
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                fileInformatioPlayerFourth.flush();
                fileInformatioPlayerFourth.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        } }}
