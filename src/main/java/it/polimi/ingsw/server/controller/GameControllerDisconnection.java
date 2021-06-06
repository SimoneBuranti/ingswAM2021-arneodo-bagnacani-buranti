package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.model.GameMultiPlayer;
import it.polimi.ingsw.server.network.Server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * game controller fall here if one of the client will eb disconnected during multiplayer game
 */
public class GameControllerDisconnection extends GameController {



    public GameControllerDisconnection(Server server, Game game) {
        this.gameControllerState = "Disconnection";
        this.server = server;
        this.game = game;
    }

    /**
     * method which received the request to exit from client or the possible disconnection due ping
     * @param msg
     * @param clientController
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public void handleMessage(ExitMessage msg, ClientController clientController) throws IOException, InterruptedException {

        if (!(server.getClientController().size()==1))
            if (clientController.turnCheck())
                server.getGame().endOfTurn();

        server.getGame().disconnectPlayerOption(clientController.getNickname());
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
                        server.getClientController().get(i).getClientHandler().sendMessage(new DisconnectionOpponentMessage(clientController.getNickname())); }
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
     * method which received the username for authentication of user on server
     * @param msg
     * @param clientController
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public void handleMessage(UsernameMessage msg, ClientController clientController) throws IOException, InterruptedException {
        if(server.getGame().checkNickname(msg.getUsername())){
            for(int i=0; i<server.getClientControllersDisconnected().size();i++)
            {
                if (server.getClientControllersDisconnected().get(i).getNickname().equals(msg.getUsername()))
            {
                    clientController.restoreClientController(server.removeClientControllersDisconnected(i));
                    server.addClientController(clientController);
            }

            }
            server.getGame().connectPlayer(msg.getUsername());

            if(server.getGame().numPlayersDisconnected() == 0)
            {
                if (server.getGame() instanceof GameMultiPlayer)
                    server.setGameController(new GameControllerMultiplayer(this.server, server.getGame()));
                else
                    server.setGameController(new GameControllerSinglePlayer(this.server, server.getGame()));
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
