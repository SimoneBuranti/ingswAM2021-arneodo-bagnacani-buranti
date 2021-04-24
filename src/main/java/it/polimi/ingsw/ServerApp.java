package it.polimi.ingsw;

import it.polimi.ingsw.server.network.*;

import java.io.*;
import com.google.gson.*;

public class ServerApp {

    public static void main(String[] args) throws FileNotFoundException {
        int argc = args.length;

        SocketServer socketServer;
        String hostName;
        int portNumber;

        if (argc==2){
            hostName = args[0];
            portNumber = Integer.parseInt(args[1]);
            socketServer = new SocketServer(hostName,portNumber);

        }else{
            Gson gson = new Gson();
            socketServer = gson.fromJson(new FileReader("src/main/resources/defaultServer"),SocketServer.class);
        }

        socketServer.create();

    }

}
