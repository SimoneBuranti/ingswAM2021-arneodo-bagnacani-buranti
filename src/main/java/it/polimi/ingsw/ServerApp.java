package it.polimi.ingsw;

import com.google.gson.Gson;
import it.polimi.ingsw.server.controller.*;
import it.polimi.ingsw.server.network.*;
import java.io.*;
import java.util.Map;

public class ServerApp {

    public static void main(String[] args) throws FileNotFoundException {
        int argc = args.length;

        SocketServer socketServer;

        int portNumber;

        GameControllerInterface gameController = new GameControllerEmpty();
        Server server = new Server(gameController);

        if (argc==2){

            portNumber = Integer.parseInt(args[1]);
            socketServer = new SocketServer(server,portNumber);

        }else{
            Gson g = new Gson();
            Map map = g.fromJson(new FileReader("src/main/resources/defaultServer.json"),Map.class);
            socketServer = new SocketServer(server,((Double) map.get("defaultServerPort")).intValue());
        }

        socketServer.create();

    }

}
