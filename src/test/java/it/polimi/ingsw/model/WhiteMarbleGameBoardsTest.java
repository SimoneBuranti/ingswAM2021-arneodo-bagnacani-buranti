package it.polimi.ingsw.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class WhiteMarbleGameBoardsTest {

    /**
     * testing the Correctness of gameBoard instance
     */
    @Test
    @DisplayName("Correct instance test")
    public void correctInstancesTest(){
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new WhiteMarbleGameBoard(gameBoard,Resource.COIN);

        assertTrue(gameBoard instanceof WhiteMarbleGameBoard);

        gameBoard = new WhiteMarbleGameBoardDouble(gameBoard,gameBoard.getResourceTypeFirst(),Resource.ROCK);

        assertTrue(gameBoard instanceof WhiteMarbleGameBoardDouble);
    }
    /**
     * testing the Correctness of gameBoard instance
     * whiteExchangeTest - null method
     * null return
     */
    @Test
    @DisplayName("whiteExchangeTest - null method")
    public void whiteExchangeNullTest() {
        WhiteMarble whiteMarble = new WhiteMarble();
        Player player = new Player("Simo" , new Game());

        try {
            whiteMarble.giveResource(player);
        } catch (WhiteMarbleException e) {
            e.printStackTrace();
        }

    }
    /**
     * testing the Correctness of gameBoard instance
     * whiteExchangeTest - not empty method
     * resource return
     */
    @Test
    @DisplayName("whiteExchangeTest")
    public void whiteExchangeTest() {
        new Reserve();
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new WhiteMarbleGameBoard(gameBoard,Resource.COIN);

        Resource resource ;

        try {
            resource = gameBoard.whiteExchange();
        } catch (WhiteMarbleException | BlockedWhiteMarbleEffectException e) {
            e.printStackTrace();
            return;
        }

        assertSame(resource, gameBoard.getResourceTypeFirst());

    }
    /**
     * testing the Correctness of gameBoard instance
     * whiteExchangeTestDouble - not empty method
     * return exception to view
     */
    @Test
    @DisplayName("whiteExchangeDoubleTest")
    public void whiteExchangeDoubleTest() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new WhiteMarbleGameBoard(gameBoard,Resource.COIN);
        gameBoard = new WhiteMarbleGameBoardDouble(gameBoard,gameBoard.getResourceTypeFirst(),Resource.ROCK);

        try {
            gameBoard.whiteExchange();
        } catch (WhiteMarbleException | BlockedWhiteMarbleEffectException e) {
            e.printStackTrace();
        }

    }



}