package it.polimi.ingsw.client;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.PingMessage;

import java.io.*;
import java.net.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class SocketClient {

    private final Socket serverSocket;
    private ViewController viewController;
    private BufferedReader in;
    private PrintWriter out;
    private int ack;
    private boolean checkServer;


    public SocketClient(String address, int port, View cli) throws IOException {
        this.serverSocket = new Socket(address, port);
        viewController = new ViewController(this,  cli);
        in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        out = new PrintWriter(serverSocket.getOutputStream(), true);
        ack=0;

    }


    public void readMessage(){


        ScheduledThreadPoolExecutor pinger = new ScheduledThreadPoolExecutor(1);
        pinger.scheduleAtFixedRate( () -> {

            if (!isCheckServer()){
                ack++;
                //System.out.println("ack error: " + ack);
                if(ack==4){
                    try {
                        viewController.sayDisconnect();
                        disconnect();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        pinger.shutdownNow();
                    }
                }}
            else{
                //System.out.println("resetto ack");
                setCheckServer(false);
                ack=0;
            }
            },4000,4000, TimeUnit.MILLISECONDS);

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
        //System.out.println(msg);
        Message parsedMsg = Message.deserialize(msg);
        parsedMsg.accept(viewController);
    }

    public synchronized void sendMessage(Message message){

        String msg = message.serialize();
        System.out.println("esco: "+msg+Thread.currentThread().getName());
        out.println(msg);
    }

    public void disconnect() throws IOException {
        in.close();
        out.close();
        serverSocket.close();
        System.exit(0);
    }

    public boolean isCheckServer() {
        return checkServer;
    }

    public void setCheckServer(boolean checkServer) {
        this.checkServer = checkServer;
    }
}
