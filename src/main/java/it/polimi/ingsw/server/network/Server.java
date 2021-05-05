package it.polimi.ingsw.server.network;

import it.polimi.ingsw.server.controller.*;
import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.virtualview.*;

import java.util.ArrayList;


public class Server {

    private GameControllerInterface gameController;
    private Game game;
    private VirtualView virtualView;
    //private ArrayList<ClientHandler> clientHandlers;
    private ArrayList<String> lobby;

    public Server(GameControllerInterface gameController) {
        this.gameController = gameController;
        lobby = new ArrayList<>();
        //this.clientHandlers = new ArrayList<>();
    }

    public GameControllerInterface getGameController() {
        return gameController;
    }

    public synchronized void  setGameController(GameControllerInterface gameController) {
        this.gameController = gameController;
    }

    public void initNewMultiplayerGame(){
        game = new GameMultiPlayer(lobby.size(),lobby,true);
        virtualView = new VirtualView();
        gameController = new GameControllerMultiplayer();
    }

    public void initNewSolitaireGame(){
        game = new GameSolitaire(lobby.get(0),true);
        virtualView = new VirtualView();
        gameController = new GameControllerSinglePlayer();
    }

    public synchronized void addPlayerToLobby(String nickname){
        lobby.add(nickname);
    }
    /*public void addPlayer(ClientHandler clientHandler){
        this.clientHandlers.add(clientHandler);
    }*/

    public int getLobbySize() {
        return lobby.size();
    }
}
