package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.exceptions.LeaderCardsGameBoardEmptyException;
import it.polimi.ingsw.server.model.exceptions.CallForCouncilException;
import it.polimi.ingsw.server.model.exceptions.LastSpaceReachedException;
import it.polimi.ingsw.server.network.ClientHandler;
import it.polimi.ingsw.server.network.Server;
import org.junit.jupiter.api.Test;

import java.io.IOException;
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
    public void testOnDiscardOneCard() throws LeaderCardsGameBoardEmptyException, CallForCouncilException, LastSpaceReachedException, IOException, InterruptedException {
        ArrayList<String> nickname = new ArrayList<>();
        nickname.add("ale");
        nickname.add("ali");ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server= new Server();
        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;

        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;

        clientControllers.add(clientController);
        clientControllers.add(clientController2);

        clientController.setNickname("ali");
        clientController2.setNickname("ale");
        GameMultiPlayer game=new GameMultiPlayer(2, nickname,true, clientControllers);
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