package it.polimi.ingsw.server.network;

import com.google.gson.Gson;
import it.polimi.ingsw.server.controller.*;
import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.virtualview.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Server {

    private GameController gameController;
    private Game game;
    private ArrayList<ClientController> clientControllers = new ArrayList<>();

    private ArrayList<ClientController> clientControllersDisconnected = new ArrayList<>();
    private VirtualView virtualView;
    private ArrayList<String> lobby = new ArrayList<>();
    private boolean sendRestartQuestion;



    public Server() {
        try {
            ArrayList<String> nickNameInOrder;
            String nickname;
            Gson gson = new Gson();
            File f = new File("src/main/resources/MultiGame.json");
            if (f.exists()){
                nickNameInOrder = gson.fromJson(new FileReader("src/main/resources/InformationAboutTurn.json"),ArrayList.class);
                this.gameController = new GameControllerRestart(this);
                gameController.setServer(this);
                lobby = nickNameInOrder;
                sendRestartQuestion = true;
                gameController.setNumberOfPlayers(nickNameInOrder.size());
            }
             else
                {
                    f = new File("src/main/resources/SingleGame.json");
                    nickname = gson.fromJson(new FileReader("src/main/resources/InformationAboutTurn.json"),String.class);
                    lobby.add(nickname);
                    this.gameController = new GameControllerRestart(this);
                    gameController.setServer(this);
                    sendRestartQuestion = true;
                    gameController.setNumberOfPlayers(1);


                }

        }
        catch (FileNotFoundException e) {
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

        game = new GameSolitaire(lobby.get(0),true,clientControllers.get(0));

        gameController = new GameControllerSinglePlayer(this,this.getGame());

        clientControllers.get(0).setGame(this.game);
    }


    public void initNewMultiplayerGame() throws IOException, InterruptedException {
        game = new GameMultiPlayer(lobby.size(),lobby,true,clientControllers);

        gameController = new GameControllerMultiplayer(this,this.game);

        for(ClientController client : clientControllers){
            client.setGame(this.game);
        }
    }

    public void restoreGameSingleBackup() throws IOException, InterruptedException {
        this.game=new GameSolitaire(clientControllers.get(0).getNickname(),false,clientControllers.get(0));

        clientControllers.get(0).setGame(this.game);
    }

    public void restoreGameMultiBackup() throws IOException, InterruptedException {
        this.clientControllers=orderRestart();
        this.game=new GameMultiPlayer(this.getLobbySize(),lobby,false,clientControllers);
        for(ClientController client : clientControllers){
            client.setGame(this.game);
        }
    }


    public void addClientController(ClientController clientController){
        clientControllers.add(clientController);
    }

    public void removeClientController(ClientController clientController){
        clientControllers.remove(clientController);
    }
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

    public ArrayList<ClientController> orderRestart(){
        ArrayList<ClientController> client = new ArrayList<>();
        for(int i=0; i<lobby.size();i++)
            for (ClientController c: clientControllers)
                if (c.getNickname().equals(lobby.get(i)))
                    client.add(c);

        return client;
    }

    public ArrayList<ClientController> getClientControllersDisconnected() {
        return clientControllersDisconnected;
    }

    public ClientController removeClientControllersDisconnected(int i){
        return clientControllersDisconnected.remove(i);
    }

    public void addClientControllersDisconnected(ClientController clientController){
        clientControllersDisconnected.add(clientController);
    }
}
