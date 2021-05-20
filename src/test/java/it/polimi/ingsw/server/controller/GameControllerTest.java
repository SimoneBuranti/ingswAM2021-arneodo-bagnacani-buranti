package it.polimi.ingsw.server.controller;

import com.google.gson.Gson;
import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.model.GameMultiPlayer;
import it.polimi.ingsw.server.model.GameSolitaire;
import it.polimi.ingsw.server.network.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest {

    @Test
    @DisplayName("GameControllerEmpty -1- one connection only")
    public void gameControllerEmptyTest1() throws InterruptedException, FileNotFoundException {
        Server server = new Server();

        Message parsedMsg;


        try {
            ClientHandler clientHandler = new ClientHandler(server);
            GameController gameController = server.getGameController();


            assertTrue(!server.getSendRestartQuestion());
            assertTrue(gameController instanceof GameControllerEmpty);
            assertTrue(server.getLobbySize()==0);

            clientHandler.readMessageServer((new UsernameMessage("Simosimo")).serialize());
            parsedMsg = Message.deserialize(clientHandler.getOutputStreamForTests());

            assertTrue(server.getLobbySize()==1);

            assertTrue(parsedMsg instanceof NPlayersMessage);
            assertTrue(((NPlayersMessage) parsedMsg).getnOfPlayers()==-1);

            clientHandler.readMessageServer((new NumberPlayerMessage(4)).serialize());

            assertTrue(server.getGameController() instanceof GameControllerLobby);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("GameControllerEmpty -2- one connection and other during lobby booting")
    public void gameControllerEmptyTest2() throws InterruptedException, FileNotFoundException {
        Server server = new Server();
        Message msg;


        try {
            ClientHandler clientHandler = new ClientHandler(server);
            GameController gameController = server.getGameController();


            assertTrue(!server.getSendRestartQuestion());
            assertTrue(gameController instanceof GameControllerEmpty);
            assertTrue(server.getLobbySize()==0);

            clientHandler.readMessageServer((new UsernameMessage("Simosimo")).serialize());
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof NPlayersMessage);
            assertTrue(((NPlayersMessage) msg).getnOfPlayers()==-1);

            clientHandler.readMessageServer((new UsernameMessage("aliali")).serialize());
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof BootingLobbyErrorMessage);

            clientHandler.readMessageServer((new UsernameMessage("aleale")).serialize());
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof BootingLobbyErrorMessage);

            clientHandler.readMessageServer((new NumberPlayerMessage(4)).serialize());
            assertTrue(server.getGameController() instanceof GameControllerLobby);

            clientHandler.readMessageServer((new UsernameMessage("aliali")).serialize());
            assertTrue(server.getLobbySize()==2);
            assertTrue(server.getGameController() instanceof GameControllerLobby);
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof NPlayersMessage);
            assertTrue(((NPlayersMessage) msg).getnOfPlayers() == 2);

            clientHandler.readMessageServer((new UsernameMessage("aliali")).serialize());
            assertTrue(server.getLobbySize()==2);
            assertTrue(server.getGameController() instanceof GameControllerLobby);
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof AlreadyExistingNickNameErrorMessage);

            clientHandler.readMessageServer((new UsernameMessage("aliali")).serialize());
            assertTrue(server.getLobbySize()==2);
            assertTrue(server.getGameController() instanceof GameControllerLobby);
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof AlreadyExistingNickNameErrorMessage);

            clientHandler.readMessageServer((new UsernameMessage("aleale")).serialize());
            assertTrue(server.getLobbySize()==3);
            assertTrue(server.getGameController() instanceof GameControllerLobby);
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof NPlayersMessage);
            assertTrue(((NPlayersMessage) msg).getnOfPlayers() == 3);


            clientHandler.readMessageServer((new ExitMessage()).serialize());
            assertTrue(server.getLobbySize()==2);
            assertTrue(server.getGameController() instanceof GameControllerLobby);

            clientHandler.readMessageServer((new UsernameMessage("aleale")).serialize());
            assertTrue(server.getLobbySize()==3);
            assertTrue(server.getGameController() instanceof GameControllerLobby);
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof NPlayersMessage);
            assertTrue(((NPlayersMessage) msg).getnOfPlayers() == 3);


            clientHandler.readMessageServer((new UsernameMessage("La principessa Sissi")).serialize());
            assertTrue(server.getLobbySize()==4);
            assertTrue(server.getGameController() instanceof GameControllerMultiplayer);


            assertTrue(server.getGame() instanceof GameMultiPlayer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @Test
    @DisplayName("GameControllerEmpty -3- single player correct messages")
    public void gameControllerEmptyTest3() throws InterruptedException, FileNotFoundException {
        Server server = new Server();

        Message msg;


        try {
            ClientHandler clientHandler = new ClientHandler(server);
            GameController gameController = server.getGameController();


            assertTrue(!server.getSendRestartQuestion());
            assertTrue(gameController instanceof GameControllerEmpty);
            assertTrue(server.getLobbySize()==0);

            clientHandler.readMessageServer((new UsernameMessage("Simosimo")).serialize());
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof NPlayersMessage);
            assertTrue(((NPlayersMessage) msg).getnOfPlayers()==-1);

            assertTrue(server.getLobbySize()==1);
            clientHandler.readMessageServer((new NumberPlayerMessage(1)).serialize());
            assertTrue(server.getGameController() instanceof GameControllerSinglePlayer);

            assertTrue(server.getGame() instanceof GameSolitaire);
            assertTrue(server.getLobbySize()==1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Test
    @DisplayName("GameControllerEmpty -4- single player correct messages and then more connection requests")
    public void gameControllerEmptyTest4() throws InterruptedException, FileNotFoundException {
        Server server = new Server();

        Message msg;


        try {
            ClientHandler clientHandler = new ClientHandler(server);
            GameController gameController = server.getGameController();


            assertTrue(!server.getSendRestartQuestion());
            assertTrue(gameController instanceof GameControllerEmpty);
            assertTrue(server.getLobbySize()==0);

            clientHandler.readMessageServer((new UsernameMessage("Simosimo")).serialize());
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof NPlayersMessage);
            assertTrue(((NPlayersMessage) msg).getnOfPlayers()==-1);

            assertTrue(server.getLobbySize()==1);
            clientHandler.readMessageServer((new NumberPlayerMessage(1)).serialize());
            assertTrue(server.getGameController() instanceof GameControllerSinglePlayer);

            assertTrue(server.getGame() instanceof GameSolitaire);
            assertTrue(server.getLobbySize()==1);


            clientHandler.readMessageServer((new UsernameMessage("Lellykelly")).serialize());
            assertTrue(server.getLobbySize()==1);
            assertTrue(server.getGameController() instanceof GameControllerSinglePlayer);
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof CompleteRunningMatchErrorMessage);

            clientHandler.readMessageServer((new UsernameMessage("le tue scarpine")).serialize());
            assertTrue(server.getLobbySize()==1);
            assertTrue(server.getGameController() instanceof GameControllerSinglePlayer);
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof CompleteRunningMatchErrorMessage);

            clientHandler.readMessageServer((new UsernameMessage("oh ye")).serialize());
            assertTrue(server.getLobbySize()==1);
            assertTrue(server.getGameController() instanceof GameControllerSinglePlayer);
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof CompleteRunningMatchErrorMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("GameControllerEmpty -5- multiplayer general messages and disconnection requests")
    public void gameControllerEmptyTest5() throws InterruptedException, FileNotFoundException {
        Server server = new Server();

        Message msg;


        try {
            ClientHandler clientHandler = new ClientHandler(server);
            GameController gameController = server.getGameController();


            assertTrue(!server.getSendRestartQuestion());
            assertTrue(gameController instanceof GameControllerEmpty);
            assertTrue(server.getLobbySize()==0);

            clientHandler.readMessageServer((new UsernameMessage("Simosimo")).serialize());
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof NPlayersMessage);
            assertTrue(((NPlayersMessage) msg).getnOfPlayers()==-1);

            clientHandler.readMessageServer((new UsernameMessage("aliali")).serialize());
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof BootingLobbyErrorMessage);

            clientHandler.readMessageServer((new UsernameMessage("aleale")).serialize());
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof BootingLobbyErrorMessage);

            clientHandler.readMessageServer((new NumberPlayerMessage(4)).serialize());
            assertTrue(server.getGameController() instanceof GameControllerLobby);

            clientHandler.readMessageServer((new UsernameMessage("aliali")).serialize());
            assertTrue(server.getLobbySize()==2);
            assertTrue(server.getGameController() instanceof GameControllerLobby);
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof NPlayersMessage);
            assertTrue(((NPlayersMessage) msg).getnOfPlayers() == 2);

            clientHandler.readMessageServer((new UsernameMessage("aliali")).serialize());
            assertTrue(server.getLobbySize()==2);
            assertTrue(server.getGameController() instanceof GameControllerLobby);
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof AlreadyExistingNickNameErrorMessage);

            clientHandler.readMessageServer((new UsernameMessage("aliali")).serialize());
            assertTrue(server.getLobbySize()==2);
            assertTrue(server.getGameController() instanceof GameControllerLobby);
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof AlreadyExistingNickNameErrorMessage);

            clientHandler.readMessageServer((new UsernameMessage("aleale")).serialize());
            assertTrue(server.getLobbySize()==3);
            assertTrue(server.getGameController() instanceof GameControllerLobby);
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof NPlayersMessage);
            assertTrue(((NPlayersMessage) msg).getnOfPlayers() == 3);


            clientHandler.readMessageServer((new ExitMessage()).serialize());
            assertTrue(server.getLobbySize()==2);
            assertTrue(server.getGameController() instanceof GameControllerLobby);

            clientHandler.readMessageServer((new UsernameMessage("aleale")).serialize());
            assertTrue(server.getLobbySize()==3);
            assertTrue(server.getGameController() instanceof GameControllerLobby);
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof NPlayersMessage);
            assertTrue(((NPlayersMessage) msg).getnOfPlayers() == 3);


            clientHandler.readMessageServer((new UsernameMessage("La principessa Sissi")).serialize());
            assertTrue(server.getLobbySize()==4);
            assertTrue(server.getGameController() instanceof GameControllerMultiplayer);


            assertTrue(server.getGame() instanceof GameMultiPlayer);


            clientHandler.readMessageServer((new ExitMessage()).serialize());
            assertTrue(server.getGameController() instanceof GameControllerDisconnection);

            clientHandler.readMessageServer((new UsernameMessage("simosimo")).serialize());
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof NoNicknameMessage);
            assertTrue(server.getGameController() instanceof GameControllerDisconnection);

            clientHandler.readMessageServer((new UsernameMessage("aliali")).serialize());
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof NoNicknameMessage);
            assertTrue(server.getGameController() instanceof GameControllerDisconnection);

            clientHandler.readMessageServer((new UsernameMessage("aleale")).serialize());
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(msg instanceof NoNicknameMessage);
            assertTrue(server.getGameController() instanceof GameControllerDisconnection);

            clientHandler.readMessageServer((new UsernameMessage("La principessa Sissi")).serialize());
            msg = Message.deserialize(clientHandler.getOutputStreamForTests());
            assertTrue(server.getGameController() instanceof GameControllerMultiplayer);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
