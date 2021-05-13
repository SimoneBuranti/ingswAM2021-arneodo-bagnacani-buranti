package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.network.Server;

import java.io.IOException;

public class GameControllerDisconnection extends GameController {


    public GameControllerDisconnection(Server server, Game game) {
        this.server = server;
        this.game = game;
    }

    @Override
    public void handleMessage(ExitMessage msg, ClientController clientController) {
        game.disconnectPlayer(clientController.getNickname());
        try {
            clientController.getClientHandler().disconnect();
        } catch (IOException e) {
            //messaggio di errore
        }
    }

    @Override
    public void handleMessage(NumberPlayerMessage msg, ClientController clientController) throws IOException, InterruptedException {
        clientController.getClientHandler().sendMessage(new CompleteRunningMatchErrorMessage());
    }

    @Override
    public void handleMessage(UsernameMessage msg, ClientController clientController) throws IOException, InterruptedException {
        if(game.checkNickname(msg.getUsername())){
            clientController.setNickname(msg.getUsername());
            clientController.setGame(this.getGame());
            game.connectPlayer(msg.getUsername());
            if(game.numPlayersDisconnected() == 0)
                server.setGameController(new GameControllerMultiplayer(this.server,this.game)); //oppure gameControllerSinglePlayer
        }else{
            clientController.getClientHandler().sendMessage(new NoNicknameMessage());
            /*try {
                clientController.getClientHandler().disconnect();
            } catch (IOException e) {
                //messaggio di errore
            }*/
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
