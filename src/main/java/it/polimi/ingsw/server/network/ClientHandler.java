package it.polimi.ingsw.server.network;

import com.google.gson.Gson;
import it.polimi.ingsw.server.network.messages.Message;
import it.polimi.ingsw.server.network.messages.MessageType;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.TimeUnit;


public class ClientHandler implements Runnable {

    private final Socket socketClient;
    private boolean isConnected;

    private final InputStream inputStream;
    private final OutputStream outputStream;

    private final BufferedReader readStream;
    private final PrintWriter writeStream;


    public ClientHandler(Socket client) throws IOException {
        this.socketClient = client;
        //this.socketServer = socketServer;
        isConnected = true;

        inputStream = socketClient.getInputStream();
        outputStream = socketClient.getOutputStream();

        readStream = new BufferedReader(new InputStreamReader(inputStream));
        writeStream = new PrintWriter(outputStream);
    }


    public void run() {

        try {


            String line;
            Gson g = new Gson();
            Message msg;

            while (isConnected) {


                if(!sendPing()){
                    isConnected = false;
                    System.out.println("ciao sono falso");}
                else
                    System.out.println("ciao sono vero");
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } }


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
            }

        }

        return false;
    }
}

