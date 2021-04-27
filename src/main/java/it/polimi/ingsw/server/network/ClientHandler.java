package it.polimi.ingsw.server.network;

import java.io.*;
import java.net.*;
import java.util.*;


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

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
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