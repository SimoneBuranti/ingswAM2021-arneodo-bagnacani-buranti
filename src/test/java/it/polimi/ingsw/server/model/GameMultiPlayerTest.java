package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.network.ClientHandler;
import it.polimi.ingsw.server.network.Server;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameMultiPlayerTest {

    @Test
    public void setCurrentPlayerTest() throws IOException, InterruptedException {
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

        nickname = new ArrayList<>();
        nickname = game.getNickNameInOrder();
        for(String nick : nickname){
            System.out.println(nick);
        }
        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());
        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());
        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());


        game.disconnectPlayer("Simo");

        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());
        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());
        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());


        game.disconnectPlayer("Ale");

        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());
        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());
        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());

        game.disconnectPlayer("Ali");

        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());
        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());
        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());


        FileClass.FileDestroyer();

    }


    @Test
    public void PlayerTest() throws IOException, InterruptedException {
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

        assertEquals(0,game.leaderDeckSize());

        FileClass.FileDestroyer();

    }



    @Test
    public void RestoreTest() throws IOException, InterruptedException {
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

        try {
        GameMultiPlayer game1 = new GameMultiPlayer(4, nickname, false, clientControllers);
        assertEquals(16,game1.leaderDeckSize());
    }catch(FileNotFoundException e){
    }



        FileClass.FileDestroyer();

    }


    @Test
    public void RestoreSingleTest() throws IOException, InterruptedException {
        ArrayList<String> nickname = new ArrayList<>();
        nickname.add("simo");

        ArrayList<ClientController> clientControllers = new ArrayList<>(1);
        Server server= new Server();
        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;
        clientControllers.add(clientController);
        clientController.setNickname("simo");
        Game game=new GameSolitaire("simo",true,clientController);

try{
        Game game2=new GameSolitaire("simo",false,clientController);
        assertEquals(16,game2.leaderDeckSize());
    }catch(FileNotFoundException e){

    }
        FileClass.FileDestroyer();

    }


    @Test
    public void AskTest() throws IOException, InterruptedException {
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
        if(game.checkNickname("ali"))
            game.askInfoOnPlayer(1,"ali");
        else {
            game.endOfLastTurn();
            assertTrue(game.isOver==true);
        }
        FileClass.FileDestroyer();

    }


    @Test
    public void AskEndTurnLookingReferenceGameServerTest() throws IOException, InterruptedException {
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
        if(game.checkNickname("ali"))
            game.askInfoOnPlayer(1,"ali");
        else
        {
            if("lillo".equals(game.currentPlayer.getNickName()))
            {
                game.endOfTurn();
                game.disconnectPlayerOption("lillo");
                game.disconnectPlayer("lillo");
                assertTrue(game.numPlayersDisconnected()==1);
            }
            else if("simo".equals(game.currentPlayer.getNickName()))
            {
                game.endOfTurn();
                game.disconnectPlayerOption("simo");
                game.disconnectPlayer("simo");
                assertTrue(game.numPlayersDisconnected()==1);
            }
            else if("ale".equals(game.currentPlayer.getNickName()))
            {
                game.endOfTurn();
                game.disconnectPlayerOption("ale");
                game.disconnectPlayer("ale");
                assertTrue(game.numPlayersDisconnected()==1);
            }
            else if("ali".equals(game.currentPlayer.getNickName()))
            {
                game.endOfTurn();
                game.disconnectPlayerOption("ali");
                game.disconnectPlayer("ali");
                assertTrue(game.numPlayersDisconnected()==1);
            }

        }



        FileClass.FileDestroyer();

    }



    @Test
    public void AskEndLastTest() throws IOException, InterruptedException {
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
        if(!server.getGame().checkNickname("ali"))
            server.getGame().askInfoOnPlayer(1,"ali");
        else
        {
            game.endOfLastTurn();
            assertTrue(game.isOver==true);
        }

        FileClass.FileDestroyer();

    }


    @Test
    public void AskDisconnectTest() throws IOException, InterruptedException {
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
        if(!server.getGame().checkNickname("ali"))
            server.getGame().askInfoOnPlayer(1,"ali");
        else
        {

            server.getGame().disconnectPlayerOption("lillo");
            server.getGame().disconnectPlayer("lillo");
            assertTrue(server.getGame().numPlayersDisconnected()==1);
        }

        FileClass.FileDestroyer();

    }



    @Test
    public void AskEndTurnTest() throws IOException, InterruptedException {
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
        if(server.getGame().checkNickname("ali"))
            server.getGame().askInfoOnPlayer(1,"ali");
        else
        {
            if("lillo".equals(server.getGame().getCurrentPlayer().getNickName()))
            {
                server.getGame().endOfTurn();
                server.getGame().disconnectPlayerOption("lillo");
                server.getGame().disconnectPlayer("lillo");
                assertTrue(server.getGame().numPlayersDisconnected()==1);
            }
            else if("simo".equals(server.getGame().getCurrentPlayer().getNickName()))
            {
                server.getGame().endOfTurn();
                server.getGame().disconnectPlayerOption("simo");
                server.getGame().disconnectPlayer("simo");
                assertTrue(server.getGame().numPlayersDisconnected()==1);
            }
            else if("ale".equals(server.getGame().getCurrentPlayer().getNickName()))
            {
                server.getGame().endOfTurn();
                server.getGame().disconnectPlayerOption("ale");
                server.getGame().disconnectPlayer("ale");
                assertTrue(server.getGame().numPlayersDisconnected()==1);
            }
            else if("ali".equals(server.getGame().getCurrentPlayer().getNickName()))
            {
                server.getGame().endOfTurn();
                server.getGame().disconnectPlayerOption("ali");
                server.getGame().disconnectPlayer("ali");
                assertTrue(server.getGame().numPlayersDisconnected()==1);
            }

        }



        FileClass.FileDestroyer();

    }






}
