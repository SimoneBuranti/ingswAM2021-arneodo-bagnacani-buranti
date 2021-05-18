package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.network.Server;

import java.io.IOException;
import java.util.ArrayList;

public class GameControllerDisconnection extends GameController {


    public GameControllerDisconnection(Server server, Game game) {
        this.server = server;
        this.game = game;
    }

    @Override
    public void handleMessage(ExitMessage msg, ClientController clientController) {
        game.disconnectPlayer(clientController.getNickname());
        server.addClientController(clientController);
        try {
            clientController.getClientHandler().disconnect();
        } catch (IOException e) {
            //messaggio di errore
        }
    }

    @Override
    public void handleMessage(NumberPlayerMessage msg, ClientController clientController) throws IOException, InterruptedException {
        clientController.getClientHandler().sendMessage(new CompleteRunningMatchErrorMessage());
    }

    @Override
    public void handleMessage(UsernameMessage msg, ClientController clientController) throws IOException, InterruptedException {
        if(game.checkNickname(msg.getUsername())){
            for(int i=0; i<server.getClientControllersDisconnected().size();i++)
                if (server.getClientControllersDisconnected().get(i).getNickname().equals(msg.getUsername()))
                    clientController.restoreClientController(server.getClientControllersDisconnected().get(i));
            game.connectPlayer(msg.getUsername());
            if(game.numPlayersDisconnected() == 0)
                if (numberOfPlayers!=1)
                    server.setGameController(new GameControllerMultiplayer(this.server,this.game));
                else
                    server.setGameController(new GameControllerSinglePlayer(this.server,this.game));
        }else{
            clientController.getClientHandler().sendMessage(new NoNicknameMessage());

        }

    }



    @Override
    public void handleMessage(RestartAnswerMessage msg, ClientController clientController) {
        //unreachable
    }

}
