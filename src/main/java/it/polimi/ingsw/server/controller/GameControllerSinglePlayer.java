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
        boolean flag = false;
        if(game.disconnectPlayer(clientController.getNickname())) {
            flag = true;
            server.addClientControllersDisconnected(clientController);
        }
        try {
            clientController.getClientHandler().disconnect();
        } catch (IOException e) {
            //messaggio di errore
        }
        if(flag) {
            server.setGameController(new GameControllerDisconnection(this.server,this.game));
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
        } catch (IOException e) {
            //messaggio di errore
        }
    }


    @Override
    public void handleMessage(RestartAnswerMessage msg, ClientController clientController) {
        //unreachable
    }
}
