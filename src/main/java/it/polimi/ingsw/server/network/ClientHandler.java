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

    /**
     * This attribute is used in tests only in order to check the output messages without
     * any socket connection
     */
    private String outputStreamForTests;

    /**
     * This attribute is used in tests only in order to change the "outputStream" during tests;
     */
    //private final boolean testMode=true;



    public ClientHandler(Socket client, Server server) throws IOException {
        this.socketClient = client;
        this.server = server;
        clientController = new ClientController(server, this);
        inputStream = socketClient.getInputStream();
        outputStream = socketClient.getOutputStream();

        readStream = new BufferedReader(new InputStreamReader(inputStream));
        writeStream = new PrintWriter(outputStream);

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
        //testMode = true;
    }

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
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

            if(server.getSendRestartQuestion() && !server.isRestartQuestionSent()){
                sendMessage(new RestartQuestionMessage(server.getRestartQuestion()));
                if(server.getRestartQuestion() == 0)
                    server.setRestartQuestion();
                server.setRestartQuestionSent(true);
                //server.setSendRestartQuestion();
            }else if(server.getSendRestartQuestion() && server.isRestartQuestionSent() && !server.isRestartAnswerReceived()) {
                sendMessage(new BootingLobbyErrorMessage());
                server.addTempClientController(clientController);
            }else if(server.getSendRestartQuestion() && server.isRestartQuestionSent() && server.isRestartAnswerReceived()){
                if(server.isRestartAnswer())
                    sendMessage(new RestartQuestionMessage(server.getRestartQuestion()));
                else
                    sendMessage(new UsernameMessage(null));
            }else if(server.getGameController().getGameControllerState().equals("Disconnection")) {
                sendMessage(new RestartQuestionMessage(1));
            }else{
                sendMessage(new UsernameMessage(null));
            }

            /*ScheduledThreadPoolExecutor pinger = new ScheduledThreadPoolExecutor(1);
            pinger.scheduleAtFixedRate( () -> {

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
                        System.out.println("Ho disconnesso client - pinger");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        pinger.shutdownNow();
                    }
                }

                setPongo(false);

            },1000,3000,TimeUnit.MILLISECONDS);*/

            while(true){

                msg = readStream.readLine();
                if(msg != null){
                    readMessageServer(msg);
                }
            }
        } catch (IOException | InterruptedException e) {
            try {
                disconnect();
            } catch (IOException | InterruptedException ioException) {
                ioException.printStackTrace();
            }
            Thread.currentThread().interrupt();
        }
    }

    public void readMessageServer(String msg) throws IOException, InterruptedException {
            Message parsedMsg = Message.deserialize(msg);
            parsedMsg.accept(clientController);

    }

    public void sendMessage (Message msg) throws InterruptedException, IOException {
        //System.out.println(clientController + " " + msg.getMessageType());
        writeStream.println(msg.serialize());
        writeStream.flush();

    }

    public void pingDisconnection() throws IOException, InterruptedException {
        switch (server.getGameController().getGameControllerState()) {
            case "Empty":
                if(server.getGameController().isFirstClient(clientController)){
                    server.removePlayerToLobby(clientController.getNickname());
                    server.removeClientController(clientController);
                    server.getGameController().disconnectFirstClient();
                }else{
                    server.getGameController().disconnectClientTempLobby(clientController);
                }
                break;

            case "Lobby":
                server.removePlayerToLobby(clientController.getNickname());
                server.removeClientController(clientController);
                for(ClientController c : server.getClientController())
                    c.getClientHandler().sendMessage(new NPlayersMessage(server.getLobbySize(),server.getGameController().getLobbySize()));
                break;
            case "Restart":
                if(server.getGameController().thereIsTempLobby()){
                    server.getGameController().disconnectClientTempLobby(clientController);
                }else {
                    server.getGameController().removeNameFromReconnected(clientController.getNickname());
                    server.removeClientController(clientController);
                    for (ClientController c : server.getClientController())
                        c.getClientHandler().sendMessage(new NPlayersMessage(server.getGameController().getLobbySize(), server.getLobbySize()));
                }
                break;
            case "MultiPlayer":
            case "SinglePlayer":
                server.setGameController(new GameControllerDisconnection(server, clientController.getGame()));
                clientController.getGame().disconnectPlayer(clientController.getNickname());
                server.addClientControllersDisconnected(clientController);
                break;
            case "Disconnection":
                clientController.getGame().disconnectPlayer(clientController.getNickname());
                server.addClientControllersDisconnected(clientController);
                break;
        }
    }
    public void disconnect() throws IOException, InterruptedException {
        pingDisconnection();

        if (inputStream != null) inputStream.close();
        if (outputStream != null) outputStream.close();
        System.out.println("Ho disconnesso client - general call");
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

