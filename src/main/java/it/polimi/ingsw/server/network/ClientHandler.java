package it.polimi.ingsw.server.network;

import com.google.gson.Gson;
import it.polimi.ingsw.server.network.messages.Message;
import it.polimi.ingsw.server.network.messages.MessageType;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ClientHandler implements Runnable {

    private Socket socketClient;
    private SocketServer socketServer;

    //private Scanner in;
    //private PrintWriter out;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    private boolean isConnected;


    public ClientHandler(SocketServer socketServer, Socket client) throws IOException {
        this.socketClient = client;
        this.socketServer = socketServer;
        isConnected = true;
        this.out = new ObjectOutputStream(socketClient.getOutputStream());
        this.in = new ObjectInputStream(socketClient.getInputStream());
    }


    public void run() {

        try {
            //in = new Scanner(socket.getInputStream());
            //out = new PrintWriter(socket.getOutputStream());

            String line;

            while (true) {
                if(!sendPing())
                    isConnected = false;
                line = (String) in.readObject();

                if (line.equals("quit")) {
                    System.out.println("Client disconnected");
                    break;
                } else {
                    //out.println("ClientHandler: " + line);
                    out.flush();
                }
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void disconnect() throws IOException {
        in.close();
        out.close();
        System.out.println("Ho disconnesso il client");
        try {
            socketClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean sendPing() throws IOException {
        String line;
        Gson g = new Gson();
        Message msg = new Message(MessageType.PING);
        out.write(Integer.parseInt(g.toJson(msg)));

        System.out.println("wiurfuiwgufiw");
        for(int i = 0; i < 30; i++){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                line = (String) in.readObject();
                msg = g.fromJson(line, Message.class);
                System.out.println(msg.getMessageType());
                if(msg.getMessageType() == MessageType.PONG)
                    return true;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public void addClient(){}
    /*
    /*private void handleClientConnection() throws IOException {
        Server.LOGGER.info("Client connected from " + client.getInetAddress());

        try {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (inputLock) {
                    Message message = (Message) input.readObject();

                    if (message != null && message.getMessageType() != MessageType.PING) {
                        if (message.getMessageType() == MessageType.LOGIN_REQUEST) {
                            socketServer.addClient(message.getNickname(), this);
                        } else {
                            Server.LOGGER.info(() -> "Received: " + message);
                            socketServer.onMessageReceived(message);
                        }
                    }
                }
            }
        } catch (ClassCastException | ClassNotFoundException e) {
            Server.LOGGER.severe("Invalid stream from client");
        }
        client.close();
    }


    public boolean isConnected() {
        return connected;
    }


    public void disconnect() {
        if (connected) {
            try {
                if (!client.isClosed()) {
                    client.close();
                }
            } catch (IOException e) {
                Server.LOGGER.severe(e.getMessage());
            }
            connected = false;
            Thread.currentThread().interrupt();

            socketServer.onDisconnect(this);
        }
    }


    public void sendMessage(Message message) {
        try {
            synchronized (outputLock) {
                output.writeObject(message);
                output.reset();
                Server.LOGGER.info(() -> "Sent: " + message);
            }
        } catch (IOException e) {
            Server.LOGGER.severe(e.getMessage());
            disconnect();
        }
    }*/

}

/*Thread pinger = new Thread(() ->{
                InetAddress clientAddress = socket.getInetAddress();
                try {
                    clientAddress.isReachable(3000);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });*/