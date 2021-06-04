package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.network.Server;

import java.io.IOException;
import java.util.ArrayList;

public class GameControllerMultiplayer extends GameController {


    public GameControllerMultiplayer(Server server, Game game) {
        this.gameControllerState = "MultiPlayer";
        this.server = server;
        this.game = game;
    }

    @Override
    public void handleMessage(ExitMessage msg, ClientController clientController) throws IOException, InterruptedException {



     if(!server.getGame().isOver()){
     boolean flag = false;
     if(game.disconnectPlayer(clientController.getNickname())) {
      flag = true;
      server.addClientControllersDisconnected(clientController);
     }
     try {
      clientController.getClientHandler().disconnect();
     } catch (IOException | InterruptedException e) {
     //messaggio di errore
    }
     if(flag && !(server.getClientControllersDisconnected().size() ==server.getClientController().size())) {
      server.setGameController(new GameControllerDisconnection(this.server,this.game));
     }
        }
        else
        {game.disconnectPlayer(clientController.getNickname());
            server.addClientControllersDisconnected(clientController);
            try {
                clientController.getClientHandler().disconnect();
                System.out.println("Ho disconnesso client");
            } catch (IOException | InterruptedException e) {
                //messaggio di errore
            }
            if (server.getClientControllersDisconnected().size()==server.getClientController().size())
            { server.resetInfo(); }
        }
        for (int i=0;i< server.getClientController().size(); i++) {
            for (int j = 0; j < server.getClientControllersDisconnected().size(); j++){
                if (!server.getClientController().get(i).equals(clientController) &&
                        !server.getClientController().get(i).equals(server.getClientControllersDisconnected().get(j))){
                    server.getClientController().get(i).getClientHandler().sendMessage(new DisconnectionOpponentMessage(clientController.getNickname()));
                }} }
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
