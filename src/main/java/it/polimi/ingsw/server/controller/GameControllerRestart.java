package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.network.Server;

import java.io.IOException;
import java.util.ArrayList;

public class GameControllerRestart extends GameController {

    private ArrayList<String> reconnected = new ArrayList<>();
    private boolean restartAnswerReceived = false;
    private ArrayList<String> tempLobbyName = new ArrayList<>();
    private ArrayList<ClientController> tempLobbyController = new ArrayList<>();


    public GameControllerRestart(Server server) {
        this.gameControllerState = "Restart";
        this.server = server;
    }

    public boolean isInTempLobby(String nickname){
        for(String nick : tempLobbyName)
            if(nick.equals(nickname))
                return true;

        return false;
    }

    @Override
    public synchronized void handleMessage(ExitMessage msg, ClientController clientController) {
        try {
            clientController.getClientHandler().disconnect();
            reconnected.remove(clientController.getNickname());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleMessage(NumberPlayerMessage msg, ClientController clientController) {
        //unreachable
    }

    @Override
    public synchronized void handleMessage(UsernameMessage msg, ClientController clientController) throws IOException, InterruptedException {
        if (!restartAnswerReceived){
            clientController.getClientHandler().sendMessage(new BootingLobbyErrorMessage());
            /*if(server.isInLobby(msg.getUsername()) && !isInTempLobby(msg.getUsername()) ){
                tempLobbyName.add(msg.getUsername());
                tempLobbyController.add(clientController);
                clientController.getClientHandler().sendMessage(new BootingLobbyErrorMessage());
            }else if(server.isInLobby(msg.getUsername()) && isInTempLobby(msg.getUsername())){
                clientController.getClientHandler().sendMessage(new AlreadyExistingNickNameErrorMessage());
            }else if(!server.isInLobby(msg.getUsername())){
                clientController.getClientHandler().sendMessage(new NoNicknameMessage());
            }*/

            /*try {
                clientController.getClientHandler().disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
        else {
            if (server.isInLobby(msg.getUsername())){
                if (!reconnected.contains(msg.getUsername())){
                    clientController.setNickname(msg.getUsername());
                    reconnected.add(msg.getUsername());
                    server.addClientController(clientController);
                    for(ClientController c : server.getClientController())
                        c.getClientHandler().sendMessage(new NPlayersMessage(reconnected.size(), server.getLobbySize()));
                }
                else {
                    clientController.getClientHandler().sendMessage(new AlreadyExistingNickNameErrorMessage());
                }
            }
            else {
                clientController.getClientHandler().sendMessage(new NoNicknameMessage());
            }

            if (reconnected.size() == server.getLobbySize()){
                if (numberOfPlayers==1){
                    server.restoreGameSingleBackup();
                    server.setGameController(new GameControllerSinglePlayer(server,server.getGame()));

                } else {
                    server.restoreGameMultiBackup();
                    server.setGameController(new GameControllerMultiplayer(this.server,this.game));

                }

            }
        }
    }


    @Override
    public synchronized void handleMessage(RestartAnswerMessage msg, ClientController clientController) throws IOException, InterruptedException {
        server.setRestartAnswerReceived(true);
        server.setRestartAnswer(msg.getAnswer());
        if(!msg.getAnswer()){
            server.setSendRestartQuestion();
            server.restartLobby();
            server.setGameController(new GameControllerEmpty(this.server, clientController));
            restartAnswerReceived = false;
        }
        else
            {
            restartAnswerReceived = true;
            if(server.tempClientControllerSize() > 0)
                reconnectionLobby();
            }
        clientController.getClientHandler().sendMessage(new UsernameMessage(null));
    }

    public void reconnectionLobby() throws IOException, InterruptedException {
        for(ClientController c : server.getTempClientController()){
            c.getClientHandler().sendMessage(new RestartQuestionMessage(1));
        }
    }

}
