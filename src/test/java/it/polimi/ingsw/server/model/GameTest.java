package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.exceptions.CallForCouncilException;
import it.polimi.ingsw.server.model.exceptions.EmptyColumnException;
import it.polimi.ingsw.server.model.exceptions.ImpossibleProductionException;
import it.polimi.ingsw.server.model.exceptions.LastSpaceReachedException;
import it.polimi.ingsw.server.network.ClientHandler;
import it.polimi.ingsw.server.network.Server;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {
    @Test
    public void setIndicatorAfterInitPlayerTestThree() throws IOException, InterruptedException {
        ArrayList<String> nickname = new ArrayList<>();
        nickname.add("Ali");
        nickname.add("Simo");
        nickname.add("Ale");
        ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server= new Server();
        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;

        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;

        ClientHandler clientHandler3= new ClientHandler(server);
        ClientController clientController3= new ClientController(server,clientHandler3) ;

        clientControllers.add(clientController);
        clientControllers.add(clientController2);
        clientControllers.add(clientController3);

        clientController3.setNickname("simo");
        clientController.setNickname("ali");
        clientController2.setNickname("ale");
        GameMultiPlayer game = new GameMultiPlayer(3, nickname, true, clientControllers);
        server.setGame(game);
        try {
            server.getGame().currentPlayer.initResource(Resource.COIN);
        } catch (CallForCouncilException e) {
            e.printStackTrace();
        } catch (LastSpaceReachedException e) {
            e.printStackTrace();
        }
        assertTrue(server.getGame().currentPlayer.getIndicator()==0);
        server.getGame().endOfTurn();

        try {
            server.getGame().currentPlayer.initResource(Resource.COIN);
        } catch (CallForCouncilException e) {
            e.printStackTrace();
        } catch (LastSpaceReachedException e) {
            e.printStackTrace();
        }
        assertTrue(server.getGame().currentPlayer.getIndicator()==0);
        server.getGame().endOfTurn();
        try {
            server.getGame().currentPlayer.initResource(Resource.COIN);
        } catch (CallForCouncilException e) {
            e.printStackTrace();
        } catch (LastSpaceReachedException e) {
            e.printStackTrace();
        }
        assertTrue(server.getGame().currentPlayer.getIndicator()==1);
        server.getGame().endOfTurn();
        assertTrue(server.getGame().currentPlayer.getIndicator()==0);



        FileClass.FileDestroyer();

    }


    @Test
    public void setIndicatorAfterInitPlayerTestFour() throws IOException, InterruptedException {
        ArrayList<String> nickname = new ArrayList<>();
        nickname.add("Ali");
        nickname.add("Simo");
        nickname.add("Ale");
        nickname.add("lillo");
        ArrayList<ClientController> clientControllers = new ArrayList<>(4);
        Server server= new Server();
        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;

        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;

        ClientHandler clientHandler3= new ClientHandler(server);
        ClientController clientController3= new ClientController(server,clientHandler3) ;

        ClientHandler clientHandler4= new ClientHandler(server);
        ClientController clientController4= new ClientController(server,clientHandler4) ;

        clientControllers.add(clientController);
        clientControllers.add(clientController2);
        clientControllers.add(clientController3);
        clientControllers.add(clientController4);

        clientController.setNickname("simo");
        clientController2.setNickname("ali");
        clientController3.setNickname("ale");
        clientController4.setNickname("lillo");
        GameMultiPlayer game = new GameMultiPlayer(4, nickname, true, clientControllers);
        server.setGame(game);
        try {
            server.getGame().currentPlayer.initResource(Resource.COIN);
        } catch (CallForCouncilException e) {
            e.printStackTrace();
        } catch (LastSpaceReachedException e) {
            e.printStackTrace();
        }
        assertTrue(server.getGame().currentPlayer.getIndicator()==0);
        server.getGame().endOfTurn();

        try {
            server.getGame().currentPlayer.initResource(Resource.COIN);
        } catch (CallForCouncilException e) {
            e.printStackTrace();
        } catch (LastSpaceReachedException e) {
            e.printStackTrace();
        }
        assertTrue(server.getGame().currentPlayer.getIndicator()==0);
        server.getGame().endOfTurn();
        try {
            server.getGame().currentPlayer.initResource(Resource.COIN);
        } catch (CallForCouncilException e) {
            e.printStackTrace();
        } catch (LastSpaceReachedException e) {
            e.printStackTrace();
        }
        assertTrue(server.getGame().currentPlayer.getIndicator()==1);
        server.getGame().endOfTurn();

        try {
            server.getGame().currentPlayer.initResource(Resource.COIN,Resource.SERVANT);
        } catch (CallForCouncilException e) {
            e.printStackTrace();
        } catch (LastSpaceReachedException e) {
            e.printStackTrace();
        }
        assertTrue(server.getGame().currentPlayer.getIndicator()==1);
        server.getGame().endOfTurn();






        server.getGame().moveEveryoneExcept(server.getGame().currentPlayer);

        assertTrue(server.getGame().currentPlayer.getIndicator()==0);
        server.getGame().endOfTurn();




        FileClass.FileDestroyer();

    }


    @Test
    public void moveEveryOneExcept() throws IOException, InterruptedException {
        ArrayList<String> nickname = new ArrayList<>();
        nickname.add("Ali");
        nickname.add("Simo");
        nickname.add("Ale");
        nickname.add("lillo");
        ArrayList<ClientController> clientControllers = new ArrayList<>(4);
        Server server= new Server();
        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;

        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;

        ClientHandler clientHandler3= new ClientHandler(server);
        ClientController clientController3= new ClientController(server,clientHandler3) ;

        ClientHandler clientHandler4= new ClientHandler(server);
        ClientController clientController4= new ClientController(server,clientHandler4) ;

        clientControllers.add(clientController);
        clientControllers.add(clientController2);
        clientControllers.add(clientController3);
        clientControllers.add(clientController4);

        clientController.setNickname("simo");
        clientController2.setNickname("ali");
        clientController3.setNickname("ale");
        clientController4.setNickname("lillo");
        GameMultiPlayer game = new GameMultiPlayer(4, nickname, true, clientControllers);
        server.setGame(game);
        try {
            server.getGame().currentPlayer.initResource(Resource.COIN);
        } catch (CallForCouncilException e) {
            e.printStackTrace();
        } catch (LastSpaceReachedException e) {
            e.printStackTrace();
        }
        assertTrue(server.getGame().currentPlayer.getIndicator()==0);
        server.getGame().endOfTurn();

        try {
            server.getGame().currentPlayer.initResource(Resource.COIN);
        } catch (CallForCouncilException e) {
            e.printStackTrace();
        } catch (LastSpaceReachedException e) {
            e.printStackTrace();
        }
        assertTrue(server.getGame().currentPlayer.getIndicator()==0);
        server.getGame().endOfTurn();
        try {
            server.getGame().currentPlayer.initResource(Resource.COIN);
        } catch (CallForCouncilException e) {
            e.printStackTrace();
        } catch (LastSpaceReachedException e) {
            e.printStackTrace();
        }
        assertTrue(server.getGame().currentPlayer.getIndicator()==1);
        server.getGame().endOfTurn();

        try {
            server.getGame().currentPlayer.initResource(Resource.COIN,Resource.SERVANT);
        } catch (CallForCouncilException e) {
            e.printStackTrace();
        } catch (LastSpaceReachedException e) {
            e.printStackTrace();
        }
        assertTrue(server.getGame().currentPlayer.getIndicator()==1);
        server.getGame().endOfTurn();






        server.getGame().moveEveryoneExcept(server.getGame().currentPlayer);

        assertTrue(server.getGame().currentPlayer.getIndicator()==0);
        server.getGame().endOfTurn();
        assertTrue(server.getGame().currentPlayer.getIndicator()==1);
        server.getGame().endOfTurn();
        assertTrue(server.getGame().currentPlayer.getIndicator()==2);
        server.getGame().endOfTurn();
        assertTrue(server.getGame().currentPlayer.getIndicator()==2);
        server.getGame().endOfTurn();




        FileClass.FileDestroyer();

    }


    @Test
    public void tryProduction() throws IOException, InterruptedException {
        ArrayList<String> nickname = new ArrayList<>();
        nickname.add("Ali");
        nickname.add("Simo");
        nickname.add("Ale");
        nickname.add("lillo");
        ArrayList<ClientController> clientControllers = new ArrayList<>(4);
        Server server= new Server();
        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;

        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;

        ClientHandler clientHandler3= new ClientHandler(server);
        ClientController clientController3= new ClientController(server,clientHandler3) ;

        ClientHandler clientHandler4= new ClientHandler(server);
        ClientController clientController4= new ClientController(server,clientHandler4) ;

        clientControllers.add(clientController);
        clientControllers.add(clientController2);
        clientControllers.add(clientController3);
        clientControllers.add(clientController4);

        clientController.setNickname("simo");
        clientController2.setNickname("ali");
        clientController3.setNickname("ale");
        clientController4.setNickname("lillo");
        GameMultiPlayer game = new GameMultiPlayer(4, nickname, true, clientControllers);
        server.setGame(game);
        try {
            server.getGame().currentPlayer.initResource(Resource.COIN);
        } catch (CallForCouncilException e) {
            e.printStackTrace();
        } catch (LastSpaceReachedException e) {
            e.printStackTrace();
        }
        assertTrue(server.getGame().currentPlayer.getIndicator()==0);
        server.getGame().endOfTurn();

        try {
            server.getGame().currentPlayer.initResource(Resource.COIN);
        } catch (CallForCouncilException e) {
            e.printStackTrace();
        } catch (LastSpaceReachedException e) {
            e.printStackTrace();
        }
        assertTrue(server.getGame().currentPlayer.getIndicator()==0);
        server.getGame().endOfTurn();
        try {
            server.getGame().currentPlayer.initResource(Resource.COIN);
        } catch (CallForCouncilException e) {
            e.printStackTrace();
        } catch (LastSpaceReachedException e) {
            e.printStackTrace();
        }
        assertTrue(server.getGame().currentPlayer.getIndicator()==1);
        server.getGame().endOfTurn();

        try {
            server.getGame().currentPlayer.initResource(Resource.COIN,Resource.SERVANT);
        } catch (CallForCouncilException e) {
            e.printStackTrace();
        } catch (LastSpaceReachedException e) {
            e.printStackTrace();
        }
        assertTrue(server.getGame().currentPlayer.getIndicator()==1);
        server.getGame().endOfTurn();


        try {
            server.getGame().productionOn(1);
        } catch (ImpossibleProductionException e) {
            e.printStackTrace();
        } catch (EmptyColumnException e) {
            e.printStackTrace();
        }



        FileClass.FileDestroyer();

    }




}
