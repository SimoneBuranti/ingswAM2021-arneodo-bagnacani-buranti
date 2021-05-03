package it.polimi.ingsw.server.network;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.server.controller.ClientController;

import java.io.*;
import java.net.Socket;


public class ClientHandler implements Runnable {

    private final Socket socketClient;
    private final ClientController clientController;

    private final InputStream inputStream;
    private final OutputStream outputStream;

    private final BufferedReader readStream;
    private final PrintWriter writeStream;

    private final Server server;


    public ClientHandler(Socket client, Server server) throws IOException {
        this.socketClient = client;
        this.server = server;
        clientController = new ClientController(server);

        inputStream = socketClient.getInputStream();
        outputStream = socketClient.getOutputStream();

        readStream = new BufferedReader(new InputStreamReader(inputStream));
        writeStream = new PrintWriter(outputStream);
    }


    public void run() {

        try {
            String msg;

            while(true){
                msg = readStream.readLine();
                if(msg != null){
                    readMessageServer(msg);
                }
            }
        } catch (IOException e) {
            try {
                disconnect();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public void readMessageServer(String msg){
        Message parsedMsg = Message.deserialize(msg);
        parsedMsg.accept(clientController);
    }

    public void sendMessage (Message msg) {
        writeStream.println(msg.serialize());
        writeStream.flush();
    }

    public void disconnect() throws IOException {

        if (inputStream != null) inputStream.close();
        if (outputStream != null) outputStream.close();
        System.out.println("Ho disconnesso il client");
        socketClient.close();
    }


    /*public boolean sendPing() throws IOException {
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
    }*/
}

