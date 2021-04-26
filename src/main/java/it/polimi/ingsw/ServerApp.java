package it.polimi.ingsw;

import it.polimi.ingsw.server.controller.GameController;
import it.polimi.ingsw.server.network.*;

import java.io.*;
import java.util.Map;

import com.google.gson.*;

public class ServerApp {

    public static void main(String[] args) throws FileNotFoundException {
        int argc = args.length;

        SocketServer socketServer;

        int portNumber;

        GameController gameController = new GameController();
        Server server = new Server(gameController);

        if (argc==2){
            //hostName = args[0];
            portNumber = Integer.parseInt(args[1]);
            socketServer = new SocketServer(server,portNumber);

        }else{
            Gson g = new Gson();
            Map map = g.fromJson(new FileReader("src/main/resources/defaultServer.json"),Map.class);
            socketServer = new SocketServer(server,((Double) map.get("defaultServerPort")).intValue());
        }

        socketServer.create();



        /*Thread thread = new Thread(socketServer, "socketserver_");
        thread.start();*/
    }

}
