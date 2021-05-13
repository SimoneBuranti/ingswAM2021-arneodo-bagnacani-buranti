package it.polimi.ingsw.server.network;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.PingMessage;
import it.polimi.ingsw.messages.RestartQuestionMessage;
import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.virtualview.VirtualView;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ClientHandler implements Runnable {

    private final Socket socketClient;
    private final ClientController clientController;

    private final InputStream inputStream;
    private final OutputStream outputStream;

    private final BufferedReader readStream;
    private final PrintWriter writeStream;

    private final Server server;

    private Boolean pongo = false;

    /**
     * This attribute is used in tests only in order to check the output messages without
     * any socket connection
     */
    private String outputStreamForTests;

    /**
     * This attribute is used in tests only in order to change the "outputStream" during tests;
     */
    private final boolean testMode;



    public ClientHandler(Socket client, Server server) throws IOException {
        this.socketClient = client;
        this.server = server;
        clientController = new ClientController(server, this);
        inputStream = socketClient.getInputStream();
        outputStream = socketClient.getOutputStream();

        readStream = new BufferedReader(new InputStreamReader(inputStream));
        writeStream = new PrintWriter(outputStream);

        testMode=false;
    }


    /**
     * NB TEST CONSTRUCTOR, this constructor doesn't create a socket as io endpoint
     */
    public ClientHandler(Server server) throws IOException {
        this.socketClient = new Socket(); // it remains unactivated

        this.server = server;
        clientController = new ClientController(server, this);

        inputStream = new ByteArrayInputStream(new byte[2]);
        outputStream = new ByteArrayOutputStream();
        readStream = new BufferedReader(new InputStreamReader(inputStream));
        writeStream = new PrintWriter(outputStream);
        testMode = true;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void run() {

        try {
            String msg;

            if(server.getSendRestartQuestion()){
                sendMessage(new RestartQuestionMessage());
                server.setSendRestartQuestion();
            }

            (new ScheduledThreadPoolExecutor(1)).scheduleAtFixedRate( () -> {

                try {
                    sendMessage(new PingMessage());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!getPongo()){
                    try {
                        disconnect();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                setPongo(false);

            },1000,3000,TimeUnit.MILLISECONDS);

            while(true){

                msg = readStream.readLine();
                if(msg != null){
                    readMessageServer(msg);
                }
            }
        } catch (IOException | InterruptedException e) {
            try {
                disconnect();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public void readMessageServer(String msg) throws IOException, InterruptedException {
            Message parsedMsg = Message.deserialize(msg);
            parsedMsg.accept(clientController);

    }

    public void sendMessage (Message msg) throws InterruptedException, IOException {
        if (testMode){
            outputStreamForTests = msg.serialize();
        } else {
            //System.out.println("result of sendPing :" + sendPing());

           // PingMessage ping = new PingMessage();
            //writeStream.println(ping.serialize());
            //TimeUnit.MILLISECONDS.sleep(5000);
            //wait(1000);
            //System.out.println(pongo);
            //if (pongo)
            //{
                writeStream.println(msg.serialize());
                writeStream.flush();
                //setPongo(false);
           // }
            //else
                //disconnect();
        }

    }

    public void disconnect() throws IOException {

        if (inputStream != null) inputStream.close();
        if (outputStream != null) outputStream.close();
        System.out.println("Ho disconnesso il client");
        socketClient.close();
    }

    public Boolean getPongo() {
        return pongo;
    }

    public void setPongo(Boolean pongo) {
        System.out.println("Set pongo :" + pongo);
        this.pongo = pongo;
    }


    /*public boolean sendPing(){
        Message msg = new PingMessage();
        writeStream.println(msg.serialize());
        writeStream.flush();
        for(int i = 0; i < 30; i++){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(pongo)
                return true;

        }

        return false;
    }*/


    /**
     * Test only method
     */
    public ClientController getClientController() {
        return clientController;
    }

    /**
     *Test Only method
     */
    public String getOutputStreamForTests() {
        String out = outputStreamForTests;
        outputStreamForTests = null;
        return out;
    }

}

