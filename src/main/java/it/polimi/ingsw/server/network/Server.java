package it.polimi.ingsw.server.network;

import com.google.gson.Gson;
import it.polimi.ingsw.server.controller.*;
import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.virtualview.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Server {

    private GameController gameController;
    private Game game;
    private VirtualView virtualView;
    private ArrayList<String> lobby;
    private boolean sendRestartQuestion;



    public Server() {
        try {
            ArrayList<String> nickNameInOrder;
            Gson gson = new Gson();

            nickNameInOrder = gson.fromJson(new FileReader("src/main/resources/InformationAboutTurn.json"),ArrayList.class);
            this.gameController = new GameControllerRestart(this);
            gameController.setServer(this);
            lobby = nickNameInOrder;
            sendRestartQuestion = true;

        } catch (FileNotFoundException e) {
            this.gameController = new GameControllerEmpty(this);
            gameController.setServer(this);
            lobby = new ArrayList<>();
            sendRestartQuestion = false;
        }

    }

    //------------------------Getter--------------------------------------

    public int getLobbySize() {
        return lobby.size();
    }


    public GameController getGameController() {
        return gameController;
    }


    public boolean getSendRestartQuestion() {
        return sendRestartQuestion;
    }


    public boolean isInLobby(String nickname){
        for (String nick : lobby){
            if(nick.equals(nickname))
                return true;
        }
        return false;
    }

    //--------------------------------------------------------------------

    public void initNewSolitaireGame() throws IOException, InterruptedException {
        game = new GameSolitaire(lobby.get(0),true);
        //virtualView = new VirtualView();
        gameController = new GameControllerSinglePlayer();
    }


    public void initNewMultiplayerGame() throws IOException, InterruptedException {
        game = new GameMultiPlayer(lobby.size(),lobby,true);
        //virtualView = new VirtualView();
        gameController = new GameControllerMultiplayer(this,this.game);
    }

    public void restoreGameBackup(){}


    //------------------------Setter--------------------------------------

    public void setSendRestartQuestion(){
        sendRestartQuestion = false;
    }

    public synchronized void  setGameController(GameController gameController) {
        this.gameController = gameController;
    }


    public synchronized boolean addPlayerToLobby(String nickname){
        for(String nick : lobby){
            if (nick.equals(nickname))
                return false;
        }
        lobby.add(nickname);
        return true;
    }

    public synchronized void removePlayerToLobby(String nickname){
        for(int i=0;i<lobby.size();i++){
            if (lobby.get(i).equals(nickname))
                lobby.remove(i);
        }
    }

    public synchronized void restartLobby(){
        lobby = new ArrayList<>();
    }



    public Game getGame(){
        return this.game;
    }
    /*public void addPlayer(ClientHandler clientHandler){
        this.clientHandlers.add(clientHandler);
    }*/


}
