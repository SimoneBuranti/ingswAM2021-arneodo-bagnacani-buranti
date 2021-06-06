package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.network.Server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
/**
 * game controller which manage a singleplayer game
 */
public class GameControllerSinglePlayer extends GameController {

    private ArrayList<String> tempLobbyName = new ArrayList<>();
    private ArrayList<ClientController> tempLobbyController = new ArrayList<>();


    public GameControllerSinglePlayer(Server server, Game game) {
        this.gameControllerState = "SinglePlayer";
          this.server = server;
        this.game = game;
    }

    public GameControllerSinglePlayer(Server server, Game game, ArrayList<String> tempLobbyName, ArrayList<ClientController> tempLobbyController) {
        this.gameControllerState = "SinglePlayer";
        this.server = server;
        this.game = game;
        this.tempLobbyName = tempLobbyName;
        this.tempLobbyController = tempLobbyController;


        for(int i = 0; i < tempLobbyName.size(); i++){
            try {
                tempLobbyController.get(i).getClientHandler().sendMessage(new CompleteRunningMatchErrorMessage());
                try {
                    tempLobbyController.get(i).getClientHandler().disconnect();
                } catch (IOException e) {
                    //messaggio di errore
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.tempLobbyName = new ArrayList<>();
        this.tempLobbyController = new ArrayList<>();
    }

    /**
     * method which received the request to exit from client or the possible disconnection due ping
     * @param msg
     * @param clientController
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public void handleMessage(ExitMessage msg, ClientController clientController) throws FileNotFoundException {
        if(!server.getGame().isOver()){
        boolean flag = false;
        if(server.getGame().disconnectPlayer(clientController.getNickname())) {
            flag = true;
            server.addClientControllersDisconnected(clientController);
            System.out.println("Ho disconnesso client ");
        }
        try {
            clientController.getClientHandler().disconnect();
        } catch (IOException | InterruptedException e) {
            //messaggio di errore
        }

        if(flag)
        {
            server.resetInfoPartial();
        }

        }
        else
        { server.getGame().disconnectPlayer(clientController.getNickname());
            server.addClientControllersDisconnected(clientController);
            try {
                clientController.getClientHandler().disconnect();
                System.out.println("Ho disconnesso client");
            } catch (IOException | InterruptedException e) {
                //messaggio di errore
            }
            server.resetInfo();
        }
    }



    /**
     * method which received the answer to number player, it is managed only during in emptyState
     * user receives error
     * @param msg
     * @param clientController
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public void handleMessage(NumberPlayerMessage msg, ClientController clientController) throws IOException, InterruptedException {
        clientController.getClientHandler().sendMessage(new CompleteRunningMatchErrorMessage());
    }
    /**
     * method which received the username for the registration and the authentication of user on server
     * send error to client
     * @param msg
     * @param clientController
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public void handleMessage(UsernameMessage msg, ClientController clientController) throws IOException, InterruptedException {
        clientController.getClientHandler().sendMessage(new CompleteRunningMatchErrorMessage());
        try {
            clientController.getClientHandler().disconnect();
            System.out.println("Ho disconnesso client");
        } catch (IOException e) {
            //messaggio di errore
        }
    }


    @Override
    public void handleMessage(RestartAnswerMessage msg, ClientController clientController) {
        //unreachable
    }

    @Override
    public boolean isFirstClient(ClientController clientController) {
        return false;
    }

    @Override
    public void disconnectFirstClient() {

    }

    @Override
    public void disconnectClientTempLobby(ClientController clientController) {

    }

    @Override
    public void removeNameFromReconnected(String nickname) {

    }

    @Override
    public int getLobbySize() {
        return 0;
    }

    @Override
    public boolean thereIsTempLobby() {
        return false;
    }
}
