package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.network.ClientHandler;
import it.polimi.ingsw.server.network.Server;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
