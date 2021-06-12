package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.network.Server;

import java.io.IOException;
import java.util.ArrayList;
/**
 * game controller first state when server is put on and no file of old game exist
 */
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
    /**
     * method which received the request to exit from client or the possible disconnection due ping
     * @param msg
     * @param clientController
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public synchronized void handleMessage(ExitMessage msg, ClientController clientController) throws IOException, InterruptedException {
        if(isFirstClient(clientController)){
            server.removePlayerToLobby(clientController.getNickname());
            server.removeClientController(clientController);
            disconnectFirstClient();
            if(tempLobbyController.size()!=0)
            {
                setFirstClient(tempLobbyController.get(0));
                server.addClientController(tempLobbyController.get(0));
                server.addPlayerToLobby(tempLobbyController.get(0).getNickname());
                tempLobbyController.get(0).getClientHandler().sendMessage(new NPlayersMessage(-1));
                tempLobbyName.remove(0);
                tempLobbyController.remove(0);

            }
        }
        else{ disconnectClientTempLobby(clientController); }
        clientController.getClientHandler().disconnect();
        System.out.println("Ho disconnesso client");
    }


    /**
     * method which received the answer to number player, it is managed only during in emptyState
     * @param msg
     * @param clientController
     * @throws IOException
     * @throws InterruptedException
     */
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
    /**
     * method which received the username for the registration and the authentication of user on server
     * @param msg
     * @param clientController
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public synchronized void handleMessage(UsernameMessage msg, ClientController clientController) throws IOException, InterruptedException {
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

        if(firstClientController == null){
            firstClientController = clientController;
        }


    }


    /**
     * method for set the first client cotntroller
     * @param clientController
     * @return
     */
    public void setFirstClient(ClientController clientController) {
        firstClientController=clientController;
    }

    @Override
    public void handleMessage(RestartAnswerMessage msg, ClientController clientController) {
        //unreachable
    }

    /**
     * method for control and check for the starts of game
     * @param clientController
     * @return
     */
    @Override
    public boolean isFirstClient(ClientController clientController) {
        return clientController == firstClientController;
    }

    @Override
    public void disconnectFirstClient() {
        firstClientController = null;
    }

    /**
     * method used for disconnect user from lobby
     * @param clientController
     */
    @Override
    public void disconnectClientTempLobby(ClientController clientController) {
        for(int i = 0; i < tempLobbyController.size(); i++){
            if(tempLobbyController.get(i) == clientController)
                tempLobbyController.remove(i);
                tempLobbyName.remove(i);
                break;
        }
    }

    @Override
    public void removeNameFromReconnected(String nickname) {

    }

    @Override
    public int getLobbySize() {
        return 0;
    }

    @Override
    public boolean thereIsTempLobby() {
        return false;
    }

}
