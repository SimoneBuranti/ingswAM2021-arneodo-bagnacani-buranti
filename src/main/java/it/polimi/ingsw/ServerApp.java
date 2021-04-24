package it.polimi.ingsw;

import it.polimi.ingsw.server.network.ClientHandler;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerApp {

    static int portNumber = 1234;

    public static void main(String[] args) {
        int argc = args.length;
        ServerSocket serverSocket;
        Socket clientSocket = null;
        String hostName;

        /*if (argc==2){   //--> Questo sarebbe carino ma dobbiamo capire come funziona json su intellij
            hostName = args[0];
            portNumber = Integer.parseInt(args[1]);
        }else{

        }*/

        ExecutorService executor = Executors.newCachedThreadPool();

        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.err.println(e.getMessage()); // Porta non disponibile
            return;
        }

        System.out.println("Server ready");

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                executor.submit(new ClientHandler(socket));
            } catch(IOException e) {
                break; // Entrerei qui se serverSocket venisse chiuso
            }
        }

        executor.shutdown();
    }

}
