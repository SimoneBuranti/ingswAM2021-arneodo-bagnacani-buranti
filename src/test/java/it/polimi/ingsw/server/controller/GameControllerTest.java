package it.polimi.ingsw.server.controller;

import com.google.gson.Gson;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.NPlayersMessage;
import it.polimi.ingsw.messages.NumberPlayerMessage;
import it.polimi.ingsw.messages.UsernameMessage;
import it.polimi.ingsw.server.network.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest {

    @Test
    @DisplayName("GameControllerEmpty - 1")
    public void gameControllerEmptyTest1(){
        Server server = new Server();
        Socket tempSocket = new Socket();
        InputStream inputStream;
        OutputStream outputStream;
        BufferedReader readStream;
        PrintWriter writeStream;
        Gson gson = new Gson();
        Message parsedMsg;

        try {
            inputStream = tempSocket.getInputStream();
            readStream = new BufferedReader(new InputStreamReader(inputStream));
            outputStream = tempSocket.getOutputStream();
            writeStream = new PrintWriter(outputStream);
            ClientHandler clientHandler = new ClientHandler(tempSocket,server);
            ClientController clientController = new ClientController(server,clientHandler);
            GameController gameController = server.getGameController();


            assertTrue(!server.getSendRestartQuestion());
            assertTrue(gameController instanceof GameControllerEmpty);
            assertTrue(server.getLobbySize()==0);

            clientController.visit(new UsernameMessage("Simosimo"));
            parsedMsg = Message.deserialize(readStream.readLine());

            assertTrue(parsedMsg instanceof NPlayersMessage);
            assertTrue(((NPlayersMessage) parsedMsg).getnOfPlayers()==-1);

            clientHandler.readMessageServer((new NumberPlayerMessage(4)).serialize());

            assertTrue(server.getGameController() instanceof GameControllerLobby);

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
