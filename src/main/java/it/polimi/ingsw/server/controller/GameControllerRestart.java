package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.network.Server;

import java.io.IOException;
import java.util.ArrayList;

public class GameControllerRestart extends GameController {

    private ArrayList<String> reconnected = new ArrayList<>();
    private ClientController firstClientController;
    private boolean firstName = false;
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
    public synchronized void handleMessage(ExitMessage msg, ClientController clientController) throws IOException, InterruptedException {
        if(thereIsTempLobby()){
            disconnectClientTempLobby(clientController);
        }else {
            removeNameFromReconnected(clientController.getNickname());
            server.removeClientController(clientController);
            for (ClientController c : server.getClientController())
                c.getClientHandler().sendMessage(new NPlayersMessage(server.getGameController().getLobbySize(), server.getLobbySize()));
        }
        clientController.getClientHandler().disconnect();
    }

    @Override
    public void handleMessage(NumberPlayerMessage msg, ClientController clientController) {
        //unreachable
    }

    @Override
    public synchronized void handleMessage(UsernameMessage msg, ClientController clientController) throws IOException, InterruptedException {
        if (!restartAnswerReceived){
            clientController.getClientHandler().sendMessage(new BootingLobbyErrorMessage());
        }
        else {
            if(server.isInLobby(msg.getUsername()) && !firstName){
                if(clientController != firstClientController){
                    if(!isInTempLobby(msg.getUsername())) {
                        tempLobbyName.add(msg.getUsername());
                        tempLobbyController.add(clientController);
                        clientController.getClientHandler().sendMessage(new BootingLobbyErrorMessage());
                    }else
                        clientController.getClientHandler().sendMessage(new AlreadyExistingNickNameErrorMessage());
                }
                else if(clientController == firstClientController){
                    System.out.println("first connected");
                    if (!reconnected.contains(msg.getUsername())) {
                        clientController.setNickname(msg.getUsername());
                        reconnected.add(msg.getUsername());
                        server.addClientController(clientController);
                        firstName = true;
                        reconnectionTempLobby();
                        System.out.println("first connected");
                        for(ClientController c : server.getClientController())
                            c.getClientHandler().sendMessage(new NPlayersMessage(reconnected.size(), server.getLobbySize()));
                    }
                }
            }
            else if(server.isInLobby(msg.getUsername()) && firstName){
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
                    System.out.println("try to restart all*******");
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
        firstClientController = clientController;
        clientController.getClientHandler().sendMessage(new UsernameMessage(null));
    }

    @Override
    public boolean isFirstClient(ClientController clientController) {
        return false;
    }

    @Override
    public void disconnectFirstClient() {

    }

    @Override
    public int getLobbySize() {
        return reconnected.size();
    }

    @Override
    public boolean thereIsTempLobby() {
        if(tempLobbyName.size() > 0)
            return true;
        return false;
    }

    @Override
    public void disconnectClientTempLobby(ClientController clientController) {
        for(int i = 0; i < tempLobbyController.size(); i++){
            if(tempLobbyController.get(i) == clientController){
                tempLobbyController.remove(i);
                tempLobbyName.remove(i);
                break;
            }
        }
    }

    @Override
    public void removeNameFromReconnected(String nickname) {
        for(int i = 0; i < reconnected.size(); i++){
            if(reconnected.get(i).equals(nickname)){
                reconnected.remove(i);
                break;
            }
        }
    }

    public void reconnectionLobby() throws IOException, InterruptedException {
        for(ClientController c : server.getTempClientController()){
            c.getClientHandler().sendMessage(new RestartQuestionMessage(1));
        }
    }

    public void reconnectionTempLobby() throws IOException, InterruptedException {
        int i = 0;
        for(; i < tempLobbyName.size(); i++){
            if (!reconnected.contains(tempLobbyName.get(i))){
                tempLobbyController.get(i).setNickname(tempLobbyName.get(i));
                reconnected.add(tempLobbyName.get(i));
                server.addClientController(tempLobbyController.get(i));
                /*for(ClientController c : server.getClientController())
                    c.getClientHandler().sendMessage(new NPlayersMessage(reconnected.size(), server.getLobbySize()));*/
            }
            else {
                tempLobbyController.get(i).getClientHandler().sendMessage(new AlreadyExistingNickNameErrorMessage());
                tempLobbyName.set(i, null);
            }
            if (reconnected.size() == server.getLobbySize()){
                for(int j = 0; j < i; j++)
                    if(tempLobbyName.get(j) == null) {
                        tempLobbyController.get(j).getClientHandler().sendMessage(new CompleteRunningMatchErrorMessage());
                    }
                break;
            }
        }

        for(i++ ; i < tempLobbyName.size(); i++){
            tempLobbyController.get(i).getClientHandler().sendMessage(new CompleteRunningMatchErrorMessage());
        }



    }

}
