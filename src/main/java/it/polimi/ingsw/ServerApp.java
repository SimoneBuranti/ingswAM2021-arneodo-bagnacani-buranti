package it.polimi.ingsw;

import it.polimi.ingsw.server.controller.GameController;
import it.polimi.ingsw.server.network.*;

import java.io.*;
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
            socketServer = g.fromJson(new FileReader("src/main/resources/defaultServer"),SocketServer.class);
            socketServer = new SocketServer(server,1234);
        }

        socketServer.create();



        /*Thread thread = new Thread(socketServer, "socketserver_");
        thread.start();*/
    }

}
