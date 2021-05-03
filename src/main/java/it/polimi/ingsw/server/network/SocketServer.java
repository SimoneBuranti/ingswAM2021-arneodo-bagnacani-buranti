package it.polimi.ingsw.server.network;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class SocketServer {

    private final Server server;
    ServerSocket serverSocket;
    private final int portNumber;


    public SocketServer(Server server, int port){
        this.portNumber = port;
        this.server = server;
    }

    public void create(){

        try {
            this.serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return;
        }

        ExecutorService executor = Executors.newCachedThreadPool();

        System.out.println("Server ready");

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                executor.submit(new ClientHandler(socket,server));
            } catch(IOException e) {
                break; // Entrerei qui se serverSocket venisse chiuso
            }
        }

        executor.shutdown();
    }


    public int getPortNumber() {
        return portNumber;
    }
}
