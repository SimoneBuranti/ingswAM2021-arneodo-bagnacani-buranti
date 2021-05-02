package it.polimi.ingsw.server.network;

import com.google.gson.Gson;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    private final Socket serverSocket;
    private BufferedReader in;
    private PrintWriter out;


    public SocketClient(String address, int port) throws IOException {
        this.serverSocket = new Socket(address, port);
        in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        out = new PrintWriter(serverSocket.getOutputStream(), true);

    }

    public void readMessage(){

        while(true){
            try {
                String line;
                Gson g = new Gson();
                line = in.readLine();
                Message msg = g.fromJson(line, Message.class);
                if (msg != null && msg.getMessageType() == MessageType.PING)
                    System.out.println(msg.getMessageType());
                    sendMessage(MessageType.PONG);

            } catch (IOException e) {
                break;
            }
        }

        }

    public void sendMessage(MessageType messageType){
        Gson g = new Gson();
        Message msg = new Message(messageType);
        out.println(g.toJson(msg));
    }
}
