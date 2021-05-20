package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.network.Server;

import java.io.IOException;
import java.util.ArrayList;

public class GameControllerLobby extends GameController {

    private int lobbySize;
    private ArrayList<String> tempLobbyName = new ArrayList<>();
    private ArrayList<ClientController> tempLobbyController = new ArrayList<>();

    public GameControllerLobby(Server server, int lobbySize){
        this.gameControllerState = "Lobby";
        this.server = server;
        this.lobbySize = lobbySize;

    }

    public GameControllerLobby(Server server, int lobbySize, ArrayList<String> tempLobbyName, ArrayList<ClientController> tempLobbyController){
        this.gameControllerState = "Lobby";
        this.server = server;
        this.lobbySize = lobbySize;
        this.tempLobbyName = tempLobbyName;
        this.tempLobbyController = tempLobbyController;

        try {
            initLobby();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void initLobby() throws IOException, InterruptedException {
        if(lobbySize-1 > tempLobbyName.size()) {
            for (int i = 0; i < tempLobbyName.size(); i++) {
                if(server.addPlayerToLobby(tempLobbyName.get(i))){
                    tempLobbyController.get(i).setNickname(tempLobbyName.get(i));
                    server.addClientController(tempLobbyController.get(i));
                }else{
                    tempLobbyController.get(i).getClientHandler().sendMessage(new AlreadyExistingNickNameErrorMessage());
                }
            }
            for (ClientController c : server.getClientController())
                c.getClientHandler().sendMessage(new NPlayersMessage(server.getLobbySize(), lobbySize));
            tempLobbyName = new ArrayList<>();
            tempLobbyController = new ArrayList<>();
        }else{
            for (int i = 0; i < lobbySize-1; i++) {
                if(server.addPlayerToLobby(tempLobbyName.get(i))){
                    tempLobbyController.get(i).setNickname(tempLobbyName.get(i));
                    server.addClientController(tempLobbyController.get(i));
                }else{
                    tempLobbyController.get(i).getClientHandler().sendMessage(new AlreadyExistingNickNameErrorMessage());
                }
            }
            for (int i = 0; i < lobbySize-1; i++) {
                tempLobbyName.remove(0);
                tempLobbyController.remove(0);
            }
            for (int i = 0; i < tempLobbyName.size(); i++) {
                try {
                    tempLobbyController.get(i).getClientHandler().sendMessage(new CompleteRunningMatchErrorMessage());
                    try {
                        tempLobbyController.get(i).getClientHandler().disconnect();
                    } catch (IOException e) {
                        //messaggio di errore
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            tempLobbyName = new ArrayList<>();
            tempLobbyController = new ArrayList<>();
            server.initNewMultiplayerGame();
        }
        /*if(server.temporaryLobbySize() > 0) {
            for (int i = 0; i < lobbySize-1; i++) {
                if (server.addPlayerToLobby(server.getKeyTemporaryLobby(i)) && server.getKeyTemporaryLobby(i) != null) {
                    server.getTemporaryLobby().get(server.getKeyTemporaryLobby(i)).setNickname(server.getKeyTemporaryLobby(i));
                    server.addClientController(server.getTemporaryLobby().get(server.getKeyTemporaryLobby(i)));
                    server.removeKeyTemporaryLobby(server.getKeyTemporaryLobby(i));
                } else {
                    server.getTemporaryLobby().get(server.getKeyTemporaryLobby(i)).getClientHandler().sendMessage(new AlreadyExistingNickNameErrorMessage());
                }

                if (lobbySize == server.getLobbySize()) {
                    server.initNewMultiplayerGame();
                    for (String key : server.getTemporaryLobby().keySet()) {
                        try {
                            server.getTemporaryLobby().get(key).getClientHandler().sendMessage(new CompleteRunningMatchErrorMessage());
                            try {
                                server.getTemporaryLobby().get(key).getClientHandler().disconnect();
                            } catch (IOException e) {
                                //messaggio di errore
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    server.removeAllTemporaryLobby();
                    System.out.println("sono qui");
                } else {
                    for (ClientController c : server.getClientController())
                        c.getClientHandler().sendMessage(new NPlayersMessage(server.getLobbySize(), lobbySize));
                }
            }
        }*/

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
            server.addClientController(clientController);
            for(ClientController c : server.getClientController())
                c.getClientHandler().sendMessage(new NPlayersMessage(server.getLobbySize(),lobbySize));
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
