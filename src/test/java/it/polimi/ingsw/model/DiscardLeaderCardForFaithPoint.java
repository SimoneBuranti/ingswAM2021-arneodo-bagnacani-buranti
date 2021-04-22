package it.polimi.ingsw.model;

import it.polimi.ingsw.model.exceptions.CallForCouncilException;
import it.polimi.ingsw.model.exceptions.LastSpaceReachedException;
import it.polimi.ingsw.model.leaderCards.LeaderCardsGameBoardEmptyException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
/**
 * test class about DiscardLeaderCardForFaithPoint
 */
class DiscardLeaderCardForFaithPoint {


    /**
     * test about discard one or two leaderCard, from one to two players, monitoring call on method moveTo of FaithPath
     */
    @Test
    public void testOnDiscardOneCard() throws LeaderCardsGameBoardEmptyException, CallForCouncilException, LastSpaceReachedException {
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
        assertEquals(4, game.getPlayerFromList(0).personalLeaderCardSize());
        assertEquals(2, game.getPlayerFromList(0).getGameBoardOfPlayer().leaderCardsSize());


        game.getPlayerFromList(0).discardLeaderCard(1);
        assertEquals(1, game.getPlayerFromList(0).getIndicator());
        assertEquals(1, game.getPlayerFromList(0).getGameBoardOfPlayer().leaderCardsSize());

        game.getPlayerFromList(0).discardLeaderCard(0);
        assertEquals(2, game.getPlayerFromList(0).getIndicator());
        assertEquals(0, game.getPlayerFromList(0).getGameBoardOfPlayer().leaderCardsSize());





        game.getPlayerFromList(1).saveLeaderCard(1,2);
        assertEquals(4, game.getPlayerFromList(1).personalLeaderCardSize());
        assertEquals(2, game.getPlayerFromList(1).getGameBoardOfPlayer().leaderCardsSize());


        game.getPlayerFromList(1).discardLeaderCard(0);
        assertEquals(1, game.getPlayerFromList(1).getIndicator());
        assertEquals(1, game.getPlayerFromList(1).getGameBoardOfPlayer().leaderCardsSize());

        game.getPlayerFromList(1).discardLeaderCard(0);
        assertEquals(2, game.getPlayerFromList(1).getIndicator());
        assertEquals(0, game.getPlayerFromList(1).getGameBoardOfPlayer().leaderCardsSize());

    }

}