package it.polimi.ingsw.server.network;

import com.google.gson.Gson;
import it.polimi.ingsw.server.controller.*;
import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.gameBoard.GameBoardInterface;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Main server class that starts a socket server.
 * It can handle different types of connections.
 * it organised the creation of the game and also his restoring
 */
public class Server {

    /**
     * manager of the game
     */
    private GameController gameController;

    /**
     * attribute of the game active or not on server
     */
    private Game game;

    /**
     * client controller connected
     */
    private ArrayList<ClientController> clientControllers = new ArrayList<>();
    /**
     * client controller in waiting to be reconnected in game
     */
    private ArrayList<ClientController> tempClientController = new ArrayList<>();
    /**
     * client controller disconnected
     */
    private ArrayList<ClientController> clientControllersDisconnected = new ArrayList<>();
    /**
     * client controller which attempt to be accept in game
     */
    private ArrayList<String> lobby = new ArrayList<>();


    /**
     * attributes specify under in the code
     */
    private boolean sendRestartQuestion;
    private int restartQuestion;
    private boolean restartAnswerReceived;
    private boolean restartAnswer;
    private boolean restartQuestionSent;



    public Server()  {
            ArrayList<String> nickNameInOrder;
            Gson gson = new Gson();

            try{
                nickNameInOrder = gson.fromJson(new FileReader("fileConfiguration/InformationAboutTurn.json"),ArrayList.class);
                if(nickNameInOrder!=null)
                {
                    this.gameController = new GameControllerRestart(this);
                    gameController.setServer(this);
                    lobby = nickNameInOrder;
                    sendRestartQuestion = true;
                    restartQuestion = 0;
                    setRestartAnswerReceived(false);
                    restartQuestionSent = false;
                    this.gameController.setNumberOfPlayers(nickNameInOrder.size());
                }
                else
                {
                    this.gameController = new GameControllerEmpty(this);
                    gameController.setServer(this);
                    lobby = new ArrayList<>();
                    sendRestartQuestion = false;
                }
            }catch (FileNotFoundException e){
                this.gameController = new GameControllerEmpty(this);
                gameController.setServer(this);
                lobby = new ArrayList<>();
                sendRestartQuestion = false;
            }
    }

    //------------------------Getter--------------------------------------

    /**
     * @return lobbby size
     */
    public int getLobbySize() {
        return lobby.size();
    }


    /**
     * @return gamecontroller
     */
    public GameController getGameController() {
        return gameController;
    }


    /**
     * @return sendRestartQuestion
     */
    public boolean getSendRestartQuestion() {
        return sendRestartQuestion;
    }

    /**
     * @return temporary lobby
     */
    public ArrayList<ClientController> getTempClientController() {
        return tempClientController;
    }

    /**
     * @return tempClientController.size() temporary lobby size
     */
    public int tempClientControllerSize() {
        return tempClientController.size();
    }

    /**
     * @return restartQuestion
     */
    public int getRestartQuestion(){
        return restartQuestion;
    }

    /**
     * @return restartAnswer
     */
    public boolean isRestartAnswer() {
        return restartAnswer;
    }

    /**
     * @return restartAnswerReceived
     */
    public boolean isRestartAnswerReceived() {
        return restartAnswerReceived;
    }

    /**
     * @return restartQuestionSent
     */
    public boolean isRestartQuestionSent() {
        return restartQuestionSent;
    }



    /**
     * @param nickname
     * @return false or true according to the presence or not of the player in lobby
     */
    public boolean isInLobby(String nickname){
        for (String nick : lobby){
            if(nick.equals(nickname))
                return true;
        }
        return false;

    }

    //--------------------------------------------------------------------

    /**
     * method which create singleplayer game, after  the client number player choice
     * @throws IOException
     * @throws InterruptedException
     */
    public void initNewSolitaireGame() throws IOException, InterruptedException {


        this.game = new GameSolitaire(lobby.get(0),true,clientControllers.get(0));

        gameController = new GameControllerSinglePlayer(this,this.getGame());

        clientControllers.get(0).setGame(this.game);
    }


    /**
     * method which create multiplayer game, after  the relative filing of the lobby
     * @throws IOException
     * @throws InterruptedException
     */

    public void initNewMultiplayerGame() throws IOException, InterruptedException {
        this.game = new GameMultiPlayer(lobby.size(),lobby,true,clientControllers);

        gameController = new GameControllerMultiplayer(this,this.getGame());

        for(ClientController client : clientControllers){
            client.setGame(this.game);
        }
    }

    /**
     * method which restore singleplayer game, after a total disconnection or server crashing, and the relative filing of the lobby
     * @throws IOException
     * @throws InterruptedException
     */
    public void restoreGameSingleBackup() throws IOException, InterruptedException {
        this.game=new GameSolitaire(clientControllers.get(0).getNickname(),false,clientControllers.get(0));
        clientControllers.get(0).setGame(this.game);
    }

    /**
     * method which restore multiplayer game, after a total disconnection or server crashing, and the relative filing of the lobby
     * @throws IOException
     * @throws InterruptedException
     */
    public void restoreGameMultiBackup() throws IOException, InterruptedException {
        this.clientControllers=orderRestart();
        this.game=new GameMultiPlayer(this.getLobbySize(),lobby,false,clientControllers);
        for(ClientController client : clientControllers){
            client.setGame(this.game);
        }

    }

    /**
     * @param clientController add to client controller
     */

    public void addClientController(ClientController clientController){
        clientControllers.add(clientController);
    }

    /**
     * @param clientController is removed from clientcontroller list
     */
    public void removeClientController(ClientController clientController){
        clientControllers.remove(clientController);
    }

    /**
     * @return clientControllers, list of client Controllers
     */
    public ArrayList<ClientController> getClientController(){
        return clientControllers;
    }
    //------------------------Setter--------------------------------------

    /**
     * method which set sendRestartQuestion
     */
    public void setSendRestartQuestion(){
        sendRestartQuestion = false;
    }

    /**
     * @param restartAnswerReceived set if answer restart was received or not
     */
    public void setRestartAnswerReceived(boolean restartAnswerReceived) {
        this.restartAnswerReceived = restartAnswerReceived;
    }

    /**
     * @param restartQuestionSent if restart question has to be sent or not
     */
    public void setRestartQuestionSent(boolean restartQuestionSent) {
        this.restartQuestionSent = restartQuestionSent;
    }

    /**
     * @param restartAnswer if restart answer is true or not
     */
    public void setRestartAnswer(boolean restartAnswer) {
        this.restartAnswer = restartAnswer;
    }

    /**
     * Only test method
     */
    public void setGame(Game game){
        this.game = game;
    }

    /**
     * @param clientController add to temp lobby
     *
     */

    public void addTempClientController(ClientController clientController){
        tempClientController.add(clientController);
    }


    /**
     * method call when restart question is sent
     */
    public void setRestartQuestion(){
        if(restartQuestion == 0)
            restartQuestion = 1;
        else
            restartQuestion = 0;
    }

    /**
     * set the correct game controller according to disconnection/reconnection/startMatch/lobby/emptyServer
     * @param gameController
     */
    public synchronized void  setGameController(GameController gameController) {
        this.gameController = gameController;
    }


    /**
     * @param nickname add to lobby
     * @return true if the operation was succesful
     */
    public synchronized boolean addPlayerToLobby(String nickname){
        for(String nick : lobby){
            if (nick.equals(nickname))
                return false;
        }
        lobby.add(nickname);
        return true;
    }


    /**
     * @param nickname is removed from lobby list
     */
    public synchronized void removePlayerToLobby(String nickname){
        for(int i=0;i<lobby.size();i++){
            if (lobby.get(i).equals(nickname)) {
                lobby.remove(i);
                break;
            }
        }
    }


    /**
     * reset lobby info
     */
    public synchronized void restartLobby(){
        lobby = new ArrayList<>();
    }


    /**
     * @return game in progress
     */
    public Game getGame(){
        return this.game;
    }
    /*public void addPlayer(ClientHandler clientHandler){
        this.clientHandlers.add(clientHandler);
    }*/

    /**
     * @return reorder client old controller from file information
     */
    public ArrayList<ClientController> orderRestart(){
        ArrayList<ClientController> client = new ArrayList<>();
        for(int i=0; i<lobby.size();i++)
            for (ClientController c: clientControllers)
                if (c.getNickname().equals(lobby.get(i)))
                    client.add(c);

        return client;
    }

    /**
     * @return list of client controller disconnected
     */
    public ArrayList<ClientController> getClientControllersDisconnected() {
        return clientControllersDisconnected;
    }


    /**
     * @param i index of the old client controller
     * @return the reconnected client controller is removed from the list of client disconnected
     */
    public ClientController removeClientControllersDisconnected(int i){
        return clientControllersDisconnected.remove(i);
    }

    /**
     * add client contreoller when this client controller digits exit on cli, or due by ping disconnection
     * @param clientController the disconnected client
     */
    public void addClientControllersDisconnected(ClientController clientController){
        clientControllersDisconnected.add(clientController);
        clientControllers.remove(clientController);
    }

    /**
     * resetAll server info at the end of the game, to be ready for a new game
     */
    public void resetInfo(){
        FileClass.FileDestroyer();
         this.game=null;
        clientControllers = new ArrayList<>();
        tempClientController = new ArrayList<>();
        clientControllersDisconnected = new ArrayList<>();
        lobby = new ArrayList<>();
        sendRestartQuestion=false;
        restartQuestion=0;
        restartAnswerReceived=false;
        restartAnswer=false;
        restartQuestionSent=false;
        this.gameController = new GameControllerEmpty(this);
        gameController.setServer(this);
    }
    /**
     * reset Partial server info when all clients of the match were disconnected
     */

    public void resetInfoPartial() throws FileNotFoundException{
        this.game=null;
        clientControllers = new ArrayList<>();
        tempClientController = new ArrayList<>();
        clientControllersDisconnected = new ArrayList<>();
        ArrayList<String> nickNameInOrder;
        Gson gson=new Gson();


        nickNameInOrder = gson.fromJson(new FileReader("fileConfiguration/InformationAboutTurn.json"),ArrayList.class);

         lobby = nickNameInOrder;
        this.gameController = new GameControllerRestart(this);
        gameController.setServer(this);
        sendRestartQuestion = true;
        restartQuestion = 0;
        setRestartAnswerReceived(false);
        restartQuestionSent = false;
        gameController.setNumberOfPlayers(lobby.size());

    }


    public void removeTempClientController(ClientController clientController) {
        tempClientController.remove(clientController);
    }

    public void removeAllTempClientController() {
        for(int i = 0; i < tempClientControllerSize(); i++)
            tempClientController.remove(0);
    }

    public boolean isInTempLobby(ClientController clientController) {
        for(ClientController c : tempClientController)
            if(c == clientController)
                return true;

        return false;
    }
}
