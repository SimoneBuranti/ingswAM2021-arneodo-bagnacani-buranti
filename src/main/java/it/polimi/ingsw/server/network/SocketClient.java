package it.polimi.ingsw.server.network;

import com.google.gson.Gson;
import it.polimi.ingsw.server.network.messages.Message;
import it.polimi.ingsw.server.network.messages.MessageType;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketClient {
    private final Socket serverSocket;
    //private final ObjectOutputStream out;
    //private final ObjectInputStream in;
    //private final ExecutorService readExecutionQueue;
    private BufferedReader in;
    private PrintWriter out;
    //private Scanner in;
    //private PrintWriter out;
    /*Scanner keyboard = new Scanner(System.in);
    private final PrintWriter out;
    private final BufferedReader in;
    private final BufferedReader stdIn;*/

    public SocketClient(String address, int port) throws IOException {
        this.serverSocket = new Socket(address, port);
        //this.out = new ObjectOutputStream(serverSocket.getOutputStream());
        //this.in = new ObjectInputStream(serverSocket.getInputStream());
        //this.readExecutionQueue = Executors.newSingleThreadExecutor();
        in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        out = new PrintWriter(serverSocket.getOutputStream(), true);
        //in = new Scanner(serverSocket.getInputStream());
        //out = new PrintWriter(serverSocket.getOutputStream());
        /*this.out = new PrintWriter(serverSocket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        this.stdIn = new BufferedReader(new InputStreamReader(System.in));*/
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
        /*readExecutionQueue.execute(() -> {
            while (!readExecutionQueue.isShutdown()) {
                String line;
                Gson g = new Gson();
                try {
                    line = (String) in.readObject();
                    Message msg = g.fromJson(line, Message.class);
                    System.out.println("msg.getMessageType()");
                    if (msg.getMessageType() == MessageType.PING)
                        sendMessage(MessageType.PONG);
                    } catch(IOException e){
                        e.printStackTrace();
                    } catch(ClassNotFoundException e){
                        e.printStackTrace();
                    }
            }
        });*/
    }

        /*while(true){
            String line;
            Gson g = new Gson();
            try {
                line = (String) in.readObject();
                Message msg = g.fromJson(line, Message.class);
                System.out.println("msg.getMessageType()");
                if(msg.getMessageType() == MessageType.PING) {
                    sendMessage(MessageType.PONG);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }*/

    public void sendMessage(MessageType messageType){
        Gson g = new Gson();
        Message msg = new Message(messageType);
        out.println(g.toJson(msg));
    }
}
