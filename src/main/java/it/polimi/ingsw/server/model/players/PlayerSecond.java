package it.polimi.ingsw.server.model.players;

import com.google.gson.Gson;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.gameBoard.*;
import it.polimi.ingsw.server.virtualview.VirtualView;

import java.io.*;
import java.nio.charset.StandardCharsets;

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
     * This method initializes the second player's storage with the resource passed as a parameter
     * @param resourceOne : player's starting resource
     */
    @Override
    public void initResource(Resource resourceOne){
        getGameBoardOfPlayer().addToStorage(resourceOne);
    }



    /**
     * Restore constructor that calls the super class constructor
     * @param nickName : the nickname chosen by the player
     */

    public PlayerSecond(String nickName, Game game, boolean newmatch,VirtualView virtualView){
        super(nickName,game,newmatch,virtualView);

        Gson gson=gsonForEveryone();
       /* Reader reader;

        reader = new InputStreamReader(this.getClass().getResourceAsStream("/fileConfiguration/fileInformationPlayerSecond.json"), StandardCharsets.UTF_8);
        this.gameBoardOfPlayer = gson.fromJson(reader, GameBoardInterface.class);

        reader = new InputStreamReader(this.getClass().getResourceAsStream("/fileConfiguration/fileInformationLeaderInitLeaderPlayerSecond.json"), StandardCharsets.UTF_8);
        this.leaderCard = gson.fromJson(reader, int[].class);
        reverseAddPersonalLeaderCardAskey();
        reader = new InputStreamReader(this.getClass().getResourceAsStream("/fileConfiguration/fileInformationInitOnLeaderPlayerSecond.json"), StandardCharsets.UTF_8);
        this.initLeader = gson.fromJson(reader, boolean.class);

        reader = new InputStreamReader(this.getClass().getResourceAsStream("/fileConfiguration/fileInformationInitOnResourcePlayerSecond.json"), StandardCharsets.UTF_8);
        this.initResource = gson.fromJson(reader, boolean.class);*/

        try {
            this.gameBoardOfPlayer= gson.fromJson(new FileReader("fileConfiguration/fileInformationPlayerSecond.json"),GameBoardInterface.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.leaderCard= gson.fromJson(new FileReader("fileConfiguration/fileInformationLeaderInitLeaderPlayerSecond.json"),int[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        reverseAddPersonalLeaderCardAskey();
        try {
            this.initLeader = gson.fromJson(new FileReader("fileConfiguration/fileInformationInitOnLeaderPlayerSecond.json"),boolean.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            this.initResource = gson.fromJson(new FileReader("fileConfiguration/fileInformationInitOnResourcePlayerSecond.json"),boolean.class);
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
            fileInformatioPlayerSecond = new FileWriter("fileConfiguration/fileInformationPlayerSecond.json");
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
        String jsonStrin2 = gson.toJson(isInitLeader(),boolean.class);
        try {
            fileInformatioPlayerSecond = new FileWriter("fileConfiguration/fileInformationInitOnLeaderPlayerSecond.json");
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
            fileInformatioPlayerSecond = new FileWriter("fileConfiguration/fileInformationLeaderInitLeaderPlayerSecond.json");
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
        }
        String jsonStrin4 = gson.toJson(isInitResource(),boolean.class);
        try {
            fileInformatioPlayerSecond = new FileWriter("fileConfiguration/fileInformationInitOnResourcePlayerSecond.json");
            fileInformatioPlayerSecond.write(jsonStrin4);
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
