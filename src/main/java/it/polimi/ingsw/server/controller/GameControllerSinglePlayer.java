package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.network.Server;

import java.io.IOException;
import java.util.ArrayList;

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
                    System.out.println("sono qui");
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

    @Override
    public void handleMessage(ExitMessage msg, ClientController clientController) {
        if(!server.getGame().isOver()){
        boolean flag = false;
        if(game.disconnectPlayer(clientController.getNickname())) {
            flag = true;
            server.addClientControllersDisconnected(clientController);
            System.out.println("Ho disconnesso client - general call");
        }
        try {
            clientController.getClientHandler().disconnect();
        } catch (IOException | InterruptedException e) {
            //messaggio di errore
        }
        if(flag) {
            server.setGameController(new GameControllerDisconnection(this.server,this.game));
        }}
        else
        { game.disconnectPlayer(clientController.getNickname());
            server.addClientControllersDisconnected(clientController);
            try {
                clientController.getClientHandler().disconnect();
                System.out.println("Ho disconnesso client - general call");
            } catch (IOException | InterruptedException e) {
                //messaggio di errore
            }
            server.resetInfo();
        }
    }

    @Override
    public void handleMessage(NumberPlayerMessage msg, ClientController clientController) throws IOException, InterruptedException {
        clientController.getClientHandler().sendMessage(new CompleteRunningMatchErrorMessage());
    }

    @Override
    public void handleMessage(UsernameMessage msg, ClientController clientController) throws IOException, InterruptedException {
        clientController.getClientHandler().sendMessage(new CompleteRunningMatchErrorMessage());
        try {
            clientController.getClientHandler().disconnect();
            System.out.println("Ho disconnesso client - general call");
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
