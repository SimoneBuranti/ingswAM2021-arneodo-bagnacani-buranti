package it.polimi.ingsw.Client;

import com.google.gson.Gson;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import it.polimi.ingsw.client.ViewController;
public class SocketClient {
    private final Socket serverSocket;
    private ViewController viewController;
    private BufferedReader in;
    private PrintWriter out;


    public SocketClient(String address, int port) throws IOException {
        this.serverSocket = new Socket(address, port);
        viewController = new ViewController();
        in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        out = new PrintWriter(serverSocket.getOutputStream(), true);

    }

    public void readMessage(){

        try {
            String msg;

            while(true){
                msg = in.readLine();
                if(msg != null){
                    readMessageClient(msg);
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


    public void readMessageClient(String msg){
        Message parsedMsg = Message.deserialize(msg);
        parsedMsg.accept(viewController);
    }

    public void sendMessage(Message message){
        String msg = message.serialize();
        out.println(msg);
    }

    public void disconnect() throws IOException {
        in.close();
        out.close();
        serverSocket.close();
    }

}
