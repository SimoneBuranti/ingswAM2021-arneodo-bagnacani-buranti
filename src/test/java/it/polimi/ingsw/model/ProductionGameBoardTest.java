package it.polimi.ingsw.model;

import it.polimi.ingsw.model.exceptions.*;
import it.polimi.ingsw.model.gameBoard.GameBoard;
import it.polimi.ingsw.model.gameBoard.GameBoardInterface;
import it.polimi.ingsw.model.gameBoard.ProductionGameBoard;
import it.polimi.ingsw.model.productionCards.*;
import org.junit.jupiter.api.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * test class about ProductionGameBoardTest
 */
class ProductionGameBoardTest {

    /**
     * This test checks the correct behaviour of both the methods firstRowFree and setProductionCard
     */
    @Test
    @DisplayName("FirstRowFree and setProductionCardTest - first column")
    public void firstRowFreeAndSetProductionCard(){
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);

        DeckProductionCardOneBlu deck = new DeckProductionCardOneBlu();
        DeckProductionCardOneGreen deck2 = new DeckProductionCardOneGreen();
        DeckProductionCardOneViolet deck3 = new DeckProductionCardOneViolet();

        try {
            assertEquals(0,gameBoard.firstRowFree(0));
        } catch (FullColumnException e) {
            e.printStackTrace();
        }
        try {
            assertEquals(0,gameBoard.firstRowFree(1));
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }
        try {
            assertEquals(0,gameBoard.firstRowFree(2));
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }

        try {
            gameBoard.setNewProductionCard(deck,0);
        } catch (EmptyException e) {
            System.out.println("EmptyException\n");
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }

        try {
            assertEquals(1,gameBoard.firstRowFree(0));
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }


        try {
            gameBoard.setNewProductionCard(deck,0);
        } catch (EmptyException e) {
            System.out.println("EmptyException\n");
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }

        try {
            assertEquals(2,gameBoard.firstRowFree(0));
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }


        try {
            gameBoard.setNewProductionCard(deck,0);
        } catch (EmptyException e) {
            System.out.println("EmptyException\n");
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }

        try {
            assertEquals(2,gameBoard.firstRowFree(0));
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }



        try {
            gameBoard.setNewProductionCard(deck,1);
        } catch (EmptyException e) {
            System.out.println("EmptyException\n");
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }

        try {
            assertEquals(1,gameBoard.firstRowFree(1));
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }




        try {
            gameBoard.setNewProductionCard(deck,1);
        } catch (EmptyException e) {
            System.out.println("EmptyException\n");
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }

        try {
            assertEquals(1,gameBoard.firstRowFree(1));
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }


        try {
            gameBoard.setNewProductionCard(deck2,1);
        } catch (EmptyException e) {
            System.out.println("EmptyException\n");
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }

        try {
            assertEquals(2,gameBoard.firstRowFree(1));
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }

        try {
            gameBoard.setNewProductionCard(deck2,1);
        } catch (EmptyException e) {
            System.out.println("EmptyException\n");
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }

        try {
            assertEquals(3,gameBoard.firstRowFree(1));
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }

        try {
            assertEquals(0,gameBoard.firstRowFree(2));
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }

        try {
            gameBoard.setNewProductionCard(deck2,2);
        } catch (EmptyException e) {
            System.out.println("EmptyException\n");
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }

        try {
            assertEquals(1,gameBoard.firstRowFree(2));
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }

        try {
            gameBoard.setNewProductionCard(deck2,2);
        } catch (EmptyException e) {
            System.out.println("EmptyException\n");
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }

        try {
            assertEquals(2,gameBoard.firstRowFree(2));
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }

        try {
            gameBoard.setNewProductionCard(deck2,2);
        } catch (EmptyException e) {
            System.out.println("EmptyException\n");
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }

        try {
            assertEquals(2,gameBoard.firstRowFree(2));
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }

        try {
            gameBoard.setNewProductionCard(deck3,2);
        } catch (EmptyException e) {
            System.out.println("EmptyException\n");
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }

        try {
            assertEquals(2,gameBoard.firstRowFree(2));
        } catch (FullColumnException e) {
            System.out.println("FullColumnException\n");
        }


    }


    /**
     * This test checks the correct behaviour of availableResources() method in case of empty storage and strongbox
     */
    @Test
    @DisplayName("Available resources test - Empty storage and Strongbox")
    public void availableResourcesTest(){
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        ArrayList<Resource> available;

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

        available = gameBoard.availableResources();

        for (Resource r : available) {
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(availableMap.get(Resource.COIN),0);
        assertEquals(availableMap.get(Resource.ROCK),0);
        assertEquals(availableMap.get(Resource.SHIELD),0);
        assertEquals(availableMap.get(Resource.SERVANT),0);



    }

    /**
     * This test checks the correct behaviour of availableResources() method
     */
    @Test
    @DisplayName("Available resources test 1 - simple")
    public void availableResourcesTest1(){
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        ArrayList<Resource> available;

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 1);
        storageMap.put(Resource.ROCK, 1);
        storageMap.put(Resource.SHIELD, 1);
        storageMap.put(Resource.SERVANT, 1);

        strongboxMap.put(Resource.COIN, 1);
        strongboxMap.put(Resource.ROCK, 1);
        strongboxMap.put(Resource.SHIELD, 1);
        strongboxMap.put(Resource.SERVANT, 1);



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

        available = gameBoard.availableResources();

        for (Resource r : available) {
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(2,availableMap.get(Resource.COIN));
        assertEquals(2,availableMap.get(Resource.ROCK));
        assertEquals(2,availableMap.get(Resource.SHIELD));
        assertEquals(2,availableMap.get(Resource.SERVANT));



    }

    /**
     * This test checks the correct behaviour in case of resource payment
     */
    @Test
    @DisplayName("Available resources test 2 - simple")
    public void availableResourcesTest2(){
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        ArrayList<Resource> available;

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 2);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 2);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 0);
        strongboxMap.put(Resource.ROCK, 2);
        strongboxMap.put(Resource.SHIELD, 0);
        strongboxMap.put(Resource.SERVANT, 2);



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

        available = gameBoard.availableResources();

        for (Resource r : available) {
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(2,availableMap.get(Resource.COIN));
        assertEquals(2,availableMap.get(Resource.ROCK));
        assertEquals(2,availableMap.get(Resource.SHIELD));
        assertEquals(2,availableMap.get(Resource.SERVANT));



    }


    /**
     * This test checks the correct behaviour of availableResources() method in case of unavailable resources
     */
    @Test
    @DisplayName("Available resources test 3 - unavailable resources")
    public void availableResourcesTest3(){
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        ArrayList<Resource> available;

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 102);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 2);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 102);
        strongboxMap.put(Resource.ROCK, 2);
        strongboxMap.put(Resource.SHIELD, 0);
        strongboxMap.put(Resource.SERVANT, 2);



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

        available = gameBoard.availableResources();

        for (Resource r : available) {
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(100,availableMap.get(Resource.COIN));
        assertEquals(2,availableMap.get(Resource.ROCK));
        assertEquals(2,availableMap.get(Resource.SHIELD));
        assertEquals(2,availableMap.get(Resource.SERVANT));



    }

    /**
     * This test checks the correct behaviour in case of resource payment
     */
    @Test
    @DisplayName("PayResources Test - simple test")
    public void payResourcesTest0(){
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();

        Map<Resource,Integer> costMap = new HashMap<>();
        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        ArrayList<Resource> available;
        ArrayList<Resource> cost = new ArrayList<>();

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

        costMap.put(Resource.COIN, 1);
        costMap.put(Resource.ROCK, 1);
        costMap.put(Resource.SHIELD, 1);
        costMap.put(Resource.SERVANT, 1);


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

        for(Resource key : costMap.keySet()){
            for (int i = 0; i<costMap.get(key); i++){
                cost.add(key);
            }
        }

        gameBoard.payResources(cost);

        available = gameBoard.availableResources();

        for (Resource r : available) {
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(0,availableMap.get(Resource.COIN));
        assertEquals(0,availableMap.get(Resource.ROCK));
        assertEquals(0,availableMap.get(Resource.SHIELD));
        assertEquals(0,availableMap.get(Resource.SERVANT));
    }


    /**
     * This test checks the correct behaviour in case of resource payment
     */
    @Test
    @DisplayName("PayResources Test 1 - simple test")
    public void payResourcesTest1(){
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();

        Map<Resource,Integer> costMap = new HashMap<>();
        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        ArrayList<Resource> available;
        ArrayList<Resource> cost = new ArrayList<>();

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 3);
        storageMap.put(Resource.ROCK, 3);
        storageMap.put(Resource.SHIELD, 3);
        storageMap.put(Resource.SERVANT, 3);

        strongboxMap.put(Resource.COIN, 4);
        strongboxMap.put(Resource.ROCK, 4);
        strongboxMap.put(Resource.SHIELD, 4);
        strongboxMap.put(Resource.SERVANT, 4);

        costMap.put(Resource.COIN, 7);
        costMap.put(Resource.ROCK, 1);
        costMap.put(Resource.SHIELD, 3);
        costMap.put(Resource.SERVANT, 4);


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

        for(Resource key : costMap.keySet()){
            for (int i = 0; i<costMap.get(key); i++){
                cost.add(key);
            }
        }

        gameBoard.payResources(cost);

        available = gameBoard.availableResources();

        for (Resource r : available) {
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(0,availableMap.get(Resource.COIN));
        assertEquals(6,availableMap.get(Resource.ROCK));
        assertEquals(4,availableMap.get(Resource.SHIELD));
        assertEquals(3,availableMap.get(Resource.SERVANT));
    }

    /**
     * This test checks the correct behaviour in case of resource payment all the resources needed and all the resources
     * paid
     */
    @Test
    @DisplayName("PayResources Test 2 - all the resources needed and all the resources payed")
    public void payResourcesTest2(){
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();

        Map<Resource,Integer> costMap = new HashMap<>();
        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        ArrayList<Resource> available;
        ArrayList<Resource> cost = new ArrayList<>();

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 51);
        storageMap.put(Resource.ROCK, 51);
        storageMap.put(Resource.SHIELD, 51);
        storageMap.put(Resource.SERVANT, 51);

        strongboxMap.put(Resource.COIN, 51);
        strongboxMap.put(Resource.ROCK, 51);
        strongboxMap.put(Resource.SHIELD, 51);
        strongboxMap.put(Resource.SERVANT, 51);

        costMap.put(Resource.COIN, 100);
        costMap.put(Resource.ROCK, 100);
        costMap.put(Resource.SHIELD, 100);
        costMap.put(Resource.SERVANT, 100);


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

        for(Resource key : costMap.keySet()){
            for (int i = 0; i<costMap.get(key); i++){
                cost.add(key);
            }
        }

        gameBoard.payResources(cost);

        available = gameBoard.availableResources();

        for (Resource r : available) {
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(0,availableMap.get(Resource.COIN));
        assertEquals(0,availableMap.get(Resource.ROCK));
        assertEquals(0,availableMap.get(Resource.SHIELD));
        assertEquals(0,availableMap.get(Resource.SERVANT));
    }


    /**
     * This test checks the seventhCardCheck method in order to confirm a EndGameException is thrown in the
     * right moment only
     */
    @Test
    @DisplayName("seventhCardCheck() test ")
    public void seventhCardCheck(){
        GameBoard gameBoard = new GameBoard() ;
        DeckProductionCardOneBlu blueDeck = new DeckProductionCardOneBlu();
        DeckProductionCardOneGreen greenDeck = new DeckProductionCardOneGreen();
        DeckProductionCardOneYellow yellowDeck = new DeckProductionCardOneYellow();

        try {
            gameBoard.setNewProductionCard(blueDeck,0);
        } catch (EmptyException | FullColumnException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.seventhCardCheck();
        } catch (EndGameException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.setNewProductionCard(blueDeck,0);
        } catch (EmptyException | FullColumnException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.seventhCardCheck();
        } catch (EndGameException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.setNewProductionCard(blueDeck,0);
        } catch (EmptyException | FullColumnException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.seventhCardCheck();
        } catch (EndGameException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.setNewProductionCard(blueDeck,1);
        } catch (EmptyException | FullColumnException e) {
            e.printStackTrace();
        }


        try {
            gameBoard.seventhCardCheck();
        } catch (EndGameException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.setNewProductionCard(greenDeck,1);
        } catch (EmptyException | FullColumnException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.seventhCardCheck();
        } catch (EndGameException e) {
            e.printStackTrace();
        }


        try {
            gameBoard.setNewProductionCard(greenDeck,1);
        } catch (EmptyException | FullColumnException e) {
            e.printStackTrace();
        }


        try {
            gameBoard.seventhCardCheck();
        } catch (EndGameException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.setNewProductionCard(greenDeck,2);
        } catch (EmptyException | FullColumnException e) {
            e.printStackTrace();
        }


        try {
            gameBoard.seventhCardCheck();
        } catch (EndGameException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.setNewProductionCard(greenDeck,2);
        } catch (EmptyException | FullColumnException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.seventhCardCheck();
        } catch (EndGameException e) {
            e.printStackTrace();
        }


        try {
            gameBoard.setNewProductionCard(yellowDeck,2);
        } catch (EmptyException | FullColumnException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.seventhCardCheck();
        } catch (EndGameException e) {
            e.printStackTrace();
        }

    }

    /**
     * This test checks the behaviour in case of an affordable card buy attempt
     */
    @Test
    @DisplayName("buyProductionCard() test - affordable card")
    public void buyProductionCardTest0(){
        GameBoard gameBoard = new GameBoard() ;
        new Reserve();
        DeckProductionCardOneBlu blueDeck = new DeckProductionCardOneBlu();

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();

        storageMap.put(Resource.COIN, 15);
        storageMap.put(Resource.ROCK, 15);
        storageMap.put(Resource.SHIELD, 15);
        storageMap.put(Resource.SERVANT, 15);

        strongboxMap.put(Resource.COIN, 15);
        strongboxMap.put(Resource.ROCK, 15);
        strongboxMap.put(Resource.SHIELD, 15);
        strongboxMap.put(Resource.SERVANT, 15);


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

    }


    /**
     * This test checks the behaviour in case of a too expensive card buy attempt
     */
    @Test
    @DisplayName("buyProductionCard() test - too expensive")
    public void buyProductionCardTest1(){
        GameBoard gameBoard = new GameBoard() ;
        new Reserve();
        DeckProductionCardOneBlu blueDeck = new DeckProductionCardOneBlu();

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();

        storageMap.put(Resource.COIN, 1);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 0);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 0);
        strongboxMap.put(Resource.ROCK, 0);
        strongboxMap.put(Resource.SHIELD, 0);
        strongboxMap.put(Resource.SERVANT, 0);


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

    }

    /**
     * This test checks the behaviour in case of wrong level card buy attempt
     */
    @Test
    @DisplayName("buyProductionCard() test - wrong level")
    public void buyProductionCardTest2(){
        GameBoard gameBoard = new GameBoard() ;
        new Reserve();
        DeckProductionCardThreeBlu blueDeckThree = new DeckProductionCardThreeBlu();

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();

        storageMap.put(Resource.COIN, 1);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 0);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 0);
        strongboxMap.put(Resource.ROCK, 0);
        strongboxMap.put(Resource.SHIELD, 0);
        strongboxMap.put(Resource.SERVANT, 0);


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
            gameBoard.buyProductionCard(blueDeckThree,0);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }

    }

    /**
     * This test checks the behaviour in case of multiple production card acquires
     */
    @Test
    @DisplayName("buyProductionCard() test - all level text and recharge available resources")
    public void buyProductionCardTest3(){
        GameBoard gameBoard = new GameBoard() ;
        new Reserve();
        DeckProductionCardOneBlu blueDeck = new DeckProductionCardOneBlu();
        DeckProductionCardTwoBlu blueDeckTwo = new DeckProductionCardTwoBlu();
        DeckProductionCardThreeBlu blueDeckThree = new DeckProductionCardThreeBlu();

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();

        storageMap.put(Resource.COIN, 3);
        storageMap.put(Resource.ROCK, 2);
        storageMap.put(Resource.SHIELD, 1);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 25);
        strongboxMap.put(Resource.ROCK, 26);
        strongboxMap.put(Resource.SHIELD, 27);
        strongboxMap.put(Resource.SERVANT, 28);


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

        try {
            assertEquals(1,gameBoard.firstRowFree(0));
        } catch (FullColumnException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.buyProductionCard(blueDeckTwo,0);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }

        try {
            assertEquals(2,gameBoard.firstRowFree(0));
        } catch (FullColumnException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.buyProductionCard(blueDeckThree,0);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }

        try {
            assertEquals(3,gameBoard.firstRowFree(0));
        } catch (FullColumnException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.buyProductionCard(blueDeck,1);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }

        try {
            assertEquals(1,gameBoard.firstRowFree(1));
        } catch (FullColumnException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.buyProductionCard(blueDeckTwo,1);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }

        try {
            assertEquals(2,gameBoard.firstRowFree(1));
        } catch (FullColumnException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.buyProductionCard(blueDeckThree,1);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }

        try {
            assertEquals(3,gameBoard.firstRowFree(1));
        } catch (FullColumnException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.buyProductionCard(blueDeck,2);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }

        try {
            assertEquals(1,gameBoard.firstRowFree(2));
        } catch (FullColumnException e) {
            e.printStackTrace();
        }

        try {
            gameBoard.buyProductionCard(blueDeckTwo,2);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }

        try {
            assertEquals(2,gameBoard.firstRowFree(2));
        } catch (FullColumnException e) {
            e.printStackTrace();
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
            gameBoard.buyProductionCard(blueDeckThree,2);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }


        try {
            assertEquals(3,gameBoard.firstRowFree(2));
        } catch (FullColumnException e) {
            e.printStackTrace();
        }
    }

    /**
     * This test checks the correct assessment of production card overall points (complete test)
     */
    @Test
    @DisplayName("productionScoreTest() test - complete test")
    public void productionScoreTest(){
        GameBoard gameBoard = new GameBoard() ;
        new Reserve();
        DeckProductionCardOneBlu blueDeck = new DeckProductionCardOneBlu();
        DeckProductionCardTwoBlu blueDeckTwo = new DeckProductionCardTwoBlu();
        DeckProductionCardThreeBlu blueDeckThree = new DeckProductionCardThreeBlu();

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();

        storageMap.put(Resource.COIN, 3);
        storageMap.put(Resource.ROCK, 2);
        storageMap.put(Resource.SHIELD, 1);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 25);
        strongboxMap.put(Resource.ROCK, 26);
        strongboxMap.put(Resource.SHIELD, 27);
        strongboxMap.put(Resource.SERVANT, 28);

        int score = 0;

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

        assertEquals(0,gameBoard.productionScore());

        try {
            score+=blueDeck.getPoints();
            gameBoard.buyProductionCard(blueDeck,0);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }
        assertEquals(score,gameBoard.productionScore());
        try {
            score+=blueDeckTwo.getPoints();
            gameBoard.buyProductionCard(blueDeckTwo,0);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }
        assertEquals(score,gameBoard.productionScore());
        try {
            score+=blueDeckThree.getPoints();
            gameBoard.buyProductionCard(blueDeckThree,0);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }
        assertEquals(score,gameBoard.productionScore());
        try {
            score+=blueDeck.getPoints();
            gameBoard.buyProductionCard(blueDeck,1);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }
        assertEquals(score,gameBoard.productionScore());
        try {
            score+=blueDeckTwo.getPoints();
            gameBoard.buyProductionCard(blueDeckTwo,1);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }
        assertEquals(score,gameBoard.productionScore());
        try {
            score+=blueDeckThree.getPoints();
            gameBoard.buyProductionCard(blueDeckThree,1);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }
        assertEquals(score,gameBoard.productionScore());
        try {
            score+=blueDeck.getPoints();
            gameBoard.buyProductionCard(blueDeck,2);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }
        assertEquals(score,gameBoard.productionScore());

        try {
            score+=blueDeckTwo.getPoints();
            gameBoard.buyProductionCard(blueDeckTwo,2);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }
        assertEquals(score,gameBoard.productionScore());
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
            score+=blueDeckThree.getPoints();
            gameBoard.buyProductionCard(blueDeckThree,2);
        } catch (LevelException | NotEnoughResourcesException | EmptyException | FullColumnException | EndGameException e) {
            e.printStackTrace();
        }

        assertEquals(score,gameBoard.productionScore());

    }

    /**
     * This test checks the correct market related action behaviour.
     */
    @Test
    @DisplayName("takeFromMarketTest() - ")
    public void takeFromMarketTest(){
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();
        Map<Resource,Integer> newResourcesMap = new HashMap<>();
        ArrayList<Resource> newResourcesList = new ArrayList<>();
        ArrayList<Resource> available;

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

        newResourcesMap.put(Resource.COIN, 1);
        newResourcesMap.put(Resource.ROCK, 0);
        newResourcesMap.put(Resource.SHIELD, 2);
        newResourcesMap.put(Resource.SERVANT, 1);

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

        for(Resource key : newResourcesMap.keySet()){
            for (int i = 0; i<newResourcesMap.get(key); i++){
                newResourcesList.add(key);
            }
        }

        try {
            gameBoard.takeFromMarket(newResourcesList);
        } catch (NotEnoughSpaceInStorageException e) {
            e.printStackTrace();
        }

        available = gameBoard.availableResources();

        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(1,availableMap.get(Resource.COIN));
        assertEquals(0,availableMap.get(Resource.ROCK));
        assertEquals(2,availableMap.get(Resource.SHIELD));
        assertEquals(1,availableMap.get(Resource.SERVANT));

        assertEquals(newResourcesMap.get(Resource.COIN),newResourcesMap.get(Resource.COIN));
        assertEquals(newResourcesMap.get(Resource.ROCK),availableMap.get(Resource.ROCK));
        assertEquals(newResourcesMap.get(Resource.SHIELD),availableMap.get(Resource.SHIELD));
        assertEquals(newResourcesMap.get(Resource.SERVANT),availableMap.get(Resource.SERVANT));




    }

    /**
     * This test checks the correct market related action behaviour.
     */
    @Test
    @DisplayName("takeFromMarketTest1() - too many resources in buffer")
    public void takeFromMarketTest1() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> newResourcesMap = new HashMap<>();
        ArrayList<Resource> newResourcesList = new ArrayList<>();

        storageMap.put(Resource.COIN, 0);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 0);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 0);
        strongboxMap.put(Resource.ROCK, 0);
        strongboxMap.put(Resource.SHIELD, 0);
        strongboxMap.put(Resource.SERVANT, 0);

        newResourcesMap.put(Resource.COIN, 4);
        newResourcesMap.put(Resource.ROCK, 0);
        newResourcesMap.put(Resource.SHIELD, 0);
        newResourcesMap.put(Resource.SERVANT, 0);

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

        for(Resource key : newResourcesMap.keySet()){
            for (int i = 0; i<newResourcesMap.get(key); i++){
                newResourcesList.add(key);
            }
        }

        try {
            gameBoard.takeFromMarket(newResourcesList);
        } catch (NotEnoughSpaceInStorageException e) {
            e.printStackTrace();
        }

    }


    /**
     * This test checks the correct market related action behaviour.
     */
    @Test
    @DisplayName("takeFromMarketTest2() - too many resources in buffer")
    public void takeFromMarketTest2() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> newResourcesMap = new HashMap<>();
        ArrayList<Resource> newResourcesList = new ArrayList<>();

        storageMap.put(Resource.COIN, 0);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 1);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 0);
        strongboxMap.put(Resource.ROCK, 0);
        strongboxMap.put(Resource.SHIELD, 0);
        strongboxMap.put(Resource.SERVANT, 0);

        newResourcesMap.put(Resource.COIN, 1);
        newResourcesMap.put(Resource.ROCK, 2);
        newResourcesMap.put(Resource.SHIELD, 0);
        newResourcesMap.put(Resource.SERVANT, 3);

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

        for(Resource key : newResourcesMap.keySet()){
            for (int i = 0; i<newResourcesMap.get(key); i++){
                newResourcesList.add(key);
            }
        }

        try {
            gameBoard.takeFromMarket(newResourcesList);
        } catch (NotEnoughSpaceInStorageException e) {
            e.printStackTrace();
        }
    }


    /**
     * This test checks the correct base production action behaviour.
     */
    @Test
    @DisplayName("productionOn() test - correct production attempt")
    public void baseProductionOnTest0() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        ArrayList<Resource> available;

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 2);
        storageMap.put(Resource.ROCK, 1);
        storageMap.put(Resource.SHIELD, 1);
        storageMap.put(Resource.SERVANT, 0);

        for(Resource key : storageMap.keySet()){
            for (int i = 0; i<storageMap.get(key); i++){
                gameBoard.addToStorage(key);
            }
        }

        try {
            gameBoard.baseProductionOn(Resource.COIN,Resource.COIN,Resource.SHIELD);
        } catch (ImpossibleProductionException e) {
            e.printStackTrace();
        }

        gameBoard.endOfProduction();

        available = gameBoard.availableResources();

        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(0,availableMap.get(Resource.COIN));
        assertEquals(1,availableMap.get(Resource.ROCK));
        assertEquals(2,availableMap.get(Resource.SHIELD));
        assertEquals(0,availableMap.get(Resource.SERVANT));

    }


    /**
     * This test checks the correct base production action behaviour.
     */
    @Test
    @DisplayName("productionOn1() test - wrong production attempt")
    public void baseProductionOnTest1() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();

        Map<Resource,Integer> storageMap = new HashMap<>();

        storageMap.put(Resource.COIN, 1);
        storageMap.put(Resource.ROCK, 1);
        storageMap.put(Resource.SHIELD, 1);
        storageMap.put(Resource.SERVANT, 0);


        for(Resource key : storageMap.keySet()){
            for (int i = 0; i<storageMap.get(key); i++){
                gameBoard.addToStorage(key);
            }
        }

        try {
            gameBoard.baseProductionOn(Resource.COIN,Resource.COIN,Resource.SHIELD);
        } catch (ImpossibleProductionException e) {
            e.printStackTrace();
        }

        gameBoard.endOfProduction();

    }

    /**
     * This test checks the correct base production action behaviour.
     */
    @Test
    @DisplayName("productionOn2() test - correct production attempt")
    public void baseProductionOnTest2() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();

        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        ArrayList<Resource> available;

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 3);
        storageMap.put(Resource.ROCK, 2);
        storageMap.put(Resource.SHIELD, 1);
        storageMap.put(Resource.SERVANT, 0);

        for(Resource key : storageMap.keySet()){
            for (int i = 0; i<storageMap.get(key); i++){
                gameBoard.addToStorage(key);
            }
        }

        try {
            gameBoard.baseProductionOn(Resource.COIN,Resource.ROCK,Resource.SERVANT);
        } catch (ImpossibleProductionException e) {
            e.printStackTrace();
        }

        gameBoard.endOfProduction();

        available = gameBoard.availableResources();

        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(2,availableMap.get(Resource.COIN));
        assertEquals(1,availableMap.get(Resource.ROCK));
        assertEquals(1,availableMap.get(Resource.SHIELD));
        assertEquals(1,availableMap.get(Resource.SERVANT));

    }

    /**
     * This test checks the correct production card action behaviour.
     */
    @Test
    @DisplayName("productionOn0() test - correct production attempt")
    public void productionOnTest0() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();
        ProductionCard card;
        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();
        Map<Resource,Integer> inputMap = new HashMap<>();
        ArrayList<Resource>  inputList;
        Map<Resource,Integer> outputMap = new HashMap<>();
        ArrayList<Resource>  outputList;
        int init ;

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);
        outputMap.put(Resource.COIN, 0);
        outputMap.put(Resource.ROCK, 0);
        outputMap.put(Resource.SHIELD, 0);
        outputMap.put(Resource.SERVANT, 0);
        inputMap.put(Resource.COIN, 0);
        inputMap.put(Resource.ROCK, 0);
        inputMap.put(Resource.SHIELD, 0);
        inputMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 0);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 0);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 4);
        strongboxMap.put(Resource.ROCK, 2);
        strongboxMap.put(Resource.SHIELD, 3);
        strongboxMap.put(Resource.SERVANT, 1);

        DeckProductionCardOneBlu deck = new DeckProductionCardOneBlu();
        init = gameBoard.getIndicator();
        try {
            card = deck.pickUpFirstCard();
        } catch (EmptyException e) {
            e.printStackTrace();
            return;
        }

        gameBoard.setProductionCard(card,0);

        outputList = card.getOut();
        inputList = card.getIn();

        for(Resource r : outputList){
            outputMap.put(r,outputMap.remove(r)+1);
        }

        for(Resource r : inputList){
            inputMap.put(r,inputMap.remove(r)+1);
        }

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
            gameBoard.productionOn(0);
        } catch (ImpossibleProductionException | EmptyColumnException | CallForCouncilException | LastSpaceReachedException e) {
            e.printStackTrace();
        }

        gameBoard.endOfProduction();

        available = gameBoard.availableResources();

        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(init+card.isFaithPoint(),gameBoard.getIndicator());
        assertEquals(4-inputMap.get(Resource.COIN)+outputMap.get(Resource.COIN),availableMap.get(Resource.COIN));
        assertEquals(2-inputMap.get(Resource.ROCK)+outputMap.get(Resource.ROCK),availableMap.get(Resource.ROCK));
        assertEquals(3-inputMap.get(Resource.SHIELD)+outputMap.get(Resource.SHIELD),availableMap.get(Resource.SHIELD));
        assertEquals(1-inputMap.get(Resource.SERVANT)+outputMap.get(Resource.SERVANT),availableMap.get(Resource.SERVANT));
    }

    /**
     * This test checks the correct production card action behaviour.
     */
    @Test
    @DisplayName("productionOn3() test - correct production attempt")
    public void productionOnTest3() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();
        ProductionCard card;
        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();
        Map<Resource,Integer> inputMap = new HashMap<>();
        ArrayList<Resource>  inputList;
        Map<Resource,Integer> outputMap = new HashMap<>();
        ArrayList<Resource>  outputList;
        int init ;

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);
        outputMap.put(Resource.COIN, 0);
        outputMap.put(Resource.ROCK, 0);
        outputMap.put(Resource.SHIELD, 0);
        outputMap.put(Resource.SERVANT, 0);
        inputMap.put(Resource.COIN, 0);
        inputMap.put(Resource.ROCK, 0);
        inputMap.put(Resource.SHIELD, 0);
        inputMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 0);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 0);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 10);
        strongboxMap.put(Resource.ROCK, 10);
        strongboxMap.put(Resource.SHIELD, 10);
        strongboxMap.put(Resource.SERVANT, 10);

        DeckProductionCardThreeBlu deck = new DeckProductionCardThreeBlu();
        init = gameBoard.getIndicator();
        try {
            card = deck.pickUpFirstCard();
        } catch (EmptyException e) {
            e.printStackTrace();
            return;
        }

        gameBoard.setProductionCard(card,0);

        outputList = card.getOut();
        inputList = card.getIn();

        for(Resource r : inputList){
            inputMap.put(r,inputMap.remove(r)+1);
        }
        for(Resource r : outputList) {
            outputMap.put(r, outputMap.remove(r) + 1);
        }

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
            gameBoard.productionOn(0);
        } catch (ImpossibleProductionException | EmptyColumnException | CallForCouncilException | LastSpaceReachedException e) {
            e.printStackTrace();
        }

        gameBoard.endOfProduction();

        available = gameBoard.availableResources();

        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }


        assertEquals(init+card.isFaithPoint(),gameBoard.getIndicator());
        assertEquals(10-inputMap.get(Resource.COIN)+outputMap.get(Resource.COIN),availableMap.get(Resource.COIN));
        assertEquals(10-inputMap.get(Resource.ROCK)+outputMap.get(Resource.ROCK),availableMap.get(Resource.ROCK));
        assertEquals(10-inputMap.get(Resource.SHIELD)+outputMap.get(Resource.SHIELD),availableMap.get(Resource.SHIELD));
        assertEquals(10-inputMap.get(Resource.SERVANT)+outputMap.get(Resource.SERVANT),availableMap.get(Resource.SERVANT));
    }

    /**
     * This test checks the correct production card action behaviour.
     */
    @Test
    @DisplayName("productionOn2() test - correct production attempt")
    public void productionOnTest2() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();
        ProductionCard card;
        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();
        Map<Resource,Integer> inputMap = new HashMap<>();
        ArrayList<Resource>  inputList;
        Map<Resource,Integer> outputMap = new HashMap<>();
        ArrayList<Resource>  outputList;
        int init ;

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);
        outputMap.put(Resource.COIN, 0);
        outputMap.put(Resource.ROCK, 0);
        outputMap.put(Resource.SHIELD, 0);
        outputMap.put(Resource.SERVANT, 0);
        inputMap.put(Resource.COIN, 0);
        inputMap.put(Resource.ROCK, 0);
        inputMap.put(Resource.SHIELD, 0);
        inputMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 0);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 0);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 4);
        strongboxMap.put(Resource.ROCK, 4);
        strongboxMap.put(Resource.SHIELD, 4);
        strongboxMap.put(Resource.SERVANT, 4);

        DeckProductionCardOneGreen deck = new DeckProductionCardOneGreen();
        init = gameBoard.getIndicator();
        try {
            card = deck.pickUpFirstCard();
        } catch (EmptyException e) {
            e.printStackTrace();
            return;
        }

        gameBoard.setProductionCard(card,0);

        outputList = card.getOut();
        inputList = card.getIn();

        for(Resource r : inputList){
            inputMap.put(r,inputMap.remove(r)+1);
        }
        for(Resource r : outputList) {
            outputMap.put(r, outputMap.remove(r) + 1);
        }

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
            gameBoard.productionOn(0);
        } catch (ImpossibleProductionException | EmptyColumnException | CallForCouncilException | LastSpaceReachedException e) {
            e.printStackTrace();
        }

        gameBoard.endOfProduction();

        available = gameBoard.availableResources();


        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }


        assertEquals(init+card.isFaithPoint(),gameBoard.getIndicator());
        assertEquals(4-inputMap.get(Resource.COIN)+outputMap.get(Resource.COIN),availableMap.get(Resource.COIN));
        assertEquals(4-inputMap.get(Resource.ROCK)+outputMap.get(Resource.ROCK),availableMap.get(Resource.ROCK));
        assertEquals(4-inputMap.get(Resource.SHIELD)+outputMap.get(Resource.SHIELD),availableMap.get(Resource.SHIELD));
        assertEquals(4-inputMap.get(Resource.SERVANT)+outputMap.get(Resource.SERVANT),availableMap.get(Resource.SERVANT));
    }


    /**
     * This test checks the correct production card action behaviour: wrong production attempt - not enough resources
     */
    @Test
    @DisplayName("productionOn1() test - wrong production attempt not enough resources")
    public void productionOnTest1() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();
        ProductionCard card;
        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();
        Map<Resource,Integer> inputMap = new HashMap<>();
        ArrayList<Resource>  inputList;
        Map<Resource,Integer> outputMap = new HashMap<>();
        ArrayList<Resource>  outputList;

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);
        outputMap.put(Resource.COIN, 0);
        outputMap.put(Resource.ROCK, 0);
        outputMap.put(Resource.SHIELD, 0);
        outputMap.put(Resource.SERVANT, 0);
        inputMap.put(Resource.COIN, 0);
        inputMap.put(Resource.ROCK, 0);
        inputMap.put(Resource.SHIELD, 0);
        inputMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 0);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 0);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 0);
        strongboxMap.put(Resource.ROCK, 0);
        strongboxMap.put(Resource.SHIELD, 0);
        strongboxMap.put(Resource.SERVANT, 0);

        DeckProductionCardOneGreen deck = new DeckProductionCardOneGreen();
        try {
            card = deck.pickUpFirstCard();
        } catch (EmptyException e) {
            e.printStackTrace();
            return;
        }

        gameBoard.setProductionCard(card,0);

        outputList = card.getOut();
        inputList = card.getIn();

        for(Resource r : inputList){
            inputMap.put(r,inputMap.remove(r)+1);
        }
        for(Resource r : outputList) {
            outputMap.put(r, outputMap.remove(r) + 1);
        }

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
            gameBoard.productionOn(0);
        } catch (ImpossibleProductionException | EmptyColumnException | CallForCouncilException | LastSpaceReachedException e) {
            e.printStackTrace();
        }

        gameBoard.endOfProduction();

        available = gameBoard.availableResources();

        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }
    }

    /**
     * This test checks the correct production card action behaviour: wrong production attempt -empty column
     */
    @Test
    @DisplayName("productionOn4() test - wrong production attempt empty column")
    public void productionOnTest4() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();
        ProductionCard card;
        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();
        Map<Resource,Integer> inputMap = new HashMap<>();
        ArrayList<Resource>  inputList;
        Map<Resource,Integer> outputMap = new HashMap<>();
        ArrayList<Resource>  outputList;

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);
        outputMap.put(Resource.COIN, 0);
        outputMap.put(Resource.ROCK, 0);
        outputMap.put(Resource.SHIELD, 0);
        outputMap.put(Resource.SERVANT, 0);
        inputMap.put(Resource.COIN, 0);
        inputMap.put(Resource.ROCK, 0);
        inputMap.put(Resource.SHIELD, 0);
        inputMap.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 0);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 0);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 0);
        strongboxMap.put(Resource.ROCK, 0);
        strongboxMap.put(Resource.SHIELD, 0);
        strongboxMap.put(Resource.SERVANT, 0);

        DeckProductionCardOneGreen deck = new DeckProductionCardOneGreen();
        try {
            card = deck.pickUpFirstCard();
        } catch (EmptyException e) {
            e.printStackTrace();
            return;
        }

        outputList = card.getOut();
        inputList = card.getIn();

        for(Resource r : inputList){
            inputMap.put(r,inputMap.remove(r)+1);
        }
        for(Resource r : outputList) {
            outputMap.put(r, outputMap.remove(r) + 1);
        }

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
            gameBoard.productionOn(0);
        } catch (ImpossibleProductionException | EmptyColumnException | CallForCouncilException | LastSpaceReachedException e) {
            e.printStackTrace();
        }

        gameBoard.endOfProduction();

        available = gameBoard.availableResources();

        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }
    }

    /**
     * This test checks the correct production card action behaviour: correct multiple production attempt
     */
    @Test
    @DisplayName("productionOn5() test - correct multiple production attempt ")
    public void productionOnTest5() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SHIELD);
        new Reserve();
        ProductionCard card,card2;
        Map<Resource,Integer> storageMap = new HashMap<>();
        Map<Resource,Integer> strongboxMap = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();
        Map<Resource,Integer> input1Map = new HashMap<>();
        ArrayList<Resource>  input1List;
        Map<Resource,Integer> output1Map = new HashMap<>();
        ArrayList<Resource>  output1List;
        Map<Resource,Integer> input2Map = new HashMap<>();
        ArrayList<Resource>  input2List;
        Map<Resource,Integer> output2Map = new HashMap<>();
        ArrayList<Resource>  output2List;
        int init ;

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);
        output1Map.put(Resource.COIN, 0);
        output1Map.put(Resource.ROCK, 0);
        output1Map.put(Resource.SHIELD, 0);
        output1Map.put(Resource.SERVANT, 0);
        input1Map.put(Resource.COIN, 0);
        input1Map.put(Resource.ROCK, 0);
        input1Map.put(Resource.SHIELD, 0);
        input1Map.put(Resource.SERVANT, 0);
        output2Map.put(Resource.COIN, 0);
        output2Map.put(Resource.ROCK, 0);
        output2Map.put(Resource.SHIELD, 0);
        output2Map.put(Resource.SERVANT, 0);
        input2Map.put(Resource.COIN, 0);
        input2Map.put(Resource.ROCK, 0);
        input2Map.put(Resource.SHIELD, 0);
        input2Map.put(Resource.SERVANT, 0);

        storageMap.put(Resource.COIN, 0);
        storageMap.put(Resource.ROCK, 0);
        storageMap.put(Resource.SHIELD, 0);
        storageMap.put(Resource.SERVANT, 0);

        strongboxMap.put(Resource.COIN, 5);
        strongboxMap.put(Resource.ROCK, 5);
        strongboxMap.put(Resource.SHIELD, 5);
        strongboxMap.put(Resource.SERVANT, 5);

        DeckProductionCardOneGreen deck = new DeckProductionCardOneGreen();
        init = gameBoard.getIndicator();
        try {
            card = deck.pickUpFirstCard();
            card2 = deck.pickUpFirstCard();
        } catch (EmptyException e) {
            e.printStackTrace();
            return;
        }

        gameBoard.setProductionCard(card,0);
        gameBoard.setProductionCard(card2,1);

        output1List = card.getOut();
        input1List = card.getIn();
        output2List = card2.getOut();
        input2List = card2.getIn();

        for(Resource r : input1List){
            input1Map.put(r,input1Map.remove(r)+1);
        }
        for(Resource r : output1List) {
            output1Map.put(r, output1Map.remove(r) + 1);
        }
        for(Resource r : input2List){
            input2Map.put(r,input2Map.remove(r)+1);
        }
        for(Resource r : output2List) {
            output2Map.put(r, output2Map.remove(r) + 1);
        }

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
            gameBoard.productionOn(0);
        } catch (ImpossibleProductionException | EmptyColumnException | CallForCouncilException | LastSpaceReachedException e) {
            e.printStackTrace();
        }
        try {
            gameBoard.productionOn(1);
        } catch (ImpossibleProductionException | EmptyColumnException | CallForCouncilException | LastSpaceReachedException e) {
            e.printStackTrace();
        }

        gameBoard.endOfProduction();

        available = gameBoard.availableResources();

        for(Resource r : available){
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(init+card.isFaithPoint()+ card2.isFaithPoint(),gameBoard.getIndicator());
        assertEquals(5-input1Map.get(Resource.COIN)+output1Map.get(Resource.COIN)-input2Map.get(Resource.COIN)+output2Map.get(Resource.COIN),availableMap.get(Resource.COIN));
        assertEquals(5-input1Map.get(Resource.ROCK)+output1Map.get(Resource.ROCK)-input2Map.get(Resource.ROCK)+output2Map.get(Resource.ROCK),availableMap.get(Resource.ROCK));
        assertEquals(5-input1Map.get(Resource.SHIELD)+output1Map.get(Resource.SHIELD)-input2Map.get(Resource.SHIELD)+output2Map.get(Resource.SHIELD),availableMap.get(Resource.SHIELD));
        assertEquals(5-input1Map.get(Resource.SERVANT)+output1Map.get(Resource.SERVANT)-input2Map.get(Resource.SERVANT)+output2Map.get(Resource.SERVANT),availableMap.get(Resource.SERVANT));
    }
    /**
     * test about extraProductionOnTest called from game
     * when ProductionGameBoard(leader card power) is instantiated
     */
    @Test
    @DisplayName("extraProductionOnTest0 - simple test")
    public void extraProductionOnTest0() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.COIN);
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
     * when ProductionGameBoard(leader card power) is instantiated
     */
    @Test
    @DisplayName("extraProductionOnTest1 - simple test")
    public void extraProductionOnTest1() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.COIN);
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
     * when ProductionGameBoard(leader card power) is instantiated
     */
    @Test
    @DisplayName("extraProductionOnTest2 - simple test")
    public void extraProductionOnTest2() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new ProductionGameBoard(gameBoard,Resource.SERVANT);
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

        assertEquals(strongboxMap.get(Resource.COIN)+1,availableMap.get(Resource.COIN));
        assertEquals(strongboxMap.get(Resource.ROCK),availableMap.get(Resource.ROCK));
        assertEquals(strongboxMap.get(Resource.SHIELD),availableMap.get(Resource.SHIELD));
        assertEquals(strongboxMap.get(Resource.SERVANT)-1,availableMap.get(Resource.SERVANT));

    }



}