package it.polimi.ingsw.server.network;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ClientHandler implements Runnable {

    private Socket socket;

    private Scanner in;
    private PrintWriter out;


    public ClientHandler(Socket socket) {
        this.socket = socket;
    }


    public void run() {

        try {
            this.in = new Scanner(socket.getInputStream());
            this.out = new PrintWriter(socket.getOutputStream());

            String line;

            InetAddress clientAddress = socket.getInetAddress();
            System.out.println(clientAddress.getHostAddress());
            ScheduledExecutorService pinger = Executors.newSingleThreadScheduledExecutor();
            pinger.scheduleAtFixedRate(() -> {
                                                try {
                                                    if(!clientAddress.isReachable(3000)){
                                                        System.out.println("Sono entrato");
                                                        disconnect();
                                                        pinger.shutdown();
                                                    }
                                                    System.out.println("Non ho chiuso il pinger");
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                            }, 0, 3000, TimeUnit.MILLISECONDS);

            while (true) {
                line = in.nextLine();

                if (line.equals("quit")) {
                    System.out.println("Client disconnected");
                    break;
                } else {
                    out.println("ClientHandler: " + line);
                    out.flush();
                }
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public void disconnect() {
        in.close();
        out.close();
        System.out.println("Ho disconnesso il client");
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addClient(){}
    /*
    private void handleClientConnection() throws IOException {
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