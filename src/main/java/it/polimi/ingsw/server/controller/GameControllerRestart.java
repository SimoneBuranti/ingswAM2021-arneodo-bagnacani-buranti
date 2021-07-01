package it.polimi.ingsw.server.controller;

import com.google.gson.Gson;
import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.model.FileClass;
import it.polimi.ingsw.server.network.Server;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * game controller fall here if all clients are disconnected during multiplayer game
 * or single player is disconnected
 * or on the power on, server read from existing file of old match
 */
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

    /**
     * @param nickname
     * @return true if nick name is in lobby
     */
    public boolean isInTempLobby(String nickname){
        for(String nick : tempLobbyName)
            if(nick.equals(nickname))
                return true;

        return false;
    }

    /**
     * method which received the request to exit from client or the possible disconnection due ping
     * @param msg
     * @param clientController
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public synchronized void handleMessage(ExitMessage msg, ClientController clientController) throws IOException, InterruptedException {
        if(!server.isRestartAnswerReceived()){
            if(server.tempClientControllerSize() == 0){
                server.setRestartQuestionSent(false);
                server.setRestartQuestion();
            }else if(!server.isInTempLobby(clientController)){
                server.getTempClientController().get(0).getClientHandler().sendMessage(new RestartQuestionMessage(0));
                server.getTempClientController().remove(0);
                if(server.getRestartQuestion() == 0)
                    server.setRestartQuestion();
                server.setRestartQuestionSent(true);
            }else{
                server.removeTempClientController(clientController);
            }
        }else if(server.isRestartAnswerReceived() && reconnected.size() == 0){
            if(server.tempClientControllerSize() == 0){
                firstClientController = null;
                server.setRestartQuestionSent(false);
                server.setRestartQuestion();
                server.setRestartAnswerReceived(false);
            }else if(!thereIsTempLobby() && clientController == firstClientController){
                firstClientController = null;
                server.getTempClientController().get(0).getClientHandler().sendMessage(new RestartQuestionMessage(0));
                server.getTempClientController().remove(0);
                if(server.getRestartQuestion() == 0)
                    server.setRestartQuestion();
                server.setRestartQuestionSent(true);
                for(ClientController c : server.getTempClientController())
                    c.getClientHandler().sendMessage(new BootingLobbyErrorMessage());
            }else if(!thereIsTempLobby() && clientController != firstClientController){
                server.removeTempClientController(clientController);
            }else if(thereIsTempLobby() && clientController == firstClientController){
                firstClientController = tempLobbyController.get(0);
                tempLobbyController.get(0).setNickname(tempLobbyName.get(0));
                reconnected.add(tempLobbyName.get(0));
                server.addClientController(tempLobbyController.get(0));
                server.removeTempClientController(tempLobbyController.get(0));
                disconnectClientTempLobby(tempLobbyController.get(0));
                firstName = true;
                reconnectionTempLobby();

                if (reconnected.size() == server.getLobbySize()){
                    if (server.getLobbySize()==1){
                        server.restoreGameSingleBackup();
                        server.setGameController(new GameControllerSinglePlayer(server,server.getGame()));
                    }
                    else {
                        server.restoreGameMultiBackup();
                        server.setGameController(new GameControllerMultiplayer(this.server,server.getGame()));
                    }
                }else{
                    for(ClientController c : server.getClientController())
                        c.getClientHandler().sendMessage(new NPlayersMessage(reconnected.size(), server.getLobbySize()));
                }
            }else if(thereIsTempLobby() && clientController != firstClientController){
                disconnectClientTempLobby(clientController);
                server.removeTempClientController(clientController);
            }
        }else if(reconnected.size() == 1){
            if(server.tempClientControllerSize() == 0){
                removeNameFromReconnected(clientController.getNickname());
                server.removeClientController(clientController);
                firstClientController = null;
                server.setRestartQuestionSent(false);
                server.setRestartQuestion();
                server.setRestartAnswerReceived(false);
            }else if(server.tempClientControllerSize() > 0 && clientController == firstClientController){
                removeNameFromReconnected(clientController.getNickname());
                server.removeClientController(clientController);
                firstClientController = server.getTempClientController().get(0);
            }else if(server.tempClientControllerSize() > 0 && clientController != firstClientController){
                server.removeTempClientController(clientController);
            }
        }else if(reconnected.size() >= 1){
            removeNameFromReconnected(clientController.getNickname());
            server.removeClientController(clientController);
            for (ClientController c : server.getClientController())
                c.getClientHandler().sendMessage(new NPlayersMessage(server.getGameController().getLobbySize(), server.getLobbySize()));
        }
        clientController.getClientHandler().disconnect();
        System.out.println("Ho disconnesso client");
    }

    @Override
    public void handleMessage(NumberPlayerMessage msg, ClientController clientController) {
        //unreachable
    }

    /**
     * method for set the first client cotntroller
     * @param clientController
     * @return
     */
    public void setFirstClient(ClientController clientController) {
        firstClientController=clientController;
    }

    /**
     * method which received the username for the registration and the authentication of user on server
     * @param msg
     * @param clientController
     * @throws IOException
     * @throws InterruptedException
     */
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
                    }
                    else
                        clientController.getClientHandler().sendMessage(new AlreadyExistingNickNameErrorMessage());
                }
                else if(clientController == firstClientController){
                    if (!reconnected.contains(msg.getUsername())) {
                        System.out.println("");
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
                if (server.getLobbySize()==1){
                    server.restoreGameSingleBackup();
                    server.setGameController(new GameControllerSinglePlayer(server,server.getGame()));

                }
                else
                {
                    server.restoreGameMultiBackup();
                    server.setGameController(new GameControllerMultiplayer(this.server,server.getGame()));

                }

            }
        }
    }

    /**
     * method which received the answer about restart possibility, it is managed only during in restart state
     * @param msg
     * @param clientController
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public synchronized void handleMessage(RestartAnswerMessage msg, ClientController clientController) throws IOException, InterruptedException {
        server.setRestartAnswerReceived(true);
        server.setRestartAnswer(msg.getAnswer());
        if(!msg.getAnswer()){
            server.setSendRestartQuestion();
            server.restartLobby();
            server.setGameController(new GameControllerEmpty(this.server, clientController));
            restartAnswerReceived = false;
            FileClass.FileDestroyer();
            Gson gson = new Gson();
            FileWriter config = null;
            String jsonStrin = gson.toJson(null,ArrayList.class);
            try {
                config = new FileWriter("fileConfiguration/InformationAboutTurn.json");
                config.write(jsonStrin);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    config.flush();
                    config.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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

    /**
     * disconnected client controller from lobby
     * @param clientController
     */
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

    /**
     * disconnected all client controllers from lobby
     */
    public void disconnectAllClientTempLobby() {
        tempLobbyController = null;
        tempLobbyName = null;
    }

    /**
     * remove nickname from reconnected player's nickname
     * @param nickname
     */
    @Override
    public void removeNameFromReconnected(String nickname) {
        for(int i = 0; i < reconnected.size(); i++){
            if(reconnected.get(i).equals(nickname)){
                reconnected.remove(i);
                break;
            }
        }
    }

    /**
     * remove all nicknames from reconnected player's nickname
     */
    public void removeAllNameFromReconnected() {
        for(int i = 0; i < reconnected.size(); i++){
            reconnected.remove(0);
        }
    }

    /**
     * send message to all user, who tries to reconnect to old game
     * @throws IOException
     * @throws InterruptedException
     */
    public void reconnectionLobby() throws IOException, InterruptedException {
        for(ClientController c : server.getTempClientController()){
            c.getClientHandler().sendMessage(new RestartQuestionMessage(1));
        }
    }

    /**
     * method which add client controller to temporary lobby
     * @throws IOException
     * @throws InterruptedException
     */
    public void reconnectionTempLobby() throws IOException, InterruptedException {
        int i = 0;
        for(; i < tempLobbyName.size(); i++){
            if (!reconnected.contains(tempLobbyName.get(i))){
                tempLobbyController.get(i).setNickname(tempLobbyName.get(i));
                reconnected.add(tempLobbyName.get(i));
                server.addClientController(tempLobbyController.get(i));
                server.removeTempClientController(tempLobbyController.get(i));
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
                        server.removeTempClientController(tempLobbyController.get(j));
                    }
                break;
            }
        }

        for(i++ ; i < tempLobbyName.size(); i++){
            tempLobbyController.get(i).getClientHandler().sendMessage(new CompleteRunningMatchErrorMessage());
            server.removeTempClientController(tempLobbyController.get(i));
        }

        disconnectAllClientTempLobby();
    }

}
