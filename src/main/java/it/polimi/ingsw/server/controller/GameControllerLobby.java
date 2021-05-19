package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.network.Server;

import java.io.IOException;

public class GameControllerLobby extends GameController {

    private int lobbySize;

    public GameControllerLobby(Server server, int lobbySize) {
        this.gameControllerState = "Lobby";
        this.server = server;
        this.lobbySize = lobbySize;
    }


    @Override
    public void handleMessage(ExitMessage msg, ClientController clientController) {
        try {
            clientController.getClientHandler().disconnect();
            server.removePlayerToLobby(clientController.getNickname());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleMessage(NumberPlayerMessage msg, ClientController clientController) {
        //unreachable
    }

    @Override
    public void handleMessage(UsernameMessage msg, ClientController clientController) throws IOException, InterruptedException {
        if (server.addPlayerToLobby(msg.getUsername())){
            clientController.setNickname(msg.getUsername());
            clientController.getClientHandler().sendMessage(new NPlayersMessage(server.getLobbySize(),lobbySize));
            server.addClientController(clientController);
        } else {
            clientController.getClientHandler().sendMessage(new AlreadyExistingNickNameErrorMessage());
        }

        if(lobbySize == server.getLobbySize()){
            server.initNewMultiplayerGame();
        }
    }

    @Override
    public void handleMessage(RestartAnswerMessage msg, ClientController clientController) {
        //unreachable
    }



}
