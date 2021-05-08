package it.polimi.ingsw.server.model.players;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.server.model.RuntimeTypeAdapterFactory;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.exceptions.CallForCouncilException;
import it.polimi.ingsw.server.model.exceptions.LastSpaceReachedException;
import it.polimi.ingsw.server.model.gameBoard.*;
import it.polimi.ingsw.server.model.leaderCards.*;
import it.polimi.ingsw.server.model.requirements.*;

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
    /*public PlayerFourth(String nickName){
        super(nickName);
    }*/

    /**
     * Restore constructor that calls the super class constructor
     * @param nickName : the nickname chosen by the player
     */

    public PlayerFourth(String nickName){
        super(nickName);
        RuntimeTypeAdapterFactory<Storage> adapterStorage =
                RuntimeTypeAdapterFactory
                        .of(Storage.class)
                        .registerSubtype(Storage.class)
                        .registerSubtype(StorageExtraFirst.class)
                        .registerSubtype(StorageExtraSecond.class);


        RuntimeTypeAdapterFactory<Colour> adapterColour =
                RuntimeTypeAdapterFactory
                        .of(Colour.class)
                        .registerSubtype(Green.class)
                        .registerSubtype(Yellow.class)
                        .registerSubtype(Blue.class)
                        .registerSubtype(Violet.class);

        RuntimeTypeAdapterFactory<GameBoardInterface> adapterGameBoard =
                RuntimeTypeAdapterFactory
                        .of(GameBoardInterface.class)
                        .registerSubtype(GameBoard.class)
                        .registerSubtype(ProductionGameBoardDouble.class)
                        .registerSubtype(ProductionGameBoard.class)
                        .registerSubtype(WhiteMarbleGameBoard.class)
                        .registerSubtype(WhiteMarbleGameBoardDouble.class)
                        .registerSubtype(ReductionGameBoard.class)
                        .registerSubtype(ReductionGameBoardDouble.class);


        RuntimeTypeAdapterFactory<Requirements> adapterRequirements =
                RuntimeTypeAdapterFactory
                        .of(Requirements.class)
                        .registerSubtype(ResourceRequirement.class)
                        .registerSubtype(SecondLevelRequirement.class)
                        .registerSubtype(ThreeFlagsTwoColourRequirement.class)
                        .registerSubtype(TwoFlagsTwoColourRequirement.class);

        RuntimeTypeAdapterFactory<LeaderCard> adapterLeader =
                RuntimeTypeAdapterFactory
                        .of(LeaderCard.class)
                        .registerSubtype(LeaderCardMarble.class)
                        .registerSubtype(LeaderCardProduction.class)
                        .registerSubtype(LeaderCardReduction.class)
                        .registerSubtype(LeaderCardStorage.class);



        Gson gson=new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapterFactory(adapterGameBoard)
                .registerTypeAdapterFactory(adapterStorage)
                .registerTypeAdapterFactory(adapterColour)
                .registerTypeAdapterFactory(adapterRequirements)
                .registerTypeAdapterFactory(adapterLeader)
                .create();

        try {
            gameBoardOfPlayer= gson.fromJson(new FileReader("src/main/resources/fileInformationPlayerFourth.json"), GameBoardInterface.class);
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
        getGameBoardOfPlayer().faithMove();
    }

    /**
     * save information for a possible restart game
     */
    @Override
    public void savePlayerInformation(){
        Gson gson=gameBoardSaving();
        String jsonStrin = gson.toJson(getGameBoardOfPlayer(),GameBoardInterface.class);
        try {

            // Constructs a FileWriter given a file name, using the platform's default charset
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

    }}
