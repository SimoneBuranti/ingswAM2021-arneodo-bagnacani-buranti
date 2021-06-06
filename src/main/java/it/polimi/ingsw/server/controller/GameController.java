package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.network.Server;

import java.io.IOException;
import java.util.ArrayList;

/**
 * abstract class for manage the message of exit, number player and username during the game or before
 */
public abstract class GameController {
    protected String gameControllerState;
    protected int numberOfPlayers;
    protected Game game;
    protected Server server;

    /**
     * method which received the request to exit from client or the possible disconnection due ping
     * @param msg
     * @param clientController
     * @throws IOException
     * @throws InterruptedException
     */

    public abstract void handleMessage(ExitMessage msg, ClientController clientController) throws IOException, InterruptedException;

    /**
     * method which received the answer to number player, it is managed only during in emptyState
     * @param msg
     * @param clientController
     * @throws IOException
     * @throws InterruptedException
     */
    public abstract void handleMessage(NumberPlayerMessage msg, ClientController clientController) throws IOException, InterruptedException;
    /**
     * method which received the username for the registration and the authentication of user on server
     * @param msg
     * @param clientController
     * @throws IOException
     * @throws InterruptedException
     */
    public abstract void handleMessage(UsernameMessage msg, ClientController clientController) throws IOException, InterruptedException;


    /**set the number of player in game
     * @param numberOfPlayers
     */
    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    /**
     * @return server reference
     */
    public Server getServer() {
        return server;
    }

    /**
     * set the server to gameController
     * @param server
     */
    public void setServer(Server server) {
        this.server = server;
    }

    /**
     * @return game reference
     */
    public Game getGame() {
        return game;
    }

    /**
     * set the game to gameController
     * @param game
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * method which received the answer about restart possibility, it is managed only during in restart state
     * @param msg
     * @param clientController
     * @throws IOException
     * @throws InterruptedException
     */
    public abstract void handleMessage(RestartAnswerMessage msg, ClientController clientController) throws IOException, InterruptedException;

    /**
     *method defined in correct classes
     */
    public abstract boolean isFirstClient(ClientController clientController);
    /**
     *method defined in correct classes
     */
    public abstract void disconnectFirstClient();
    /**
     *method defined in correct classes
     */
    public abstract void disconnectClientTempLobby(ClientController clientController);
    /**
     *method defined in correct classes
     */
    public abstract void removeNameFromReconnected(String nickname);
    /**
     *method defined in correct classes
     */
    public abstract int getLobbySize();
    /**
     *method defined in correct classes
     */
    public abstract boolean thereIsTempLobby();

    /**
     * @return game controller state of the game
     */
    public String getGameControllerState(){
        return gameControllerState;
    }
}
