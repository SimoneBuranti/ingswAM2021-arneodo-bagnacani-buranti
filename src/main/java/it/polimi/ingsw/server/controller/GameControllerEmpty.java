package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.network.Server;

import java.io.IOException;
import java.util.ArrayList;

public class GameControllerEmpty extends GameController {

    private ArrayList<String> tempLobbyName = new ArrayList<>();
    private ArrayList<ClientController> tempLobbyController = new ArrayList<>();
    private ClientController firstClientController;

    public GameControllerEmpty(Server server) {
        this.gameControllerState = "Empty";
        this.server = server;
        this.firstClientController = null;
    }

    public GameControllerEmpty(Server server, ClientController firstClientController) {
        this.gameControllerState = "Empty";
        this.server = server;
        this.firstClientController = firstClientController;
        if(server.tempClientControllerSize() > 0){
            for(ClientController c : server.getTempClientController()) {
                try {
                    c.getClientHandler().sendMessage(new UsernameMessage(null));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public boolean isInTempLobby(String nickname){
        for(String nick : tempLobbyName)
            if(nick.equals(nickname))
                return true;

        return false;
    }
    @Override
    public void handleMessage(ExitMessage msg, ClientController clientController) {
        //unreachable
    }

    @Override
    public void handleMessage(NumberPlayerMessage msg, ClientController clientController) throws IOException, InterruptedException {
        if (server.getLobbySize()>0){
            if (msg.getnOfPlayers()== 1 && tempLobbyName.isEmpty()){
                server.setGameController(new GameControllerSinglePlayer(server,server.getGame()));
                server.initNewSolitaireGame();
            } else if(msg.getnOfPlayers()== 1 && !tempLobbyName.isEmpty()){
                server.setGameController(new GameControllerSinglePlayer(server,server.getGame(), tempLobbyName, tempLobbyController));
                server.initNewSolitaireGame();
            }else if(msg.getnOfPlayers()> 1 && tempLobbyName.isEmpty()) {
                    server.setGameController(new GameControllerLobby(this.server,msg.getnOfPlayers()));
            }else{
                server.setGameController(new GameControllerLobby(this.server,msg.getnOfPlayers(), tempLobbyName, tempLobbyController));
            }
        }
    }

    @Override
    public void handleMessage(UsernameMessage msg, ClientController clientController) throws IOException, InterruptedException {
        if (server.getLobbySize()==0 && (clientController == firstClientController || firstClientController == null)) {
            if (server.addPlayerToLobby(msg.getUsername())){
                clientController.setNickname(msg.getUsername());
                clientController.getClientHandler().sendMessage(new NPlayersMessage(-1));
                server.addClientController(clientController);
            } else {
                clientController.getClientHandler().sendMessage(new AlreadyExistingNickNameErrorMessage()); //unreachable
            }
        } else if(server.getLobbySize()==0 && clientController != firstClientController){
            tempLobbyName.add(msg.getUsername());
            tempLobbyController.add(clientController);
            clientController.getClientHandler().sendMessage(new BootingLobbyErrorMessage());
        } else {
            if(!isInTempLobby(msg.getUsername()) && !server.isInLobby(msg.getUsername())){
                tempLobbyName.add(msg.getUsername());
                tempLobbyController.add(clientController);
                clientController.getClientHandler().sendMessage(new BootingLobbyErrorMessage());
            }else{
                clientController.getClientHandler().sendMessage(new AlreadyExistingNickNameErrorMessage());
            }
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
