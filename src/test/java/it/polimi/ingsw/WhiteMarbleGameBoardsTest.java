package it.polimi.ingsw;

import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class WhiteMarbleGameBoardsTest {

    @Test
    @DisplayName("Correct instance test")
    public void correctInstancesTest(){
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new WhiteMarbleGameBoard(gameBoard,Resource.COIN);

        assertTrue(gameBoard instanceof WhiteMarbleGameBoard);

        gameBoard = new WhiteMarbleGameBoardDouble(gameBoard,gameBoard.getResourceTypeFirst(),Resource.ROCK);

        assertTrue(gameBoard instanceof WhiteMarbleGameBoardDouble);
    }

    @Test
    @DisplayName("whiteExchangeTest - null method")
    public void whiteExchangeNullTest() {
        WhiteMarble whiteMarble = new WhiteMarble();
        Player player = new Player("SIMOSIMO" , new Game());

        try {
            whiteMarble.giveResource(player);
        } catch (WhiteMarbleException e) {
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("whiteExchangeTest")
    public void whiteExchangeTest() {
        Reserve reserve = new Reserve();
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new WhiteMarbleGameBoard(gameBoard,Resource.COIN);

        Resource resource ;

        try {
            resource = gameBoard.whiteExchange();
        } catch (WhiteMarbleException | BlockedWhiteMarbleEffectException | UnavailableResourceException e) {
            e.printStackTrace();
            return;
        }

        assertTrue(resource==gameBoard.getResourceTypeFirst());

    }

    @Test
    @DisplayName("whiteExchangeDoubleTest")
    public void whiteExchangeDoubleTest() {
        GameBoardInterface gameBoard = new GameBoard();
        gameBoard = new WhiteMarbleGameBoard(gameBoard,Resource.COIN);
        gameBoard = new WhiteMarbleGameBoardDouble(gameBoard,gameBoard.getResourceTypeFirst(),Resource.ROCK);

        try {
            gameBoard.whiteExchange();
        } catch (WhiteMarbleException | BlockedWhiteMarbleEffectException | UnavailableResourceException e) {
            e.printStackTrace();
        }

    }



}