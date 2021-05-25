package it.polimi.ingsw.client;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.Message;

import java.io.*;
import java.net.*;


public class SocketClient {

    private final Socket serverSocket;
    private ViewController viewController;
    private BufferedReader in;
    private PrintWriter out;


    public SocketClient(String address, int port, View cli) throws IOException {
        this.serverSocket = new Socket(address, port);
        viewController = new ViewController(this,  cli);
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
        } catch (IOException | InterruptedException e) {
            try {
                //System.out.println("disconnetto dalla catch");
                disconnect();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }


    public synchronized void readMessageClient(String msg) throws IOException, InterruptedException {
        System.out.println(msg);
        Message parsedMsg = Message.deserialize(msg);
        parsedMsg.accept(viewController);
    }

    public synchronized void sendMessage(Message message){

        String msg = message.serialize();
        System.out.println("esco: "+msg);
        out.println(msg);
    }

    public void disconnect() throws IOException {
        in.close();
        out.close();
        serverSocket.close();
    }

}
