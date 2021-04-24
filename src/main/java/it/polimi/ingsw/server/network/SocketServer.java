package it.polimi.ingsw.server.network;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServer {

    private final Server server;
    ServerSocket serverSocket;
    private String hostName;
    private final int portNumber;


    public SocketServer(String hostName, int port){
        this.hostName = hostName;
        this.portNumber = port;
        this.server = new Server();
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
                executor.submit(new ClientHandler(socket));
            } catch(IOException e) {
                break; // Entrerei qui se serverSocket venisse chiuso
            }
        }

        executor.shutdown();
    }


    public String getHostName() {
        return hostName;
    }

    public int getPortNumber() {
        return portNumber;
    }
}
