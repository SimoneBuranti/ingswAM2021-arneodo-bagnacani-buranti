package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.network.Server;

import java.io.IOException;
import java.util.ArrayList;

public abstract class GameController {
    protected String gameControllerState;
    protected int numberOfPlayers;
    protected Game game;
    protected Server server;

    //Client to server
    public abstract void handleMessage(ExitMessage msg, ClientController clientController) throws IOException, InterruptedException;
    public abstract void handleMessage(NumberPlayerMessage msg, ClientController clientController) throws IOException, InterruptedException;
    public abstract void handleMessage(UsernameMessage msg, ClientController clientController) throws IOException, InterruptedException;


    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public abstract void handleMessage(RestartAnswerMessage msg, ClientController clientController) throws IOException, InterruptedException;

    public abstract boolean isFirstClient(ClientController clientController);

    public abstract void disconnectFirstClient();

    public abstract void disconnectClientTempLobby(ClientController clientController);

    public abstract void removeNameFromReconnected(String nickname);

    public abstract int getLobbySize();

    public abstract boolean thereIsTempLobby();

    public String getGameControllerState(){
        return gameControllerState;
    }
}
