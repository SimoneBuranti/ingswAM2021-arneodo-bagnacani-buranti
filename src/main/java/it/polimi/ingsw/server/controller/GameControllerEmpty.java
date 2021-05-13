package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.network.Server;

import java.io.IOException;

public class GameControllerEmpty extends GameController {

    public GameControllerEmpty(Server server) {
        this.server = server;
    }

    @Override
    public void handleMessage(ExitMessage msg, ClientController clientController) {
        //unreachable
    }

    @Override
    public void handleMessage(NumberPlayerMessage msg, ClientController clientController) throws IOException, InterruptedException {
        if (server.getLobbySize()>0){
            if (msg.getnOfPlayers()== 1){
                server.setGameController(new GameControllerSinglePlayer());
                server.initNewSolitaireGame();
            } else {
                server.setGameController(new GameControllerLobby(this.server,msg.getnOfPlayers()));
            }
        }
    }

    @Override
    public void handleMessage(UsernameMessage msg, ClientController clientController) throws IOException, InterruptedException {
        if (server.getLobbySize()==0) {
            if (server.addPlayerToLobby(msg.getUsername())){
                clientController.setNickname(msg.getUsername());
                clientController.getClientHandler().sendMessage(new NPlayersMessage(-1));
            } else {
                clientController.getClientHandler().sendMessage(new AlreadyExistingNickNameErrorMessage()); //unreachable
            }
        } else {
            clientController.getClientHandler().sendMessage(new BootingLobbyErrorMessage());
            try {
                clientController.getClientHandler().disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void handleMessage(RestartAnswerMessage msg, ClientController clientController) {
        //unreachable
    }




    /*@Override
    public void handleMessage(ActivateLeaderCardMessage msg) {

    }

    @Override
    public void handleMessage(BaseProductionOnMessage msg) {

    }

    @Override
    public void handleMessage(BuyProductionCardMessage msg) {

    }

    @Override
    public void handleMessage(DiscardLeaderCardMessage msg) {

    }

    @Override
    public void handleMessage(DoubleProductionOnMessage msg) {

    }

    @Override
    public void handleMessage(EndOfProductionMessage msg) {

    }

    @Override
    public void handleMessage(ExtraProductionOnMessage msg) {

    }

    @Override
    public void handleMessage(InitialResourcesMessage msg) {

    }

    @Override
    public void handleMessage(KeepLeaderCardsMessage msg) {

    }

    @Override
    public void handleMessage(KeepResourcesMessage msg) {

    }

    @Override
    public void handleMessage(ProductionOnMessage msg) {

    }

    @Override
    public void handleMessage(PushColumnMessage msg) {

    }

    @Override
    public void handleMessage(PushRowMessage msg) {

    }


    @Override
    public void handleMessage(WhiteMarbleChoosenResources msg) {

    }*/



}
