package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.network.Server;

import java.io.IOException;

public class GameControllerEmpty extends GameController {

    public GameControllerEmpty(Server server) {
        this.gameControllerState = "Empty";
        this.server = server;
    }

    @Override
    public void handleMessage(ExitMessage msg, ClientController clientController) {
        //unreachable
    }

    @Override
    public void handleMessage(NumberPlayerMessage msg, ClientController clientController) throws IOException, InterruptedException {
        if (server.getLobbySize()>0){
            if (msg.getnOfPlayers()== 1){
                server.setGameController(new GameControllerSinglePlayer(server,server.getGame()));
                server.initNewSolitaireGame();
            } else {
                server.setGameController(new GameControllerLobby(this.server,msg.getnOfPlayers()));
            }
        }
    }

    @Override
    public void handleMessage(UsernameMessage msg, ClientController clientController) throws IOException, InterruptedException {
        if (server.getLobbySize()==0) {
            if (server.addPlayerToLobby(msg.getUsername())){
                clientController.setNickname(msg.getUsername());
                clientController.getClientHandler().sendMessage(new NPlayersMessage(-1));
                server.addClientController(clientController);
            } else {
                clientController.getClientHandler().sendMessage(new AlreadyExistingNickNameErrorMessage()); //unreachable
            }
        } else {
            clientController.getClientHandler().sendMessage(new BootingLobbyErrorMessage());
            /*try {
                clientController.getClientHandler().disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }


    }

    @Override
    public void handleMessage(RestartAnswerMessage msg, ClientController clientController) {
        //unreachable
    }

}
