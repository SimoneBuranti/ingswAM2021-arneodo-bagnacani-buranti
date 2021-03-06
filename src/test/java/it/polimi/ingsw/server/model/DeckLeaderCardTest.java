package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.players.PlayerFirst;
import it.polimi.ingsw.server.model.players.PlayerSecond;
import it.polimi.ingsw.server.network.ClientHandler;
import it.polimi.ingsw.server.network.Server;
import org.junit.jupiter.api.Test;

import java.io.IOException;
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
    public void testAboutDrawLeaderCards() throws IOException, InterruptedException {
        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");
        ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server= new Server();
        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;


        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;
        clientController.setNickname("ali");
        clientController2.setNickname("ale");

        clientControllers.add(clientController);
        clientControllers.add(clientController2);

        GameMultiPlayer game= new GameMultiPlayer(2,nickname,true, clientControllers);
        assertEquals(8,game.leaderDeckSize());
        FileClass.FileDestroyer();
    }



    /**
     * test about match creation and its consequent deckLeader creation, with the control on the distribution of eight leader Cards.
     * test also controls if draw cards are correct or not
     *
     */
    @Test
    public void testAboutEqualsOfPersonalLeaderCards() throws IOException, InterruptedException {

        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");
        ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server= new Server();
        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;

        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;

        clientControllers.add(clientController);
        clientControllers.add(clientController2);

        clientController.setNickname("ali");
        clientController2.setNickname("ale");


        GameMultiPlayer game= new GameMultiPlayer(2,nickname,true, clientControllers);
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
    public void testAboutTypeOfPlayers() throws IOException, InterruptedException {
        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");
        ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server= new Server();
        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;

        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;

        clientControllers.add(clientController);
        clientControllers.add(clientController2);

        clientController.setNickname("ali");
        clientController2.setNickname("ale");
        GameMultiPlayer game= new GameMultiPlayer(2,nickname,true, clientControllers);
        assertTrue(game.getPlayerFromList(0) instanceof PlayerFirst);
        assertTrue(game.getPlayerFromList(1) instanceof PlayerSecond);
        FileClass.FileDestroyer();

    }





}