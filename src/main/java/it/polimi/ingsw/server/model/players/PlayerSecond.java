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
    public PlayerSecond(String nickName, Game game){
        super(nickName, game);
    }


    /**
     * Restore constructor that calls the super class constructor
     * @param nickName : the nickname chosen by the player
     */

    public PlayerSecond(String nickName){
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
            this.gameBoardOfPlayer = gson.fromJson(new FileReader("src/main/resources/fileInformationPlayerSecond.json"),GameBoardInterface.class);
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
        Gson gson=gameBoardSaving();
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

    }
}
