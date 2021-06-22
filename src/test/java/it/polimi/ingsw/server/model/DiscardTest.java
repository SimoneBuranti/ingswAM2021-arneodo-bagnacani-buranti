package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.network.ClientHandler;
import it.polimi.ingsw.server.network.Server;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * test class about DiscardLeaderCard action
 */
class DiscardTest {


    /**
     *
     * test which controls the correctness of savage of two leader cards
     * for two players
     *
     */
    @Test
    public void discardTest() throws IOException, InterruptedException, IOException {

    ArrayList<String> nickname= new ArrayList<>(3);
    nickname.add("ale");
    nickname.add("ali");
    nickname.add("simo");
        ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server= new Server();
        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;

        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;

        ClientHandler clientHandler3= new ClientHandler(server);
        ClientController clientController3= new ClientController(server,clientHandler2) ;

        clientControllers.add(clientController);
        clientControllers.add(clientController2);
        clientControllers.add(clientController3);

        clientController3.setNickname("simo");
        clientController.setNickname("ali");
        clientController2.setNickname("ale");
    GameMultiPlayer gameMultiPlayer = new GameMultiPlayer(3,nickname,true, clientControllers);
    assertEquals(4, gameMultiPlayer.leaderDeckSize());
    assertEquals(4, gameMultiPlayer.getPlayerFromList(0).personalLeaderCardSize());
    assertEquals(0, gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().leaderCardsSize());
    gameMultiPlayer.getPlayerFromList(0).saveLeaderCard(1,2);
    assertEquals(4, gameMultiPlayer.getPlayerFromList(0).personalLeaderCardSize());
    assertEquals(2, gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().leaderCardsSize());

    gameMultiPlayer.getPlayerFromList(1).saveLeaderCard(0,3);
    assertEquals(4, gameMultiPlayer.getPlayerFromList(1).personalLeaderCardSize());
    assertEquals(2, gameMultiPlayer.getPlayerFromList(1).getGameBoardOfPlayer().leaderCardsSize());
        FileClass.FileDestroyer();

    }



    /**
     * test which controls the correctness of savage of two leader cards (base)
     */
    @Test
    public void discardTestOne() throws IOException, InterruptedException {

        ArrayList<String> nickname= new ArrayList<>(3);
        nickname.add("ale");
        nickname.add("ali");
        nickname.add("simo");
        ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server= new Server();
        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;

        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;

        ClientHandler clientHandler3= new ClientHandler(server);
        ClientController clientController3= new ClientController(server,clientHandler2) ;

        clientControllers.add(clientController);
        clientControllers.add(clientController2);
        clientControllers.add(clientController3);

        clientController3.setNickname("simo");
        clientController.setNickname("ali");
        clientController2.setNickname("ale");
        GameMultiPlayer gameMultiPlayer = new GameMultiPlayer(3,nickname,true, clientControllers);
        assertEquals(4, gameMultiPlayer.leaderDeckSize());
        assertEquals(4, gameMultiPlayer.getPlayerFromList(0).personalLeaderCardSize());
        assertEquals(0, gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().leaderCardsSize());
        gameMultiPlayer.getPlayerFromList(0).saveLeaderCard(1,2);
        assertEquals(4, gameMultiPlayer.getPlayerFromList(0).personalLeaderCardSize());
        assertEquals(2, gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().leaderCardsSize());

 FileClass.FileDestroyer();

    }



    /**
     * test which controls the correctness of savage of two leader cards for one players
     *
     */

   @Test
    public void discardTestTwo() throws IOException, InterruptedException {

        ArrayList<String> nickname= new ArrayList<>(3);
        nickname.add("ale");
        nickname.add("ali");
        nickname.add("simo");
        ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server= new Server();
        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;

        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;

        ClientHandler clientHandler3= new ClientHandler(server);
        ClientController clientController3= new ClientController(server,clientHandler2) ;

        clientControllers.add(clientController);
        clientControllers.add(clientController2);
        clientControllers.add(clientController3);

        clientController3.setNickname("simo");
        clientController.setNickname("ali");
        clientController2.setNickname("ale");
        GameMultiPlayer gameMultiPlayer = new GameMultiPlayer(3,nickname,true, clientControllers);
        gameMultiPlayer.getPlayerFromList(0).saveLeaderCard(1,2);
        assertEquals(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().reportLeaderCardToGameBoard(0), gameMultiPlayer.getPlayerFromList(0).getCardFromPersonalLeaderCard(1));

 FileClass.FileDestroyer();
    }

}