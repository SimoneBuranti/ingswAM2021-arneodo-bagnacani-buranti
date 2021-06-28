package it.polimi.ingsw.server.network;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.controller.GameControllerDisconnection;
import it.polimi.ingsw.server.virtualview.VirtualView;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ClientHandler implements Runnable {

    private final Socket socketClient;
    private ClientController clientController;

    private final InputStream inputStream;
    private final OutputStream outputStream;

    private final BufferedReader readStream;
    private final PrintWriter writeStream;

    private final Server server;

    private Boolean pongo = false;

    private int ack;

    private boolean disconnectedDueExit;


    /**
     * This attribute is used in tests only in order to check the output messages without
     * any socket connection
     */
    private String outputStreamForTests;


    public ClientHandler(Socket client, Server server) throws IOException {
        this.socketClient = client;
        this.server = server;
        clientController = new ClientController(server, this);
        inputStream = socketClient.getInputStream();
        outputStream = socketClient.getOutputStream();

        readStream = new BufferedReader(new InputStreamReader(inputStream));
        writeStream = new PrintWriter(outputStream);
        ack=0;

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

    }

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }


    /**
     * Handles the connection of a new client and keep listening to the socket for new messages.
     * used also for response and check if the pinger communication is still active
     *
     * @throws IOException any of the usual Input/Output related exceptions.
     */
    public void run() {

        try {
            String msg;

            if(server.getSendRestartQuestion() && !server.isRestartQuestionSent()){
                sendMessage(new RestartQuestionMessage(server.getRestartQuestion()));
                if(server.getRestartQuestion() == 0)
                    server.setRestartQuestion();
                server.setRestartQuestionSent(true);
                //server.setSendRestartQuestion();
            }
            else if(server.getSendRestartQuestion() && server.isRestartQuestionSent() && !server.isRestartAnswerReceived()) {
                sendMessage(new BootingLobbyErrorMessage());
                server.addTempClientController(clientController);
            }else if(server.getSendRestartQuestion() && server.isRestartQuestionSent() && server.isRestartAnswerReceived()){
                if(server.isRestartAnswer()) {
                    sendMessage(new RestartQuestionMessage(server.getRestartQuestion()));
                    server.addTempClientController(this.clientController);
                }else
                    sendMessage(new UsernameMessage(null));
            }
            else if(server.getGameController().getGameControllerState().equals("Disconnection")) {
                sendMessage(new RestartQuestionMessage(1));
            }else{
                sendMessage(new UsernameMessage(null));
            }

            ScheduledThreadPoolExecutor pinger = new ScheduledThreadPoolExecutor(1);
            pinger.scheduleAtFixedRate( () -> {

                if(!disconnectedDueExit)
                { try {
                    sendMessage(new PingMessage());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (!getPongo()){
                    ack++;
                    System.out.println("ack error: " + ack);
                    if(ack==2){
                    try {
                            pingDisconnection();
                        System.out.println("passo da qui " + ack);
                            pinger.shutdown();

                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }}
                else{
                    setPongo(false);
                    ack=0;
                }}
                else
                    pinger.shutdown();


            },3000,2500,TimeUnit.MILLISECONDS);

            while(true){

                msg = readStream.readLine();
                if(msg != null){
                    readMessageServer(msg);
                }
            }
        } catch (IOException | InterruptedException ignored) { }
            Thread.currentThread().interrupt();
        }

    /**
     * read message from the client via socket.
     *
     * @param msg the message to be read.
     */
    public synchronized void readMessageServer(String msg) throws IOException, InterruptedException {
        System.out.println(clientController.getNickname()+"here in lettura"+msg);
            Message parsedMsg = Message.deserialize(msg);
            parsedMsg.accept(clientController);

    }
    /**
     * Sends a message to the client via socket.
     *
     * @param msg the message to be sent.
     */
    public synchronized void sendMessage (Message msg) throws InterruptedException, IOException {
        System.out.println(clientController.getNickname()+"here in send"+msg.toString());
        writeStream.println(msg.serialize());
        writeStream.flush();

    }

    /**
     * Disconnects due to pingDisconnection
     */
    public void pingDisconnection() throws IOException, InterruptedException {

            server.getGameController().handleMessage(new ExitMessage(), this.clientController);

    }

    /**
     * Disconnects fte clientandler due to exit or pingDisconnection
     */
    public void disconnect() throws IOException, InterruptedException {

        if(!disconnectedDueExit)
        {
            if (inputStream != null) inputStream.close();
        if (outputStream != null) outputStream.close();
        socketClient.close();
        disconnectedDueExit=true;
        }


    }

    /**
     * @return pongo true or not
     */
    public Boolean getPongo() {
        return pongo;
    }



    /**
     * @param pongo set for response to ping client
     */
    public void setPongo(Boolean pongo) {
        System.out.println("Set pongo :" + pongo);
        this.pongo = pongo;
    }




    /**
     * Test only method
     */
    public ClientController getClientController() {
        return clientController;
    }


}

