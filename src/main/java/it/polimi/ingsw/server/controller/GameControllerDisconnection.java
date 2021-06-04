package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.model.GameMultiPlayer;
import it.polimi.ingsw.server.network.Server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GameControllerDisconnection extends GameController {



    public GameControllerDisconnection(Server server, Game game) {
        this.gameControllerState = "Disconnection";
        this.server = server;
        this.game = game;
    }

    @Override
    public void handleMessage(ExitMessage msg, ClientController clientController) throws IOException, InterruptedException {

        game.disconnectPlayer(clientController.getNickname());
        server.addClientControllersDisconnected(clientController);
        try {
            clientController.getClientHandler().disconnect();
            System.out.println("Ho disconnesso client ");
        } catch (IOException | InterruptedException e) {
            //messaggio di errore
        }
        if((server.getClientController().size())==0)
        {
            server.resetInfoPartial();
        }
        else{
            for (int i=0;i< server.getClientController().size(); i++) {
              //  for (int j = 0; j < server.getClientControllersDisconnected().size(); j++){
                   // if (!server.getClientController().get(i).equals(clientController) &&
                           // !server.getClientController().get(i).equals(server.getClientControllersDisconnected().get(j))){
                        server.getClientController().get(i).getClientHandler().sendMessage(new DisconnectionOpponentMessage(clientController.getNickname()));
                   // }}
    }
    }}

    @Override
    public void handleMessage(NumberPlayerMessage msg, ClientController clientController) throws IOException, InterruptedException {
        clientController.getClientHandler().sendMessage(new CompleteRunningMatchErrorMessage());
    }

    @Override
    public void handleMessage(UsernameMessage msg, ClientController clientController) throws IOException, InterruptedException {
        if(game.checkNickname(msg.getUsername())){
            for(int i=0; i<server.getClientControllersDisconnected().size();i++)
            {
                if (server.getClientControllersDisconnected().get(i).getNickname().equals(msg.getUsername()))
            {
                    clientController.restoreClientController(server.removeClientControllersDisconnected(i));
                    server.addClientController(clientController);
            }

            }
            game.connectPlayer(msg.getUsername());

            if(game.numPlayersDisconnected() == 0)
            {
                if (server.getGame() instanceof GameMultiPlayer)
                    server.setGameController(new GameControllerMultiplayer(this.server, this.game));
                else
                    server.setGameController(new GameControllerSinglePlayer(this.server, this.game));
            }


        }
        else
        {
            clientController.getClientHandler().sendMessage(new NoNicknameMessage());
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
