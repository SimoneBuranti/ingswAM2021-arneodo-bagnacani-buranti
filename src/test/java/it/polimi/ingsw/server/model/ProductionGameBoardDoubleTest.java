package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.model.exceptions.CallForCouncilException;
import it.polimi.ingsw.server.model.exceptions.ImpossibleProductionException;
import it.polimi.ingsw.server.model.exceptions.LastSpaceReachedException;
import it.polimi.ingsw.server.model.gameBoard.GameBoard;
import it.polimi.ingsw.server.model.gameBoard.GameBoardInterface;
import it.polimi.ingsw.server.model.gameBoard.ProductionGameBoard;
import it.polimi.ingsw.server.model.gameBoard.ProductionGameBoardDouble;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
/**
 * test class about ProductionGameBoardDoubleTest
 */
class ProductionGameBoardDoubleTest {
    /**
     * test about extraProductionOnTest called from game
     * when ProductionGameBoardDouble(leader card power) is instantiated
     */
    @Test
    @DisplayName("extraProductionOnTest0 - simple test")
    public void extraProductionOnTest0() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.COIN);
        gameBoard = new ProductionGameBoardDouble(gameBoard,gameBoard.getResourceTypeFirst(),Resource.ROCK);

        new Reserve();
        int init ;

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 0);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 0);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 1);
        strongboxMap.put(Resource.ROCK, 1);
        strongboxMap.put(Resource.SHIELD, 1);
        strongboxMap.put(Resource.SERVANT, 1);

        init = gameBoard.getIndicator();

        ArrayList<Resource> available;

        for(Resource key : storageMap.keySet()){
            for (int i = 0; i<storageMap.get(key); i++){
                gameBoard.addToStorage(key);
            }
        }

        for(Resource key : strongboxMap.keySet()){
            for (int i = 0; i<strongboxMap.get(key); i++){
                gameBoard.addToStrongbox(key);
            }
        }


        try {
            gameBoard.extraProductionOn(Resource.COIN);
        } catch (ImpossibleProductionException | LastSpaceReachedException | CallForCouncilException e) {
            e.printStackTrace();
        }
        gameBoard.endOfProduction();

        available = gameBoard.availableResources();
        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(init+1,gameBoard.getIndicator());

        assertEquals(strongboxMap.get(Resource.COIN),availableMap.get(Resource.COIN));
        assertEquals(strongboxMap.get(Resource.ROCK),availableMap.get(Resource.ROCK));
        assertEquals(strongboxMap.get(Resource.SHIELD),availableMap.get(Resource.SHIELD));
        assertEquals(strongboxMap.get(Resource.SERVANT),availableMap.get(Resource.SERVANT));

    }
    /**
     * test about extraProductionOnTest called from game
     * when ProductionGameBoardDouble(leader card power) is instantiated
     */
    @Test
    @DisplayName("extraProductionOnTest1 - simple test")
    public void extraProductionOnTest1() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.COIN);
        gameBoard = new ProductionGameBoardDouble(gameBoard,gameBoard.getResourceTypeFirst(),Resource.ROCK);

        new Reserve();
        int init ;

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 0);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 0);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 1);
        strongboxMap.put(Resource.ROCK, 1);
        strongboxMap.put(Resource.SHIELD, 1);
        strongboxMap.put(Resource.SERVANT, 1);

        init = gameBoard.getIndicator();

        ArrayList<Resource> available;

        for(Resource key : storageMap.keySet()){
            for (int i = 0; i<storageMap.get(key); i++){
                gameBoard.addToStorage(key);
            }
        }

        for(Resource key : strongboxMap.keySet()){
            for (int i = 0; i<strongboxMap.get(key); i++){
                gameBoard.addToStrongbox(key);
            }
        }


        try {
            gameBoard.extraProductionOn(Resource.SHIELD);
        } catch (ImpossibleProductionException | LastSpaceReachedException | CallForCouncilException e) {
            e.printStackTrace();
        }
        gameBoard.endOfProduction();

        available = gameBoard.availableResources();
        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }
        assertEquals(init+1,gameBoard.getIndicator());

        assertEquals(strongboxMap.get(Resource.COIN)-1,availableMap.get(Resource.COIN));
        assertEquals(strongboxMap.get(Resource.ROCK),availableMap.get(Resource.ROCK));
        assertEquals(strongboxMap.get(Resource.SHIELD)+1,availableMap.get(Resource.SHIELD));
        assertEquals(strongboxMap.get(Resource.SERVANT),availableMap.get(Resource.SERVANT));

    }

    /**
     * test about extraProductionOnTest called from game
     * when ProductionGameBoardDouble(leader card power) is instantiated
     */

    @Test
    @DisplayName("extraProductionOnTest2 - simple test")
    public void extraProductionOnTest2() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.COIN);
        gameBoard = new ProductionGameBoardDouble(gameBoard,gameBoard.getResourceTypeFirst(),Resource.ROCK);

        new Reserve();
        int init ;

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 0);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 0);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 1);
        strongboxMap.put(Resource.ROCK, 1);
        strongboxMap.put(Resource.SHIELD, 1);
        strongboxMap.put(Resource.SERVANT, 1);

        init = gameBoard.getIndicator();

        ArrayList<Resource> available;

        for(Resource key : storageMap.keySet()){
            for (int i = 0; i<storageMap.get(key); i++){
                gameBoard.addToStorage(key);
            }
        }

        for(Resource key : strongboxMap.keySet()){
            for (int i = 0; i<strongboxMap.get(key); i++){
                gameBoard.addToStrongbox(key);
            }
        }


        try {
            gameBoard.extraProductionOn(Resource.COIN);
        } catch (ImpossibleProductionException | LastSpaceReachedException | CallForCouncilException e) {
            e.printStackTrace();
        }
        gameBoard.endOfProduction();

        available = gameBoard.availableResources();
        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }
        assertEquals(init+1,gameBoard.getIndicator());

        assertEquals(strongboxMap.get(Resource.COIN),availableMap.get(Resource.COIN));
        assertEquals(strongboxMap.get(Resource.ROCK),availableMap.get(Resource.ROCK));
        assertEquals(strongboxMap.get(Resource.SHIELD),availableMap.get(Resource.SHIELD));
        assertEquals(strongboxMap.get(Resource.SERVANT),availableMap.get(Resource.SERVANT));

    }


    /**
     * test about extraProductionOnTest called from game
     * when ProductionGameBoardDouble(leader card power) is instantiated
     */
    @Test
    @DisplayName("anotherExtraProductionOnTest0 - simple test")
    public void anotherExtraProductionOnTest0() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.COIN);
        gameBoard = new ProductionGameBoardDouble(gameBoard,gameBoard.getResourceTypeFirst(),Resource.ROCK);

        new Reserve();
        int init ;

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 0);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 0);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 1);
        strongboxMap.put(Resource.ROCK, 1);
        strongboxMap.put(Resource.SHIELD, 1);
        strongboxMap.put(Resource.SERVANT, 1);

        init = gameBoard.getIndicator();

        ArrayList<Resource> available;

        for(Resource key : storageMap.keySet()){
            for (int i = 0; i<storageMap.get(key); i++){
                gameBoard.addToStorage(key);
            }
        }

        for(Resource key : strongboxMap.keySet()){
            for (int i = 0; i<strongboxMap.get(key); i++){
                gameBoard.addToStrongbox(key);
            }
        }


        try {
            gameBoard.anotherExtraProductionOn(Resource.ROCK);
        } catch (ImpossibleProductionException | LastSpaceReachedException | CallForCouncilException e) {
            e.printStackTrace();
        }
        gameBoard.endOfProduction();

        available = gameBoard.availableResources();
        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(init+1,gameBoard.getIndicator());

        assertEquals(strongboxMap.get(Resource.COIN),availableMap.get(Resource.COIN));
        assertEquals(strongboxMap.get(Resource.ROCK),availableMap.get(Resource.ROCK));
        assertEquals(strongboxMap.get(Resource.SHIELD),availableMap.get(Resource.SHIELD));
        assertEquals(strongboxMap.get(Resource.SERVANT),availableMap.get(Resource.SERVANT));

    }
    /**
     * test about extraProductionOnTest called from game
     * when ProductionGameBoardDouble(leader card power) is instantiated
     */
    @Test
    @DisplayName("anotherExtraProductionOnTest1 - simple test")
    public void anotherExtraProductionOnTest1() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.COIN);
        gameBoard = new ProductionGameBoardDouble(gameBoard,gameBoard.getResourceTypeFirst(),Resource.ROCK);

        new Reserve();
        int init ;

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 0);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 0);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 1);
        strongboxMap.put(Resource.ROCK, 1);
        strongboxMap.put(Resource.SHIELD, 1);
        strongboxMap.put(Resource.SERVANT, 1);

        init = gameBoard.getIndicator();

        ArrayList<Resource> available;

        for(Resource key : storageMap.keySet()){
            for (int i = 0; i<storageMap.get(key); i++){
                gameBoard.addToStorage(key);
            }
        }

        for(Resource key : strongboxMap.keySet()){
            for (int i = 0; i<strongboxMap.get(key); i++){
                gameBoard.addToStrongbox(key);
            }
        }


        try {
            gameBoard.anotherExtraProductionOn(Resource.SHIELD);
        } catch (ImpossibleProductionException | LastSpaceReachedException | CallForCouncilException e) {
            e.printStackTrace();
        }
        gameBoard.endOfProduction();

        available = gameBoard.availableResources();
        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }
        assertEquals(init+1,gameBoard.getIndicator());

        assertEquals(strongboxMap.get(Resource.COIN),availableMap.get(Resource.COIN));
        assertEquals(strongboxMap.get(Resource.ROCK)-1,availableMap.get(Resource.ROCK));
        assertEquals(strongboxMap.get(Resource.SHIELD)+1,availableMap.get(Resource.SHIELD));
        assertEquals(strongboxMap.get(Resource.SERVANT),availableMap.get(Resource.SERVANT));

    }
    /**
     * test about extraProductionOnTest called from game
     * when ProductionGameBoardDouble(leader card power) is instantiated
     */
    @Test
    @DisplayName("anotherExtraProductionOnTest2 - simple test")
    public void anotherExtraProductionOnTest2() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard, Resource.COIN);
        gameBoard = new ProductionGameBoardDouble(gameBoard,gameBoard.getResourceTypeFirst(),Resource.ROCK);

        new Reserve();
        int init ;

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 0);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 0);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 1);
        strongboxMap.put(Resource.ROCK, 1);
        strongboxMap.put(Resource.SHIELD, 1);
        strongboxMap.put(Resource.SERVANT, 1);

        init = gameBoard.getIndicator();

        ArrayList<Resource> available;

        for(Resource key : storageMap.keySet()){
            for (int i = 0; i<storageMap.get(key); i++){
                gameBoard.addToStorage(key);
            }
        }

        for(Resource key : strongboxMap.keySet()){
            for (int i = 0; i<strongboxMap.get(key); i++){
                gameBoard.addToStrongbox(key);
            }
        }


        try {
            gameBoard.anotherExtraProductionOn(Resource.SERVANT);
        } catch (ImpossibleProductionException | LastSpaceReachedException | CallForCouncilException e) {
            e.printStackTrace();
        }
        gameBoard.endOfProduction();

        available = gameBoard.availableResources();
        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }
        assertEquals(init+1,gameBoard.getIndicator());

        assertEquals(strongboxMap.get(Resource.COIN),availableMap.get(Resource.COIN));
        assertEquals(strongboxMap.get(Resource.ROCK)-1,availableMap.get(Resource.ROCK));
        assertEquals(strongboxMap.get(Resource.SHIELD),availableMap.get(Resource.SHIELD));
        assertEquals(strongboxMap.get(Resource.SERVANT)+1,availableMap.get(Resource.SERVANT));

    }
}