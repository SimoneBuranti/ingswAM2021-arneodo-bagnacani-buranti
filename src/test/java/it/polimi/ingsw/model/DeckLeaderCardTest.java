package it.polimi.ingsw.model;

import it.polimi.ingsw.model.players.PlayerFirst;
import it.polimi.ingsw.model.players.PlayerSecond;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test class about DeckLeaderCard
 */
class DeckLeaderCardTest {


    /**
     * test about match creation and its consequent deckLeader creation, with the control on the distribution of eight leader Cards
     */
    @Test
    public void testAboutDrawLeaderCards()
    {
        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");
        GameMultiPlayer game= new GameMultiPlayer(2,nickname);
        assertEquals(8,game.leaderDeckSize());
    }



    /**
     * test about match creation and its consequent deckLeader creation, with the control on the distribution of eight leader Cards.
     * test also controls if draw cards are correct or not
     *
     */
    @Test
    public void testAboutEqualsOfPersonalLeaderCards()
    {

        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");
        GameMultiPlayer game= new GameMultiPlayer(2,nickname);
        assertEquals(8,game.leaderDeckSize());
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(0),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(0)));
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(0),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(1)));
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(0),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(2)));
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(0),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(3)));

        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(1),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(0)));
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(1),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(1)));
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(1),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(2)));
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(1),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(3)));

        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(2),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(0)));
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(2),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(1)));
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(2),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(2)));
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(2),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(3)));

        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(3),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(0)));
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(3),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(1)));
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(3),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(2)));
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(3),(game.getPlayerFromList(1).getCardFromPersonalLeaderCard(3)));



        assertEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(0),(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(0)));
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(0),(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(1)));
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(0),(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(2)));
        assertNotEquals(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(0),(game.getPlayerFromList(0).getCardFromPersonalLeaderCard(3)));
    }



    /**
     * test about match creation and his consequent listOf players and its order
     */
    @Test
    public void testAboutTypeOfPlayers()
    {
        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");
        GameMultiPlayer game= new GameMultiPlayer(2,nickname);
        assertTrue(game.getPlayerFromList(0) instanceof PlayerFirst);
        assertTrue(game.getPlayerFromList(1) instanceof PlayerSecond);


    }





}