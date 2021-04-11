package it.polimi.ingsw.model;
import it.polimi.ingsw.model.GameMultiPlayer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DiscardTest {


    /**
     *
     * test which controls the correctness of savage of two leader cards
     * for two players
     *
     */
    @Test
    public void discardTest()
    {

    ArrayList<String> nickname= new ArrayList<>(3);
    nickname.add("ale");
    nickname.add("ali");
    nickname.add("simo");

    GameMultiPlayer gameMultiPlayer = new GameMultiPlayer(3,nickname);
    assertTrue(gameMultiPlayer.leaderDeckSize()==4);
    assertTrue(gameMultiPlayer.getPlayerFromList(0).personalLeaderCardSize()==4);
    assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().leaderCardsSize()==0);
    gameMultiPlayer.getPlayerFromList(0).saveLeaderCard(1,2);
    assertTrue(gameMultiPlayer.getPlayerFromList(0).personalLeaderCardSize()==4);
    assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().leaderCardsSize()==2);

    gameMultiPlayer.getPlayerFromList(1).saveLeaderCard(0,3);
    assertTrue(gameMultiPlayer.getPlayerFromList(1).personalLeaderCardSize()==4);
    assertTrue(gameMultiPlayer.getPlayerFromList(1).getGameBoardOfPlayer().leaderCardsSize()==2);




    }



    /**
     * test which controls the correctness of savage of two leader cards (base)
     */
    @Test
    public void discardTestOne()
    {

        ArrayList<String> nickname= new ArrayList<>(3);
        nickname.add("ale");
        nickname.add("ali");
        nickname.add("simo");

        GameMultiPlayer gameMultiPlayer = new GameMultiPlayer(3,nickname);
        assertTrue(gameMultiPlayer.leaderDeckSize()==4);
        assertTrue(gameMultiPlayer.getPlayerFromList(0).personalLeaderCardSize()==4);
        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().leaderCardsSize()==0);
        gameMultiPlayer.getPlayerFromList(0).saveLeaderCard(1,2);
        assertTrue(gameMultiPlayer.getPlayerFromList(0).personalLeaderCardSize()==4);
        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().leaderCardsSize()==2);



    }



    /**
     * test which controls the correctness of savage of two leader cards for one players
     *
     */

    @Test
    public void discardTestTwo()
    {

        ArrayList<String> nickname= new ArrayList<>(3);
        nickname.add("ale");
        nickname.add("ali");
        nickname.add("simo");

        GameMultiPlayer gameMultiPlayer = new GameMultiPlayer(3,nickname);
        gameMultiPlayer.getPlayerFromList(0).saveLeaderCard(1,2);
        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().reportLeaderCardToGameBoard(0).equals(gameMultiPlayer.getPlayerFromList(0).getCardFromPersonalLeaderCard(1)));


    }

}