package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.model.Reserve;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.exceptions.*;
import it.polimi.ingsw.server.model.gameBoard.GameBoard;
import it.polimi.ingsw.server.model.gameBoard.GameBoardInterface;
import it.polimi.ingsw.server.model.gameBoard.ReductionGameBoard;
import it.polimi.ingsw.server.model.productionCards.DeckProductionCardOneBlu;
import it.polimi.ingsw.server.model.productionCards.DeckProductionCardOneGreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * test class about ReductionGameBoard
 */
class ReductionGameBoardTest {
    /**
     * test about simple instantiated of ReductionGameBoard
     */
    @Test
    @DisplayName("reductionTest - simple test")
    public void reductionTest0() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ReductionGameBoard(gameBoard, Resource.SHIELD);
        ReductionGameBoard reductionGameBoard = (ReductionGameBoard) gameBoard;
        ArrayList<Resource> cost = new ArrayList<>();
        HashMap<Resource,Integer> costMap = new HashMap<>();
        HashMap<Resource,Integer> reducedMap = new HashMap<>();

        costMap.put(Resource.COIN,1);
        costMap.put(Resource.ROCK,1);
        costMap.put(Resource.SHIELD,1);
        costMap.put(Resource.SERVANT,1);

        reducedMap.put(Resource.COIN,0);
        reducedMap.put(Resource.ROCK,0);
        reducedMap.put(Resource.SHIELD,0);
        reducedMap.put(Resource.SERVANT,0);

        for (Resource key : costMap.keySet()){
            for(int i = 0; i< costMap.get(key); i++){
                cost.add(key);
            }
        }

        cost = reductionGameBoard.costReduction(cost);

        for (Resource r : cost){
            reducedMap.put(r,reducedMap.remove(r)+1);
        }

        assertEquals(costMap.get(Resource.COIN),reducedMap.get(Resource.COIN));
        assertEquals(costMap.get(Resource.ROCK),reducedMap.get(Resource.ROCK));
        assertEquals(costMap.get(Resource.SHIELD)-1,reducedMap.get(Resource.SHIELD));
        assertEquals(costMap.get(Resource.SERVANT),reducedMap.get(Resource.SERVANT));

    }

    /**
     * test about simple instantiated of ReductionGameBoard
     * testing "0 resources"
     */
    @Test
    @DisplayName("reductionTest - 0 resources")
    public void reductionTest1() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ReductionGameBoard(gameBoard,Resource.SHIELD);
        ReductionGameBoard reductionGameBoard = (ReductionGameBoard) gameBoard;
        ArrayList<Resource> cost = new ArrayList<>();
        HashMap<Resource,Integer> costMap = new HashMap<>();
        HashMap<Resource,Integer> reducedMap = new HashMap<>();

        costMap.put(Resource.COIN,0);
        costMap.put(Resource.ROCK,0);
        costMap.put(Resource.SHIELD,0);
        costMap.put(Resource.SERVANT,0);

        reducedMap.put(Resource.COIN,0);
        reducedMap.put(Resource.ROCK,0);
        reducedMap.put(Resource.SHIELD,0);
        reducedMap.put(Resource.SERVANT,0);

        for (Resource key : costMap.keySet()){
            for(int i = 0; i< costMap.get(key); i++){
                cost.add(key);
            }
        }

        cost = reductionGameBoard.costReduction(cost);

        for (Resource r : cost){
            reducedMap.put(r,reducedMap.remove(r)+1);
        }

        assertEquals(costMap.get(Resource.COIN),reducedMap.get(Resource.COIN));
        assertEquals(costMap.get(Resource.ROCK),reducedMap.get(Resource.ROCK));
        assertEquals(costMap.get(Resource.SHIELD),reducedMap.get(Resource.SHIELD));
        assertEquals(costMap.get(Resource.SERVANT),reducedMap.get(Resource.SERVANT));

        assertEquals(0,reducedMap.get(Resource.COIN));
        assertEquals(0,reducedMap.get(Resource.ROCK));
        assertEquals(0,reducedMap.get(Resource.SHIELD));
        assertEquals(0,reducedMap.get(Resource.SERVANT));

    }

    /**
     * test about simple instantiated of ReductionGameBoard
     * buyProductionCard() affordable card"
     */
    @Test
    @DisplayName("buyProductionCard() test - affordable card")
    public void buyProductionCardTest0(){
        new Reserve();
        Resource parameter = Resource.SERVANT;
        GameBoardInterface gameBoard = new GameBoard() ;
        gameBoard = new ReductionGameBoard(gameBoard,parameter);

        DeckProductionCardOneBlu blueDeck = new DeckProductionCardOneBlu();

        ArrayList<Resource> available ;
        ArrayList<Resource> cost ;
        Map<Resource,Integer> availableMap = new HashMap<>();
        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> costMap = new HashMap<>();


        costMap.put(Resource.COIN, 0);
        costMap.put(Resource.ROCK, 0);
        costMap.put(Resource.SHIELD, 0);
        costMap.put(Resource.SERVANT, 0);

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 0);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 0);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 15);
        strongboxMap.put(Resource.ROCK, 15);
        strongboxMap.put(Resource.SHIELD, 15);
        strongboxMap.put(Resource.SERVANT, 15);

        cost = blueDeck.requiredResources();

        for(Resource r : cost){
            costMap.put(r,costMap.remove(r)+1);
        }

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
            gameBoard.buyProductionCard(blueDeck,0);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }
        available = gameBoard.availableResources();
        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }

        if(costMap.get(Resource.COIN)>0 && parameter == Resource.COIN){
            assertEquals(strongboxMap.get(Resource.COIN)-costMap.get(Resource.COIN)+1,availableMap.get(Resource.COIN));
        }else{
            assertEquals(strongboxMap.get(Resource.COIN)-costMap.get(Resource.COIN),availableMap.get(Resource.COIN));
        }
        if(costMap.get(Resource.ROCK)>0 && parameter == Resource.ROCK){
            assertEquals(strongboxMap.get(Resource.ROCK)-costMap.get(Resource.ROCK)+1,availableMap.get(Resource.ROCK));
        }else{
            assertEquals(strongboxMap.get(Resource.ROCK)-costMap.get(Resource.ROCK),availableMap.get(Resource.ROCK));
        }
        if(costMap.get(Resource.SHIELD)>0 && parameter == Resource.SHIELD){
            assertEquals(strongboxMap.get(Resource.SHIELD)-costMap.get(Resource.SHIELD)+1,availableMap.get(Resource.SHIELD));
        }else{
            assertEquals(strongboxMap.get(Resource.SHIELD)-costMap.get(Resource.SHIELD),availableMap.get(Resource.SHIELD));
        }
        if(costMap.get(Resource.SERVANT)>0 && parameter == Resource.SERVANT){
            assertEquals(strongboxMap.get(Resource.SERVANT)-costMap.get(Resource.SERVANT)+1,availableMap.get(Resource.SERVANT));
        }else{
            assertEquals(strongboxMap.get(Resource.SERVANT)-costMap.get(Resource.SERVANT),availableMap.get(Resource.SERVANT));
        }

        try {
            assertEquals(0,gameBoard.lastRowOccupied(0));
        } catch (EmptyColumnException ignored) {}

        assertEquals(3,blueDeck.size());

    }
    /**
     * test about simple instantiated of ReductionGameBoard
     * buyProductionCard() 3 affordable card"
     */
    @Test
    @DisplayName("buyProductionCard() test - 3 affordable card")
    public void buyProductionCardTest1(){
        new Reserve();
        Resource parameter = Resource.ROCK;
        GameBoardInterface gameBoard = new GameBoard() ;
        gameBoard = new ReductionGameBoard(gameBoard,parameter);

        DeckProductionCardOneBlu blueDeck = new DeckProductionCardOneBlu();
        DeckProductionCardOneGreen greenDeck = new DeckProductionCardOneGreen();

        ArrayList<Resource> available ;
        ArrayList<Resource> cost ;
        Map<Resource,Integer> availableMap = new HashMap<>();
        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> costMap = new HashMap<>();


        costMap.put(Resource.COIN, 0);
        costMap.put(Resource.ROCK, 0);
        costMap.put(Resource.SHIELD, 0);
        costMap.put(Resource.SERVANT, 0);

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 0);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 0);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 15);
        strongboxMap.put(Resource.ROCK, 15);
        strongboxMap.put(Resource.SHIELD, 15);
        strongboxMap.put(Resource.SERVANT, 15);

        cost = blueDeck.requiredResources();

        for(Resource r : cost){
            costMap.put(r,costMap.remove(r)+1);
        }

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
            gameBoard.buyProductionCard(blueDeck,0);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }
        available = gameBoard.availableResources();
        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }

        if(costMap.get(Resource.COIN)>0 && parameter == Resource.COIN){
            assertEquals(strongboxMap.get(Resource.COIN)-costMap.get(Resource.COIN)+1,availableMap.get(Resource.COIN));
        }else{
            assertEquals(strongboxMap.get(Resource.COIN)-costMap.get(Resource.COIN),availableMap.get(Resource.COIN));
        }
        if(costMap.get(Resource.ROCK)>0 && parameter == Resource.ROCK){
            assertEquals(strongboxMap.get(Resource.ROCK)-costMap.get(Resource.ROCK)+1,availableMap.get(Resource.ROCK));
        }else{
            assertEquals(strongboxMap.get(Resource.ROCK)-costMap.get(Resource.ROCK),availableMap.get(Resource.ROCK));
        }
        if(costMap.get(Resource.SHIELD)>0 && parameter == Resource.SHIELD){
            assertEquals(strongboxMap.get(Resource.SHIELD)-costMap.get(Resource.SHIELD)+1,availableMap.get(Resource.SHIELD));
        }else{
            assertEquals(strongboxMap.get(Resource.SHIELD)-costMap.get(Resource.SHIELD),availableMap.get(Resource.SHIELD));
        }
        if(costMap.get(Resource.SERVANT)>0 && parameter == Resource.SERVANT){
            assertEquals(strongboxMap.get(Resource.SERVANT)-costMap.get(Resource.SERVANT)+1,availableMap.get(Resource.SERVANT));
        }else{
            assertEquals(strongboxMap.get(Resource.SERVANT)-costMap.get(Resource.SERVANT),availableMap.get(Resource.SERVANT));
        }

        try {
            assertEquals(0,gameBoard.lastRowOccupied(0));
        } catch (EmptyColumnException ignored) {}

        assertEquals(3,blueDeck.size());

        //First card bought---------------------------------------------------------------------------------------------

        cost = greenDeck.requiredResources();
        costMap.put(Resource.COIN, 0);
        costMap.put(Resource.ROCK, 0);
        costMap.put(Resource.SHIELD, 0);
        costMap.put(Resource.SERVANT, 0);

        for(Resource r : cost){
            costMap.put(r,costMap.remove(r)+1);
        }

        strongboxMap.replaceAll((k, v) -> availableMap.get(k));

        try {
            gameBoard.buyProductionCard(greenDeck,1);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }
        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);
        available = gameBoard.availableResources();
        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }

        if(costMap.get(Resource.COIN)>0 && parameter == Resource.COIN){
            assertEquals(strongboxMap.get(Resource.COIN)-costMap.get(Resource.COIN)+1,availableMap.get(Resource.COIN));
        }else{
            assertEquals(strongboxMap.get(Resource.COIN)-costMap.get(Resource.COIN),availableMap.get(Resource.COIN));
        }
        if(costMap.get(Resource.ROCK)>0 && parameter == Resource.ROCK){
            assertEquals(strongboxMap.get(Resource.ROCK)-costMap.get(Resource.ROCK)+1,availableMap.get(Resource.ROCK));
        }else{
            assertEquals(strongboxMap.get(Resource.ROCK)-costMap.get(Resource.ROCK),availableMap.get(Resource.ROCK));
        }
        if(costMap.get(Resource.SHIELD)>0 && parameter == Resource.SHIELD){
            assertEquals(strongboxMap.get(Resource.SHIELD)-costMap.get(Resource.SHIELD)+1,availableMap.get(Resource.SHIELD));
        }else{
            assertEquals(strongboxMap.get(Resource.SHIELD)-costMap.get(Resource.SHIELD),availableMap.get(Resource.SHIELD));
        }
        if(costMap.get(Resource.SERVANT)>0 && parameter == Resource.SERVANT){
            assertEquals(strongboxMap.get(Resource.SERVANT)-costMap.get(Resource.SERVANT)+1,availableMap.get(Resource.SERVANT));
        }else{
            assertEquals(strongboxMap.get(Resource.SERVANT)-costMap.get(Resource.SERVANT),availableMap.get(Resource.SERVANT));
        }

        try {
            assertEquals(0,gameBoard.lastRowOccupied(1));
        } catch (EmptyColumnException ignored) {}

        assertEquals(3,greenDeck.size());

        //second card bought  ------------------------------------------------------------------------------------------


        cost = greenDeck.requiredResources();
        costMap.put(Resource.COIN, 0);
        costMap.put(Resource.ROCK, 0);
        costMap.put(Resource.SHIELD, 0);
        costMap.put(Resource.SERVANT, 0);

        for(Resource r : cost){
            costMap.put(r,costMap.remove(r)+1);
        }

        strongboxMap.replaceAll((k, v) -> availableMap.get(k));

        try {
            gameBoard.buyProductionCard(greenDeck,2);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }
        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);
        available = gameBoard.availableResources();
        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }

        if(costMap.get(Resource.COIN)>0 && parameter == Resource.COIN){
            assertEquals(strongboxMap.get(Resource.COIN)-costMap.get(Resource.COIN)+1,availableMap.get(Resource.COIN));
        }else{
            assertEquals(strongboxMap.get(Resource.COIN)-costMap.get(Resource.COIN),availableMap.get(Resource.COIN));
        }
        if(costMap.get(Resource.ROCK)>0 && parameter == Resource.ROCK){
            assertEquals(strongboxMap.get(Resource.ROCK)-costMap.get(Resource.ROCK)+1,availableMap.get(Resource.ROCK));
        }else{
            assertEquals(strongboxMap.get(Resource.ROCK)-costMap.get(Resource.ROCK),availableMap.get(Resource.ROCK));
        }
        if(costMap.get(Resource.SHIELD)>0 && parameter == Resource.SHIELD){
            assertEquals(strongboxMap.get(Resource.SHIELD)-costMap.get(Resource.SHIELD)+1,availableMap.get(Resource.SHIELD));
        }else{
            assertEquals(strongboxMap.get(Resource.SHIELD)-costMap.get(Resource.SHIELD),availableMap.get(Resource.SHIELD));
        }
        if(costMap.get(Resource.SERVANT)>0 && parameter == Resource.SERVANT){
            assertEquals(strongboxMap.get(Resource.SERVANT)-costMap.get(Resource.SERVANT)+1,availableMap.get(Resource.SERVANT));
        }else{
            assertEquals(strongboxMap.get(Resource.SERVANT)-costMap.get(Resource.SERVANT),availableMap.get(Resource.SERVANT));
        }

        try {
            assertEquals(0,gameBoard.lastRowOccupied(2));
        } catch (EmptyColumnException ignored) {}

        assertEquals(2,greenDeck.size());

    }
    /**
     * test about simple instantiated of ReductionGameBoard
     * buyProductionCard() not affordable card"
     */
    @Test
    @DisplayName("buyProductionCard() test - not affordable card")
    public void buyProductionCardTest2(){
        new Reserve();
        Resource parameter = Resource.COIN;
        GameBoardInterface gameBoard = new GameBoard() ;
        gameBoard = new ReductionGameBoard(gameBoard,parameter);

        DeckProductionCardOneBlu blueDeck = new DeckProductionCardOneBlu();

        ArrayList<Resource> available ;
        ArrayList<Resource> cost ;
        Map<Resource,Integer> availableMap = new HashMap<>();
        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> costMap = new HashMap<>();


        costMap.put(Resource.COIN, 0);
        costMap.put(Resource.ROCK, 0);
        costMap.put(Resource.SHIELD, 0);
        costMap.put(Resource.SERVANT, 0);

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 0);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 0);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 0);
        strongboxMap.put(Resource.ROCK, 0);
        strongboxMap.put(Resource.SHIELD, 0);
        strongboxMap.put(Resource.SERVANT, 0);

        cost = blueDeck.requiredResources();

        for(Resource r : cost){
            costMap.put(r,costMap.remove(r)+1);
        }

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
            gameBoard.buyProductionCard(blueDeck,0);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }
        available = gameBoard.availableResources();
        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(0,availableMap.get(Resource.COIN));
        assertEquals(0,availableMap.get(Resource.ROCK));
        assertEquals(0,availableMap.get(Resource.SHIELD));
        assertEquals(0,availableMap.get(Resource.SERVANT));

        try {
            assertEquals(0,gameBoard.lastRowOccupied(0));
        } catch (EmptyColumnException ignored) {}

        assertEquals(4,blueDeck.size());


    }

}