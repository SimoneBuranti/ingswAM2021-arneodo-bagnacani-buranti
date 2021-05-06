package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;

import java.io.IOException;

public class GameControllerSinglePlayer extends GameControllerInterface{

    @Override
    public void handleMessage(ExitMessage msg, ClientController clientController) {
        boolean flag = false;
        if(game.disconnectPlayer(clientController.getNickname())) {
            flag = true;
        }
        try {
            clientController.getClientHandler().disconnect();
        } catch (IOException e) {
            //messaggio di errore
        }
        if(flag) {
            server.setGameController(new GameControllerDisconnection());
        }
    }

    @Override
    public void handleMessage(NumberPlayerMessage msg, ClientController clientController) {
        clientController.getClientHandler().sendMessage(new CompleteRunningMatchErrorMessage());
    }

    @Override
    public void handleMessage(UsernameMessage msg, ClientController clientController) {
        clientController.getClientHandler().sendMessage(new CompleteRunningMatchErrorMessage());
        try {
            clientController.getClientHandler().disconnect();
        } catch (IOException e) {
            //messaggio di errore
        }
    }

    @Override
    public void handleMessage(OkMessage msg, ClientController clientController) {

    }

    @Override
    public void handleMessage(PingMessage msg, ClientController clientController) {

    }

    @Override
    public void handleMessage(PongMessage msg, ClientController clientController) {

    }


   /* @Override
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

    }*/


   /* @Override
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

    }*/


   /* @Override
    public void handleMessage(ProductionOnMessage msg) {

    }

    @Override
    public void handleMessage(PushColumnMessage msg) {

    }

    @Override
    public void handleMessage(PushRowMessage msg) {

    }*/


   /* @Override
    public void handleMessage(WhiteMarbleChoosenResources msg) {

    }*/
}
