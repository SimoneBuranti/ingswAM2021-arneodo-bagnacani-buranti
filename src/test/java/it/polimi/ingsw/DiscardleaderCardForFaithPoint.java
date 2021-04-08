package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DiscardleaderCardForFaithPoint {


    /**
     * test about discard one or two leadercard, from 0ne to two players, monitoring call on method moveTo of Faithpath
     */
    @Test
    public void TestOnDiscardOneCArd() throws LeaderCardsGameboardEmptyException, CallForCouncilException, LastSpaceReachedException {
        ArrayList<String> nickname = new ArrayList<>();
        nickname.add("ale");
        nickname.add("ali");
        GameMultiPlayer game=new GameMultiPlayer(2, nickname);
        assertEquals(8,game.leaderDeckSize());
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(0),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(0)));
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(0),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(1)));
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(0),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(2)));
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(0),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(3)));

        game.getPlayerFromList(0).saveLeaderCard(1,2);
        assertTrue(game.getPlayerFromList(0).personalLeaderCardsize()==4);
        assertTrue(game.getPlayerFromList(0).getGameBoardOfPlayer().leaderCardsSize()==2);


        game.getPlayerFromList(0).discardLeaderCard(1);
        assertTrue(game.getPlayerFromList(0).getIndicator()==1);
        assertTrue(game.getPlayerFromList(0).getGameBoardOfPlayer().leaderCardsSize()==1);

        game.getPlayerFromList(0).discardLeaderCard(0);
        assertTrue(game.getPlayerFromList(0).getIndicator()==2);
        assertTrue(game.getPlayerFromList(0).getGameBoardOfPlayer().leaderCardsSize()==0);





        game.getPlayerFromList(1).saveLeaderCard(1,2);
        assertTrue(game.getPlayerFromList(1).personalLeaderCardsize()==4);
        assertTrue(game.getPlayerFromList(1).getGameBoardOfPlayer().leaderCardsSize()==2);


        game.getPlayerFromList(1).discardLeaderCard(0);
        assertTrue(game.getPlayerFromList(1).getIndicator()==1);
        assertTrue(game.getPlayerFromList(1).getGameBoardOfPlayer().leaderCardsSize()==1);

        game.getPlayerFromList(1).discardLeaderCard(0);
        assertTrue(game.getPlayerFromList(1).getIndicator()==2);
        assertTrue(game.getPlayerFromList(1).getGameBoardOfPlayer().leaderCardsSize()==0);







        assertTrue( true );
    }

}