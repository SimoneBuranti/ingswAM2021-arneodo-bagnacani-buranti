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
    public void handleMessage(ExitMessage msg, ClientController clientController){
        if(!server.getGame().isOver()){
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
     }}
        else
        {server.addClientControllersDisconnected(clientController);
            if (server.getClientControllersDisconnected().size()==server.getClientController().size())
            { server.resetInfo(); }
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
