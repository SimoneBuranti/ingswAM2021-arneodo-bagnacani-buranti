package it.polimi.ingsw;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DiscardTest {


    /**
     * Rigorous Test :-)
     */
    @Test
    public void Discardtest()
    {

    ArrayList<String> nickname= new ArrayList<String>(3);
    nickname.add("ale");
    nickname.add("ali");
    nickname.add("simo");

    GameMultiPlayer gameMultiPlayer = new GameMultiPlayer(3,nickname);
    assertTrue(gameMultiPlayer.leaderDeckSize()==4);
    assertTrue(gameMultiPlayer.getPlayerFromList(0).personalLeaderCardsize()==4);
    assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().leaderCardsSize()==0);
    gameMultiPlayer.getPlayerFromList(0).discardLeaderCard(1,2);
    assertTrue(gameMultiPlayer.getPlayerFromList(0).personalLeaderCardsize()==4);
    assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().leaderCardsSize()==2);

    gameMultiPlayer.getPlayerFromList(1).discardLeaderCard(0,3);
    assertTrue(gameMultiPlayer.getPlayerFromList(1).personalLeaderCardsize()==4);
    assertTrue(gameMultiPlayer.getPlayerFromList(1).getGameBoardOfPlayer().leaderCardsSize()==2);




    }



    /**
     * Rigorous Test :-)
     */
    @Test
    public void DiscardtestOne()
    {

        ArrayList<String> nickname= new ArrayList<String>(3);
        nickname.add("ale");
        nickname.add("ali");
        nickname.add("simo");

        GameMultiPlayer gameMultiPlayer = new GameMultiPlayer(3,nickname);
        assertTrue(gameMultiPlayer.leaderDeckSize()==4);
        assertTrue(gameMultiPlayer.getPlayerFromList(0).personalLeaderCardsize()==4);
        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().leaderCardsSize()==0);
        gameMultiPlayer.getPlayerFromList(0).discardLeaderCard(1,2);
        assertTrue(gameMultiPlayer.getPlayerFromList(0).personalLeaderCardsize()==4);
        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().leaderCardsSize()==2);



    }@Test
    public void DiscardtestTwo()
    {

        ArrayList<String> nickname= new ArrayList<String>(3);
        nickname.add("ale");
        nickname.add("ali");
        nickname.add("simo");

        GameMultiPlayer gameMultiPlayer = new GameMultiPlayer(3,nickname);
        gameMultiPlayer.getPlayerFromList(0).discardLeaderCard(1,2);
        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().reportLeaderCardToGameboard(0).equals(gameMultiPlayer.getPlayerFromList(0).getCardFromPersonalLeaderCard(1)));


    }

}