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

    private final Socket socketClient;
    //private SocketServer socketServer;

    //private Scanner in;
    //private PrintWriter out;
    //private final ObjectOutputStream out;
    //private final ObjectInputStream in;
    private boolean isConnected;

    private final InputStream inputStream;
    private final OutputStream outputStream;

    private final BufferedReader readStream;
    private final PrintWriter writeStream;


    public ClientHandler(Socket client) throws IOException {
        this.socketClient = client;
        //this.socketServer = socketServer;
        isConnected = true;
        //this.out = new ObjectOutputStream(socketClient.getOutputStream());
        //this.in = new ObjectInputStream(socketClient.getInputStream());
        inputStream = socketClient.getInputStream();
        outputStream = socketClient.getOutputStream();

        readStream = new BufferedReader(new InputStreamReader(inputStream));
        writeStream = new PrintWriter(outputStream);
    }


    public void run() {

        try {
            //in = new Scanner(socket.getInputStream());
            //out = new PrintWriter(socket.getOutputStream());

            String line;
            Gson g = new Gson();
            Message msg;
            int n = 0;
            while (n<2000) {
                //TimeUnit.SECONDS.sleep(30);
                if(!sendPing())
                    isConnected = false;
                System.out.println(isConnected);
                /*line = readStream.readLine();
                msg = g.fromJson(line, Message.class);
                if (msg.getMessageType() == MessageType.EXIT) {
                    System.out.println("Client disconnected");
                    break;
                } else {
                    //out.println("ClientHandler: " + line);
                    writeStream.flush();
                }*/
                n++;
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public void disconnect() throws IOException {

        if (inputStream != null) inputStream.close();
        if (outputStream != null) outputStream.close();
        System.out.println("Ho disconnesso il client");
        socketClient.close();
    }

    public boolean sendPing() throws IOException {
        String line;
        Gson g = new Gson();
        Message msg = new Message(MessageType.PING);
        writeStream.println(g.toJson(msg));
        writeStream.flush();
        for(int i = 0; i < 30; i++){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(readStream.ready()) {
                line = readStream.readLine();
                msg = g.fromJson(line, Message.class);
                System.out.println(msg.getMessageType());
                if (msg.getMessageType() == MessageType.PONG)
                    return true;
            }else
                return false;
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